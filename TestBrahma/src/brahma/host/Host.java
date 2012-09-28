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
	private PluginManager pluginManager;
	
	public Host() {
		this.setDependencyResolver(new DependencyResolver());
		this.plugins = new ArrayList<IPlugin>();
		
		try {
			this.pluginManager = new PluginManager(this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Thread thread = new Thread(this.pluginManager);
		thread.start();
	}
	
	public void addPlugin(IPlugin plugin) {
		this.plugins.add(plugin);
		plugin.start();
		System.out.println("Added new plugin");
	}

	public void removePlugin(IPlugin plugin) {
		this.plugins.remove(plugin);
	}
	
	/**
	 * @return the dependencyResolver
	 */
	public IDependencyResolver getDependencyResolver() {
		return dependencyResolver;
	}

	/**
	 * @param dependencyResolver the dependencyResolver to set
	 */
	public void setDependencyResolver(IDependencyResolver dependencyResolver) {
		this.dependencyResolver = dependencyResolver;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Host();
	}
}
