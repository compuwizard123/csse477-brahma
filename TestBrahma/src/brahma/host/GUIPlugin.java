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
	
	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#start()
	 */
	@Override
	public Boolean start() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#stop()
	 */
	@Override
	public Boolean stop() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#load()
	 */
	@Override
	public Boolean load() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#unload()
	 */
	@Override
	public Boolean unload() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see brahma.host.IPlugin#getDependencies()
	 */
	@Override
	public List<IPlugin> getDependencies() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
	}
}
