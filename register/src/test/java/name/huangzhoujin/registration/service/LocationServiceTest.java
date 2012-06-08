package name.huangzhoujin.registration.service;

import java.util.List;

import junit.framework.TestCase;
import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.persistence.domain.Location;
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

	@Test
	public void testGetAll() {
		List<Location> result = ls.getAll();
		int expected = 2;
		int actual = 0;
		for (Location l : result) {
			System.out.print("[LocationID=" + l.getLocationId() + "]\t");
			actual++;
		}
		System.out.println();
		TestCase.assertEquals(expected, actual);
	}

}
