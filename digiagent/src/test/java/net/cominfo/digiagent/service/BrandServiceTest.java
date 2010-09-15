package net.cominfo.digiagent.service;

import static org.junit.Assert.fail;

import java.util.Date;

import junit.framework.TestCase;

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
	public void testCount() {
		int count = bs.countBrand();
		TestCase.assertEquals(count, 8);
		
	}

}
