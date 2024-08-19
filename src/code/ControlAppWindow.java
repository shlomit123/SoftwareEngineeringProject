package code;

import javax.swing.JPanel;

public class ControlAppWindow extends JPanel {

	private SelectedDevicesPanel devicesPanel;
	private TopPanel topPanel;

	// Creating the control app panel
	ControlAppWindow(int x, int y, int width, int height, MainAppWindow mainAppWindow, Home home) {
		// Setting the size of the frame
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		devicesPanel = new SelectedDevicesPanel(width, height - 50, mainAppWindow, home);
		topPanel = new TopPanel(width, 50, mainAppWindow, home);
		this.add(topPanel);
		this.add(devicesPanel);

	}

	// Getters

	public SelectedDevicesPanel getSelectedDevicesPanel() {
		return this.devicesPanel;
	}

	public TopPanel getTopPanel() {
		return this.topPanel;
	}

}
