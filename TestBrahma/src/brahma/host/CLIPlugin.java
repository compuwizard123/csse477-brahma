/**
 * 
 */
package brahma.host;

import java.util.List;

/**
 * @author risdenkj
 *
 */
public abstract class CLIPlugin implements IPlugin {

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
		return null;
	}
	
	@Override
	public void setClassloader(ClassLoader classLoader) {
		this.parentClassLoader  = classLoader;
	}

	/**
	 * @return the parentClassLoader
	 */
	public ClassLoader getClassloader() {
		return this.parentClassLoader;
	}

}
