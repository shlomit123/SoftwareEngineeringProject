package code;

public class Led extends Device {

	private int color;

	public Led(String name) {
		this.reset(name);
	}

	@Override
	public void reset(String name) {
		// Local vars
		this.color = 0;
		// Device vars
		this.controlled = false;
		this.status = false;
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
