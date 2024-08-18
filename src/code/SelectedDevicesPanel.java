package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SelectedDevicesPanel extends JPanel {

	// private DeviceButton[] allDevicesButtons = new DeviceButton[6];
	private ArrayList<DeviceButton> allButtons = new ArrayList<>();
	private MainAppWindow mainWindow;
	private Home home;

	public SelectedDevicesPanel(int width, int height, MainAppWindow mainAppWindow, Home home1) {
		// System.out.println("in SelectedDevicesPanel: constructor");
		// System.out.println("all buttons: " + allDevicesButtons);
		// System.out.println("all buttons in list: " + allButtons);
		mainWindow = mainAppWindow;
		home = home1;
		updateSelectedDevices();

		this.setBackground(new Color(225, 225, 225));
		this.setBounds(0, 50, width, height);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

		/*
		 * this.revalidate();
		 * System.out.println("calling repaint from selected devices"); this.repaint();
		 */

	}

	public void updateSelectedDevices() {
		// clear all current buttons from SelectedDevicesPanel
		this.removeAll();
		// clear all buttons from the buttons array
		allButtons.clear();
		// System.out.println("all devices: " + home.getDevices());
		// System.out.println("all devices in list: " + allButtons);
		// add the currently controlled devices
		/*
		 * for (int i = 0; i < home.getDevices().size(); i++) {
		 * home.getDevices().get(i).set_controlled(true); if
		 * (home.getDevices().get(i).get_controlled()) { allDevicesButtons[i] = new
		 * DeviceButton(new ImageIcon("resources\\ACicon.png"),
		 * home.getDevices().get(i).get_device_name(), mainWindow);
		 * this.add(allDevicesButtons[i]); } }
		 */
		for (int i = 0; i < home.getDevices().size(); i++) {
			/*
			 * if (i % 2 == 0) { home.getDevices().get(i).set_controlled(true); }
			 */
			// home.getDevices().get(i).set_controlled(true);
			if (home.getDevices().get(i).get_controlled()) {
				DeviceButton button = new DeviceButton(
						ImageResizer.resizeImageIcon(new ImageIcon(home.getDevices().get(i).getIconPath()), 75, 75),
						home.getDevices().get(i), mainWindow, home);
				allButtons.add(button);
				this.add(button);
			}
		}
		// Refresh the panel to show updated buttons
		this.revalidate();
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		// System.out.println("in SelectedDevicesPanel: paint");
		super.paint(g);
	}
}
