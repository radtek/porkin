package name.huangzhoujin.registration.service;

import java.util.HashMap;

import junit.framework.TestCase;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomServiceTest {

	CustomService cs = null;

	@Before
	public void setUp() throws Exception {
		cs = (CustomService) BeanLocatorUtil.getBean(Constants.Custom_Service);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testCountByCondition1() {
		HashMap condition = new HashMap();
		// condition.put("register", "黄州锦");
		condition.put("unemployed_no", "123456789");

		int expected = 2;
		int actual = cs.countByCondition(condition);
		System.out.println("Result=" + actual);
		TestCase.assertEquals(expected, actual);

	}

	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testCountByCondition2() {
		HashMap condition = new HashMap();
		condition.put("register", "黄州锦");
		// condition.put("unemployed_no", "123456789");

		int expected = 12;
		int actual = cs.countByCondition(condition);
		System.out.println("Result=" + actual);
		TestCase.assertEquals(expected, actual);

	}

}
