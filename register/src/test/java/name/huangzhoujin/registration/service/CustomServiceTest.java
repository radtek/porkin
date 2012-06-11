package name.huangzhoujin.registration.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import name.huangzhoujin.registration.persistence.dto.CustomDto;
import name.huangzhoujin.registration.utils.BeanLocatorUtil;
import name.huangzhoujin.registration.utils.Constants;
import name.huangzhoujin.registration.utils.DateUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomServiceTest {

	CustomService cs = null;

	@Before
	public void setUp() throws Exception {
		cs = (CustomService) BeanLocatorUtil.getBean(Constants.Custom_Service);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testCountByCondition1() {
		HashMap condition = new HashMap();
		// condition.put("register", "黄州锦");
		condition.put("unemployed_no", "123456789");
		
		condition.put("start_date", "2012-06-01");
		condition.put("end_date", "2013-06-01");
		condition.put("start_time", "2012-06-01");
		condition.put("end_time", "2013-06-01");

		long expected = 2;
		long actual = cs.countByCondition(condition);
		System.out.println("Result=" + actual);
		TestCase.assertEquals(expected, actual);

	}

	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testCountByCondition2() {
		HashMap condition = new HashMap();
		condition.put("register", "黄州锦");
		// condition.put("unemployed_no", "123456789");

		long expected = 12;
		long actual = cs.countByCondition(condition);
		System.out.println("Result=" + actual);
		TestCase.assertEquals(expected, actual);

	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testListtByCondition1() {
		int pageNo = 1;
		int pageSize = 5;
		
		HashMap condition = new HashMap();
		condition.put("register", "黄州锦");
		condition.put("first", pageNo);
		condition.put("pageSize", pageSize);
		// condition.put("unemployed_no", "123456789");
		
		List<CustomDto> result = cs.listByCondition(condition);
		Iterator<CustomDto> iter = result.iterator();
		CustomDto temp = null;
		int i = 0;
		while(iter.hasNext()){
			i++;
			temp = (CustomDto)iter.next();
			System.out.println(i+":"+temp.getRegistrationId()+"\t"+DateUtil.dateToStr(temp.getRegistrationDate()));
		}
		TestCase.assertTrue(true);
	}

}
