package loaders.tests;

import java.net.URL;

import org.junit.Assert;

import org.easymock.EasyMock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import loaders.tests.TestDirLoader;

public class DirLoaderTest {
	private TestDirLoader l;
	
	@Before
	public void setUp() throws Exception {
		l = new TestDirLoader("/Users/nick/Documents/Rose/Classes/CSSE477/csse477-brahma/TestPictureViewer/tests/loaders/tests/pic");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLoadImagesCorrectly() {
		Assert.assertEquals(l.getPics().size(), 3);
	}
	
	@Test
	public void testGetImagesCorrectly() {
		Assert.assertNotNull(l.getImage());
	}
	
}
