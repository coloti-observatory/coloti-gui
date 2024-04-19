package coloti.telescope;

import java.util.List;

public class MountController implements IMount{


    private int pip;
    private McsSetters mcss;
    private McsGetters mcsg;


    public MountController(int pip) {
        this.pip = pip;
    }


    //#region Override

    @Override
    public void init() {
        mcss.cmdGoLoaded(true);

    }

    @Override
    public void start() {
        mcss.cmdGoOnline(true);

    }

    @Override
    public void stop() {
        mcss.cmdGoStandby(true);
    }

    @Override
    public void shutdown() {
    }

    @Override
    public void maintenance() {
        mcss.cmdGoMaintenance(true);
    }

    @Override
    public EHardwareState getCurrentHwState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentHwState'");
    }

    @Override
    public void moveToAzEl(double azimuth, double elevation) {
        mcss.setAzTelPosition(azimuth);
        mcss.setElTelPosition(elevation);
        mcss.cmdStartMotion(true);
    }

    @Override
    public void setTrajectory(List<TrajectoryData> trajectory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTrajectory'");
    }

    @Override
    public void enableMountStatusDataPublication(boolean enable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enableMountStatusDataPublication'");
    }

    @Override
    public boolean isMountStatusDataPublicationEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isMountStatusDataPublicationEnabled'");
    }

    @Override
    public void setTolerance(double tolerance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTolerance'");
    }

    @Override
    public double getTolerance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTolerance'");
    }

    @Override
    public TelescopeMotionLimits getMotionLimits() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMotionLimits'");
    }

    @Override
    public void setMotionLimits(TelescopeMotionLimits lim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMotionLimits'");
    }

    @Override
    public void setMinimumElevation(double elMin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMinimumElevation'");
    }

    @Override
    public void resetLimits() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetLimits'");
    }

    @Override
    public double timeToSlew(double fromAz, double fromEl, double toAz, double toEl) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timeToSlew'");
    }

    @Override
    public double timeToSlewFromCurrent(double toAz, double toEl) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timeToSlewFromCurrent'");
    }

    @Override
    public void setAxisMode(ETelescopeMountAxisModes axMode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAxisMode'");
    }

    @Override
    public ETelescopeMountAxisModes getAzAxisMode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAzAxisMode'");
    }

    @Override
    public ETelescopeMountAxisModes getElAxisMode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getElAxisMode'");
    }

    @Override
    public boolean inLocalMode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inLocalMode'");
    }

    @Override
    public boolean isMoveable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isMoveable'");
    }

    @Override
    public String getMountError() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMountError'");
    }
    

    //#region My Functions

    public void moveToAz(double azimuth) {
        mcss.setAzTelPosition(azimuth);
        mcss.cmdStartAzMotion(true);
    }
    public void moveToEl(double elevation) {
        mcss.setElTelPosition(elevation);
        mcss.cmdStartElMotion(true);
    }



























}
