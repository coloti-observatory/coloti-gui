package coloti.telescope;

//import astri.telescope.mount.ConfigTable;

public class TelescopeConfigTable {
	private int serialID = 1;
	private String name;
	private String manufacturer ="EIE";
	private String type ="ASTRI-MA";
	private double diameter=4.0; //Use S.I. units
	private double latitude;
	private double longitude;
	private double altitude;
	private String mountConfigFile;
	//private ConfigTable mountConfig;
	
	
	public TelescopeConfigTable() {
		
	}
	public int getSerialID() {
		return serialID;
	}
	public String getName() {
		return name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getType() {
		return type;
	}
	public double getDiameter() {
		return diameter;
	}
	
	public void setSerialID(int serialID) {
		this.serialID = serialID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	/* 
	public ConfigTable getMountConfig() {
		return mountConfig;
	}
	public void setMountConfig(ConfigTable mountConfig) {
		this.mountConfig = mountConfig;
	}
	*/
	public String getMountConfigFile() {
		return mountConfigFile;
	}
	public void setMountConfigFile(String mountConfigFile) {
		this.mountConfigFile = mountConfigFile;
	}
	@Override
	public String toString() {
		return "TelescopeConfigTable [serialID=" + serialID + ", name=" + name + ", manufacturer=" + manufacturer
				+ ", type=" + type + ", diameter=" + diameter + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", altitude=" + altitude + ", mountConfigFile=" + mountConfigFile + ", mountConfig=" //+ mountConfig
				+ "]";
	}
	
}
