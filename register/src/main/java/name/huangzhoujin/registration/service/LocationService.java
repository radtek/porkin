package name.huangzhoujin.registration.service;

import name.huangzhoujin.registration.persistence.sqlmapdao.LocationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private LocationMapper locationMapper;
	
	public int countAllLocation() {
		return locationMapper.countByExample(null);
	}
}
