/**
 * 
 */
package brahma.host;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/**
 * @author risdenkj
 *
 */
public class PictureViewer extends GUIPlugin {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ILoader loader;

	public PictureViewer() {
		//this.loader = new URLLoader("https://www.google.com/images/srpr/logo3w.png");
		this.loader = new SamLocalLoader();
	}
	
	public void paint(Graphics g) {
		BufferedImage image = this.loader.getImage();
		int newImageHeight = image.getHeight();
		int newImageWidth = image.getWidth();
		if (image.getHeight() >= image.getWidth() && image.getHeight() > getHeight()) {
			newImageHeight = getHeight();
			newImageWidth = Math.round((getHeight()/((float)image.getHeight()))*image.getWidth());
		} else if(image.getHeight() < image.getWidth() && image.getWidth() > getWidth()) {
			newImageHeight = Math.round((getWidth()/((float)image.getWidth()))*image.getHeight());
			newImageWidth = getWidth();
		}
		g.drawImage(image, getWidth()/2-newImageWidth/2, getHeight()/2-newImageHeight/2, newImageWidth, newImageHeight, null);
	}

	@Override
	public Boolean start() {
		JFrame frame = new JFrame("Display image");
		Panel panel = new PictureViewer();
		frame.setSize(500, 500);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		return true;
	}
}
