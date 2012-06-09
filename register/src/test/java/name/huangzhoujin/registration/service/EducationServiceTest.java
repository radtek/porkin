package name.huangzhoujin.registration.service;

import java.util.List;

import junit.framework.TestCase;
import name.huangzhoujin.registration.persistence.domain.Education;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EducationServiceTest {
	
	EducationService es = null;

	@Before
	public void setUp() throws Exception {
		es = (EducationService) BeanLocatorUtil
				.getBean(Constants.Eduction_Service);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAllEducation() {
		int expected = 9;
		int actual = es.countAllEducation();
		TestCase.assertEquals(expected, actual);
	}	
	
	@Test
	public void testGetAll(){
		List<Education> result = es.getAll();
		int expected = 9;
		int actual = 0;
		for(Education e: result){
			System.out.print("[EducationID="+e.getEducationId()+"]\t");
			actual++;
		}
		System.out.println();
		TestCase.assertEquals(expected, actual);
	}

}
