/**
 * 
 */
package loaders;

import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author risdenkj
 *
 */
public abstract class MultipleURLLoader extends URLLoader {
	private Random randomGenerator;
	private ArrayList<URL> urls;

	/**
	 * 
	 */
	public MultipleURLLoader(ArrayList<String> urls) {
	    this.randomGenerator = new Random();
	    this.urls = new ArrayList<URL>();
		for(String url : urls) {
			try {
				this.urls.add(new URL(url));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public BufferedImage getImage() {
		super.setUrl(this.urls.get(this.randomGenerator.nextInt(this.urls.size())));
		return super.getImage();
	}
	
	public ArrayList<URL> getUrls() {
		return this.urls;
	}
}
