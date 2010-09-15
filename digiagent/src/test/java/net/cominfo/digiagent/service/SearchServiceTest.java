package net.cominfo.digiagent.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import net.cominfo.digiagent.utils.BeanLocatorUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchServiceTest {

	private SearchService ss = null;
	
	@Before
	public void setUp() throws Exception {
		ss = (SearchService)BeanLocatorUtil.getBean("searchService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFixedSearch() {
		Map condition = new HashMap();
		condition.put("categoryId", "1");
		condition.put("productId", "2");
		condition.put("brandId", "6");
		List<Map> result = ss.fixedSearch(condition);
		Map temp = result.get(0);
		System.out.println(temp);
		TestCase.assertEquals(temp.get("SUPPLIER_ID").toString(), "1");
	}

}
