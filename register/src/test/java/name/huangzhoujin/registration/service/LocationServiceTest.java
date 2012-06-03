package name.huangzhoujin.registration.service;

import junit.framework.TestCase;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocationServiceTest {
	
	LocationService ls = null;

	@Before
	public void setUp() throws Exception {
		ls = (LocationService) BeanLocatorUtil
				.getBean(Constants.Location_Service);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAllLocation() {
		int expected = 2;
		int actual = ls.countAllLocation();		
		TestCase.assertEquals(expected, actual);
	}

}
