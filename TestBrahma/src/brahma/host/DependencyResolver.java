/**
 * 
 */
package brahma.host;

import java.util.List;

/**
 * @author risdenkj
 *
 */
public class DependencyResolver implements IDependencyResolver {

	@Override
	public List<IPlugin> resolveDependencies(List<IPlugin> plugins) {
		for(IPlugin plugin : plugins) {
			System.out.println(plugin.getDependencies());
		}
		return null;
	}

}
