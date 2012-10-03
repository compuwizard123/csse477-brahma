package loaders.tests;

import java.net.URL;

import org.junit.Assert;

import org.easymock.EasyMock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import loaders.tests.TestDirLoader;

public class DirLoaderTest {
	private TestDirLoader full;
	private TestDirLoader empty;
	
	@Before
	public void setUp() throws Exception {
		full = new TestDirLoader("/Users/nick/Documents/Rose/Classes/CSSE477/csse477-brahma/TestPictureViewer/tests/loaders/tests/pic");
		empty = new TestDirLoader("pic");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLoadImagesCorrectly() {
		Assert.assertEquals(full.getPics().size(), 3);
	}
	
	@Test
	public void testGetImagesCorrectly() {
		Assert.assertNotNull(full.getImage());
	}
	
	@Test
	public void testLoadEmptyDir() {
		Assert.assertEquals(empty.getPics().size(), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetImageFromEmptyDir() {
		empty.getImage();
	}
	
}
