package brahma.host;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PluginManager implements Runnable {
	private Host host;
	private WatchDir watchDir;
	private HashMap<Path, IPlugin> pathToPlugin;
	private ClassLoader classLoader;

	public PluginManager(Host host) throws IOException {
		this.host = host;
		this.pathToPlugin = new HashMap<Path, IPlugin>();
		watchDir = new WatchDir(this, FileSystems.getDefault().getPath("plugins"), false);
	}

	@Override
	public void run() {
		// First load existing plugins if any
		try {
			Path pluginDir = FileSystems.getDefault().getPath("plugins");
			File pluginFolder = pluginDir.toFile();
			File[] files = pluginFolder.listFiles();
			if(files != null) {
				for(File f : files) {
					this.loadBundle(f.toPath());
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// Listen for newly added plugins
		watchDir.processEvents();
	}

	void loadBundle(Path bundlePath) throws Exception {
		// Get hold of the jar file
		File jarBundle = bundlePath.toFile();
		JarFile jarFile = new JarFile(jarBundle);
		
		// Get the manifest file in the jar file
		Manifest mf = jarFile.getManifest();
        Attributes mainAttribs = mf.getMainAttributes();
        
        // Get hold of the Plugin-Class attribute and load the class
        String className = mainAttribs.getValue("Plugin-Class");
        URL[] urls = new URL[]{bundlePath.toUri().toURL()};
        classLoader = new URLClassLoader(urls);
        Class<?> pluginClass = classLoader.loadClass(className);
        
        // Create a new instance of the plugin class and add to the core
        IPlugin plugin = (IPlugin)pluginClass.newInstance();
        this.host.addPlugin(plugin);
        this.pathToPlugin.put(bundlePath, plugin);

        // Release the jar resources
        jarFile.close();
	}
	
	void unloadBundle(Path bundlePath) {
		IPlugin plugin = this.pathToPlugin.remove(bundlePath);
		if(plugin != null) {
			this.host.removePlugin(plugin);
		}
	}
}
