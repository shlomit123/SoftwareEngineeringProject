package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DeviceControlWindow extends JFrame implements ActionListener {

	MainAppWindow mainAppWindow1;

	public DeviceControlWindow(String device, MainAppWindow mainAppWindow) {
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle(device + "configuration window");
		// Setting the program to exit when closing the frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Setting the size of the frame
		this.setSize(400, 400);
		// prevent frame from being re-sized
		this.setResizable(false);
		// setting frame's position to center of screen
		this.setLocationRelativeTo(null);
		// set background color
		this.getContentPane().setBackground(Color.green);
		// creating an ImageIcon to set a non-default icon to the frame
		ImageIcon logo = new ImageIcon("resources\\smarthomelogo.png");
		// setting the icon of the frame
		this.setIconImage(logo.getImage());
		this.setLayout(null);
		JButton b = new JButton("press");
		b.setBounds(50, 50, 200, 200);
		b.addActionListener(this);
		this.add(b);
		// Making the frame visible
		this.setVisible(true);

		mainAppWindow1 = mainAppWindow;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action detected");
		mainAppWindow1.getHomeView().repaint();
	}
}
