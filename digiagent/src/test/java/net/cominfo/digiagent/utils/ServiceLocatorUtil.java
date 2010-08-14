package net.cominfo.digiagent.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocatorUtil {

	private static String[] SERVICE_FACTORY_PATH = new String[] { "classpath:spring/db-config.xml"};

	private static ApplicationContext context = null;

	public static ApplicationContext getContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext(SERVICE_FACTORY_PATH);
		}
		return context;
	}
}
