package code;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MainAppWindow extends JFrame {
	final int HEIGHT = 600;
	final int WIDTH = 1000;
	final int CONTENT_PANE_HEIGHT = 563;
	final int CONTENT_PANE_WIDTH = 986;
	private HomeViewWindow homeView;
	private ControlAppWindow controlApp;
	private LampControlWindow currentLampControlWindow;
	private LedControlWindow currentLedControlWindow;
	private AcControlWindow currentAcControlWindow;
	private TvControlWindow currentTvControlWindow;
	private DeviceSearchWindow currentSearchWindow;
	private Home home;

	public MainAppWindow(Home home1) {
		// removes 'focus' property from all buttons
		UIManager.put("Button.focus", new java.awt.Color(0, 0, 0, 0));
		// System.out.println("in MainAppWindow: constructor");
		// Initiating a new JFrame (a GUI canvas to add components to)
		// setting the frame's title
		this.setTitle("Smart Home App");
		// Setting the program to exit when closing the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Setting the size of the frame
		this.setSize(WIDTH - 50, HEIGHT);
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
		home = home1;
		homeView = new HomeViewWindow(0, 0, (int) CONTENT_PANE_WIDTH * 2 / 3, CONTENT_PANE_HEIGHT, this, home);
		controlApp = new ControlAppWindow(((int) CONTENT_PANE_WIDTH * 2 / 3), 0, ((int) CONTENT_PANE_WIDTH / 3) - 50,
				CONTENT_PANE_HEIGHT, this, home);
		this.add(homeView);
		this.add(controlApp);

		// Making the frame visible
		this.setVisible(true);

		// initiate tutorial messages dialog
		new TutorialMessagesDialog();
	}

	public HomeViewWindow getHomeView() {
		return this.homeView;
	}

	public ControlAppWindow getControllAppWindow() {
		return this.controlApp;
	}

	public DeviceSearchWindow getDeviceSearchWindow() {
		return this.currentSearchWindow;
	}

	public void openDeviceControlWindow(Device device) {
		if ((currentLampControlWindow != null && currentLampControlWindow.isDisplayable())
				|| (currentLedControlWindow != null && currentLedControlWindow.isDisplayable())
				|| (currentAcControlWindow != null && currentAcControlWindow.isDisplayable())
				|| (currentTvControlWindow != null && currentTvControlWindow.isDisplayable())) {
			JOptionPane.showMessageDialog(this,
					"Please close the current device control window before opening a new one.", "Window Already Open",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (device.get_device_type().compareTo("Lamp") == 0) {
				if (device.get_device_name().compareTo("Right Lamp") == 0) {
					currentLampControlWindow = new LampControlWindow(home.getLamp1(), this);
				} else {
					currentLampControlWindow = new LampControlWindow(home.getLamp2(), this);
				}
				currentLampControlWindow.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						currentLampControlWindow = null;
					}
				});
				currentLampControlWindow.setVisible(true);
			} else if (device.get_device_type().compareTo("LED") == 0) {
				currentLedControlWindow = new LedControlWindow(home.getLed(), this);
				currentLedControlWindow.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						currentLedControlWindow = null;
					}
				});
				currentLedControlWindow.setVisible(true);
			} else if (device.get_device_type().compareTo("AC") == 0) {
				if (device.get_device_name().compareTo("Right AC") == 0) {
					currentAcControlWindow = new AcControlWindow(home.getAc1(), this);
				} else {
					currentAcControlWindow = new AcControlWindow(home.getAc2(), this);
				}
				currentAcControlWindow.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						currentAcControlWindow = null;
					}
				});
				currentAcControlWindow.setVisible(true);
			} else if (device.get_device_type().compareTo("TV") == 0) {
				currentTvControlWindow = new TvControlWindow(home.getTv(), this);
				currentTvControlWindow.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						currentTvControlWindow = null;
					}
				});
				currentTvControlWindow.setVisible(true);
			}
		}
	}

	public void openDeviceSearchWindow() {
		if (currentSearchWindow != null && currentSearchWindow.isDisplayable()) {
			JOptionPane.showMessageDialog(this,
					"Please close the current device search window before opening a new one.", "Window Already Open",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			currentSearchWindow = new DeviceSearchWindow(this, home);
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
