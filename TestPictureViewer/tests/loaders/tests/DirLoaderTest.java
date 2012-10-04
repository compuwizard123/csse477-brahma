package loaders.tests;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import loaders.tests.TestDirLoader;

public class DirLoaderTest {
	private TestDirLoader full;
	private TestDirLoader empty;
	
	@Before
	public void setUp() throws Exception {
		full = new TestDirLoader("tests/loaders/tests/pic");
		empty = new TestDirLoader("pic");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLoadImagesCorrectly() {
		Assert.assertEquals(3, full.getPics().size());
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
