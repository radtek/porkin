package name.huangzhoujin.registration.utils;

public class StringUtil {
	
	public static final String STRING_BLANK = "";
	public static final String STRING_ZERO = "0";
	
	public static String toNull(String s){
		String result = null;
		if(s!=null){
			result = s.trim();
			if(result.equals(STRING_BLANK) || result.equals(STRING_ZERO) ){
				result = null;
			}
		}
		return result;
	}
	
	public static Integer strToIngeger(String s){
		Integer result = null;
		if(s==null || s.trim().equals(STRING_BLANK)){
			result = null;
		}
		else{
			result = Integer.parseInt(s);
		}
		return result;
	}

}
