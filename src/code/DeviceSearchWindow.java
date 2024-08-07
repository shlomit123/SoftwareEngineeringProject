package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DeviceSearchWindow extends JFrame implements ActionListener {

	MainAppWindow mainAppWindow1;

	public DeviceSearchWindow(MainAppWindow mainAppWindow) {
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle("Device search window");
		// Setting the program to exit when closing the frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Setting the size of the frame
		this.setSize(400, 400);
		// prevent frame from being re-sized
		this.setResizable(false);
		// setting frame's position to center of screen
		this.setLocationRelativeTo(null);
		// set background color
		this.getContentPane().setBackground(Color.red);
		// creating an ImageIcon to set a non-default icon to the frame
		ImageIcon logo = new ImageIcon("resources\\smarthomelogo.png");
		// setting the icon of the frame
		this.setIconImage(logo.getImage());
		this.setLayout(null);

		SelectedDevicesPanel devicesPanel = new SelectedDevicesPanel(400, 350, mainAppWindow);
		SearchTextBoxPanel searchPanel = new SearchTextBoxPanel(400, 50, mainAppWindow);
		this.add(searchPanel);
		this.add(devicesPanel);
		// Making the frame visible
		this.setVisible(true);

		mainAppWindow1 = mainAppWindow;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
