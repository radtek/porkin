package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Location;
import name.huangzhoujin.registration.persistence.domain.LocationCriteria;
import name.huangzhoujin.registration.persistence.domain.RegistrationCriteria;
import name.huangzhoujin.registration.persistence.sqlmapdao.LocationMapper;
import name.huangzhoujin.registration.persistence.sqlmapdao.RegistrationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private LocationMapper locationMapper;

	@Autowired
	private RegistrationMapper registrationMapper;

	public int countAllLocation() {
		return locationMapper.countByExample(null);
	}

	public List<Location> getAll() {
		LocationCriteria criteria = new LocationCriteria();
		criteria.setOrderByClause("Location_ID");
		return locationMapper.selectByExample(criteria);
	}

	public boolean delete(int id) {
		RegistrationCriteria criteria = new RegistrationCriteria();
		criteria.createCriteria().andLocationIdEqualTo(id);
		registrationMapper.deleteByExample(criteria);
		int result = locationMapper.deleteByPrimaryKey(id);
		return result > 0;
	}

	public boolean save(Location record) {
		int result = locationMapper.updateByPrimaryKey(record);
		return result > 0;
	}

	public boolean create(Location record) {
		int result = locationMapper.insertSelective(record);
		return result > 0;
	}

	public Location getById(int id) {
		return locationMapper.selectByPrimaryKey(id);
	}

	public List<Location> getByPage(int first, int pageSize) {
		LocationCriteria criteria = new LocationCriteria();
		criteria.setFirst(first);
		criteria.setPageSize(pageSize);
		criteria.setOrderByClause("Location_ID");
		return locationMapper.selectByExample(criteria);
	}

}
