package code;

public class Lamp extends Device {

	public Lamp(String name, boolean status, boolean controlled) {
		// Device vars
		this.controlled = controlled;
		this.status = status;
		this.priority = 3;
		this.device_name = name;
		this.type = "Lamp";
		this.iconPath = "resources\\lampicon.jpg";
	}
}
