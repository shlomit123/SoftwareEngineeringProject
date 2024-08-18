package code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LampControlWindow extends JFrame implements ActionListener {

	private Dimension frameDimension = new Dimension(200, 200);
	private MainAppWindow mainAppWindow1;
	private JButton toggleStatusButton;
	private Lamp lamp;
	private JPanel deviceControlPanel;

	public LampControlWindow(Lamp lamp, MainAppWindow mainAppWindow) {
		this.mainAppWindow1 = mainAppWindow;
		this.lamp = lamp;
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle(lamp.get_device_name() + " configuration window");
		// Setting the program to exit when closing the frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Setting the size of the frame
		this.setSize(frameDimension);
		// prevent frame from being re-sized
		this.setResizable(false);
		// setting frame's position to center of screen
		this.setLocationRelativeTo(null);
		// creating an ImageIcon to set a non-default icon to the frame
		ImageIcon logo = new ImageIcon("resources\\smarthomelogo.png");
		// setting the icon of the frame
		this.setIconImage(logo.getImage());
		this.setLayout(null);

		this.deviceControlPanel = new JPanel();
		this.deviceControlPanel.setSize(frameDimension);
		this.add(deviceControlPanel);
		updateDeviceControlWindow(lamp);

		// Making the frame visible
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == toggleStatusButton) {
			lamp.toggle();
			if (lamp.get_device_name().compareTo("Right Lamp") == 0) {
				if (lamp.get_status()) {
					mainAppWindow1.getHomeView().turnOnLamp1();
				} else {
					///// add turn off lamp 1
					mainAppWindow1.getHomeView().turnOffLamp1();
				}
			} else {
				if (lamp.get_status()) {
					mainAppWindow1.getHomeView().turnOnLamp2();
				} else {
					mainAppWindow1.getHomeView().turnOffLamp2();
				}
			}
			updateDeviceControlWindow(lamp);
		}
		mainAppWindow1.getHomeView().repaint();
	}

	public void updateDeviceControlWindow(Device device) {
		deviceControlPanel.removeAll();
		toggleStatusButton = new JButton();
		toggleStatusButton.setBounds(50, 50, 100, 100);
		toggleStatusButton.addActionListener(this);
		if (device.get_status()) {
			toggleStatusButton.setText("Turn Off");
			deviceControlPanel.add(toggleStatusButton);
		} else {
			toggleStatusButton.setText("Turn On");
			deviceControlPanel.add(toggleStatusButton);
		}
		revalidate();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
}
