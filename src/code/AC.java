package code;

public class AC extends Device {

	private int temp;
	private int mode;
	
	public AC()
	{
		this.reset();
	}
	
	@Override
	public void reset() {
		
		// Local vars
		this.temp = 25;
		this.mode = 0;
		
		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 4;
		this.device_name = "AC";
		this.type = "AC";
	}
	
	// Method to get the temperature field of the device
    public int get_temp() {
        return this.temp;
    }
    
    // Method to set the temperature field of the device
    public void set_priority(int t) {
        this.temp = t;
    }
    
    // Method to get the mode field of the device
    public int get_mode() {
        return this.mode;
    }
    
    // Method to set the mode field of the device
    public void set_mode(int m) {
        this.mode = m;
    }	
	

}
