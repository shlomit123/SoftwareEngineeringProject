package code;

public class TV extends Device {

	private int channel;

	public TV(String name, boolean status, boolean controlled, int channel) {
		// Local vars
		this.channel = channel;

		// Device vars
		this.controlled = controlled;
		this.status = status;
		this.priority = 1;
		this.device_name = name;
		this.type = "TV";
		this.iconPath = "resources\\tvicon.jpg";
	}

	// Method to get the channel field of the device
	public int get_channel() {
		return this.channel;
	}

	// Method to set the channel field of the device
	public void set_channel(int c) {
		this.channel = Math.abs(c % 2);
	}

	public void increase_channel() {
		set_channel(this.get_channel() + 1);
	}

	public void decrease_channel() {
		set_channel(this.get_channel() - 1);
	}

}
