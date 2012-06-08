package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Location;
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
	
	public List<Location> getAll(){
		return locationMapper.selectByExample(null);
	}
}
