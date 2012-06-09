package name.huangzhoujin.registration.service;

import java.util.List;

import junit.framework.TestCase;
import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LevelServiceTest {

	LevelService ls = null;
	@Before
	public void setUp() throws Exception {
		ls = (LevelService) BeanLocatorUtil
				.getBean(Constants.Level_Service);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAllLevel() {
		int expected = 5;
		int actual = ls.countAllLevel();
		TestCase.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetAll(){
		List<Level> result = ls.getAll();
		int expected = 5;
		int actual = 0;
		for(Level l: result){
			System.out.print("[LevelID="+l.getLevelId()+"]\t");
			actual++;
		}
		System.out.println();
		TestCase.assertEquals(expected, actual);
	}

}
