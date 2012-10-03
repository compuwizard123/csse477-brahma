package brahma.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;

import org.easymock.EasyMock;
import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brahma.host.Host;
import brahma.host.PluginManager;
import brahma.host.WatchDir;

public class WatchDirTest {
	
	Host h;
	PluginManager p;
	WatchDir w;
	Path path;

	@Before
	public void setUp() throws Exception {
		path = EasyMock.createMock(Path.class);
		h = new Host();
		p = new PluginManager(h);
		w = new WatchDir(p, path, false);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void testRegisterPath() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Path path = EasyMock.createMock(Path.class);
		Method method = PluginManager.class.getDeclaredMethod("register", Path.class);
		method.setAccessible(true);
		method.invoke(w, path);
	}
	*/

}
