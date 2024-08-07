package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DeviceButton extends JButton implements ActionListener {

	String name;
	MainAppWindow mainAppWindow;

	DeviceButton(ImageIcon deviceImg, String deviceName, MainAppWindow mainAppWindow1) {
		super(deviceName);
		this.name = deviceName;
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
		mainAppWindow.openDeviceControlWindow(this.name);
	}
}
