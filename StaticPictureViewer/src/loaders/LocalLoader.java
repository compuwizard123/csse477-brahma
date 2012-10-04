/**
 * 
 */
package loaders;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * @author risdenkj
 * 
 */
public abstract class LocalLoader implements ILoader {
	private File file;

	@Override
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(this.file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public void setFile(File fileObj) {
		this.file = fileObj;
	}
}
