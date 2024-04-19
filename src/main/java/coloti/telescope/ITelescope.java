package coloti.telescope;

import astri.astron.Target;

/**
 * @author gino
 *
 */
public interface ITelescope {
	
	/**
	 * 
	 */
	
	 /**
	 * //cold start of a telescope --> each assembly are started up
	 */
	public void startup();  
	
	/**
	 * //the telescope is in safe state all assemblies are powered-off
	 */
	public void shutdown(); 
	
	
	/**
	 * //the telescope is in safe state all assemblies are powered-off
	 */
	public void setConfiguration(TelescopeConfigTable tct); 
	
	public void startDataTaking();
	
	public void stopDataTaking();
	
	public void raiseAlarm();
	
	public void lowerAlarm();
	
	/**
	 * // Preset telescope to given RA/DEC coordinates
	 * @param source 
	 * 			the target
	 */
	public void presetTarget(Target source);

	/**
	 * // preset the tracking time. The tracking time counter start when the telescope is “on target”.
	 * @param time
	 * 	durtion of the tracking
	 */
	public void presetTrackingTime(double time); 
	

	/**
	 * //Move the telescope to the specified az and El position. 
	 * @param azimuth the azimuth final position
	 * @param elevation the elevation final position
	 */
	public void moveTo(double azimuth, double elevation); 

	/**
	 * //slew the telescope to the currently defined source (as for presetTarget) no traking is performed at the ned of the slew
	 */
	public void slew(); 

	/**
	 * //cancel the current slewing
	 */
	public void stopSlew(); 

	/**
	 *  //Slew to and Track the currently defined source. The telescope keeps tracking until the next stopTrack() command arrives or the Tracking time is elapsed.
	 */
	public void track(double duration ) ;

	/**
	 * //cancel the current tracking. 
	 */
	public void stopTrack() ; 
	

	/**
	 * // Move the telescope to the stow position (TBD) without inserting the stow pins. This command should be used at the end of an observing session to park the telescope in a safe position.
	 */
	public void park() ; 
	

	/**
	 * // Move the telescope to the stow position (TBD), insert the stow pins. The scheduler will refuse to observe any further object until the telescope is un-stowed. This command should be used in case of critical environmental conditions that could do harm to the telescope if it is not stowed.
	 */
	public void stow( ) ; 

	/**
	 * // Retract the telescope stow pins and park the telescope at the stow position (TBD). The telescope is now prepared for observations.
	 */
	public void unstow( ) ; 
	
	/**
	 * //set the telescope status (The meaning of each state can be detailed TBD) Each state imply several configuration to be loaded or activated in the real hardware device managed by telescope dedicated software components.
	 * @param state the desired state 
	 */
	public void setTelescopeState(ETelescopeStates state); 

	/**
	 * // return the current telescope state
	 * @return
	 */
	public ETelescopeStates getTelescopeStatus(); 

	/**
	 * // return the remaining slewing time
	 */
	public void getTimeToTarget(); 

	/**
	 * // return the remaining tracking time
	 */
	public void getRemainingTrackingTime(); 

	/**
	 * // this command return the Telescope info TBD.
	 * @return the general info about the telescope
	 */
	public TelescopeConfigTable getTelescopeData () ; 

	
	/**
	 * // This function activate the publishing of the telescope data structure on the appropriate notification channel)
	 * This information concern mainly the status and the activities ongoing in the telescope, this function will also activate the publication of the 
	 * information by its assembly. (TBD)
	 * @param samplingTime
	 */
	public void publishTelescopeData(int samplingTime); 

	/**
	 * // This function activate the publishing of the telescope data structure on the appropriate notification channel)
	 */
	public void stopPublishTelescopeData(); 
	


	//public void setWeatherData(WeatherInfo temp);

    //public TelescopeFocusTable getFocusModel();
    
    //public void setFocusModel(TelescopeFocusTable model);
 
    /** This triggers the reporting of the focus position, to data capture
     * 
     * @return
     */
    //public TelescopeFocusTable reportFocusPosition();

    /** Reloads the pointing model from TMCDB. This must be done when model
     * in the Archive is changed, to pick up the changes.
    */
    public void reloadPointingModel();
   

    /** This returns the current values stored in the pointing
    * model.
    */
    
    //public TelescopePointingModelTable getPointingModel();
    
    /** Specify a new set of pointing model coefficients. Coefficients
     *which are not specified are set to zero.
     */
    //public void setPointingModel(TelescopePointingModelTable model) ;
        
    
    /** This sets the pointing model for the mount, any terms not listed are
     *   set to zero. 
    */
    public void setPointingModelCoefficient(String name, double value); 
       
 
    /** Zeros all coefficients in the pointing model. The pointing model is
     still enabled but does not change the positions.
    */
    public void zeroPointingModel(); 
    
    /** Enable/Disable the pointing model. A disabled model will not adjust
    * the Telescope positions and is equivalent to setting all coefficients
    to zero.
    */
    public void enablePointingModel(boolean enabled);
    
    /** Returns true is the  pointing model is enabled, false otherwise
     * 
     */
    public boolean isPointingModelEnabled();
    
    /** This triggers the reporting of the pointing model offsets, to data capture
     * 
     * @return
     */
    //public TelescopePointingModelTable reportPointingModelOffeset();
           
	/** returns true if the requested position has been reached according
     to the tolerance
     */
    public boolean onSource();
	
	/** This function returns the estimated time, in seconds, it will take
     *  for this Telescope to slew to the commanded position i.e., for the
     *  Telescope to go "on-source". This function will return zero if the
     *  Telescope already is on-source so its important to command the
     * Telescope to start moving to the new position before calling this
     * function.
    */
    
    public double timeToSource(long timeStartOfSource);

	/**
	 * //return the name of the MountComponent
	 * @return
	 */
	public IMount getMount(); 
//	
//	/**
//	 * //return the name of the Amc Component
//	 * @return
//	 */
//	public String getAmc(); 
//	
//	/**
//	 * //return the name of the Aux Component
//	 * @return
//	 */
//	public String getAux(); 
//	
//	public String getCamera(); 

}
