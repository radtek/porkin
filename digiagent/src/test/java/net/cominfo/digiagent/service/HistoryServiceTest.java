package net.cominfo.digiagent.service;

import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import net.cominfo.digiagent.utils.BeanLocatorUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HistoryServiceTest {

	private HistoryService hs = null;
	
	@Before
	public void setUp() throws Exception {
		hs = (HistoryService)BeanLocatorUtil.getBean("historyService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSupplierReportByDays() {
		List<HashMap> result = hs.getSupplierReportByDays(7);
		TestCase.assertEquals(2, result.size());
		
	}

}
