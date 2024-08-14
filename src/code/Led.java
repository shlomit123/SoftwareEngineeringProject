package code;

public class Led extends Device{

	private int color;
	
	@Override
	public void reset() {
		// Local vars
		this.color = 0;
		
		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 0;
		this.device_name = "LED";
		this.type = "LED";
	}
	
	// Method to get the priority field of the device
    public int get_color() { return this.color; }
    
    // Method to set the priority field of the device
    public void set_color(int c) { this.color = c; }
	

}
