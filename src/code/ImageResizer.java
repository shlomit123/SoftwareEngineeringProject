package code;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageResizer {

	public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
		// Get the image from the ImageIcon
		Image image = icon.getImage();

		// Scale the image to the desired size
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		// Create a new ImageIcon from the scaled image
		return new ImageIcon(scaledImage);
	}

	public static void main(String[] args) {
		// Load your ImageIcon
		ImageIcon originalIcon = new ImageIcon("resources\\smarthomelogo.png");

		// Resize the ImageIcon
		ImageIcon resizedIcon = resizeImageIcon(originalIcon, 50, 50);

		// Use the resizedIcon as needed
		// For example, set it on a JButton
		JButton button = new JButton(resizedIcon);
	}
}
