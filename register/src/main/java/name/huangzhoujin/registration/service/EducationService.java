package name.huangzhoujin.registration.service;

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
}
