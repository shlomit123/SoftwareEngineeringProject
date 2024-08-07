package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel implements ActionListener {
	private JButton searchButton;
	private JButton sortButton;
	private JLabel titleLabel;
	private MainAppWindow mainAppWindow;

	public TopPanel(int width, int height, MainAppWindow mainAppWindow1) {
		this.setBackground(Color.white);
		this.setBounds(0, 0, width, height);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

		searchButton = new JButton();
		searchButton.addActionListener(this); //
		searchButton.setPreferredSize(new Dimension(50, height)); //
		searchButton.setBorderPainted(false); // Remove the border //
		searchButton.setContentAreaFilled(false); // Remove the background //
		searchButton.setFocusPainted(false); // Remove the focus indicator
		searchButton.setIcon(new ImageIcon("resources\\searchIcon.png"));

		titleLabel = new JLabel("Assigned Devices"); //
		titleLabel.setPreferredSize(new Dimension(210, height));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setHorizontalTextPosition(JLabel.CENTER);
		titleLabel.setForeground(new Color(0x1F7E92));
		titleLabel.setFont(new Font("David", Font.BOLD, 20));
		titleLabel.setBackground(Color.white);
		titleLabel.setOpaque(true);

		sortButton = new JButton();
		sortButton.addActionListener(this); //
		sortButton.setPreferredSize(new Dimension(50, height));
		sortButton.setBorderPainted(false); // Remove the border //
		sortButton.setContentAreaFilled(false); // Remove the background //
		sortButton.setFocusPainted(false); // Remove the focus indicator
		sortButton.setIcon(new ImageIcon("resources\\sortIcon.png"));

		this.add(searchButton);
		this.add(titleLabel);
		this.add(sortButton);

		mainAppWindow = mainAppWindow1;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchButton) {
			mainAppWindow.openDeviceSearchWindow();
		} else if (e.getSource() == sortButton) {
			System.out.println("Sorting");
		}
	}

}
