package name.huangzhoujin.registration.utils;

public class Constants {

	public static final String User_Service = "userService";

	public static String[] SERVICE_FACTORY_PATH_FOR_TEST = new String[] { "spring/applicationContext.xml" };

	public static String[] SERVICE_FACTORY_PATH = new String[] {
			"/spring/applicationContext.xml",
			"/spring/applicationContext-BusinessDB.xml",
			"/spring/applicationContext-Common.xml",
			"/spring/applicationContext-CommonDB.xml",
			"/spring/applicationContext-DS.xml",
			"/spring/applicationContext-Workflow.xml",
			"/spring/dataAccessContext-hibernate.xml",
			"/spring/serviceContext.xml", };

}
