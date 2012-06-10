package name.huangzhoujin.registration.service;

import junit.framework.TestCase;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistrationServiceTest {

	RegistrationService rs = null;
	
	@Before
	public void setUp() throws Exception {
		rs = (RegistrationService) BeanLocatorUtil
				.getBean(Constants.Registration_Service);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAllRegistration() {
		int expected = 36;
		int actual = rs.countAllRegistration();
		TestCase.assertEquals(expected, actual);
	}

}
