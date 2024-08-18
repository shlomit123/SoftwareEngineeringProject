package code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AcControlWindow extends JFrame implements ActionListener {

	private Dimension frameDimension = new Dimension(200, 200);
	private MainAppWindow mainAppWindow1;
	private JButton toggleStatusButton;
	private JButton increaseTempButton;
	private JButton decreaseTempButton;
	private JLabel tempLabel;
	private AC ac;
	private JPanel deviceControlPanel;

	public AcControlWindow(AC ac, MainAppWindow mainAppWindow) {
		this.mainAppWindow1 = mainAppWindow;
		this.ac = ac;
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle(ac.get_device_name() + " configuration window");
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
		updateDeviceControlWindow(ac);

		// Making the frame visible
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == toggleStatusButton) {
			ac.toggle();
			if (ac.get_device_name().compareTo("Right AC") == 0) {
				if (ac.get_status()) {
					mainAppWindow1.getHomeView().setTemperature1(ac.get_temp() + "\u00B0C");
				} else {
					///// add turn off lamp 1
					mainAppWindow1.getHomeView().setTemperature1("");
				}
			} else {
				if (ac.get_status()) {
					mainAppWindow1.getHomeView().setTemperature2(ac.get_temp() + "\u00B0C");
				} else {
					mainAppWindow1.getHomeView().setTemperature2("");
				}
			}
		} else if (e.getSource() == decreaseTempButton) {
			this.ac.set_temp(this.ac.get_temp() - 1);
			if (ac.get_device_name().compareTo("Right AC") == 0) {
				mainAppWindow1.getHomeView().setTemperature1(ac.get_temp() + "\u00B0C");
			} else {
				mainAppWindow1.getHomeView().setTemperature2(ac.get_temp() + "\u00B0C");
			}
		} else if (e.getSource() == increaseTempButton) {
			this.ac.set_temp(this.ac.get_temp() + 1);
			if (ac.get_device_name().compareTo("Right AC") == 0) {
				mainAppWindow1.getHomeView().setTemperature1(ac.get_temp() + "\u00B0C");
			} else {
				mainAppWindow1.getHomeView().setTemperature2(ac.get_temp() + "\u00B0C");
			}
		}
		updateDeviceControlWindow(ac);
		mainAppWindow1.getHomeView().repaint();
	}

	public void updateDeviceControlWindow(AC ac) {
		deviceControlPanel.removeAll();
		toggleStatusButton = new JButton();
		toggleStatusButton.setBounds(50, 50, 100, 100);
		toggleStatusButton.addActionListener(this);
		if (ac.get_status()) {
			toggleStatusButton.setText("Turn Off");
			deviceControlPanel.add(toggleStatusButton);
			decreaseTempButton = new JButton();
			tempLabel = new JLabel();
			tempLabel.setText(ac.get_temp() + "\u00B0C");
			increaseTempButton = new JButton();
			decreaseTempButton.setText("Dec");
			increaseTempButton.setText("Inc");
			decreaseTempButton.addActionListener(this);
			increaseTempButton.addActionListener(this);

			deviceControlPanel.add(toggleStatusButton);
			deviceControlPanel.add(decreaseTempButton);
			deviceControlPanel.add(tempLabel);
			deviceControlPanel.add(increaseTempButton);

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
