package code;

import java.awt.Color;

import javax.swing.JPanel;

public class ControlAppWindow extends JPanel {

	ControlAppWindow(int x, int y, int width, int height, MainAppWindow mainAppWindow) {
		// Setting the size of the frame
		this.setBounds(x, y, width, height);
		this.setBackground(Color.pink);
		this.setLayout(null);
		SelectedDevicesPanel devicesPanel = new SelectedDevicesPanel(width, height - 50, mainAppWindow);
		TopPanel top = new TopPanel(width, 50, mainAppWindow);
		this.add(top);
		this.add(devicesPanel);

	}

}
