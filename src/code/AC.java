package code;

public class AC extends Device {
	private int temp;
	private int mode;

	public AC(String name, boolean status, boolean controlled, int temp) {
		// Local vars
		this.temp = temp;

		// Device vars
		this.controlled = controlled;
		this.status = status;
		this.priority = 4;
		this.device_name = name;
		this.type = "AC";
		this.iconPath = "resources\\acicon.jpg";
	}
	
	public AC() {
		// Local vars
		this.temp = 25;

		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 4;
		this.device_name = "";
		this.type = "AC";
		this.iconPath = "resources\\acicon.jpg";
		
	}
	// Method to get the temperature field of the device
	public int get_temp() {
		return this.temp;
	}
	// Method to set the temperature field of the device
	public void set_temp(int t) {
		this.temp = t;
	}
}

