package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.sqlmapdao.AreaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	public int countAllArea() {
		return areaMapper.countByExample(null);
	}
	
	public List<Area> getAll(){
		return areaMapper.selectByExample(null);
	}
}
