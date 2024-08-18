package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomeViewWindow extends JPanel {
	private Home home;
	Image background;
	private String temperature1;
	private String temperature2;
	private String lamp2path;
	private String lamp1path;
	private String channelpath;
	private String ledColorPath;

	public HomeViewWindow(int x, int y, int width, int height, MainAppWindow mainAppWindow, Home home) {
		this.home = home;
		// System.out.println("in HomeViewWindow: constructor");
		// Setting the size of the frame
		this.setBounds(x, y, width, height);
		this.temperature1 = "";
		this.temperature2 = "";
		this.lamp2path = "resources\\lamp2Off.png";
		this.ledColorPath = "";
		this.channelpath = "";
		this.lamp1path = "";
	}

	public void paint(Graphics g) {
		// System.out.println("in HomeViewWindow: paint");
		super.paintComponent(g);
		// this.setBackground(Color.blue);
		// Graphics2D g2d = (Graphics2D) g;
		background = new ImageIcon("resources\\1517195.jpg").getImage();
		g.drawImage(background, 0, 0, null);
		// g.fillRect(0, 0, 100, 100);
		// g2d.setBackground(Color.black);
		// g2d.drawImage(background, 0, 0, null);

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
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.setColor(Color.WHITE);
		if (this.temperature1.compareTo("") != 0) {
			g.drawString(this.temperature1, 520, 132);
		}

		// add AC in upper right room
		Image AC2 = new ImageIcon("resources\\AC4.png").getImage();
		g.drawImage(AC2, 20, 100, 160, 65, null);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.setColor(new Color(255, 255, 255));
		if (this.temperature2.compareTo("") != 0) {
			g.drawString(this.temperature2, 100, 132);
		}

		// add lamp2 in upper left room
		Image lamp2 = new ImageIcon(this.lamp2path).getImage();
		g.drawImage(lamp2, 140, 190, 60, 75, null);
		// lamp in upper right room (for enabling turning on)
		if (this.lamp1path.compareTo("") != 0) {
			Image lamp1On = new ImageIcon(this.lamp1path).getImage();
			g.drawImage(lamp1On, 625, 213, 27, 13, null);
		}

		// add fluorescent to kitchen
		Image fluorescent = new ImageIcon("resources\\florosent.jpg").getImage();
		g.drawImage(fluorescent, 35, 443, 120, 3, null);
		// changes fluorescent light color according to buttons presses
		if (ledColorPath.compareTo("") != 0) {
			Image fColor = new ImageIcon(ledColorPath).getImage();
			g.drawImage(fColor, 39, 443, 113, 3, null);
		}
	}

	// change temperatureAC1
	public void setTemperature1(String newTemperature) {
		this.temperature1 = newTemperature;
		repaint(); // Trigger a repaint to update the display
	}

	// change temperatureAC1
	public void setTemperature2(String newTemperature) {
		this.temperature2 = newTemperature;
		repaint(); // Trigger a repaint to update the display
	}

	public void turnOnLamp2() {
		this.lamp2path = "resources\\lamp2On.png";
		repaint();
	}

	public void turnOffLamp2() {
		this.lamp2path = "resources\\lamp2Off.png";
		repaint();
	}

	public void turnOnLamp1() {
		this.lamp1path = "resources\\lampOn1.jpg";
		repaint();
	}

	public void turnOffLamp1() {
		this.lamp1path = "";
		repaint();
	}

	// set TV to sports channel
	public void setChannel(int channel) {
		if (channel == 0) {
			this.channelpath = "resources\\sports.jpg";
		} else if (channel == 1) {
			this.channelpath = "resources\\masterChef.png";
		}
		repaint();
	}

	public void turnOffTv() {
		this.channelpath = "";
		repaint();
	}

	public void turnOnTv() {
		setChannel(home.getTv().get_channel());
	}

	// set led color
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
	}

}
