/**
 * 
 */
package loaders;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author risdenkj
 *
 */
public abstract class DirLocalLoader extends LocalLoader {
	private Random randomGenerator;
	private ArrayList<File> pics;

	/**
	 * 
	 */
	public DirLocalLoader(String dir) {
		this.pics = new ArrayList<File>();
	    this.randomGenerator = new Random();
		
		Path picDir = FileSystems.getDefault().getPath(dir).toAbsolutePath();
		File picFolder = picDir.toFile();
		File[] files = picFolder.listFiles();
		if(files != null) {
			for(File f : files) {
				if(f.getName().endsWith(".JPG")) {
					this.pics.add(f);
				}
			}
		}
	}
	
	@Override
	public BufferedImage getImage() {
		super.setFile(this.pics.get(this.randomGenerator.nextInt(this.pics.size())));
		return super.getImage();
	}
	
	public ArrayList<File> getPics() {
		return pics;
	}
}
