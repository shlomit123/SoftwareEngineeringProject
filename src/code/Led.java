package code;

public class Led extends Device {

	private int color;

	public Led(int id) {
		this.reset(id);
	}

	@Override
	public void reset(int id) {
		// Local vars
		this.color = 0;
		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 2;
		this.device_name = "LED";
		this.type = "LED";
		this.id = id;
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
