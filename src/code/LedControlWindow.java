package code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LedControlWindow extends JFrame implements ActionListener {

	private Dimension frameDimension = new Dimension(200, 200);
	private MainAppWindow mainAppWindow1;
	private JButton toggleStatusButton;
	private JRadioButton defaultColorButton;
	private JRadioButton blueColorButton;
	private JRadioButton greenColorButton;
	private JRadioButton purpleColorButton;
	private Led led;
	private JPanel deviceControlPanel;

	public LedControlWindow(Led led, MainAppWindow mainAppWindow) {
		this.mainAppWindow1 = mainAppWindow;
		this.led = led;
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle(led.get_device_name() + " configuration window");
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
		updateDeviceControlWindow(led);

		// Making the frame visible
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Update the LED's status and display according to buttons presses
		if (e.getSource() == toggleStatusButton) {
			led.toggle();
			if (led.get_status()) {
				mainAppWindow1.getHomeView().setLedColor(0);
			} else {
				mainAppWindow1.getHomeView().setLedColor(-1);
			}
			updateDeviceControlWindow(led);
		} else if (e.getSource() == defaultColorButton) {
			mainAppWindow1.getHomeView().setLedColor(0);
		} else if (e.getSource() == blueColorButton) {
			mainAppWindow1.getHomeView().setLedColor(1);
		} else if (e.getSource() == greenColorButton) {
			mainAppWindow1.getHomeView().setLedColor(2);
		} else if (e.getSource() == purpleColorButton) {
			mainAppWindow1.getHomeView().setLedColor(3);
		}
		mainAppWindow1.getHomeView().repaint();
	}

	public void updateDeviceControlWindow(Led led) {
		deviceControlPanel.removeAll();
		deviceControlPanel.setLayout(new BoxLayout(deviceControlPanel, BoxLayout.Y_AXIS));

		// Create a container panel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		// Load the power on/off icons
		ImageIcon powerOnIcon = new ImageIcon("resources/on.png");
		ImageIcon powerOffIcon = new ImageIcon("resources/off.png");
		// create button and clear the background
		toggleStatusButton = new JButton();
		toggleStatusButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		toggleStatusButton.addActionListener(this);
		toggleStatusButton.setPreferredSize(new Dimension(10, 10));
		toggleStatusButton.setFocusPainted(false);
		toggleStatusButton.setContentAreaFilled(false);
		toggleStatusButton.setBorderPainted(false);
		toggleStatusButton.setOpaque(false);

		// "Turn Off" button
		if (led.get_status()) {
			toggleStatusButton.setIcon(powerOffIcon);
			deviceControlPanel.add(toggleStatusButton);

			defaultColorButton = new JRadioButton("Default");
			blueColorButton = new JRadioButton("Blue    ");
			greenColorButton = new JRadioButton("Green  ");
			purpleColorButton = new JRadioButton("Purple ");

			ButtonGroup colorChoicesButtonGroup = new ButtonGroup();
			colorChoicesButtonGroup.add(defaultColorButton);
			colorChoicesButtonGroup.add(blueColorButton);
			colorChoicesButtonGroup.add(greenColorButton);
			colorChoicesButtonGroup.add(purpleColorButton);

			defaultColorButton.addActionListener(this);
			blueColorButton.addActionListener(this);
			greenColorButton.addActionListener(this);
			purpleColorButton.addActionListener(this);

			// Set alignment for color buttons and add them to the button panel
			defaultColorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			blueColorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			greenColorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			purpleColorButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

			// checking if the led's color is already set from before to mark the relevant
			// button as selected
			if (led.get_color() == 0) {
				defaultColorButton.setSelected(true);
			} else if (led.get_color() == 1) {
				blueColorButton.setSelected(true);
			} else if (led.get_color() == 2) {
				greenColorButton.setSelected(true);
			} else if (led.get_color() == 3) {
				purpleColorButton.setSelected(true);
			}

			deviceControlPanel.add(defaultColorButton);
			deviceControlPanel.add(blueColorButton);
			deviceControlPanel.add(greenColorButton);
			deviceControlPanel.add(purpleColorButton);
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
		super.paint(g);
	}
}
