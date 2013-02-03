package name.huangzhoujin.mymaven.service;

import name.huangzhoujin.mymaven.utils.ServiceFacade;
import junit.framework.TestCase;

public class RepositoryServiceTest extends TestCase {
	
	private RepositoryService rs;

	protected void setUp() throws Exception {
		rs = ServiceFacade.getRepositoryService();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCountAll() {
		//String url = "abc";
		//rs.create(url);
	}

	public void testDelete() {
		//fail("Not yet implemented");
	}

	public void testCreateRepository() {
		//fail("Not yet implemented");
	}

	public void testCreateString() {
		//fail("Not yet implemented");
		boolean actual = rs.create("test");
		TestCase.assertEquals(true, actual);
	}

}
