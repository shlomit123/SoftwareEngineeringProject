package code;

public class Lamp extends Device {

	public Lamp() {
		// Device variables
		this.controlled = false;
		this.status = false;
		this.priority = 3;
		this.device_name = "";
		this.type = "Lamp";
		this.iconPath = "resources\\lampicon.jpg";
	}

}
