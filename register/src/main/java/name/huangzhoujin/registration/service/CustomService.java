package name.huangzhoujin.registration.service;

import java.util.HashMap;
import java.util.List;

import name.huangzhoujin.registration.persistence.dto.CustomDto;
import name.huangzhoujin.registration.persistence.sqlmapdao.CustomMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

	@Autowired
	private CustomMapper customMapper;

	@SuppressWarnings("rawtypes")
	public Long countByCondition(HashMap param) {
		return customMapper.countByCondition(param);
	}

	@SuppressWarnings("rawtypes")
	public List<CustomDto> listByCondition(HashMap param) {
		return customMapper.listByCondition(param);
	}
	
	public CustomDto getByRegistrationId(int id){
		return customMapper.getByRegistrationId(id);
	}

}
