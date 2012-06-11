package name.huangzhoujin.registration.utils;

public class NumberUtil {

	public static Integer strToIngeger(String s){
		Integer result = null;
		if(s==null || s.trim().equals("")){
			result = null;
		}
		else{
			result = Integer.parseInt(s);
		}
		return result;
	}
}
