package code;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainAppWindow extends JFrame {
	final int HEIGHT = 600;
	final int WIDTH = 1000;
	final int CONTENT_PANE_HEIGHT = 563;
	final int CONTENT_PANE_WIDTH = 986;

	public MainAppWindow() {
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle("Smart Home App");
		// Setting the program to exit when closing the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Setting the size of the frame
		this.setSize(WIDTH, HEIGHT);
		// prevent frame from being re-sized
		this.setResizable(false);
		// setting frame's position to center of screen
		this.setLocationRelativeTo(null);
		// set background color
		this.getContentPane().setBackground(Color.white);
		// creating an ImageIcon to set a non-default icon to the frame
		ImageIcon logo = new ImageIcon("resources\\smarthomelogo.png");
		// setting the icon of the frame
		this.setIconImage(logo.getImage());
		this.setLayout(null);
		// Making the frame visible
		this.setVisible(true);

		HomeViewWindow homeView = new HomeViewWindow(0, 0, (int) CONTENT_PANE_WIDTH * 2 / 3, CONTENT_PANE_HEIGHT);
		ControlAppWindow controlApp = new ControlAppWindow((int) CONTENT_PANE_WIDTH * 2 / 3, 0,
				(int) CONTENT_PANE_WIDTH / 3, CONTENT_PANE_HEIGHT);
		this.add(homeView);
		this.add(controlApp);
	}
}
