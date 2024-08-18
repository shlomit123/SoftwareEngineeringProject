package code;

public class TV extends Device {

	private int channel;

	public TV(int id) {
		this.reset(id);
	}

	@Override
	public void reset(int id) {

		// Local vars
		this.channel = 0;

		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 1;
		this.device_name = "TV";
		this.type = "TV";
		this.id = id;
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
