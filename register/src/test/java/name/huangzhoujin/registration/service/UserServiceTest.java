package name.huangzhoujin.registration.service;

import java.util.List;

import junit.framework.TestCase;
import name.huangzhoujin.registration.persistence.domain.User;
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
	
	@Test
	public void testGetAll() {
		List<User> result = us.getAll();
		int expected = 1;
		int actual = 0;
		for (User u : result) {
			System.out.print("[UserID=" + u.getUserId() + "]\t");
			actual++;
		}
		System.out.println();
		TestCase.assertEquals(expected, actual);
	}

}
