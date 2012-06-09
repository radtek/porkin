package name.huangzhoujin.registration.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static String dateFormat = "yyyy-MM-dd";
	
	public static String getDateFormat() {
		return dateFormat;
	}

	public static void setDateFormat(String dateFormat) {
		DateUtil.dateFormat = dateFormat;
	}

	public static Date strToDate(String strDate){
		Date result = null;
		try{
			SimpleDateFormat sdf=new SimpleDateFormat(getDateFormat());
			result = sdf.parse(strDate);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
