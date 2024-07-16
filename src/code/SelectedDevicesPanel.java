package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectedDevicesPanel extends JPanel implements ActionListener {

	JButton b1, b2, b3, b4, b5;
	JButton[] allDevices = { b1, b2, b3, b4, b5 };
	ArrayList<JButton> selectedDevices = new ArrayList<JButton>();

	public SelectedDevicesPanel(int width, int height) {
		for (int i = 0; i < 5; i++) {
			allDevices[i] = new JButton("Button" + i);
			if (i % 2 == 0) {
				selectedDevices.add(allDevices[i]);
			}
		}

		this.setBackground(Color.pink);
		this.setBounds(0, 0, width, height);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
