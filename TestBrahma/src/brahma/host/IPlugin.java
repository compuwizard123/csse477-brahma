/**
 * 
 */
package brahma.host;

import java.util.List;

/**
 * @author risdenkj
 *
 */
public interface IPlugin {
	public Boolean start();
	public Boolean stop();
	public Boolean load();
	public Boolean unload();
	public List<IPlugin> getDependencies();
}
