package code;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TvControlWindow extends JFrame implements ActionListener {

	private Dimension frameDimension = new Dimension(170, 220);
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
		
        if (tv.get_status()) {
			toggleStatusButton.setIcon(powerOffIcon);
			deviceControlPanel.add(toggleStatusButton);
			currentChanneLabel = new JLabel();
	        String channelInfo = "";
	        if (tv.get_channel() == 0) {
	            channelInfo = "Sports Channel";
	        } else {
	            channelInfo = "Food Channel";
	        }

	        currentChanneLabel.setText(channelInfo);
	        currentChanneLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); 
	        //currentChanneLabel.setForeground(Color.blue);  
	        currentChanneLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			decreaseChannelButton = new JButton();
			decreaseChannelButton.setFocusPainted(false);
			decreaseChannelButton.setContentAreaFilled(false);
			decreaseChannelButton.setBorderPainted(false);
			increaseChannelButton = new JButton();
			increaseChannelButton.setFocusPainted(false);
			increaseChannelButton.setContentAreaFilled(false);
			increaseChannelButton.setBorderPainted(false);
			decreaseChannelButton.setText("+");
			decreaseChannelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
			increaseChannelButton.setText("-");
			increaseChannelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
			decreaseChannelButton.addActionListener(this);
			increaseChannelButton.addActionListener(this);
			//align in the middle
			decreaseChannelButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			increaseChannelButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			currentChanneLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			
			deviceControlPanel.add(toggleStatusButton);
			deviceControlPanel.add(decreaseChannelButton);
			deviceControlPanel.add(Box.createRigidArea(new Dimension(0, 2)));
			deviceControlPanel.add(currentChanneLabel);
			deviceControlPanel.add(increaseChannelButton);

			
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
