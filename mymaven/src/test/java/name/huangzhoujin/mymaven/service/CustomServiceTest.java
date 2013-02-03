package name.huangzhoujin.mymaven.service;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import name.huangzhoujin.mymaven.utils.ServiceFacade;

public class CustomServiceTest extends TestCase {

	private CustomService cs;

	protected void setUp() throws Exception {
		cs = ServiceFacade.getCustomService();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetRepositoryTopList() {
		List<String> list = cs.getRepositoryTopList(ServiceFacade
				.getPropertiesBean().getRepository().length() + 2);
		System.out.println("Length="+list.size());
		Iterator<String> iter = list.iterator();
		String url;
		while(iter.hasNext()){
			url = iter.next();
			System.out.println("URL>>>"+url);
		}
	}

}
