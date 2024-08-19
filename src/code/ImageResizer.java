package code;

import java.awt.Image;

import javax.swing.ImageIcon;

// A class to set a given image to a desired size
public class ImageResizer {

	public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
		// Get the image from the ImageIcon
		Image image = icon.getImage();

		// Scale the image to the desired size
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		// Create a new ImageIcon from the scaled image
		return new ImageIcon(scaledImage);
	}
}
