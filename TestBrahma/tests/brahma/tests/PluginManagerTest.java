package brahma.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.easymock.EasyMock;
import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brahma.host.Host;
import brahma.host.PluginManager;

//import org.apache.commons.io.FileUtils;

public class PluginManagerTest {
	
	PluginManager p;
	Host h;
	
	private final Path pluginPath = FileSystems.getDefault().getPath("plugins");
	private final Path jarPath = FileSystems.getDefault().getPath("plugin.jar");

	@Before
	public void setUp() throws Exception {
		h = new Host();
		p = new PluginManager(h);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmptyLoadBundle() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
		Path path = EasyMock.createMock(Path.class);
		Method method = PluginManager.class.getDeclaredMethod("loadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(p.getPathToPlugin().size(), 0);
	}
	
	@Test
	public void testEmptyUnload() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
		Path path = EasyMock.createMock(Path.class);
		Method method = PluginManager.class.getDeclaredMethod("unloadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(p.getPathToPlugin().size(), 0);
	}
	
	@Test
	public void testSingleLoadBundle() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
		FileUtils.copyFile(pluginPath, jarPath);
		Path path = EasyMock.createMock(Path.class);
		Method method = PluginManager.class.getDeclaredMethod("loadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(p.getPathToPlugin().size(), 1);
	}
	
	@Test
	public void testSingleUnloadBundle() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
		FileUtils.copyFile(pluginPath, jarPath);
		Path path = EasyMock.createMock(Path.class);
		Method method = PluginManager.class.getDeclaredMethod("loadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(p.getPathToPlugin().size(), 1);
		method = PluginManager.class.getDeclaredMethod("unloadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(p.getPathToPlugin().size(), 0);
	}
}
