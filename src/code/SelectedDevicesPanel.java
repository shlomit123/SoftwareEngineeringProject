package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// A class to hold and display all of the currently assigned devices
public class SelectedDevicesPanel extends JPanel {

	private ArrayList<DeviceButton> allButtons = new ArrayList<>();
	private MainAppWindow mainWindow;
	private Home home;

	// Constructor
	public SelectedDevicesPanel(int width, int height, MainAppWindow mainAppWindow, Home home1) {
		mainWindow = mainAppWindow;
		home = home1;
		updateSelectedDevices();

		this.setBackground(new Color(225, 225, 225));
		this.setBounds(0, 50, width, height);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

	}

	public void updateSelectedDevices() {
		// clear all current buttons from SelectedDevicesPanel
		this.removeAll();
		// clear all buttons from the buttons array
		allButtons.clear();

		for (int i = 0; i < home.getDevices().size(); i++) {
			if (home.getDevices().get(i).get_controlled()) {
				DeviceButton button = new DeviceButton(
						ImageResizer.resizeImageIcon(new ImageIcon(home.getDevices().get(i).getIconPath()), 75, 75),
						home.getDevices().get(i), mainWindow, home);
				allButtons.add(button);
				this.add(button);
			}
		}
		Database.writeDevicesToFile(HomeViewWindow.home.getDevices());
		// Refresh the panel to show updated buttons
		this.revalidate();
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
}
