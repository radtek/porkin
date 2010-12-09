package net.cominfo.digiagent.service;

import static org.junit.Assert.fail;
import net.cominfo.digiagent.utils.BeanLocatorUtil;

import org.junit.Before;
import org.junit.Test;

public class SortableServiceTest {
	
	private SortableService ss = null;

	@Before
	public void setUp() throws Exception {
		ss = (SortableService)BeanLocatorUtil.getBean("sortableService");
	}

	@Test
	public void testSortCategory() {
		int[] categoryIds = new int[]{1,3,2};
		ss.sortCategory(categoryIds);
	}

}
