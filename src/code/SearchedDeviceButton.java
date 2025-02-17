package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//A class to implement a personalized JButton for the unassigned devices
public class SearchedDeviceButton extends JButton implements ActionListener {

	private Device device;
	private MainAppWindow mainAppWindow;
	private Home home;

	// Constructor
	public SearchedDeviceButton(ImageIcon deviceImg, Device device, MainAppWindow mainAppWindow1, Home home) {
		super(device.get_device_name());
		this.device = device;
		this.setPreferredSize(new Dimension(125, 125));
		this.setBackground(Color.white);
		this.setFocusable(false);
		this.addActionListener(this);
		this.setIcon(deviceImg);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		this.mainAppWindow = mainAppWindow1;
		this.home = home;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.device.set_controlled(true);
		home.getMainAppWindow().getControllAppWindow().getSelectedDevicesPanel().updateSelectedDevices();
		home.getMainAppWindow().getDeviceSearchWindow().getSearchedDevicesPanel().updateSearchedDevices(
				home.getMainAppWindow().getDeviceSearchWindow().getSearchTextBoxPanel().getSearchTextField().getText());
	}
}
