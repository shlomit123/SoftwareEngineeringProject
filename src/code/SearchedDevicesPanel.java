package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// A class to hold all the unassigned devices' buttons that returns from the search
public class SearchedDevicesPanel extends JPanel {

	private ArrayList<SearchedDeviceButton> allButtons = new ArrayList<SearchedDeviceButton>();
	private ArrayList<Device> SearchResult;
	private MainAppWindow mainWindow;
	private Home home;

	// Constructor
	public SearchedDevicesPanel(int width, int height, MainAppWindow mainAppWindow, Home home1) {
		mainWindow = mainAppWindow;
		home = home1;
		updateSearchedDevices("EMPTY");

		this.setBackground(new Color(225, 225, 225));
		this.setBounds(0, 50, width, height);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

	}

	public void updateSearchedDevices(String searchedType) {
		// clear all current buttons from SelectedDevicesPanel
		this.removeAll();
		// clear all buttons from the buttons array
		allButtons.clear();
		// add the currently controlled devices
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
