package code;

import java.awt.Color;

import javax.swing.JPanel;

public class ControlAppWindow extends JPanel {

	ControlAppWindow(int x, int y, int width, int height) {
		// Setting the size of the frame
		this.setBounds(0, 0, width, height);
		this.setBackground(Color.pink);
		this.setLayout(null);
		JPanel p1 = new JPanel();
		TopPanel top = new TopPanel(width, 50);
		p1.setBounds(0, 50, width, height - 50);
		this.add(top);
		this.add(p1);

	}

}
