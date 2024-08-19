package code;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class TutorialMessagesDialog {

	private String openingInfoMessageString = "Welcome to your smart home application!\n\n"
			+ "In the app you can control all of your smart devices, and see your actions on the home simulator.\n"
			+ "The app contains two major components:\n"
			+ "- The control app component, used to control your smart devices, add/remove them from the app and modify their status.\n"
			+ "- The home view component, used to view your home and see the changes you make in real-time.";
	private String controlAppInfoMessageString = "In the control app component, you can see all of your assigned devices.\n\n"
			+ "Once you assigned a device you can click on it's button to open a configuration window in which you can customize your device.\n"
			+ "You can also right-click on the device's button if you would like to un-assign it.\n"
			+ "Click the sort button on the top right to sort your assigned buttons by type, and the search button to search for available un-assigned devices.\n"
			+ "In the search window you can search for all devices (empty search) or search for a specific type, and click on a device's button to assign it.";

	public TutorialMessagesDialog() {
		generateFirstMessage();
	}

	public void generateFirstMessage() {
		// Create a JOptionPane
		JOptionPane optionPane = new JOptionPane(openingInfoMessageString, JOptionPane.INFORMATION_MESSAGE);

		// Create a custom button
		JButton nextButton = new JButton("Next");

		// Set the action for the custom button
		nextButton.addActionListener(e -> optionPane.setValue(JOptionPane.OK_OPTION));

		// Add the custom button to the JOptionPane
		optionPane.setOptions(new Object[] { nextButton });

		// Create a dialog with the customized JOptionPane
		JDialog dialog = optionPane.createDialog("Smart Home App tutorial (1/2)");

		dialog.setLocationRelativeTo(null);
		// Set the dialog's icon
		ImageIcon logoIcon = new ImageIcon("resources\\smarthomelogo.png");
		dialog.setIconImage(logoIcon.getImage());

		dialog.setVisible(true);

		// Retrieve the user's response (if needed)
		Object response = optionPane.getValue();
		if (response != null && response.equals(JOptionPane.OK_OPTION)) {
			generateSecondMessage();
		}
	}

	public void generateSecondMessage() {
		// Create a JOptionPane
		JOptionPane optionPane = new JOptionPane(controlAppInfoMessageString, JOptionPane.INFORMATION_MESSAGE);

		// Create a custom button
		JButton okButton = new JButton("Got it!");

		// Set the action for the custom button
		okButton.addActionListener(e -> optionPane.setValue(JOptionPane.OK_OPTION));

		// Add the custom button to the JOptionPane
		optionPane.setOptions(new Object[] { okButton });

		// Create a dialog with the customized JOptionPane
		JDialog dialog = optionPane.createDialog("Smart Home App tutorial (2/2)");

		dialog.setLocationRelativeTo(null);
		// Set the dialog's icon
		ImageIcon logoIcon = new ImageIcon("resources\\smarthomelogo.png");
		dialog.setIconImage(logoIcon.getImage());

		dialog.setVisible(true);

		// Retrieve the user's response (if needed)
		Object response = optionPane.getValue();
		if (response != null && response.equals(JOptionPane.OK_OPTION)) {
			dialog.dispose();
		}
	}

}
