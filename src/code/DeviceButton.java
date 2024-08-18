package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DeviceButton extends JButton implements ActionListener {

	Device device;
	MainAppWindow mainAppWindow;

	public DeviceButton(ImageIcon deviceImg, Device device, MainAppWindow mainAppWindow1) {
		super(device.get_device_name());
		this.device = device;
		this.setPreferredSize(new Dimension(100, 100));
		this.setBackground(Color.pink);
		this.setFocusable(false);
		this.addActionListener(this);
		this.setIcon(deviceImg);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		mainAppWindow = mainAppWindow1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainAppWindow.openDeviceControlWindow(this.device);
	}
}
