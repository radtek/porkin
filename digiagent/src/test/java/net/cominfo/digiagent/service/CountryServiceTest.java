package net.cominfo.digiagent.service;

import static org.junit.Assert.fail;

import java.util.Date;

import net.cominfo.digiagent.persistence.domain.Country;
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
	public void testCreate() {
		Country country = new Country();
		country.setActiveFlag("N");
		country.setCountryAbbreviation("CN");
		country.setCountryName("China");
		country.setCreatedBy("Porkin");
		country.setCreatedDate(new Date());
		country.setLastupdatedBy("Porkin");
		country.setLastupdatedDate(new Date());
		//cs.create(country);
	}
	
}
