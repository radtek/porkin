package name.huangzhoujin.registration.service;

import java.util.HashMap;

import name.huangzhoujin.registration.persistence.sqlmapdao.CustomMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {
	
	@Autowired
	private CustomMapper customMapper;
	
	@SuppressWarnings("rawtypes")
	public int countByCondition(HashMap param){
		return customMapper.countByCondition(param);
	}

}
