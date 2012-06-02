package name.huangzhoujin.registration.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocatorUtil {
private static ApplicationContext context = null;
	
	public static ApplicationContext getContext() {
		if(context==null){
			context = new ClassPathXmlApplicationContext(Constants.SERVICE_FACTORY_PATH_FOR_TEST);
		}
		return context;
	}
	
}
