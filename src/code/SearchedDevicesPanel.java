package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SearchedDevicesPanel extends JPanel {

	private ArrayList<SearchedDeviceButton> allButtons = new ArrayList<SearchedDeviceButton>();
	private ArrayList<Device> SearchResult;
	private MainAppWindow mainWindow;
	private Home home;

	public SearchedDevicesPanel(int width, int height, MainAppWindow mainAppWindow, Home home1) {
		// System.out.println("in SearchedDevicesPanel: constructor");
		// System.out.println("all buttons: " + allDevicesButtons);
		// System.out.println("all buttons in list: " + allButtons);
		mainWindow = mainAppWindow;
		home = home1;
		updateSearchedDevices("EMPTY");

		this.setBackground(new Color(225, 225, 225));
		this.setBounds(0, 50, width, height);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

		/*
		 * this.revalidate();
		 * System.out.println("calling repaint from selected devices"); this.repaint();
		 */

	}

	public void updateSearchedDevices(String searchedType) {
		// clear all current buttons from SelectedDevicesPanel
		this.removeAll();
		// clear all buttons from the buttons array
		allButtons.clear();
		// add the currently controlled devices
		/*
		 * for (int i = 0; i < home.getDevices().size(); i++) {
		 * home.getDevices().get(i).set_controlled(true); if
		 * (home.getDevices().get(i).get_controlled()) { allDevicesButtons[i] = new
		 * DeviceButton(new ImageIcon("resources\\ACicon.png"),
		 * home.getDevices().get(i).get_device_name(), mainWindow);
		 * this.add(allDevicesButtons[i]); } }
		 */
		if (searchedType.compareTo("EMPTY") == 0) {
			SearchResult = home.findDevice("");
		} else if (searchedType.compareTo("") == 0) {
			SearchResult = home.getDevices();
		} else {
			SearchResult = home.findDevice(searchedType);
		}
		for (int i = 0; i < SearchResult.size(); i++) {
			if (!SearchResult.get(i).get_controlled()) {
				SearchedDeviceButton sButton = new SearchedDeviceButton(
						ImageResizer.resizeImageIcon(new ImageIcon(SearchResult.get(i).getIconPath()), 75, 75),
						SearchResult.get(i), mainWindow, home);
				allButtons.add(sButton);
				this.add(sButton);
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
