package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Education;
import name.huangzhoujin.registration.persistence.sqlmapdao.EducationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

	@Autowired
	private EducationMapper educationMapper;

	public int countAllEducation() {
		return educationMapper.countByExample(null);
	}
	
	public List<Education> getAll(){
		return educationMapper.selectByExample(null);
	}
}
