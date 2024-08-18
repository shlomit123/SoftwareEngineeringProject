package code;

import java.awt.Color;

import javax.swing.JPanel;

public class ControlAppWindow extends JPanel {

	private SelectedDevicesPanel devicesPanel;
	private TopPanel topPanel;

	ControlAppWindow(int x, int y, int width, int height, MainAppWindow mainAppWindow, Home home) {
		// System.out.println("in ControlAppWindow: constructor");
		// Setting the size of the frame
		this.setBounds(x, y, width, height);
		this.setBackground(Color.pink);
		this.setLayout(null);
		devicesPanel = new SelectedDevicesPanel(width, height - 50, mainAppWindow, home);
		topPanel = new TopPanel(width, 50, mainAppWindow, home);
		this.add(topPanel);
		this.add(devicesPanel);

	}

	public SelectedDevicesPanel getSelectedDevicesPanel() {
		return this.devicesPanel;
	}

	public TopPanel getTopPanel() {
		return this.topPanel;
	}

}
