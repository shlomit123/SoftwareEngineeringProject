package code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		toggleStatusButton = new JButton();
		toggleStatusButton.setBounds(50, 50, 100, 100);
		toggleStatusButton.addActionListener(this);
		if (led.get_status()) {
			toggleStatusButton.setText("Turn Off");
			deviceControlPanel.add(toggleStatusButton);

			defaultColorButton = new JRadioButton("Default");
			blueColorButton = new JRadioButton("Blue");
			greenColorButton = new JRadioButton("Green");
			purpleColorButton = new JRadioButton("Purple");

			ButtonGroup colorChoicesButtonGroup = new ButtonGroup();
			colorChoicesButtonGroup.add(defaultColorButton);
			colorChoicesButtonGroup.add(blueColorButton);
			colorChoicesButtonGroup.add(greenColorButton);
			colorChoicesButtonGroup.add(purpleColorButton);

			defaultColorButton.addActionListener(this);
			blueColorButton.addActionListener(this);
			greenColorButton.addActionListener(this);
			purpleColorButton.addActionListener(this);

			deviceControlPanel.add(defaultColorButton);
			deviceControlPanel.add(blueColorButton);
			deviceControlPanel.add(greenColorButton);
			deviceControlPanel.add(purpleColorButton);
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
