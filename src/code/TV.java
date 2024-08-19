package code;

public class TV extends Device {

	private int channel;

	public TV(String name) {
		this.reset(name);
	}

	@Override
	public void reset(String name) {

		// Local vars
		this.channel = 0;

		// Device vars
		this.controlled = false;
		this.status = false;
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
		this.channel = ((c % 4) + 4) % 4 ;
	}
	
	//Method to increase the channel number
	public void increase_channel() {
		set_channel(this.get_channel() + 1);
	}
	
	//Method to decrease the channel number
	public void decrease_channel() {
		set_channel(this.get_channel() - 1);
	}

}
