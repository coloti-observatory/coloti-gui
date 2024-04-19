package coloti.telescope;

import java.util.ArrayList;
import java.util.List;

import org.jastronomy.jsofa.JSOFA;
import org.jastronomy.jsofa.JSOFA.JulianDate;
import org.jastronomy.jsofa.JSOFA.RefCos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import astri.astron.ESolSystem;
import astri.astron.EquatorialObject;
import astri.astron.HorizonDirection;
import astri.astron.Iers;
import astri.astron.JplHorizonReader;
import astri.astron.Observer;
import astri.astron.PointingCoord;
import astri.astron.SolarSystem;
import astri.astron.Target;
import astri.astron.Weather;
//import astri.telescope.config.PointingModelCoeff;

public class TrajectoryGenerator implements ITrajectoryGenerator {

    private static int numberOfNodes = 61;
    private double MINDURATION = 3600.; // seconds
    private static double TOTALDURATION = 3600.; // seconds
    private double timeStep = 60.; // seconds
    private static int nextIndex = 0;
    private static List<TrajectoryData> trajectoryNodes;
    private Iers iers;
    private Observer observer;
    private Weather atm;
    private Target target;
    private JulianDate startTime;
    private JulianDate endTime;
    private static double elapsedTime = 0;
    private static double nextTstart = 0;
    private static double initialTstart = 0;
    private static double maxTime = 0;
    private static double expTime = 3600.;
    private static double[] trajectoryArray = new double[numberOfNodes * 3];

    private Logger logger = LoggerFactory.getLogger(TrajectoryGenerator.class);
    //private static PointingModelCoeff pointingModelCoeff;

    public TrajectoryGenerator(Target source, Iers iers, Observer obs) {
        trajectoryNodes = new ArrayList<>(numberOfNodes);
        this.iers = iers;
        this.observer = obs;
        this.target = source;
    }

    public TrajectoryGenerator(Iers iers, Observer obs,  Logger logger) { //PointingModelCoeff pmcoeff,
        trajectoryNodes = new ArrayList<>(numberOfNodes);
        this.iers = iers;
        this.observer = obs;
        this.logger = logger;
        //this.pointingModelCoeff = pmcoeff;
    }

    public double getMINDURATION() {
        return MINDURATION;
    }

    public void setMINDURATION(long mAXDURATION) {
        MINDURATION = mAXDURATION;
    }

    public double getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(long timeStep) {
        this.timeStep = timeStep;
    }

    public Iers getIers() {
        return iers;
    }

    public void setIers(Iers iers) {
        this.iers = iers;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void setWeather(Weather dat) {
        this.atm = dat;
    }

    @Override
    public List<TrajectoryData> getTrajectory(Target source, SkyOffset offsets, long startTime, long timeStep) {

        return null;
    }

    private void printTrajectoryData(TrajectoryData coo) {
        System.out.format("%s%n", coo.toString());
    }

    // private TrajectoryData getTrajectoryData(JulianDate time, PointingCoord coo)
    // {
    // return new TrajectoryData(time, Math.toDegrees(coo.getCommandedAzEl().az),
    // Math.toDegrees(coo.getCommandedAzEl().el));
    // }

    private TrajectoryData getTrajectoryData(JulianDate time, PointingCoord coo, boolean useRefraction,
            boolean useTpoint) {
        TrajectoryData tra;
        if (useRefraction) {
            //logger.info("USE REFRACTION");
            tra = new TrajectoryData(time, Math.toDegrees(coo.getCommandedAzElRefracted().az),
                    Math.toDegrees(coo.getCommandedAzElRefracted().el));
        } else
            tra = new TrajectoryData(time, Math.toDegrees(coo.getCommandedAzEl().az),
                    Math.toDegrees(coo.getCommandedAzEl().el));
        if (useTpoint) {
            tra = addTpoint(tra);
            //logger.info("USE TPOINT");
        }

        return tra;
    }

    public void clearTrajectoryBuffer() {
        trajectoryArray = new double[numberOfNodes * 3];
        trajectoryNodes.clear();
        trajectoryNodes = new ArrayList<>(numberOfNodes);
        nextIndex = 0;
        nextTstart = 0;
        elapsedTime = 0;
    }

    @Override
    public List<TrajectoryData> getTrajectory(Weather atm, JulianDate startTime) {
        generateTrajectory(atm, startTime);
        return trajectoryNodes;

    }

    public static double getElapsedTime() {
        return elapsedTime;
    }

    private void generateTrajectory(Weather atm, JulianDate startTime) {

        this.atm = atm;
        this.startTime = startTime;
        EquatorialObject tar = new EquatorialObject(startTime, iers, target, observer, atm, logger);

        double tStart = startTime.djm0 + startTime.djm1;
        double tStop = tStart + TOTALDURATION / JSOFA.DAYSEC;
        double tStep = timeStep / JSOFA.DAYSEC;
        int i = nextIndex;
        elapsedTime = 0.0;
        TrajectoryData tra = new TrajectoryData();
        for (double time = tStart; time <= tStop && i < numberOfNodes; time += tStep) {
            JulianDate jd = new JulianDate(time, 0.);
            PointingCoord coo = tar.getPointing(jd);
            tra = getTrajectoryData(jd, coo, target.isUseRefraction(), target.isUsePointingModel());
            trajectoryNodes.add(i, tra);
            //printTrajectoryData(tra);
            elapsedTime += timeStep;
            i++;
        }
        nextIndex = i;
        nextTstart = tStop + tStep;
        if (i < numberOfNodes) {
            TrajectoryData tra1 = tra;
            for (int k = i; k < numberOfNodes; k++) {
                tra1.setTime(new JulianDate(nextTstart + k * tStep, 0.));
                // logger.info(""+tra.getTime().toString());
                // trajectoryNodes.remove(k);
                trajectoryNodes.add(k, tra1);
            }
            logger.info("filling:" + i);
        } else {
            if (elapsedTime > expTime) {
                nextIndex = 0;
                //trajectoryNodes.clear();
            }
            logger.info("Resetting Buffers");
        }

    }

    public double[] updateTrajectory(Weather atm) {
        getTrajectory(atm, new JulianDate(nextTstart, 0.));
        return getTrajectoryNodesAsArray();
    }

    public double[] startTrajectoryGenerator(Target source, Weather atm, JulianDate startTime, double duration) {

        this.target = source;
        this.expTime = duration;
        nextIndex = 0;
        // if(expTime<MINDURATION){
        // TOTALDURATION=MINDURATION;
        // }
        initialTstart = startTime.djm0 + startTime.djm1;
        maxTime = initialTstart + TOTALDURATION / JSOFA.DAYSEC;
        clearTrajectoryBuffer();
        generateTrajectory(atm, startTime);
        return getTrajectoryNodesAsArray();
    }

    public double[] startSolSystemTrajectoryGenerator(ESolSystem body, double jdTime) {
        double[] traj = new double[183];
        //SolarSystem source = new SolarSystem(this.observer, body);
        //traj = source.getTrajectory(jdTime);
        JplHorizonReader.setObserver(this.observer);
		traj=JplHorizonReader.getTrajectory(body.getName(), jdTime, jdTime+1/24.);
        return traj;
    }

    public double[] startSolSystemTrajectoryGeneratorNoJpl(ESolSystem body, double jdTime) {
        double[] traj = new double[183];
        SolarSystem source = new SolarSystem(this.observer, body);
        traj = source.getTrajectory(jdTime);
        return traj;
    }

    public TrajectoryData addTpoint(TrajectoryData tra) {
        TrajectoryData trajTpoint = tra;
        HorizonDirection tpointCorr = getTpoint(tra);
        trajTpoint.setAz(tra.getAz() - tpointCorr.az);
        trajTpoint.setEl(tra.getEl() + tpointCorr.el);
        trajTpoint.setTpAzCorr(tpointCorr.az);
        trajTpoint.setTpElCorr(tpointCorr.el);
        //logger.info("ADDED TPOINT");
        return trajTpoint;
    }

    public double[] addRefraction(double[] val1) {
        double[] ret = new double[183];
        List<TrajectoryData> tra = TrajectoryData.arrayToList(val1);
        int i = 0;
        for (TrajectoryData tr : tra) {
            tr = addRefraction(tr);
            ret[i] = val1[i];
            ret[i + 1] = tr.getAz();
            ret[i + 2] = tr.getEl();
            i += 3;
        }
        return ret;
    }

    public double[] addTpoint(double[] val1) {
        double[] ret=new double[183];
        List<TrajectoryData> tra = TrajectoryData.arrayToList(val1);
        int i = 0;
        for (TrajectoryData tr : tra) {
            tr = addTpoint(tr);
            ret[i] = val1[i];
            ret[i + 1] = tr.getAz();
            ret[i + 2] = tr.getEl();
            i += 3;
        }
        return ret;
    }

    public TrajectoryData addRefraction(TrajectoryData tra) {
        TrajectoryData trajRef = tra;
        double refCorr = getRefraction(atm, Math.toRadians(90. - tra.getEl()));
        trajRef.setEl(tra.getEl() + refCorr);
        trajRef.setRefCorr(refCorr);
        //logger.info("ADDED REFRACTION");
        return trajRef;
    }

    public static HorizonDirection getTpoint(double az, double el) {
        return applyModel(az, el);

    }

    public HorizonDirection getTpoint(TrajectoryData tra) {
        return getTpoint(tra.getAz(), tra.getEl());
    }

    public static HorizonDirection applyModel(double azo, double elo) {

        double ia = 0; //pointingModelCoeff.getIa();
        double ie = 0; //pointingModelCoeff.getIe();
        double an = 0; //pointingModelCoeff.getAn();
        double aw = 0; //pointingModelCoeff.getAw();
        double ca = 0; //pointingModelCoeff.getCa();
        double npae = 0; //= pointingModelCoeff.getNpae();
        double tf = 0; //pointingModelCoeff.getTf();
        double tx = 0; //pointingModelCoeff.getTx();

        double az = Math.toRadians(azo);
        double alt = Math.toRadians(elo);
        double da =  ia;
        da += an * Math.sin(az) * Math.tan(alt);
        da -= aw * Math.cos(az) * Math.tan(alt);
        da += ca / Math.cos(alt);
        da += npae * Math.tan(alt);

        double de = ie;
        de += an * Math.cos(az);
        de += aw * Math.sin(az);
        de -= tf * Math.cos(alt);
        de -= tx / Math.tan(alt);
        da/=3600.;
        de/=3600.;
        //double new_az = azo + da;
        //double new_alt = elo + de;

        //System.out.println(azo + " " + elo + " " + new_az + " " + new_alt+" "+da+" "+de);
        return new HorizonDirection(da, de);

    }

    private RefCos getRefractionParams(Weather weather) {
        return JSOFA.jauRefco(weather.getPressure(), weather.getTemperature(), weather.getHumidity(), 0.55);
    }

    // deg
    public double getRefractionCorrection(Weather weather, double za) {
        RefCos coeff = getRefractionParams(weather);
        za=Math.toRadians(za);
        double corr = coeff.a * Math.tan(za) + coeff.b * Math.pow(Math.tan(za), 3.);
        return Math.toDegrees(corr);
    }

    public double getRefraction(Weather atm0, double za) {

        return getRefractionCorrection(atm0, za);
    }

    private void setTrajectoryAsArray(double[] traj) {
        List<TrajectoryData> td = new ArrayList<>();
        if (Math.floorMod(traj.length, 3) == 0) {
            int k = 0;
            for (int i = 0; i < traj.length; i += 3) {
                TrajectoryData t = new TrajectoryData(new JulianDate(traj[i], 0.), traj[i + 1], traj[i + 2]);
                // System.out.println("Point:"+(k+1)+"-->"+t);
                td.add(k, t);
                k++;
            }
            trajectoryNodes = td;
        }
    }

    public double getTOTALDURATION() {
        return TOTALDURATION;
    }

    public static int getNextIndex() {
        return nextIndex;
    }

    public static double getNextTstart() {
        return nextTstart;
    }

    public static double getInitialTstart() {
        return initialTstart;
    }

    public static double getMaxTime() {
        return maxTime;
    }

    @Override
    public TrajectoryData getHorizontal(Target source, long startTime) {
        return null;
    }

    @Override
    public TrajectoryData getHorizontal(double ra, double dec, long startTime) {
        return null;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        trajectoryArray = new double[numberOfNodes];
        trajectoryNodes = new ArrayList<>(numberOfNodes);
    }

    public List<TrajectoryData> getTrajectoryNodes() {
        return trajectoryNodes;
    }

    public double[] getTrajectoryNodesAsArray() {
        int i = 0;

        for (int k = 0; k < trajectoryNodes.size() && i < numberOfNodes * 3; k++) {
            TrajectoryData t = trajectoryNodes.get(k);
            trajectoryArray[i] = t.getTime().djm0 + t.getTime().djm1;
            trajectoryArray[++i] = t.getAz();
            trajectoryArray[++i] = t.getEl();
            i++;
            // System.out.println("Point:"+(k+1)+"-->"+t);
        }

        return trajectoryArray;
    }

    public void setTrajectoryNodes(List<TrajectoryData> trajectoryNodes) {
        this.trajectoryNodes = trajectoryNodes;
    }


}
