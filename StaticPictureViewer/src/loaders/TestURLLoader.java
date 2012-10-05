package loaders;
import java.util.ArrayList;

import loaders.MultipleURLLoader;

public class TestURLLoader extends MultipleURLLoader {	
	@SuppressWarnings("serial")
	private static ArrayList<String> urls = new ArrayList<String>() {{
		  add("http://upload.wikimedia.org/wikipedia/commons/e/ec/Happy_smiley_face.png");
		  add("http://www.cartoonlogodesigns.com/images/misc/Smiley%20faces/smiley%20face.jpg");
		  add("http://iuliaradu.files.wordpress.com/2010/01/smiley-face1.jpg");
		}};
	
	public TestURLLoader() {
		super(urls);
	}
}
