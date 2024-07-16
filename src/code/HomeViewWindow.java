package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomeViewWindow extends JPanel {
	Image background;

	public HomeViewWindow(int x, int y, int width, int height) {
		// Setting the size of the frame
		this.setBounds(x, y, width, height);
		this.setBackground(Color.blue);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		background = new ImageIcon("resources\\housebackground.jpg").getImage();
		g2d.drawImage(background, 0, 0, null);
		// g2d.setPaint(Color.pink);
	}
}
