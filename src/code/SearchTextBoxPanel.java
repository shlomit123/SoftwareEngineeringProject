package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

// A class to hold the search text box and search button in the search window 
public class SearchTextBoxPanel extends JPanel implements ActionListener {
	private JButton submitSearchButton;
	private JTextField searchTextField;
	private MainAppWindow mainAppWindow;
	private Home home;

	// Constructor
	public SearchTextBoxPanel(int width, int height, MainAppWindow mainAppWindow1, Home home) {
		this.setBackground(Color.white);
		this.setBounds(0, 0, width, height);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

		searchTextField = new JTextField();
		searchTextField.setPreferredSize(new Dimension(210, height));
		searchTextField.setFont(new Font("David", Font.BOLD, 20));

		submitSearchButton = new JButton();
		submitSearchButton.addActionListener(this);
		submitSearchButton.setPreferredSize(new Dimension(50, height));
		submitSearchButton.setBorderPainted(false); // Remove the border
		submitSearchButton.setContentAreaFilled(false); // Remove the background
		submitSearchButton.setFocusPainted(false); // Remove the focus indicator
		submitSearchButton.setIcon(new ImageIcon("resources\\searchIcon.png"));

		this.add(searchTextField);
		this.add(submitSearchButton);

		this.mainAppWindow = mainAppWindow1;
		this.home = home;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		home.getMainAppWindow().getControllAppWindow().getSelectedDevicesPanel().updateSelectedDevices();
		home.getMainAppWindow().getDeviceSearchWindow().getSearchedDevicesPanel()
				.updateSearchedDevices(searchTextField.getText());
	}

	public JTextField getSearchTextField() {
		return this.searchTextField;
	}

}
