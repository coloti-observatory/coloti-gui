package coloti.telescope;

import java.util.List;

import org.jastronomy.jsofa.JSOFA.JulianDate;

import astri.astron.Target;
import astri.astron.Weather;

public interface ITrajectoryGenerator {
	
	/**
	 * @param startTime
	 * @return
	 */
	List<TrajectoryData> getTrajectory(Target source, SkyOffset offset, long startTime,long timeStep);

	/**
	 * @param source
	 * @param startTime
	 * @param timeStep
	 * @return
	 */
	List<TrajectoryData> getTrajectory(Weather atm, JulianDate startTime);
	
	/**
	 * @param source
	 * @param startTime
	 * @return
	 */
	TrajectoryData getHorizontal(Target source,long startTime);
	
	/**
	 * @param ra  //apparent ra
	 * @param dec //apparent dec 
	 * @param startTime
	 * @return
	 */
	TrajectoryData getHorizontal(double ra,double dec, long startTime);

}
