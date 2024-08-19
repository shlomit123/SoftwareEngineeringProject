package code;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AcControlWindow extends JFrame implements ActionListener {

	private Dimension frameDimension = new Dimension(170, 220);
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
		deviceControlPanel.setLayout(new BoxLayout(deviceControlPanel, BoxLayout.Y_AXIS));
		
		// Load the power on/off icons
        ImageIcon powerOnIcon = new ImageIcon("resources/on.png");
        ImageIcon powerOffIcon = new ImageIcon("resources/off.png");
        //create button and clear the background
		toggleStatusButton = new JButton();
		toggleStatusButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		toggleStatusButton.addActionListener(this);
		toggleStatusButton.setPreferredSize(new Dimension(50, 50));
		toggleStatusButton.setFocusPainted(false);
        toggleStatusButton.setContentAreaFilled(false);
        toggleStatusButton.setBorderPainted(false);
        toggleStatusButton.setOpaque(false);
        
		if (ac.get_status()) {
			toggleStatusButton.setIcon(powerOffIcon);
			deviceControlPanel.add(toggleStatusButton);
			tempLabel = new JLabel();
			tempLabel.setText(ac.get_temp() + "\u00B0C");
			
			tempLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); 
	        //currentChanneLabel.setForeground(Color.blue);  
			tempLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			
			//create increase button
			increaseTempButton = new JButton();
			increaseTempButton.setFocusPainted(false);
			increaseTempButton.setContentAreaFilled(false);
			increaseTempButton.setBorderPainted(false);
			increaseTempButton.setText("+");
			increaseTempButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
			//create decrease button
			decreaseTempButton = new JButton();
			decreaseTempButton.setFocusPainted(false);
			decreaseTempButton.setContentAreaFilled(false);
			decreaseTempButton.setBorderPainted(false);
			decreaseTempButton.setText("-");
			decreaseTempButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
			decreaseTempButton.addActionListener(this);
			increaseTempButton.addActionListener(this);
			//align in the middle
			decreaseTempButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			increaseTempButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			tempLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

			deviceControlPanel.add(toggleStatusButton);
			deviceControlPanel.add(increaseTempButton);
			deviceControlPanel.add(tempLabel);
			deviceControlPanel.add(decreaseTempButton);

		} else {
			toggleStatusButton.setIcon(powerOnIcon);
			deviceControlPanel.add(toggleStatusButton);
		}
		Database.writeDevicesToFile(HomeViewWindow.home.getDevices());
		revalidate();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
}
