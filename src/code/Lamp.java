package code;

public class Lamp extends Device {

	public Lamp(int id) {
		this.reset(id);
	}

	@Override
	public void reset(int id) {
		// Device vars
		this.controlled = false;
		this.status = false;
		this.priority = 3;
		this.device_name = "Lamp";
		this.type = "Lamp";
		this.id = id;
	}

}
