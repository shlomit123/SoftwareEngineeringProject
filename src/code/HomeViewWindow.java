package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// The home's display in real-time
public class HomeViewWindow extends JPanel {
	public static Home home;
	Image background;
	private String temperature1;
	private String temperature2;
	private String lamp2path;
	private String lamp1path;
	private String channelpath;
	private String ledColorPath;

	// Constructor
	public HomeViewWindow(int x, int y, int width, int height, MainAppWindow mainAppWindow, Home home) {
		this.home = home;
		this.setBounds(x, y, width, height);
		// Display devices' status according to their current value
		if (home.getAc1().get_status()) {
			this.temperature1 = home.getAc1().get_temp() + "\u00B0C";
		} else {
			this.temperature1 = "";
		}
		if (home.getAc2().get_status()) {
			this.temperature2 = home.getAc2().get_temp() + "\u00B0C";
		} else {
			this.temperature2 = "";
		}
		this.lamp2path = "resources\\lamp2Off.png";
		this.setLedColor(home.getLed().get_color());
		this.setChannel(home.getTv().get_channel());
		if (home.getLamp1().get_status()) {
			this.lamp1path = "resources\\lampOn1.jpg";
		} else
			this.lamp1path = "";
		if (home.getLamp2().get_status()) {
			this.lamp2path = "resources\\lamp2On.png";
		} else
			this.lamp2path = "resources\\lamp2Off.png";
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		background = new ImageIcon("resources\\1517195.jpg").getImage();
		g.drawImage(background, 0, 0, null);

		// add TV in down left room
		Image TV = new ImageIcon("resources\\TV.png").getImage();
		g.drawImage(TV, 408, 454, 110, 50, null);
		if (this.channelpath.compareTo("") != 0) {
			// show channel
			Image channel = new ImageIcon(this.channelpath).getImage();
			g.drawImage(channel, 424, 456, 79, 42, null);
		}

		// add AC in upper left room
		Image AC1 = new ImageIcon("resources\\AC4.png").getImage();
		g.drawImage(AC1, 440, 100, 160, 65, null);
		// add degrees text on AC1
		g.setFont(new Font("Arial", Font.BOLD, 12));
		g.setColor(new Color(0, 240, 255));
		if (this.temperature1.compareTo("") != 0) {
			g.drawString(this.temperature1, 510, 132);
		}

		// add AC in upper right room
		Image AC2 = new ImageIcon("resources\\AC4.png").getImage();
		g.drawImage(AC2, 20, 100, 160, 65, null);
		g.setFont(new Font("Arial", Font.BOLD, 12));
		g.setColor(new Color(0, 240, 255));
		if (this.temperature2.compareTo("") != 0) {
			g.drawString(this.temperature2, 90, 132);
		}

		// add lamp2 in upper left room
		Image lamp2 = new ImageIcon(this.lamp2path).getImage();
		g.drawImage(lamp2, 140, 190, 60, 75, null);
		// lamp in upper right room (for enabling turning on)
		if (this.lamp1path.compareTo("") != 0) {
			Image lamp1On = new ImageIcon(this.lamp1path).getImage();
			g.drawImage(lamp1On, 625, 213, 27, 13, null);

		}

		// add led to kitchen
		Image fluorescent = new ImageIcon("resources\\florosent.jpg").getImage();
		g.drawImage(fluorescent, 35, 443, 120, 3, null);
		// changes led light color according to buttons presses
		if (ledColorPath.compareTo("") != 0) {
			Image fColor = new ImageIcon(ledColorPath).getImage();
			g.drawImage(fColor, 39, 443, 113, 3, null);
		}
	}

	// change temperatureAC1
	public void setTemperature1(String newTemperature) {
		this.temperature1 = newTemperature;
		Database.writeDevicesToFile(home.getDevices());
		repaint(); // Trigger a repaint to update the display
	}

	// change temperatureAC1
	public void setTemperature2(String newTemperature) {
		this.temperature2 = newTemperature;
		Database.writeDevicesToFile(home.getDevices());
		repaint(); // Trigger a repaint to update the display
	}

	public void turnOnLamp2() {
		this.lamp2path = "resources\\lamp2On.png";
		Database.writeDevicesToFile(home.getDevices());
		repaint();
	}

	public void turnOffLamp2() {
		this.lamp2path = "resources\\lamp2Off.png";
		Database.writeDevicesToFile(home.getDevices());
		repaint();
	}

	public void turnOnLamp1() {
		this.lamp1path = "resources\\lampOn1.jpg";
		Database.writeDevicesToFile(home.getDevices());
		repaint();
	}

	public void turnOffLamp1() {
		this.lamp1path = "";
		Database.writeDevicesToFile(home.getDevices());
		repaint();
	}

	// set TV channel
	public void setChannel(int channel) {
		if (channel == 0) {
			this.channelpath = "resources\\sports.jpg";
		} else if (channel == 1) {
			this.channelpath = "resources\\masterChef.png";
		} else if (channel == 2) {
			this.channelpath = "resources\\movies.jpg";
		} else if (channel == 3) {
			this.channelpath = "resources\\haim.jpg";
		}
		Database.writeDevicesToFile(home.getDevices());
		repaint();
	}

	public void turnOffTv() {
		this.channelpath = "";
		Database.writeDevicesToFile(home.getDevices());
		repaint();
	}

	public void turnOnTv() {
		setChannel(home.getTv().get_channel());
		Database.writeDevicesToFile(home.getDevices());
	}

	// Set led color
	public void setLedColor(int color) {
		if (color == 0) {
			home.getLed().set_color(0);
			this.ledColorPath = "resources\\fOn.jpg";
		} else if (color == 1) {
			home.getLed().set_color(1);
			this.ledColorPath = "resources\\fBlue.jpg";
		} else if (color == 2) {
			home.getLed().set_color(2);
			this.ledColorPath = "resources\\fGreen.jpg";
		} else if (color == 3) {
			home.getLed().set_color(3);
			this.ledColorPath = "resources\\fPurple.jpg";
		} else if (color == -1) {
			home.getLed().set_color(-1);
			this.ledColorPath = "";
		}
		Database.writeDevicesToFile(home.getDevices());
	}

}
