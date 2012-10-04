package brahma.tests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.easymock.EasyMock;
import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brahma.host.Host;
import brahma.host.PluginManager;

public class PluginManagerTest {
	
	PluginManager p;
	Host h;
	
	private final Path pluginPath = FileSystems.getDefault().getPath("tests/brahma/tests/TestPictureViewer.jar");
	private final Path jarPath = FileSystems.getDefault().getPath("plugins/testPlugin.jar");

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
		Assert.assertEquals(0, p.getPathToPlugin().size());
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
		Assert.assertEquals(0, p.getPathToPlugin().size());
	}
	
	@Test
	public void testSingleLoadBundle() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
		try {
			Files.copy(pluginPath, jarPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Path path = EasyMock.createMock(Path.class);
		Method method = PluginManager.class.getDeclaredMethod("loadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(1, p.getPathToPlugin().size());
	}
	
	@Test
	public void testSingleUnloadBundle() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
		try {
			Files.copy(pluginPath, jarPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Path path = EasyMock.createMock(Path.class);
		Method method = PluginManager.class.getDeclaredMethod("loadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(1, p.getPathToPlugin().size());
		method = PluginManager.class.getDeclaredMethod("unloadBundle", Path.class);
		method.setAccessible(true);
		try {
			method.invoke(p, path);
		} catch (InvocationTargetException e) {
			
		}
		Assert.assertEquals(0, p.getPathToPlugin().size());
	}
}
