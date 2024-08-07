package code;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
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
	}
}
