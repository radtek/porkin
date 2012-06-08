package name.huangzhoujin.registration.service;

import java.util.List;

import junit.framework.TestCase;
import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AreaServiceTest {

	AreaService as = null;
	
	@Before
	public void setUp() throws Exception {
		as = (AreaService) BeanLocatorUtil
				.getBean(Constants.Area_Service);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAllArea() {
		int expected = 6;
		int actual = as.countAllArea();
		TestCase.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetAll(){
		List<Area> result = as.getAll();
		int expected = 6;
		int actual = 0;
		for(Area a: result){
			System.out.print("[AreaID="+a.getAreaId()+"]\t");
			actual++;
		}
		System.out.println();
		TestCase.assertEquals(expected, actual);
	}

}
