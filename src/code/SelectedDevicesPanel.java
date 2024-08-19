package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectedDevicesPanel extends JPanel{

	// private DeviceButton[] allDevicesButtons = new DeviceButton[6];
	private ArrayList<DeviceButton> allButtons = new ArrayList<>();
	private MainAppWindow mainWindow;
	private Home home;

	public SelectedDevicesPanel(int width, int height, MainAppWindow mainAppWindow, Home home1) {
		
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
		// System.out.println("in SelectedDevicesPanel: paint");
		super.paint(g);
	}
}
