/**
 * 
 */
package brahma.host;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author risdenkj
 *
 */
public abstract class GUIPlugin extends Panel implements IPlugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IPlugin> dependencies = new ArrayList<IPlugin>();
	private IDependencyResolver dependencyResolver = new DependencyResolver();
	private ClassLoader parentClassLoader = ClassLoader.getSystemClassLoader();
	
	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#start()
	 */
	@Override
	public Boolean start() {
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#stop()
	 */
	@Override
	public Boolean stop() {
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#load()
	 */
	@Override
	public Boolean load() {
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#unload()
	 */
	@Override
	public Boolean unload() {
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#getDependencies()
	 */
	@Override
	public List<IPlugin> getDependencies() {
		return this.dependencies;
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
	 * @param dependencies the dependencies to set
	 */
	public void setDependencies(List<IPlugin> dependencies) {
		this.dependencies = dependencies;
	}
	
	@Override
	public void setClassloader(ClassLoader classLoader) {
		this.parentClassLoader = classLoader;
	}

	/**
	 * @return the parentClassLoader
	 */
	public ClassLoader getClassloader() {
		return this.parentClassLoader;
	}
}
