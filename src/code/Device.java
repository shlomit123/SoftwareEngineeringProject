package code;

public abstract class Device {
	protected String type;
	protected String device_name;
    protected boolean status = false;
    protected boolean controlled = false;
    protected int priority;
    

    // method to turn on the device
    public void turn_on()
    { this.status = true; }
    
    // method to turn off the device
    public void turn_off()
    { this.status = false; }
    
    //Getters
    // Method to get the priority field of the device
    public String get_device_type() { return this.type; }
    
    // Method to get the priority field of the device
    public String get_device_name() { return this.device_name; }
    
    // Method to get the status of the device
    public boolean get_status() { return this.status ? true : false; }
    
    // Method to get the controlled field of the device
    public boolean get_controlled() { return this.controlled ? true : false; }
    
    // Method to get the priority field of the device
    public int get_priority() { return this.priority; }
    
    
    //Setters
    // Method to set the priority field of the device
    public void set_device_type(String type) { this.type = type; }
    
    // Method to set the priority field of the device
    public void set_device_name(String name) { this.device_name = name; }
    
    // Method to set the controlled field of the device
    public void set_controlled(boolean bool) { this.status = bool; }
    
    // Method to set the priority field of the device
    public void set_priority(int p) { this.priority = p; }
    

    // Method to toggle the device state
    public void toggle() {
        if (this.status) {
            turn_off();
        } else {
            turn_on();
        }
    }

    // Abstract method to reset the device to its default state
    public abstract void reset();
}
