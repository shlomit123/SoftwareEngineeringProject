package code;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainAppWindow extends JFrame {
	final int HEIGHT = 600;
	final int WIDTH = 1000;
	final int CONTENT_PANE_HEIGHT = 563;
	final int CONTENT_PANE_WIDTH = 986;

	private HomeViewWindow homeView;
	private ControlAppWindow controlApp;
	private DeviceControlWindow currentControlWindow;
	private DeviceSearchWindow currentSearchWindow;

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

		homeView = new HomeViewWindow(0, 0, (int) CONTENT_PANE_WIDTH * 2 / 3, CONTENT_PANE_HEIGHT, this);
		controlApp = new ControlAppWindow((int) CONTENT_PANE_WIDTH * 2 / 3, 0, (int) CONTENT_PANE_WIDTH / 3,
				CONTENT_PANE_HEIGHT, this);
		this.add(homeView);
		this.add(controlApp);

		// Making the frame visible
		this.setVisible(true);
	}

	public HomeViewWindow getHomeView() {
		return this.homeView;
	}

	public void openDeviceControlWindow(String deviceName) {
		if (currentControlWindow != null && currentControlWindow.isDisplayable()) {
			JOptionPane.showMessageDialog(this,
					"Please close the current device control window before opening a new one.", "Window Already Open",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			currentControlWindow = new DeviceControlWindow(deviceName, this);
			currentControlWindow.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					currentControlWindow = null;
				}
			});
			currentControlWindow.setVisible(true);
		}
	}

	public void openDeviceSearchWindow() {
		if (currentSearchWindow != null && currentSearchWindow.isDisplayable()) {
			JOptionPane.showMessageDialog(this,
					"Please close the current device search window before opening a new one.", "Window Already Open",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			currentSearchWindow = new DeviceSearchWindow(this);
			currentSearchWindow.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					currentSearchWindow = null;
				}
			});
			currentSearchWindow.setVisible(true);
		}
	}
}
