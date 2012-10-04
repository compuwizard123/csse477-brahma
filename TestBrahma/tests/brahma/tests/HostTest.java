package brahma.tests;

import org.junit.Assert;

import org.easymock.EasyMock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brahma.host.Host;
import brahma.host.IPlugin;

public class HostTest {
	private Host h;
	
	@Before
	public void setUp() throws Exception {
		h = new Host();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAddPlugin() {
		Assert.assertEquals("Initial number of plugins", h.getPlugins().size(), 0);
		for(int i = 0; i < 10; i++) {
			h.addPlugin(EasyMock.createMock(IPlugin.class));
		}
		Assert.assertEquals("Number after add", h.getPlugins().size(), 10);
	}
	
	@Test
	public void testRemovePlugin() {
		IPlugin p = EasyMock.createMock(IPlugin.class);
		h.addPlugin(p);
		Assert.assertTrue("Specific plugin in list", h.getPlugins().contains(p));
		h.removePlugin(p);
		Assert.assertFalse("Specific plugin no longer in list", h.getPlugins().contains(p));
	}
	
	@Test
	public void testAddRemovePlugin() {
		Assert.assertEquals("Initial number of plugins", h.getPlugins().size(), 0);
		IPlugin p = EasyMock.createMock(IPlugin.class);
		h.addPlugin(p);
		for(int i = 0; i < 10; i++) {
			h.addPlugin(EasyMock.createMock(IPlugin.class));
		}
		Assert.assertEquals("Number after add", h.getPlugins().size(), 11);
		Assert.assertTrue("Specific plugin in list", h.getPlugins().contains(p));
		h.removePlugin(p);
		Assert.assertEquals("Number after remove", h.getPlugins().size(), 10);
		Assert.assertFalse("Specific plugin no longer in list", h.getPlugins().contains(p));
	}
	
}
