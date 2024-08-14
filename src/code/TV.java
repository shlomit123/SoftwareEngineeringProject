package code;

public class TV extends Device{

	private int channel;
	
	public TV()
	{
		this.reset();
	}
	
	@Override
	public void reset() {
		
		// Local vars
		this.channel = 0;
		
		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 2;
		this.device_name = "TV";
		this.type = "TV";
	}
	
	// Method to get the channel field of the device
    public int get_channel() {
        return this.channel;
    }
    
    // Method to set the channel field of the device
    public void set_channel(int c) {
        this.channel = c;
    }

}
