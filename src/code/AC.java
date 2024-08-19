package code;

public class AC extends Device {
	private int temp;

	public AC() {
		// Local variables
		this.temp = 25;

		// Device variables
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
		if (t <= 30 && t >= 15)
			this.temp = t;
	}
}
