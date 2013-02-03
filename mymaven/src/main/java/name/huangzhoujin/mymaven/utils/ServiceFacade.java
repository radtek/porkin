package name.huangzhoujin.mymaven.utils;

import name.huangzhoujin.mymaven.service.CustomService;
import name.huangzhoujin.mymaven.service.PropertiesBean;
import name.huangzhoujin.mymaven.service.RepositoryService;

public class ServiceFacade {
	private static PropertiesBean propertiesBean = null;
	private static RepositoryService repositoryService = null;
	private static CustomService customService = null;

	public static PropertiesBean getPropertiesBean() {
		if (propertiesBean == null) {
			propertiesBean = (PropertiesBean) BeanLocatorUtil
					.getBean(Constants.PropertiesBean);
		}
		return propertiesBean;
	}

	public static RepositoryService getRepositoryService() {
		if (repositoryService == null) {
			repositoryService = (RepositoryService) BeanLocatorUtil
					.getBean(Constants.RepositoryService);
		}
		return repositoryService;
	}

	public static CustomService getCustomService() {
		if (customService == null) {
			customService = (CustomService) BeanLocatorUtil
					.getBean(Constants.CustomService);
		}
		return customService;
	}

}
