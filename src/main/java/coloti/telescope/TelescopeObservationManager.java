package coloti.telescope;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.milo.opcua.stack.core.UaRuntimeException;
import org.jastronomy.jsofa.JSOFAIllegalParameter;
import org.jastronomy.jsofa.JSOFAInternalError;
import org.jastronomy.jsofa.JSOFA.HorizonCoordinate;
import org.jastronomy.jsofa.JSOFA.JulianDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import astri.astron.AstroTime;
import astri.astron.CoordinatesUtil;
import astri.astron.ESolSystem;
import astri.astron.EquatorialObject;
import astri.astron.FieldSourceObservability;
import astri.astron.HorizonDirection;
import astri.astron.Iers;
import astri.astron.IersData;
import astri.astron.Observer;
import astri.astron.PointingCoord;
import astri.astron.Target;
import astri.astron.TimeUtil;
import astri.astron.Weather;
import astri.opcuautils.Results;
import astri.telescope.config.ConfigManager;
import astri.telescope.config.PointingModelCoeff;
import astri.telescope.config.TelescopeConfigTable;
import astri.telescope.mount.EAssemblyVariables;
import astri.telescope.mount.EHardwareState;
import astri.telescope.mount.EMcsCommands;
import astri.telescope.mount.IMcsCommandListener;
import astri.telescope.mount.McsCommandListener;
import astri.telescope.mount.McsCommands;
import astri.telescope.mount.MountController;
import astri.telescope.mount.MountListener;
import astri.telescope.mount.TrajectoryStatusData;
import astri.telescope.mount.info.TelescopeTrackingInfo;
import astri.weather.WeatherStationController;
import ch.qos.logback.core.joran.conditional.ElseAction;

public class TelescopeObservationManager {
    private TelescopeConfigTable telConfig;
    private MountController mc;
    private WeatherStationController ws;
    private Logger logger = LoggerFactory.getLogger(TelescopeObservationManager.class);
    private TelescopePointingModelTable telescopeTpointModel;
    private AstromIersData iersData;
    private Target skyTarget;
    private ObserverData observerData;
    private Weather astromAtm;
    private ETrajectoryMode trajectoryMode;
    private Iers iers;
    private Observer astroObserver;
    private Properties astrometryProp;
    private WeatherData weatherData;
    private ConfigManager cManager;
    private Double taiutc;
    private int currentExpTime;
    private boolean isTracking = false;
    private boolean isMcsError = false;
    private boolean useRefraction = false;
    private boolean usePointingModel = false;
    private McsCommands command;
    private TelescopePositionMonitor monitor;
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);
    private static final double MAXSLEWTIME = 90.;
    private TrajectoryStatusData traStatusData;
    private TelescopePositionReportTable positionTable;
    private MountListener mListener = null;
    private boolean trajectoryDataUpdate = false;
    private PointingModelCoeff pointingModelCoeff;
    private double[] currentTrajectory = new double[0];

    MountListener internalListener = new MountListener() {

        @Override
        public void onError(Object ob) {
        }

        @Override
        public void onChange(Object oldvalue, Object value) {
            positionTable = (TelescopePositionReportTable) value;
            actualTelPos(positionTable);
            // logger.info(positionTable.getTrajStatusData().toString());
            trajectoryDataUpdate = true;
        }

        @Override
        public void onEvent(Object ob) {

        }

    };

    private Weather weather = new Weather();
    private boolean isSlewing = false;
    private IMcsCommandListener clist = null;

    public boolean isTrajectoryDataUpdate() {
        return trajectoryDataUpdate;
    }

    public void uploadPointingModel() {
        CompletableFuture.runAsync(() -> telescopeTpointModel.setTpointCoeff(pointingModelCoeff));
        // command.executeSync(EMcsCommands.SaveParameters.getName(), 20);

    }

    public void clearPointingModel() {
        CompletableFuture.runAsync(() -> telescopeTpointModel.clearPmCoeff());
    }

    public void setTrajectoryDataUpdate(boolean trajectoryDataUpdate) {
        this.trajectoryDataUpdate = trajectoryDataUpdate;
    }

    public TelescopeObservationManager(ConfigManager cm, EAstriTels tel, MountController mc) {
        this(cm, tel.getTelName(), mc);

    }

    public TelescopeObservationManager(ConfigManager cm, String telname, MountController mc, Logger log) {
        this(cm, telname, mc);
        logger = log;

    }

    public TelescopeObservationManager(ConfigManager cm, String telname, MountController mc) {
        this.cManager = cm;
        this.telConfig = cManager.getTelConf(telname);
        this.mc = mc;
        init();
    }

    public TelescopeObservationManager(TelescopeConfigTable telConfig, MountController mc, Logger log) {
        this.telConfig = telConfig;
        logger = log;
        this.mc = mc;
        init();
    }

    private void init() {
        telescopeTpointModel = new TelescopePointingModelTable(mc.getConnector(), logger);
        iersData = new AstromIersData(mc.getConnector());
        skyTarget = new Target();
        observerData = new ObserverData(mc.getConnector());
        weatherData = new WeatherData(mc.getConnector());
        command = new McsCommands(mc.getConnector().getOpcuaClient(), executor);
        command.setCommandListener(new McsCommandListener(logger)); // create a listener here
        pointingModelCoeff = telConfig.getMountConfig().getTelConfig().getPointingModelCoeff();
        astromAtm = new Weather(970, 15, 0.5);
        clearPointingModel();
        // logger.info("FATTO");
        iers = new Iers();
        loadObserver();
        try {
            loadTaiMUtic();
        } catch (IOException e) {
            logger.error("Unable to open/read Astriometric file", e);
        }
        traStatusData = new TrajectoryStatusData();
        monitor = new TelescopePositionMonitor(astroObserver, mc.getConnector(), logger);
        monitor.addListener(internalListener);
    }

    public TrajectoryStatusData actualTelPos(TelescopePositionReportTable value) {
        // traStatusData=null;
        if (value != null && trajectoryDataUpdate) {
            traStatusData = value.getTrajStatusData();
            trajectoryDataUpdate = false;
        }
        return traStatusData;
    }

    public void addCommandlistener(IMcsCommandListener clist) {
        this.clist = clist;
        command.setCommandListener(clist);
    }

    public void addPositionListener(MountListener list) {
        mListener = list;
        monitor.addListener(list);
    }

    public void startPositionMonitor(int sampling) {

        CompletableFuture.runAsync(()->{
        monitor.setSampling(sampling);
        
        if (mListener == null)
            monitor.addListener(internalListener);
        else
            monitor.addListener(mListener);
        monitor.startMonitor();
        monitor.run();
        //CompletableFuture.runAsync(monitor);
        });
    }

    public void stopPositionMonitor() {
        monitor.stopMonitor();
    }

    public boolean isTracking() {
        return isTracking;
    }

    public void setTracking(boolean isTracking) {
        this.isTracking = isTracking;
    }

    public boolean isSlewing() {
        return isSlewing;
    }

    public void setSlewing(boolean isSlewing) {
        this.isSlewing = isSlewing;
    }

    private void loadObserver() {
        astroObserver = new Observer(telConfig.getName(), telConfig.getSerialID(),
                telConfig.getLatitude(),
                telConfig.getLongitude(),
                telConfig.getAltitude());
    }

    private void loadTaiMUtic() throws IOException {
        Properties prop = cManager.loadAstrometricConfiguration();
        taiutc = Double.valueOf(prop.getProperty("astrometry.taiutc"));
    }

    public void setObserverData() {
        observerData.setObserver(astroObserver.getSITE_LAT(), astroObserver.getSITE_LONG(),
                astroObserver.getSITE_ALTITUDE());
    }

    public void setAstromAtm(Weather wea) {
        astromAtm = wea;
        logger.debug(wea.toString());
        weatherData.updateWeatherData(wea);
        // insert here update of th etrajectory if refraction is on and traj mode =
        // external
    }

    public void setTelescopeTpointModel(TelescopePointingModelTable telescopeTpointModel) {
        this.telescopeTpointModel = telescopeTpointModel;
    }

    private IersData getIersData() {
        double mjd = TimeUtil.getMJDNow();
        IersData iersD = iers.getIersValues(mjd); // at the start
        logger.info("IERS:{}", iersD);
        return iersD;
    }

    public void setIersData() {
        IersData iersD = getIersData();
        iersData.setIersDut1(iersD.ut1_utc);
        iersData.setIersXpp(iersD.xpm_arcsec);
        iersData.setIersYpp(iersD.ypm_arcsec);
        iersData.setIersTaiUtc(taiutc);

    }

    public void setMcsError(boolean val) {
        isMcsError = val;
    }

    public void setTarget(Target skyTarget) {
        this.skyTarget = skyTarget;
        SkyTarget target = new SkyTarget(mc.getConnector());
        target.setSkyTarget(skyTarget);
        try {
            target.uploadTarget();
        } catch (Exception e) {
            logger.error("Unable to upload target");
        }
    }

    public PointingCoord getObjActualCoord(double timestamp) {
        try {
            JulianDate jd = TimeUtil.getJulianDate(TimeUtil.getDateOfEpochMillis(timestamp));
            EquatorialObject tar = new EquatorialObject(jd, getIers(), skyTarget, getObserver(),
                    astromAtm,
                    logger);
            return tar.getPointing(jd);
        } catch (JSOFAIllegalParameter e) {
            logger.error("bad jd parameter");
        } catch (JSOFAInternalError e) {
            logger.error("error evaluating jd");
        } 
        return null;
    }

    public PointingCoord getObjActualCoord(JulianDate jd , Target st) {
       
        EquatorialObject tar = new EquatorialObject(jd, getIers(), st, getObserver(),
                astromAtm,
                logger);
        return tar.getPointing(jd);
    }

    public boolean isObservable(Target skyT, double elMin) {
        this.skyTarget = skyT;
        FieldSourceObservability sfo = CoordinatesUtil.getRisingAndSettingParameters(skyTarget.getSkyCoordinates(),
                getObserver().getSITE_LAT(), getObserver().getSITE_LONG(), AstroTime.getNow());
        logger.info(sfo.toString());
        skyTarget.setVisibility(sfo);
        if (sfo.isVisibleNow() || sfo.getAlwaysVisible()) {
            EquatorialObject tar = new EquatorialObject(TimeUtil.getJDNow(), getIers(), skyTarget, getObserver(),
                    astromAtm,
                    logger);
            PointingCoord coo = tar.getPointing(TimeUtil.getJDNow());
            logger.info(coo.toString());
            if (Math.toDegrees(coo.getCommandedAzEl().el) > elMin)
                return true;
        }
        return false;
    }

    public void setTrajectoryMode(ETrajectoryMode tmode) {
        if (tmode == ETrajectoryMode.EXTERNAL)
            setTrajectoryModeExternal();
        else
            setTrajectoryModeInternal();
    }

    public void presetObsData(Target skyTarget, Weather wea) {
        setObserverData();
        setIersData();
        setTarget(skyTarget);
        setAstromAtm(wea);
        if (skyTarget.isUseRefraction()) {
            mc.getMountSetter().setRefractionOnoff(true);
        } else {
            mc.getMountSetter().setRefractionOnoff(false);
        }
        if (skyTarget.isUsePointingModel()) {
            mc.getMountSetter().setPointingModelOnoff(true);
        } else {
            mc.getMountSetter().setPointingModelOnoff(false);
        }
    }

    public synchronized void slew(Target skyTar) {
        this.skyTarget = skyTar;
        slew(skyTar, astromAtm);
    }

    public synchronized void slew(Target skyTarget, Weather wea) {
        if (mc.getCurrentHwState() == EHardwareState.ONLINE) {
            setTrajectoryMode(ETrajectoryMode.INTERNAL);
            if (isObservable(skyTarget, 10))
                presetObsData(skyTarget, wea);
            else {
                logger.info("Invalid Target");
                return;
            }
            if (mc.axesEnabled()) {
                isSlewing = true;
                command.executeSync(EMcsCommands.Point.getName(), 90);
                isSlewing = false;
            }
        }
    }

    private Weather getDefaultWeather() {
        Weather atm = new Weather();
        atm.setPressure(780.0); // mB
        atm.setTemperature(15.0); // °C
        atm.setHumidity(0.23);
        return atm;
    }

    public synchronized void track(Target skyTar, double duration) {
        this.skyTarget = skyTar;
        isTracking = true;
        track(skyTar, astromAtm, duration);
        isTracking = false;
    }

    public synchronized void track(Target skyTarget, Weather wea, double duration) {

        if (mc.getCurrentHwState() == EHardwareState.ONLINE) {
            setTrajectoryMode(ETrajectoryMode.INTERNAL);
            if (isObservable(skyTarget, 10)) {
                presetObsData(skyTarget, wea);
                setExpTimeToTelescope(duration);
            } else {
                logger.info("Invalid Target");
                return;
            }
            if (mc.axesEnabled()) {
                // startPositionMonitor();
                setTracking(true);

                command.executeSync(EMcsCommands.Track.getName(), (int) (duration) + 90);
                // stopPositionMonitor();
            }

        }
    }

    public synchronized void updateTrajectory() {
        if (trajectoryMode == ETrajectoryMode.EXTERNAL && isTracking) {

            command.executeSync(EMcsCommands.UpdateTrajectory.getName(), 20);
        }
    }

    public synchronized void setAzElOffsets(double az, double el) {
        if (isTracking) {
            MountController.getMountSetter().setOffsetAzimuth(az);
            MountController.getMountSetter().setOffsetElevation(el);
        }
    }

    public synchronized void monitoringTraking() {
        if (isTracking && !isMcsError) {

        }
    }

    public boolean isUseRefraction() {
        return useRefraction;
    }

    public void useRefraction(boolean useRefraction) {
        MountController.getMountSetter().setRefractionOnoff(useRefraction);
        this.useRefraction = useRefraction;
    }

    public boolean isUsePointingModel() {
        return usePointingModel;
    }

    public void usePointingModel(boolean usePointingModel) {
        MountController.getMountSetter().setPointingModelOnoff(usePointingModel);
        this.usePointingModel = usePointingModel;
    }

    private void setTrajectoryModeExternal() {
        MountController.getMountSetter().setTrajectoryGenerationMode(ETrajectoryMode.EXTERNAL.ordinal());
        this.trajectoryMode = ETrajectoryMode.EXTERNAL;
    }

    private void setTrajectoryModeInternal() {
        MountController.getMountSetter().setTrajectoryGenerationMode(ETrajectoryMode.INTERNAL.ordinal());
        this.trajectoryMode = ETrajectoryMode.INTERNAL;
    }

    public Target getSkyTarget() {
        return skyTarget;
    }

    public Weather getAstromAtm() {
        return astromAtm;
    }

    public ETrajectoryMode getTrajectoryMode() {
        return trajectoryMode;
    }

    public Iers getIers() {
        return iers;
    }

    public Observer getObserver() {
        return astroObserver;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public Double getTaiutc() {
        return taiutc;
    }

    private void sendDataToTelescope(double[] val1) {
        Results res = mc.getConnector().setDoubleArrayValue(EAssemblyVariables.TRAJECTORY_NODE_ARRAY, val1);
        if (res.isGood()) {
            double[] val = mc.getConnector().getDoubleArrayValue(EAssemblyVariables.TRAJECTORY_NODE_ARRAY);
            for (int i = 0; i < 183; i += 3) {
                logger.info("" + val[i] + "," + val[i + 1] + "," + val[i + 2]);
            }
        } else {
            logger.error("error setting the trajectory");
            isTracking = false;
        }
    }

    private void setExpTimeToTelescope(double duration) {
        currentExpTime = (int) duration; // secs
        mc.getConnector().setIntValue(EAssemblyVariables.TRACKING_DURATION, currentExpTime);

    }

    public CompletableFuture<Void> generateTrackingTrajectory(Target skyTarget, JulianDate start, double duration) {
        return CompletableFuture.runAsync(() -> generateAndSetTrajectory(skyTarget, start, duration));

    }

    public void stopCommand() {
        command.stopExecution();
    }

    public void close() {
        setTracking(false);
        executor.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                // Cancel currently executing tasks forcefully
                executor.shutdownNow();
                // Wait a while for tasks to respond to being cancelled
                if (!executor.awaitTermination(10, TimeUnit.SECONDS))
                    logger.error("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            executor.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void UpdateTrajectory(Target skyTarget, JulianDate start, double duration) {
        if (isTracking) {
            setTarget(skyTarget);
            TrajectoryGenerator p = new TrajectoryGenerator(iers, astroObserver, pointingModelCoeff, logger);
            currentTrajectory = p.startTrajectoryGenerator(skyTarget, astromAtm, start, duration);
            /*
             * if (skyTarget.isUseRefraction())
             * val1 = p.addRefraction(val1);
             * if (skyTarget.isUsePointingModel())
             * val1 = p.addTpoint(val1);
             */
            sendDataToTelescope(currentTrajectory);

            updateTrajectory();
        } else {
            logger.warn("The telescope is not tracking any object");
        }

    }

    public synchronized void generateAndSetTrajectory(Target skyTarget, JulianDate start, double duration) {
        setTarget(skyTarget);
        if (mc.getCurrentHwState() == EHardwareState.ONLINE) {
            //double[] finaletp = new double[183];
            //double[] finaleref = new double[183];
            setExpTimeToTelescope(duration);
            setTrajectoryModeExternal();
            TrajectoryGenerator p = new TrajectoryGenerator(iers, astroObserver, pointingModelCoeff, logger);
            currentTrajectory = p.startTrajectoryGenerator(skyTarget, astromAtm, start, duration);

            sendDataToTelescope(currentTrajectory);
            isTracking = true;
            // mc.getMountSetter().cmdStartTracking(true);
            try {
                command.executeSync(EMcsCommands.Track.name(), (int) (duration + 90));
                // System.out.println("cycle:");
            } catch (UaRuntimeException e) {
                logger.error(e.getMessage());
            }
            isTracking = false;
        }else {
            logger.warn("the Mount is not ONLINE");
        }
    }

    public synchronized void generateAndSetSolSysTrajectory(Target skyTarget, JulianDate start, double duration,
            boolean jpl) {
        if (mc.getCurrentHwState() == EHardwareState.ONLINE) {
            setTarget(skyTarget);
            setExpTimeToTelescope(duration);
            setTrajectoryModeExternal();
            TrajectoryGenerator p = new TrajectoryGenerator(iers, astroObserver, pointingModelCoeff, logger);
            p.setWeather(astromAtm);
            currentTrajectory = new double[183];
            if (jpl)
                currentTrajectory = p.startSolSystemTrajectoryGenerator(ESolSystem.valueOf(skyTarget.getName()),
                        TimeUtil.JulianDateToJd(start));
            else
                currentTrajectory = p.startSolSystemTrajectoryGeneratorNoJpl(ESolSystem.valueOf(skyTarget.getName()),
                        TimeUtil.JulianDateToJd(start));

            sendDataToTelescope(currentTrajectory);
            isTracking = true;

            try {
                command.executeSync(EMcsCommands.Track.name(), (int) (duration + MAXSLEWTIME));

            } catch (UaRuntimeException e) {
                logger.error(e.getMessage());
            }
            isTracking = false;
        } else {
            logger.warn("the Mount is not ONLINE");
        }
    }

    public synchronized void generateAndSetTrajectory(Target skyTarget, JulianDate start) {
        if (mc.getCurrentHwState() == EHardwareState.ONLINE) {
            setTarget(skyTarget);
            setTrajectoryModeExternal();
            TrajectoryGenerator p = new TrajectoryGenerator(iers, astroObserver, pointingModelCoeff, logger);
            currentTrajectory = p.startTrajectoryGenerator(skyTarget, astromAtm, start, 0.);
            sendDataToTelescope(currentTrajectory);
            isSlewing = true;
            try {
                command.executeSync(EMcsCommands.Point.name(), 180);
                // System.out.println("cycle:");
            } catch (UaRuntimeException e) {
                logger.error(e.getMessage());
            }
            isSlewing = false;
        } else {
            logger.warn("the Mount is not ONLINE");
        }
    }

    public TrajectoryStatusData getTrajectoryStatusData() {
        if (!monitor.isMonitoring()) {
            positionTable.updateData();
        }
        traStatusData = positionTable.getTrajStatusData();
        return traStatusData;
    }

    public void setExposureTime(double time) {
        currentExpTime = (int) time;
    }

    public int getExposureTime() {
        return currentExpTime;
    }

}
