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

public class TvControlWindow extends JFrame implements ActionListener {

	private Dimension frameDimension = new Dimension(300, 300);
	private MainAppWindow mainAppWindow1;
	private JButton toggleStatusButton;
	private JButton increaseChannelButton;
	private JButton decreaseChannelButton;
	private JLabel currentChanneLabel;
	private TV tv;
	private JPanel deviceControlPanel;

	public TvControlWindow(TV tv, MainAppWindow mainAppWindow) {
		this.mainAppWindow1 = mainAppWindow;
		this.tv = tv;
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle(tv.get_device_name() + " configuration window");
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
		updateDeviceControlWindow(tv);

		// Making the frame visible
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == toggleStatusButton) {
			tv.toggle();
			if (tv.get_status()) {
				mainAppWindow1.getHomeView().turnOnTv();
			} else {
				mainAppWindow1.getHomeView().turnOffTv();
			}
		} else if (e.getSource() == decreaseChannelButton) {
			this.tv.decrease_channel();
			mainAppWindow1.getHomeView().setChannel(this.tv.get_channel());
		} else if (e.getSource() == increaseChannelButton) {
			this.tv.increase_channel();
			mainAppWindow1.getHomeView().setChannel(this.tv.get_channel());
		}
		updateDeviceControlWindow(tv);
		mainAppWindow1.getHomeView().repaint();
	}

	public void updateDeviceControlWindow(TV tv) {
		deviceControlPanel.removeAll();
		toggleStatusButton = new JButton();
		toggleStatusButton.setBounds(50, 50, 100, 100);
		toggleStatusButton.addActionListener(this);
		if (tv.get_status()) {
			toggleStatusButton.setText("Turn Off");
			deviceControlPanel.add(toggleStatusButton);
			decreaseChannelButton = new JButton();
			currentChanneLabel = new JLabel();
			if (tv.get_channel() == 0) {
				currentChanneLabel.setText("Sports Channel");
			} else {
				currentChanneLabel.setText("Food Channel");
			}

			increaseChannelButton = new JButton();
			decreaseChannelButton.setText("Dec");
			increaseChannelButton.setText("Inc");
			decreaseChannelButton.addActionListener(this);
			increaseChannelButton.addActionListener(this);

			deviceControlPanel.add(toggleStatusButton);
			deviceControlPanel.add(decreaseChannelButton);
			deviceControlPanel.add(currentChanneLabel);
			deviceControlPanel.add(increaseChannelButton);

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
