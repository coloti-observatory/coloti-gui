package coloti.telescope;

import java.util.Arrays;

import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;

import astri.astron.FieldSourceObservability;
import astri.astron.Target;
import coloti.opcua.OpcUaConnector;

public class SkyTarget {

	// private double inputRightAscension; /* the right ascension of the source
	// taken from the catalog in radians*/
	// private double inputDeclination; /* the declination of the source taken from
	// the catalog in radians*/
	// private double inputJEpoch; /* the julian epoch the catalog RA and Dec refer
	// to */
	// private double inputRaProperMotion; /* the proper motion in right ascension
	// (milli arcseconds per tropical year if FK4 is used, per julian year if Fk5 is
	// used)*/
	// private double inputDecProperMotion; /* the proper motion in declination
	// (milli arcseconds per tropical year if FK4 is used, per julian year if Fk5 is
	// used) */
	// private double inputParallax; /* the parallax in milli arcseconds. */
	// private double inputRadialVelocity; /* the radial velocity in Km/sec (
	// positive value means the source is moving away) */
	// private double inputGalacticLongitude; /* the galactic longitude of the
	// source in radians */
	// private double inputGalacticLatitude; /* the galactic latitude of the source
	// in radians*/
	private short targetCoordtype=0;
	private double targetPx =0.0;
	private double targetEpoch = 2000.0;
	private double targetPmRa = 0.0;
	private double targetPmDec = 0.0;
	private double targetOffsetRa =0.0;
	private double targetOffsetDec = 0.0;
	private double targetEquinox=2000.0;
	private Integer targetCoordframe=0;
	private String targetName="";
	private double targetRv=0.0;
	private double targetDec=0.0;
	private double targetRa=0.0;
	private boolean useRefraction=false;
	private boolean usePointingModel = false; 
	private double esposureTime=0.0;
	private FieldSourceObservability sfo;

	private EMcsVariables[] Vars = {

			EMcsVariables.TARGET_COORDTYPE,
			EMcsVariables.TARGET_PX,
			EMcsVariables.TARGET_EPOCH,
			EMcsVariables.TARGET_PM_RA,
			EMcsVariables.TARGET_PM_DEC,
			EMcsVariables.TARGET_EQUINOX,
			EMcsVariables.TARGET_COORDFRAME,
			EMcsVariables.TARGET_NAME,
			EMcsVariables.TARGET_RV,
			EMcsVariables.TARGET_DEC,
			EMcsVariables.TARGET_RA,
			EMcsVariables.REFRACTION_ONOFF,
			EMcsVariables.POINTING_MODEL_ONOFF,
			EMcsVariables.POINTING_MODEL_STATUS

	};

	private OpcUaConnector opcuac;
	private boolean newTarget =false;
	private boolean isUploaded=false;

	

	public SkyTarget(OpcUaConnector opcuac) {
		this.opcuac = opcuac;
	}

	public void setSkyTarget(String targetName,double targetRa,double targetDec,double targetEpoch, double targetPmRa, double targetPmDec,  double targetRv) {
		this.targetEpoch = targetEpoch;
		this.targetPmRa = targetPmRa;
		this.targetPmDec = targetPmDec;
		this.targetName = targetName;
		this.targetRv = targetRv;
		this.targetDec = targetDec;
		this.targetRa = targetRa;
		this.newTarget=true;
		this.isUploaded=false;
	}

	public void setSkyTarget(String targetName,double targetRa,double targetDec) {
		this.targetDec = targetDec;
		this.targetRa = targetRa;
		this.targetEpoch = 2000.;
		this.targetPmRa = 0.;
		this.targetPmDec = 0.;
		this.targetName = targetName;
		this.targetRv = 0.;
		this.newTarget=true;
		this.isUploaded=false;
	}

	public void setSkyTarget(Target target){
		this.targetEpoch = 2000.;
		this.targetPmRa = target.getPmRA();
		this.targetPmDec = target.getPmDec();
		this.targetName = target.getName();
		this.targetRv = target.getRadVel();
		this.targetDec = target.getDec2000();
		this.targetRa = target.getRa2000();
		this.targetPx = target.getParallax();
		this.useRefraction=target.isUseRefraction();
		this.useRefraction=target.isUsePointingModel();
		this.newTarget=true;
		this.isUploaded=false;

	}

	public void uploadTarget() throws Exception{

		if(newTarget && !isUploaded){
			setTargetName(targetName);
			setTargetRa(targetRa);
			setTargetDec(targetDec);
			setTargetEpoch(targetEpoch);
			setTargetPmRa(targetPmRa);
			setTargetPmDec(targetPmDec);
			setTargetRv(targetRv);
			setTargetPx(targetPx);
			setUsePointingModel(usePointingModel);
			setUseRefraction(useRefraction);
			newTarget=false;
			isUploaded=true;
		}
	}

	public boolean isUploaded() {
		return isUploaded;
	}

	public void setTargetCoordtype(short val) throws Exception {
		if(!opcuac.setShortValue(EMcsVariables.TARGET_COORDTYPE, val).isGood()){
			throw new Exception("Unable to set value");
		}
	}

	public short getTargetCoordtype() {
		targetCoordtype = opcuac.getShortValue(EMcsVariables.TARGET_COORDTYPE);
		return targetCoordtype;
	}

	public void setTargetPx(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_PX, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetPx() {
		targetPx = opcuac.getDoubleValue(EMcsVariables.TARGET_PX);
		return targetPx;
	}

	public void setTargetEpoch(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_EPOCH, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetEpoch() {
		targetEpoch = opcuac.getDoubleValue(EMcsVariables.TARGET_EPOCH);
		return targetEpoch;
	}

	public void setTargetPmRa(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_PM_RA, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetPmRa() {
		targetPmRa = opcuac.getDoubleValue(EMcsVariables.TARGET_PM_RA);
		return targetPmRa;
	}

	public void setTargetPmDec(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_PM_DEC, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetPmDec() {
		targetPmDec = opcuac.getDoubleValue(EMcsVariables.TARGET_PM_DEC);
		return targetPmDec;
	}

	
	public void setTargetEquinox(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_EQUINOX, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetEquinox() {
		targetEquinox = opcuac.getDoubleValue(EMcsVariables.TARGET_EQUINOX);
		return targetEquinox;
	}

	public void setTargetCoordframe(Integer val) throws Exception {
		if(!opcuac.setIntegerValue(EMcsVariables.TARGET_COORDFRAME, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public Integer getTargetCoordframe() {
		targetCoordframe = opcuac.getIntegerValue(EMcsVariables.TARGET_COORDFRAME);
		return targetCoordframe;
	}

	public void setTargetName(String val) throws Exception {
		if(!opcuac.setStringValue(EMcsVariables.TARGET_NAME, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public String getTargetName() {
		targetName = opcuac.getStringValue(EMcsVariables.TARGET_NAME);
		return targetName;
	}

	public void setTargetRv(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_RV, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetRv() {
		targetRv = opcuac.getDoubleValue(EMcsVariables.TARGET_RV);
		return targetRv;
	}

	public void setTargetDec(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_DEC, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetDec() {
		targetDec = opcuac.getDoubleValue(EMcsVariables.TARGET_DEC);
		return targetDec;
	}

	public void setTargetRa(double val) throws Exception {
		if(!opcuac.setDoubleValue(EMcsVariables.TARGET_RA, val).isGood()){
			throw new Exception("Unamble to set value");
		}
	}

	public double getTargetRa() {
		targetRa = opcuac.getDoubleValue(EMcsVariables.TARGET_RA);
		return targetRa;
	}

	public EMcsVariables[] getVars() {
		return Vars;
	}


	public FieldSourceObservability getVisbility() {
		return sfo;
	}

	public void setVisibility(FieldSourceObservability sfo) {
		this.sfo = sfo;
	}

	

	public boolean isUseRefraction() {

		return useRefraction;
	}

	public void setUseRefraction(boolean useRefraction) throws Exception {
		if(!opcuac.setBooleanValue(EMcsVariables.REFRACTION_ONOFF, useRefraction).isGood()){
			throw new Exception("Unamble to set value");
		}
		this.useRefraction = useRefraction;
	}

	public boolean isUsePointingModel() {
		return usePointingModel;
	}

	public void setUsePointingModel(boolean usePointingModel) throws Exception {
		if(!opcuac.setBooleanValue(EMcsVariables.POINTING_MODEL_ONOFF, usePointingModel).isGood()){
			throw new Exception("Unamble to set value");
		}
		this.usePointingModel = usePointingModel;
	}

	public double getEsposureTime() {
		return esposureTime;
	}

	public void setEsposureTime(double esposureTime) {
		this.esposureTime = esposureTime;
	}

	public FieldSourceObservability getSfo() {
		return sfo;
	}

	public void setSfo(FieldSourceObservability sfo) {
		this.sfo = sfo;
	}

	public boolean isNewTarget() {
		return newTarget;
	}

	public void setNewTarget(boolean newTarget) {
		this.newTarget = newTarget;
	}

	public void setUploaded(boolean isUploaded) {
		this.isUploaded = isUploaded;
	}

	@Override
	public String toString() {
		return "SkyTarget [targetCoordtype=" + targetCoordtype + ", targetPx=" + targetPx + ", targetEpoch="
				+ targetEpoch + ", targetPmRa=" + targetPmRa + ", targetPmDec=" + targetPmDec + ", targetOffsetRa="
				+ targetOffsetRa + ", targetOffsetDec=" + targetOffsetDec + ", targetEquinox=" + targetEquinox
				+ ", targetCoordframe=" + targetCoordframe + ", targetName=" + targetName + ", targetRv=" + targetRv
				+ ", targetDec=" + targetDec + ", targetRa=" + targetRa + ", useRefraction=" + useRefraction
				+ ", usePointingModel=" + usePointingModel + ", Vars=" + Arrays.toString(Vars) + ", newTarget="
				+ newTarget + ", isUploaded=" + isUploaded + "]";
	}

	
	
}
