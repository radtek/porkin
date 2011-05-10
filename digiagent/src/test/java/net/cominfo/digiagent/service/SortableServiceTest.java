package net.cominfo.digiagent.service;

import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import net.cominfo.digiagent.utils.BeanLocatorUtil;

import org.junit.Before;
import org.junit.Test;

public class SortableServiceTest {

	private SortableService ss = null;

	@Before
	public void setUp() throws Exception {
		ss = (SortableService) BeanLocatorUtil.getBean("sortableService");
	}

	@Test
	public void testReset() {
		// ss.reset();
	}

	@Test
	public void testNavigationPage() {
		List<HashMap> list = ss.getNavigationPage();
		TestCase.assertEquals(38, list.size());
	}

	@Test
	public void testPromotionPage() {
		List<HashMap> list = ss.getPromotionPage();
		TestCase.assertEquals(13, list.size());
	}

	@Test
	public void testSecondHandPage() {
		List<HashMap> list = ss.getSecondHandPage();
		TestCase.assertEquals(6, list.size());
	}

	public static void main(String[] args) {
		SortableService ss2 = (SortableService) BeanLocatorUtil
				.getBean("sortableService");
		Integer rootId = new Integer(5);
		List<Integer> result = ss2.getAllChild(rootId);
		for (Integer i : result) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

}
