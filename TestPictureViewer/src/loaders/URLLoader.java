/**
 * 
 */
package loaders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import brahma.host.ILoader;

/**
 * @author risdenkj
 *
 */
public abstract class URLLoader implements ILoader {
	private URL url;
	
	public URLLoader(String urlStr) {
		try {
			this.url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(this.url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
