package name.huangzhoujin.registration.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static String dateFormat = SystemConstants.defaultFormat1;
	
	public static String getDateFormat() {
		return dateFormat;
	}

	public static void setDateFormat(String dateFormat) {
		DateUtil.dateFormat = dateFormat;
	}

	public static String dateToStr(Date date){
		String result = null;
		try{
			SimpleDateFormat sdf=new SimpleDateFormat(getDateFormat());
			result = sdf.format(date);
		}
		catch(Exception e){
			result = "";
		}
		return result;
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
