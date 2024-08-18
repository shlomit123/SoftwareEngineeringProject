package code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LampControlWindow extends JFrame implements ActionListener {

	private Dimension frameDimension = new Dimension(120, 100);
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
		
		// Load the power on/off icons
        ImageIcon powerOnIcon = new ImageIcon("resources/on.png");
        ImageIcon powerOffIcon = new ImageIcon("resources/off.png");
        //create button and clear the background
		toggleStatusButton = new JButton();
		toggleStatusButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		toggleStatusButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		toggleStatusButton.addActionListener(this);
		toggleStatusButton.setPreferredSize(new Dimension(50, 50));
		toggleStatusButton.setFocusPainted(false);
        toggleStatusButton.setContentAreaFilled(false);
        toggleStatusButton.setBorderPainted(false);
        toggleStatusButton.setOpaque(false);
		
		
		if (device.get_status()) {
			toggleStatusButton.setIcon(powerOffIcon);
			deviceControlPanel.add(toggleStatusButton);
		} else {
			toggleStatusButton.setIcon(powerOnIcon);
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


