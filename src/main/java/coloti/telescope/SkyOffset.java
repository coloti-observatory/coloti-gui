/**
 * 
 */
package coloti.telescope;

import coloti.opcua.OpcUaConnector;

/**
 * @author gino
 *
 */
public class SkyOffset {

	private double offsetElevation;
	private double offsetAzimuth;
	private EMcsVariables[] Vars = {
			EMcsVariables.OFFSET_AZIMUTH,
			EMcsVariables.OFFSET_ELEVATION,
	};
	private OpcUaConnector opcuac;



	public SkyOffset(OpcUaConnector opcuac) {
		this.opcuac = opcuac;
	}

	public void setOffsetAzimuth(double val) {
		opcuac.setDoubleValue(EMcsVariables.OFFSET_AZIMUTH, val);
		offsetAzimuth=val;
	}

	public double getOffsetAzimuth() {
		offsetAzimuth = opcuac.getDoubleValue(EMcsVariables.OFFSET_AZIMUTH);
		return offsetAzimuth;
	}

	public void setOffsetElevation(double val) {
		opcuac.setDoubleValue(EMcsVariables.OFFSET_ELEVATION, val);
		offsetElevation=val;
	}

	public double getOffsetElevation() {
		offsetElevation = opcuac.getDoubleValue(EMcsVariables.OFFSET_ELEVATION);
		return offsetElevation;
	}

	public EMcsVariables[] getVars() {
		return Vars;
	}

	@Override
	public String toString() {
		return "SkyOffset [offsetElevation=" + offsetElevation + ", offsetAzimuth=" + offsetAzimuth + "]";
	}

	
	
}
