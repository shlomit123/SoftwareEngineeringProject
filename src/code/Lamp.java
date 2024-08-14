package code;

public class Lamp extends Device{

	public Lamp()
	{
		this.reset();
	}
	@Override
	public void reset() {
		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 0;
		this.device_name = "Lamp";
		this.type = "Lamp";
		
	}

}
