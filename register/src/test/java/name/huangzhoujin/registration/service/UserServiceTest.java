package name.huangzhoujin.registration.service;

import junit.framework.TestCase;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

	UserService us = null;
	
	@Before
	public void setUp() throws Exception {
		us = (UserService) BeanLocatorUtil
				.getBean(Constants.User_Service);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCountAllPermission() {
		int expected = 1;
		int actual = us.countAllPermission();
		TestCase.assertEquals(expected, actual);
	}

}
