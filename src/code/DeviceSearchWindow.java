package code;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DeviceSearchWindow extends JFrame {

	private SearchedDevicesPanel devicesPanel;
	private SearchTextBoxPanel searchPanel;
	private MainAppWindow mainAppWindow1;

	// The search window to assign unassigned devices
	public DeviceSearchWindow(MainAppWindow mainAppWindow, Home home) {
		mainAppWindow1 = mainAppWindow;
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle("Device search window");
		// Setting the program to exit when closing the frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Setting the size of the frame
		this.setSize(415, 365);
		// prevent frame from being re-sized
		this.setResizable(false);
		// setting frame's position to center of screen
		this.setLocationRelativeTo(null);
		// set background color
		this.getContentPane().setBackground(Color.red);
		// creating an ImageIcon to set a non-default icon to the frame
		ImageIcon logo = new ImageIcon("resources\\smarthomelogo.png");
		// setting the icon of the frame
		this.setIconImage(logo.getImage());
		this.setLayout(null);

		this.devicesPanel = new SearchedDevicesPanel(415, 315, mainAppWindow, home);
		this.searchPanel = new SearchTextBoxPanel(415, 50, mainAppWindow, home);
		this.add(searchPanel);
		this.add(devicesPanel);
		// Making the frame visible
		this.setVisible(true);

	}

	public SearchedDevicesPanel getSearchedDevicesPanel() {
		return this.devicesPanel;
	}

	public SearchTextBoxPanel getSearchTextBoxPanel() {
		return this.searchPanel;
	}
}
