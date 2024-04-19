package coloti.telescope;

import astri.astron.Target;

public class TelescopeController implements ITelescope{


    private int pip;


    public TelescopeController(int pip) {
        this.pip = pip;
    }

    @Override
    public void startup() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startup'");
    }

    @Override
    public void shutdown() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shutdown'");
    }

    @Override
    public void setConfiguration(TelescopeConfigTable tct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
    }

    @Override
    public void startDataTaking() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startDataTaking'");
    }

    @Override
    public void stopDataTaking() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stopDataTaking'");
    }

    @Override
    public void raiseAlarm() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'raiseAlarm'");
    }

    @Override
    public void lowerAlarm() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lowerAlarm'");
    }

    @Override
    public void presetTarget(Target source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presetTarget'");
    }

    @Override
    public void presetTrackingTime(double time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'presetTrackingTime'");
    }

    @Override
    public void moveTo(double azimuth, double elevation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveTo'");
    }

    @Override
    public void slew() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'slew'");
    }

    @Override
    public void stopSlew() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stopSlew'");
    }

    @Override
    public void track(double duration) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'track'");
    }

    @Override
    public void stopTrack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stopTrack'");
    }

    @Override
    public void park() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'park'");
    }

    @Override
    public void stow() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stow'");
    }

    @Override
    public void unstow() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unstow'");
    }

    @Override
    public void setTelescopeState(ETelescopeStates state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTelescopeState'");
    }

    @Override
    public ETelescopeStates getTelescopeStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTelescopeStatus'");
    }

    @Override
    public void getTimeToTarget() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTimeToTarget'");
    }

    @Override
    public void getRemainingTrackingTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRemainingTrackingTime'");
    }

    @Override
    public TelescopeConfigTable getTelescopeData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTelescopeData'");
    }

    @Override
    public void publishTelescopeData(int samplingTime) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'publishTelescopeData'");
    }

    @Override
    public void stopPublishTelescopeData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stopPublishTelescopeData'");
    }

    @Override
    public void reloadPointingModel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reloadPointingModel'");
    }

    @Override
    public void setPointingModelCoefficient(String name, double value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPointingModelCoefficient'");
    }

    @Override
    public void zeroPointingModel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'zeroPointingModel'");
    }

    @Override
    public void enablePointingModel(boolean enabled) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enablePointingModel'");
    }

    @Override
    public boolean isPointingModelEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPointingModelEnabled'");
    }

    @Override
    public boolean onSource() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSource'");
    }

    @Override
    public double timeToSource(long timeStartOfSource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timeToSource'");
    }

    @Override
    public IMount getMount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMount'");
    }
    
}
