package net.cominfo.digiagent.service;

import static org.junit.Assert.fail;

import java.util.Date;

import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.utils.BeanLocatorUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrandServiceTest {

	private BrandService bs = null;
	@Before
	public void setUp() throws Exception {
		bs = (BrandService)BeanLocatorUtil.getBean("brandService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		Brand brand = new Brand();
		brand.setActiveFlag("Y");
		brand.setBrandEnglish("Sony");
		brand.setBrandName("Sony");
		brand.setCreatedBy("Porkin");
		brand.setCreatedDate(new Date());
		brand.setLastupdatedBy("Porkin");
		brand.setLastupdatedDate(new Date());
		brand.setCountryId(1);
//		bs.create(brand);
		
	}

}
