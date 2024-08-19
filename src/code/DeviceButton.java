package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DeviceButton extends JButton implements ActionListener {

	private Device device;
	private MainAppWindow mainAppWindow;
	private Home home;

	public DeviceButton(ImageIcon deviceImg, Device device, MainAppWindow mainAppWindow1, Home home) {
		super(device.get_device_name());
		this.mainAppWindow = mainAppWindow1;
		this.device = device;
		this.home = home;
		this.setPreferredSize(new Dimension(125, 125));
		this.setBackground(Color.white);
		this.setFocusable(false);
		this.addActionListener(this);
		this.setIcon(deviceImg);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					device.set_controlled(false);
					home.getMainAppWindow().getControllAppWindow().getSelectedDevicesPanel().updateSelectedDevices();
					try {
						home.getMainAppWindow().getDeviceSearchWindow().getSearchedDevicesPanel()
								.updateSearchedDevices("");
						home.getMainAppWindow().getDeviceSearchWindow().getSearchTextBoxPanel().getSearchTextField()
								.setText("");
					} catch (Exception e2) {

					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainAppWindow.openDeviceControlWindow(this.device);
	}
}
