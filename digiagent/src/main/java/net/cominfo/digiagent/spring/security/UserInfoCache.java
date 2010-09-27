package net.cominfo.digiagent.spring.security;

import java.util.HashMap;
import java.util.List;

public class UserInfoCache {
	
	public static HashMap<String, List<UserInfo>> sessionMap = new HashMap<String, List<UserInfo>>();
	
	static {
		if (null == sessionMap) {
			sessionMap = new HashMap<String, List<UserInfo>>();
		}
	}

}
