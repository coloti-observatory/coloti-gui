package coloti.telescope;

import java.util.LinkedList;
import java.util.List;

import org.jastronomy.jsofa.JSOFA.JulianDate;

import astri.astron.TimeUtil;

/**
 * @author gino
 *
 */


public class TrajectoryData {
			private  JulianDate time; // Jd The time when the telescope should be at
	        private  double az=0;     // The azimuth in deg
	        private  double el=0;     // The elevation in deg
			private  double za=0;
			private  double refCorr=0;
			private  double tpAzCorr=0;
			private  double tpElCorr=0;
	     
	     
	        
	        // this position and moving at this velocity. number of milliseconds since January 1, 1970, 00:00:00 GMT
			
			public TrajectoryData() {

			}

			public TrajectoryData(JulianDate time, double az, double el) {
				this.time = time;
				this.az = az;
				this.el = el;
				this.za = 90 - el;
			}

			public double getAz() {
				return az;
			}

			public void setAz(double az) {
				this.az = az;
			}

			public double getEl() {
				return el;
			}

			public double getElAsRadians() {
				return Math.toRadians(el);
			}

			public double getAzAsRadians() {
				return Math.toRadians(az);
			}

			public void setEl(double el) {
				this.el = el;
			}

			public JulianDate getTime() {
				return time;
			}

			public void setTime(JulianDate time) {
				this.time = time;
			}
	
			public double getZa() {
				return za;
			}

			public void setZa(double za) {
				this.za = za;
			}

		

			public double getRefCorr() {
				return refCorr;
			}

			public void setRefCorr(double refCorr) {
				this.refCorr = refCorr;
			}

			public double getTpAzCorr() {
				return tpAzCorr;
			}

			public void setTpAzCorr(double tpAzCorr) {
				this.tpAzCorr = tpAzCorr;
			}

			public double getTpElCorr() {
				return tpElCorr;
			}

			public void setTpElCorr(double tpElCorr) {
				this.tpElCorr = tpElCorr;
			}

			@Override
			public String toString() {
				return "TrajectoryData [time=" + (time.djm0+time.djm1) + ", az=" + az + ", el=" + el + ", za=" + za + ", refCorr="
						+ refCorr + ", tpAzCorr=" + tpAzCorr + ", tpElCorr=" + tpElCorr + "]";
			}

			public static List<TrajectoryData> arrayToList(double[] data){
				List<TrajectoryData> tra = new LinkedList<>();
				for (int i=0;i<data.length;i+=3){
					TrajectoryData tr = new TrajectoryData(TimeUtil.jdToJulianDate(data[i]),data[i+1],data[i+2]);
					tra.add(tr);
				}
				return tra;
			}

			public static double[] arrayToList( List<TrajectoryData> data){
				double[] tra = new double[data.size()*3];
				int i=0;
				for ( TrajectoryData dat:data){
					tra[i] = TimeUtil.JulianDateToJd(dat.getTime());
					tra[i+1]=dat.getAz();
					tra[i+2]= dat.getEl();
					i+=3;
				}
				return tra;
			}
			
	    }  
	 
	    
	    /// This structure holds a synchronized "snapshot" of the telescope position
	    /// that is accessable through the getMountStatusData() method. All values
	    /// are in SI units ie., angles are in radians and positions in meters.


