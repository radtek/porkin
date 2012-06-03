package name.huangzhoujin.registration.service;

import junit.framework.TestCase;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EducationServiceTest {
	
	EducationService es = null;

	@Before
	public void setUp() throws Exception {
		es = (EducationService) BeanLocatorUtil
				.getBean(Constants.Eduction_Service);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAllEducation() {
		int expected = 9;
		int actual = es.countAllEducation();
		TestCase.assertEquals(expected, actual);
	}

}
