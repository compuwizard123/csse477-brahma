/**
 * 
 */
package brahma.host;

import java.util.List;

/**
 * @author risdenkj
 *
 */
public interface IDependencyResolver {
	public List<IPlugin> resolveDependencies(List<IPlugin> plugins);
}
