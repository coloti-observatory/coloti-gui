package coloti.telescope;

public class TelescopeMotionLimits {
	
	private double maxAz;
	private double minAz;
	private double minEl;
	private double maxEl;
	
	
	/**
	 * 
	 */
	public TelescopeMotionLimits() {
		
	}
	/**
	 * Azimuth and elevation potition limits
	 * 
	 * @param maxAz 
	 * @param minAz
	 * @param minEl
	 * @param maxEl
	 */
	public TelescopeMotionLimits(double maxAz, double minAz, double minEl, double maxEl) {
		this.maxAz = maxAz;
		this.minAz = minAz;
		this.minEl = minEl;
		this.maxEl = maxEl;
	}
	/**
	 * @return the maxAz
	 */
	public double getMaxAz() {
		return maxAz;
	}
	/**
	 * @return the minAz
	 */
	public double getMinAz() {
		return minAz;
	}
	/**
	 * @return the minEl
	 */
	public double getMinEl() {
		return minEl;
	}
	/**
	 * @return the maxEl
	 */
	public double getMaxEl() {
		return maxEl;
	}
	/**
	 * @param maxAz the maxAz to set
	 */
	public void setMaxAz(double maxAz) {
		this.maxAz = maxAz;
	}
	/**
	 * @param minAz the minAz to set
	 */
	public void setMinAz(double minAz) {
		this.minAz = minAz;
	}
	/**
	 * @param minEl the minEl to set
	 */
	public void setMinEl(double minEl) {
		this.minEl = minEl;
	}
	/**
	 * @param maxEl the maxEl to set
	 */
	public void setMaxEl(double maxEl) {
		this.maxEl = maxEl;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TelescopeMotionLimits [maxAz=" + maxAz + ", minAz=" + minAz + ", minEl=" + minEl + ", maxEl=" + maxEl
				+ "]";
	}

}
