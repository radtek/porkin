package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.domain.AreaCriteria;
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

	public List<Area> getAll() {
		AreaCriteria criteria = new AreaCriteria();
		criteria.setOrderByClause("AREA_ID");
		return areaMapper.selectByExample(criteria);
	}

	public boolean delete(int id) {
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
}
