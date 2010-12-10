package net.cominfo.digiagent.service;

import java.util.List;

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
	public void testReset() {
		ss.reset();
	}
	
	
//	@Test
//	public void testSortProduct() {
//		int[] productIds1 = new int[]{1,2,3};
//		int[] productIds2 = new int[]{5,6,7};
//		ss.sortProduct(productIds1, 30);
//		ss.sortProduct(productIds2, 33);
//	}
//	
//	@Test
//	public void testSortBrand() {
//		int[] brandIds1 = new int[]{11,12,13};
//		int[] brandIds2 = new int[]{15,16,17};
//		ss.sortBrand(brandIds1, 34);
//		ss.sortBrand(brandIds1, 35);
//	}
	
	public static void main(String[] args){
		SortableService ss2 = (SortableService)BeanLocatorUtil.getBean("sortableService");
		Integer rootId = new Integer(5);
		List<Integer> result = ss2.getAllChild(rootId);
		for(Integer i: result){
			System.out.print(i+",");
		}
		System.out.println();
	}

}
