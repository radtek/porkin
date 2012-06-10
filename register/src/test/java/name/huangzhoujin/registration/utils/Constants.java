package name.huangzhoujin.registration.utils;

public class Constants {

	public static final String Area_Service = "areaService";
	public static final String Eduction_Service = "educationService";
	public static final String Level_Service = "levelService";
	public static final String Location_Service = "locationService";
	public static final String Registration_Service = "registrationService";
	public static final String User_Service = "userService";
	public static final String Custom_Service = "customService";

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
