package net.cominfo.digiagent.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/*
 * *
 * @copyright: Copyright 2009
 * @company: Genpact
 * @author: 703006677
 * @version: 1.0 Modification History: Date Author Description ----------------------- Jun 5, 2009 703006677
 * Initialization
 */
public class BeanLocatorUtil {

	private static Log log = LogFactory.getLog(BeanLocatorUtil.class);

	private static ApplicationContext context = null;

	static {
		if (null == context) {
			context = ServiceLocatorUtil.getContext();
		}
	}

	public static void setApplicationContext(
			ApplicationContext applicationContext) {
		if (null == context) {
			context = applicationContext;
		}
	}

	public static final Object getBean(String beanName) {
		if (null != context) {
			return context.getBean(beanName);
		}

		throw new RuntimeException("Please Init me at employee login.");
	}
	
	public static void showBeanList() {
		if (null != context) {
			String[] beanList = context.getBeanDefinitionNames();
			for(String t: beanList){
				System.out.println("Name="+t);
			}
		}
	}

}