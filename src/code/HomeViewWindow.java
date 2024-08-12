package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeViewWindow extends JPanel {
	Image background;
	private String temperature1;
	private String temperature2;
	private String lamp2Image;
	private String lamp1Image;
	
	public HomeViewWindow(int x, int y, int width, int height, MainAppWindow mainAppWindow) {
		// Setting the size of the frame
		this.setBounds(x, y, width, height);
		this.temperature1 = "24\u00B0C";
		this.temperature2 = "25\u00B0C";
		this.lamp2Image = "resources\\lamp2Off.png";
	}

	public void paint(Graphics g) {
		System.out.println("entered paint()");
		super.paintComponent(g);
		// this.setBackground(Color.blue);
		// Graphics2D g2d = (Graphics2D) g;
		background = new ImageIcon("resources\\1517195.jpg").getImage();
		g.drawImage(background, 0, 0, null);
		//g.fillRect(0, 0, 100, 100);
		// g2d.setBackground(Color.black);
		// g2d.drawImage(background, 0, 0, null);
		
		//add TV in down left room
		Image TV = new ImageIcon("resources\\TV.png").getImage();
		g.drawImage(TV, 408, 454, 110, 50, null);
		//turn on sports in down left room
		Image sports = new ImageIcon("resources\\sports.jpg").getImage();
		g.drawImage(sports, 424, 456, 79, 42, null);
		
		//add AC in upper left room
		Image AC1 = new ImageIcon("resources\\AC4.png").getImage();
		g.drawImage(AC1, 440, 100, 160, 65, null);
		//add degrees text on AC1
		g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.WHITE); 
        g.drawString(this.temperature1, 520, 132);
		
		//add AC in upper right room
		Image AC2 = new ImageIcon("resources\\AC4.png").getImage();
		g.drawImage(AC2, 20, 100, 160, 65, null);
		g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.WHITE); 
        g.drawString(this.temperature2, 100, 132);
        
        //add lamp2 in upper left room
        Image lamp2 = new ImageIcon(this.lamp2Image).getImage();
		g.drawImage(lamp2, 140, 190, 60, 75, null); 
		
		//lamp in upper right room (for enabling turning on)
		Image lampOn = new ImageIcon(this.lamp1Image).getImage();
		g.drawImage(lampOn, 625, 213, 27, 13, null); 
		
		//add fluorescent to kitchen
		Image fluorescent = new ImageIcon("resources\\florosent.jpg").getImage();
		g.drawImage(fluorescent, 35, 443, 120, 3, null); 
		//changes fluorescent light color according to buttons presses
		//Image fOn = new ImageIcon("resources\\fOn.jpg").getImage();
		//g.drawImage(fOn, 35, 443, 120, 3, null); 
		//Image fBlue = new ImageIcon("resources\\fBlue.jpg").getImage();
		//g.drawImage(fBlue, 35, 443, 120, 3, null); 
		//Image fGreen = new ImageIcon("resources\\fGreen.jpg").getImage();
		//g.drawImage(fGreen, 35, 443, 120, 3, null); 
		//Image fPurple = new ImageIcon("resources\\fPurple.jpg").getImage();
		//g.drawImage(fPurple, 35, 443, 120, 3, null); 
	}
	//change temperatureAC1
	public void setTemperature1(String newTemperature) {
	    this.temperature1 = newTemperature;
	    repaint(); // Trigger a repaint to update the display
	}
	
	//change temperatureAC1
	public void setTemperature2(String newTemperature) {
	    this.temperature2 = newTemperature;
	    repaint(); // Trigger a repaint to update the display
	}
	
	public void turnOnLamp2() {
		this.lamp2Image = "resources\\lamp2On.png";
		repaint();
	}
	
	public void turnOffLamp2() {
		this.lamp2Image = "resources\\lamp2Off.png";
		repaint();
	}
	
	public void turnOnLamp1() {
		this.lamp1Image = "resources\\lampOn.jpg";
		repaint();
	}
	
}
