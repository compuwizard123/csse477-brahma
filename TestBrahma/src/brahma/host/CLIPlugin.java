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
	
	@Override
	public void setClassloader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
	}

}
