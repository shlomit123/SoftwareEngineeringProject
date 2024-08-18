package code;

public class Lamp extends Device {

	public Lamp(String name) {
		this.reset(name);
	}

	@Override
	public void reset(String name) {
		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 3;
		this.device_name = name;
		this.type = "Lamp";
		this.iconPath = "resources\\lampicon.jpg";
	}

}
