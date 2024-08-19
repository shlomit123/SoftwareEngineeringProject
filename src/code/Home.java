package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Home {
	private ArrayList<Device> devices = new ArrayList<>();
	private Lamp lamp1;
	private Lamp lamp2;
	private Led led;
	private AC ac1;
	private AC ac2;
	private TV tv;
	private MainAppWindow window;

	// constructor
	public Home() {
		Database.createFileIfNotExists();
		initDevices();
		window = new MainAppWindow(this);
	}

	// create instances for all devices in home and add to devices array
	public void initDevices() {
		lamp1 = new Lamp("Right Lamp", false, false);
		lamp2 = new Lamp("Left Lamp", false, false);
		led = new Led("LED", false, false, -1);
		ac1 = new AC("Right AC", false, false, 25);
		ac2 = new AC("Left AC", false, false, 25);
		tv = new TV("TV", false, false, 0);
		Database.readDevicesFromFile(this);
		devices.add(lamp1);
		devices.add(ac1);
		devices.add(lamp2);
		devices.add(tv);
		devices.add(ac2);
		devices.add(led);
	}

	// getters
	public MainAppWindow getMainAppWindow() {
		return this.window;
	}

	public ArrayList<Device> getDevices() {
		return this.devices;
	}

	public Led getLed() {
		return this.led;
	}

	public TV getTv() {
		return this.tv;
	}

	public AC getAc1() {
		return this.ac1;
	}

	public AC getAc2() {
		return this.ac2;
	}

	public Lamp getLamp1() {
		return this.lamp1;
	}

	public Lamp getLamp2() {
		return this.lamp2;
	}

	// sort devices array
	public void sortDevices() {
		Collections.sort(devices, Home.compareDevicesType);
	}

	// comparator for sort method- comparing according to device priority
	public static Comparator<Device> compareDevicesType = new Comparator<Device>() {

		public int compare(Device dev1, Device dev2) {
			return Integer.compare(dev1.get_priority(), dev2.get_priority());
		}
	};

	public ArrayList<Device> findDevice(String type) {
		ArrayList<Device> ofType = new ArrayList<>();
		for (Device dev : devices) {
			if (dev.type.equalsIgnoreCase(type))
				ofType.add(dev);
		}
		return ofType;
	}

	public void turnOnAllDevices() {////////////////////////
		for (Device device : devices) {
			device.turn_on();
		}
	}

	public void turnOffAllDevices() {//////////////////////////
		for (Device device : devices) {
			device.turn_off();
		}
	}
}
