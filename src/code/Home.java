package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Home {
	private MainAppWindow window = new MainAppWindow();
	private ArrayList<Device> devices = new ArrayList<>(); 

	//constructor
	public Home() {
		initDevices();
		
	}
	
	//create instances for all devices in home and add to devices array
	public void initDevices() {
		Lamp lamp1 = new Lamp();
		Lamp lamp2 = new Lamp();
		Lamp lamp3 = new Lamp();
		AC ac1 = new AC();
		AC ac2 = new AC();
		TV tv = new TV();
		devices.add(lamp1);
		devices.add(lamp2);
		devices.add(lamp3);
		devices.add(ac1);
		devices.add(ac2);
		devices.add(tv);
	}
	
	public ArrayList<Device> getDevices(){ return this.devices; }  
	
	public void sortDevices() { //////////////////////////
		Collections.sort(devices, Home.compareDevicesType);
	}
	
	public static Comparator<Device> compareDevicesType = new Comparator<Device>() {

		public int compare(Device dev1, Device dev2) {
			return Integer.compare(dev1.get_priority(), dev2.get_priority());
		}
	};
	
	public ArrayList<Device> findDevice(String type) {
		ArrayList<Device> ofType = new ArrayList<>();
		for (Device dev : devices) {
			if (dev.type == type) //change to compare
				ofType.add(dev);
		}
		return ofType;
	}

	public void turnOnAllDevices() {
        for (Device device : devices) {
            device.turn_on();
        }
    }

    public void turnOffAllDevices() {
        for (Device device : devices) {
            device.turn_off();
        }
    }
}
