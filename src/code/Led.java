package code;

public class Led extends Device {

	private int color;

	public Led(String name, boolean status, boolean controlled, int color) {
		// Local vars
		this.color = color;
		// Device vars
		this.controlled = controlled;
		this.status = status;
		this.priority = 2;
		this.device_name = name;
		this.type = "LED";
		this.iconPath = "resources\\ledicon.jpg";
	}

	// Method to get the priority field of the device
	public int get_color() {
		return this.color;
	}

	// Method to set the priority field of the device
	public void set_color(int c) {
		this.color = c;
	}

}
