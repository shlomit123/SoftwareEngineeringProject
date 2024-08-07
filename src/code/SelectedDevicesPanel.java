package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SelectedDevicesPanel extends JPanel implements ActionListener {

	DeviceButton b6, b7, b8, b9, b10;
	DeviceButton[] allDevices1 = { b6, b7, b8, b9, b10 };
	ArrayList<DeviceButton> selectedDevices1 = new ArrayList<DeviceButton>();

	MainAppWindow mainWindow;

	public SelectedDevicesPanel(int width, int height, MainAppWindow mainAppWindow) {
		for (int i = 0; i < 5; i++) {
			allDevices1[i] = new DeviceButton(new ImageIcon("resources\\ACicon.png"), "AC" + i, mainAppWindow);
			if (i % 2 == 0) {
				selectedDevices1.add(allDevices1[i]);
				System.out.println("added " + i + "to selected devices");
			}
		}
		this.setBackground(Color.pink);
		this.setBounds(0, 50, width, height);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		for (int i = 0; i < selectedDevices1.size(); i++) {
			this.add(selectedDevices1.get(i));
		}
		mainWindow = mainAppWindow;
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
