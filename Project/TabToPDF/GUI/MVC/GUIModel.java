package MVC;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


/**
 * 
 * 
 * @author cse23170
 *
 *	TO IMPLEMENT:
 *					- Update logbox ONLY WHEN NEEDED
 *					- 
 *
 */
public class GUIModel {

	// Static variables.

	protected static ArrayList<String> selectionImages = new ArrayList<String>();
	private static File imageFile;
	static String logString = "";
	static BufferedImage image;

	/**
	 * GUI Model constructor, constructs a model of the GUI.
	 * 
	 * @param - First initialization should give bare minimum i.e. picture
	 *        should be no preview image. Image lists should be empty (Except
	 *        for preview image). Should offset other array by s1 to account for
	 *        this.
	 */
	public GUIModel() {

	}

	public static void updateTopBoxLogic() {
		GUIView.topBox.setText("");

		if (imageFile == null) {
			imageFile = new File("res/nopreview.gif");
		} else if (GUIView.selectionFiles.get(0) == GUIView.NO_PREVIEW) {
			selectionImages.remove(0);
			GUIView.selectionFiles.remove(0);
		}

		try {
			image = ImageIO.read(imageFile);
			setImage();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logString += "Document preview has been updated.\n";
		updateLog();
	}

	/**
	 * 
	 */
	public static void setImage() {
		GUIController.image = image;
	}

	/**
	 * 
	 * @param f
	 *            - File to replace "no preview available"
	 */
	public static void setPreviewImage(File f) {
		imageFile = f;
	}

	/**
	 * Updates the log box with current activity.
	 */
	static void updateLog() {
		GUIView.log.append(logString);
		logString = "";
	}

	public static void addToSelectionImages(String image) {
		selectionImages.add(image);
	}

}
