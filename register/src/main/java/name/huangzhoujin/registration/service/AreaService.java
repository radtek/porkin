package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.domain.AreaCriteria;
import name.huangzhoujin.registration.persistence.domain.RegistrationCriteria;
import name.huangzhoujin.registration.persistence.sqlmapdao.AreaMapper;
import name.huangzhoujin.registration.persistence.sqlmapdao.RegistrationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private RegistrationMapper registrationMapper;

	public int countAllArea() {
		return areaMapper.countByExample(null);
	}

	public List<Area> getAll() {
		AreaCriteria criteria = new AreaCriteria();
		criteria.setOrderByClause("AREA_ID");
		return areaMapper.selectByExample(criteria);
	}

	public boolean delete(int id) {
		RegistrationCriteria criteria = new RegistrationCriteria();
		criteria.createCriteria().andAreaIdEqualTo(id);
		registrationMapper.deleteByExample(criteria);
		int result = areaMapper.deleteByPrimaryKey(id);
		return result > 0;
	}

	public boolean save(Area record) {
		int result = areaMapper.updateByPrimaryKey(record);
		return result > 0;
	}

	public boolean create(Area record) {
		int result = areaMapper.insertSelective(record);
		return result > 0;
	}
	
	public Area getById(int id){
		return areaMapper.selectByPrimaryKey(id);
	}
	
	public List<Area> getByPage(int first,int pageSize) {
		AreaCriteria criteria = new AreaCriteria();
		criteria.setFirst(first);
		criteria.setPageSize(pageSize);
		criteria.setOrderByClause("AREA_ID");
		return areaMapper.selectByExample(criteria);
	}
}
