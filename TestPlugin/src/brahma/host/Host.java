/**
 * 
 */
package brahma.host;

import java.util.ArrayList;
import java.util.List;

/**
 * @author risdenkj
 *
 */
public class Host {
	private IDependencyResolver dependencyResolver;
	private List<IPlugin> plugins;
	
	public Host() {
		this.dependencyResolver = new DependencyResolver();
		this.plugins = new ArrayList<IPlugin>();
		this.plugins.add(new PictureViewer());
		this.plugins.add(new PictureViewer());
		
		for(IPlugin plugin:this.plugins) {
			plugin.start();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Host();
	}
}
