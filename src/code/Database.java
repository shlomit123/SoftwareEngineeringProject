package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
	// Implement a JSON file based database
	private static final String FILE_NAME = "database.json";

	// Create the file for the database for the first time (already exists on the
	// repository)
	public static void createFileIfNotExists() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Save devices' data to the database
	public static void writeDevicesToFile(ArrayList<Device> devices) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < devices.size(); i++) {
			sb.append("{");
			if (devices.get(i) instanceof AC) {
				AC ac = (AC) devices.get(i);
				sb.append("\"name\":").append(ac.get_device_name()).append(",");
				sb.append("\"status\":").append(ac.get_status()).append(",");
				sb.append("\"controlled\":").append(ac.get_controlled()).append(",");
				sb.append("\"temp\":").append(ac.get_temp());
			} else if (devices.get(i) instanceof Lamp) {
				Lamp lamp = (Lamp) devices.get(i);
				sb.append("\"name\":").append(lamp.get_device_name()).append(",");
				sb.append("\"status\":").append(lamp.get_status()).append(",");
				sb.append("\"controlled\":").append(lamp.get_controlled()).append(",");
			} else if (devices.get(i) instanceof Led) {
				Led led = (Led) devices.get(i);
				sb.append("\"name\":").append(led.get_device_name()).append(",");
				sb.append("\"status\":").append(led.get_status()).append(",");
				sb.append("\"controlled\":").append(led.get_controlled()).append(",");
				sb.append("\"color\":").append(led.get_color());
			} else if (devices.get(i) instanceof TV) {
				TV tv = (TV) devices.get(i);
				sb.append("\"name\":").append(tv.get_device_name()).append(",");
				sb.append("\"status\":").append(tv.get_status()).append(",");
				sb.append("\"controlled\":").append(tv.get_controlled()).append(",");
				sb.append("\"channel\":").append(tv.get_channel());
			}

			sb.append("}");

			if (i < devices.size() - 1) {
				sb.append(",");
			}
		}

		sb.append("]");

		try (FileWriter file = new FileWriter(FILE_NAME)) {
			file.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Load devices' data from the database
	public static void readDevicesFromFile(Home home) {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String jsonString = sb.toString();

		// Remove the leading and trailing brackets
		jsonString = jsonString.substring(1, jsonString.length() - 1);

		// Split by "},{" to handle each device separately
		String[] deviceStrings = jsonString.split("\\},\\{");

		for (String deviceString : deviceStrings) {
			deviceString = deviceString.replaceAll("[{}]", ""); // Remove curly braces

			String[] attributes = deviceString.split(",");

			String deviceName = "";
			String status = "";
			String controlled = "";
			String temp = "";
			String color = "";
			String channel = "";

			for (String attribute : attributes) {
				String[] keyValue = attribute.split(":");
				String key = keyValue[0].replace("\"", "").trim();
				String value = keyValue[1].replace("\"", "").trim();

				switch (key) {
				case "name":
					deviceName = value;
					break;
				case "status":
					status = value;
					break;
				case "controlled":
					controlled = value;
					break;
				case "temp":
					temp = value;
					break;
				case "color":
					color = value;
					break;
				case "channel":
					channel = value;
					break;
				default:
					break;
				}
			}

			// set the appropriate device attributes
			switch (deviceName) {

			case "Right Lamp":
				home.getLamp1().set_device_name(deviceName);
				home.getLamp1().set_status(Boolean.parseBoolean(status));
				home.getLamp1().set_controlled(Boolean.parseBoolean(controlled));
				break;
			case "Left Lamp":
				home.getLamp2().set_device_name(deviceName);
				home.getLamp2().set_status(Boolean.parseBoolean(status));
				home.getLamp2().set_controlled(Boolean.parseBoolean(controlled));
				break;
			case "LED":
				home.getLed().set_device_name(deviceName);
				home.getLed().set_status(Boolean.parseBoolean(status));
				home.getLed().set_controlled(Boolean.parseBoolean(controlled));
				home.getLed().set_color(Integer.parseInt(color));
				break;
			case "Right AC":
				home.getAc1().set_device_name(deviceName);
				home.getAc1().set_status(Boolean.parseBoolean(status));
				home.getAc1().set_controlled(Boolean.parseBoolean(controlled));
				home.getAc1().set_temp(Integer.parseInt(temp));
				break;
			case "Left AC":
				home.getAc2().set_device_name(deviceName);
				home.getAc2().set_status(Boolean.parseBoolean(status));
				home.getAc2().set_controlled(Boolean.parseBoolean(controlled));
				home.getAc2().set_temp(Integer.parseInt(temp));
				break;
			case "TV":
				home.getTv().set_device_name(deviceName);
				home.getTv().set_status(Boolean.parseBoolean(status));
				home.getTv().set_controlled(Boolean.parseBoolean(controlled));
				home.getTv().set_channel(Integer.parseInt(channel));
				break;
			default:
				System.out.println("Unknown device type: " + deviceName);
				break;
			}
		}
	}
}
