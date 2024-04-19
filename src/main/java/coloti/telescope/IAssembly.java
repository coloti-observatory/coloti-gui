/**
 * 
 */
package coloti.telescope;



/**
 * @author gino
 *
 */
public interface IAssembly {
	
	public void init();  // loaded->standby (configuration applied)
	
	public void start(); // standby->online[idle] 
	
	public void stop();  // online[idle]->standby
	
	public void shutdown(); // standby->loaded

	public void maintenance();

	public EHardwareState getCurrentHwState();
	

}
