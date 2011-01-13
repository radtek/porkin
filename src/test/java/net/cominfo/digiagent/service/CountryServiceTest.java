package net.cominfo.digiagent.service;

import junit.framework.TestCase;
import net.cominfo.digiagent.utils.BeanLocatorUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountryServiceTest {

	
	private CountryService cs = null;
	
	@Before
	public void setUp() throws Exception {
		cs = (CountryService)BeanLocatorUtil.getBean("countryService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCount() {
		int count = cs.countCountry();
		TestCase.assertEquals(count, 12);
	}
	
}
