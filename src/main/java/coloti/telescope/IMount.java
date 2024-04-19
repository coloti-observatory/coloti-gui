/**
 * 
 */
package coloti.telescope;

import java.util.List;



/**
 * @author gino
 *
 */
/**
 * @author gino
 *
 */
public interface IMount extends IAssembly{
	
	/**
	 * This function will move the Telescope to the specified azimuth and
        elevation position. 
	 * @param azimuth
	 * @param elevation
	 */
	public void moveToAzEl(double azimuth, double elevation);
	
	/**
	 *  This function moves the Telescope to the specified sequence positions
        at the specified times. Its used for all scientific
        observations. This functions checks
        that the trajectories are sorted in time ascending order and will
        silently discard trajectories that are in the past. 

	 * @param trajectory
	 */
	public void setTrajectory( List<TrajectoryData> trajectory);
   
	/**
	 * @param enable
	 */
	public void enableMountStatusDataPublication(boolean enable);
	
	
	/**
	 * @return
	 */
	public boolean isMountStatusDataPublicationEnabled();
	
	
   
    /**
     *  Set the tolerance to be used in the onSource calculation
     * @param tolerance
     */
    public void setTolerance(double tolerance);
  
    /** Get the tolerance currently used by the Mount component
     * 
     * @return
     */
    public double getTolerance();

    /** Get the limits on both axes. Typically the the azimuth limits are
     * -270 to +270 degrees and the elevation limits are 0.0 to 88.2.  All
     * values are returned in radians.
     */
    public TelescopeMotionLimits  getMotionLimits();
   
    /** Set the limits on both axes.
     * 
     * @param lim
     */
    public  void setMotionLimits(TelescopeMotionLimits lim);

    /** Set the lower elevation limit. The value specified must be in
     * radians. All commands that attempt to set the Telescope to a lower
     *  elevation will be truncated to this limit.
     */
    public void setMinimumElevation(double elMin); 

    /** Reset all limits to their initial value.
     *  
     */
    public void resetLimits();

    
       

    /** This function returns the estimated time, in seconds, it will take
     * for this telescope to slew between the "from" and "to" directions and
     * go "on-source". 
     */
    public double timeToSlew(double fromAz, double fromEl, double toAz, double toEl);
        

    /** This function returns the estimated time, in seconds, it will take
     * for this telescope to slew from its current position to the specified
     * direction and go "on-source". 
     */
    
    public double timeToSlewFromCurrent(double toAz, double toEl);
        
    /** Set the axis mode for both the azimuth and elevation axes.
     * This function is used to change the mode of the both axes.  
     */
                    
    public void setAxisMode(ETelescopeMountAxisModes axMode);
    
    /** Returns the Az axes mode.
     * 
     */
    public ETelescopeMountAxisModes getAzAxisMode();
    
    /** Returns the El axes mode.
     * 
     */
    public ETelescopeMountAxisModes getElAxisMode();
    
    /** This function returns true if the Local PLC  is in local access mode. In 
    * local access mode the PLC will ignore all commands and only
    * respond to monitor requests.
    */
    boolean inLocalMode();
    
    
    public boolean isMoveable();
       
    
    public String getMountError();

        
}
