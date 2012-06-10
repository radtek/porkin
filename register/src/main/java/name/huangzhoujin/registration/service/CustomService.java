package name.huangzhoujin.registration.service;

import java.util.List;
import java.util.Map;

import name.huangzhoujin.registration.persistence.dto.CustomDto;
import name.huangzhoujin.registration.persistence.sqlmapdao.CustomMapper;
import name.huangzhoujin.registration.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

	@Autowired
	private CustomMapper customMapper;

	public int countByCondition(Map<String, Object> param) {
		Page<CustomDto> page = new Page<CustomDto>();
		page.setParam(param);
		return customMapper.countByCondition(page);
	}

	public List<CustomDto> listByCondition(int pageNo, int pageSize,
			Map<String, Object> param) {
		Page<CustomDto> page = new Page<CustomDto>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setParam(param);
		return customMapper.listByCondition(page);
	}

}
