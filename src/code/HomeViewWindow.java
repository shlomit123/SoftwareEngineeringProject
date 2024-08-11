package code;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeViewWindow extends JPanel {
	Image background;

	public HomeViewWindow(int x, int y, int width, int height, MainAppWindow mainAppWindow) {
		// Setting the size of the frame
		this.setBounds(x, y, width, height);
	}

	public void paint(Graphics g) {
		System.out.println("entered paint()");
		super.paintComponent(g);
		// this.setBackground(Color.blue);
		// Graphics2D g2d = (Graphics2D) g;
		background = new ImageIcon("resources\\1517195.jpg").getImage();
		g.drawImage(background, 0, 0, null);
		g.fillRect(0, 0, 100, 100);
		// g2d.setBackground(Color.black);
		// g2d.drawImage(background, 0, 0, null);
		Image TV = new ImageIcon("resources\\TV.png").getImage();
		g.drawImage(TV, 408, 454, 110, 50, null); 
		//Image AC1 = new ImageIcon("resources\\AC.jpg").getImage();
		//g.drawImage(AC1, 408, 300, 110, 50, null);
		Image lampOn = new ImageIcon("resources\\lampOn.jpg").getImage();
		g.drawImage(lampOn, 625, 213, 27, 13, null); 
	}
}
