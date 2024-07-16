package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ControlAppWindowFrame extends JFrame implements ActionListener {

	String[] devicess = { "Lamp1", "Lamp2", "LED", "AC", "TV" };

	public ControlAppWindowFrame(HomeViewWindow home) {
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle("Smart Home Controller");
		// Setting the program to exit when closing the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Setting the size of the frame
		this.setSize(500, 500);
		// prevent frame from being re-sized
		this.setResizable(false);
		// setting frame's position to center of screen
		this.setLocationRelativeTo(home);
		// set background color
		this.getContentPane().setBackground(Color.white);
		// creating an ImageIcon to set a non-default icon to the frame
		ImageIcon logo = new ImageIcon("resources\\smarthomelogo.png");
		// setting the icon of the frame
		this.setIconImage(logo.getImage());
		this.setLayout(null);
		// Making the frame visible
		this.setVisible(true);
		// getting the frame's dimensions - the area that we can place components into
		Dimension dim = this.getContentPane().getSize();
		// taking the height and width of editable space
		int frameHeight = 463;
		int frameWidth = 486;
		// TopPanel redPanel = new TopPanel(frameHeight, frameWidth);
		// redPanel.setBackground(Color.red);
		System.out.println(dim + " " + frameHeight + " " + frameWidth);
		// ConfirmPanel confPanel = new ConfirmPanel(frameHeight, frameWidth);

		// this.add(confPanel);
		// this.add(redPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
