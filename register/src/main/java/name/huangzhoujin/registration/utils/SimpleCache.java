package name.huangzhoujin.registration.utils;

import java.util.HashMap;
import java.util.Map;

public class SimpleCache {
	
	private static Map<String, Object> cache = new HashMap<String, Object>();

	public static Object Load(String name) {
		return cache.get(name);
	}

	public static void Refresh(String name, Object obj) {
		cache.put(name, obj);
	}

}
