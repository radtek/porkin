package name.huangzhoujin.registration.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

public class BeanLocatorUtil {

	private static Log log = LogFactory.getLog(BeanLocatorUtil.class);
	private static ApplicationContext context = ServiceLocatorUtil.getContext();

	public static void setApplicationContext(
			ApplicationContext applicationContext) {
		if (null == context) {
			BeanLocatorUtil.context = applicationContext;
			log.info("application context is created successfully!");
		}
	}

	public static final Object getBean(String beanName) {
		if (null != context) {
			return context.getBean(beanName);
		}
		throw new RuntimeException("Please Initial me first.");
	}

}