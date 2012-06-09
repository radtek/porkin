package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Education;
import name.huangzhoujin.registration.persistence.domain.EducationCriteria;
import name.huangzhoujin.registration.persistence.sqlmapdao.EducationMapper;
import name.huangzhoujin.registration.utils.SimpleCache;
import name.huangzhoujin.registration.utils.SystemConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

	@Autowired
	private EducationMapper educationMapper;

	public int countAllEducation() {
		return educationMapper.countByExample(null);
	}
	
	@SuppressWarnings("unchecked")
	public List<Education> getAll(){
		List<Education> result = (List<Education>) SimpleCache.load(SystemConstants.EducationCache);
		if(result==null || result.size()==0){
			EducationCriteria criteria = new EducationCriteria();
			criteria.setOrderByClause("Education_Id");
			result = educationMapper.selectByExample(criteria);
			SimpleCache.refresh(SystemConstants.EducationCache, result);
		}
		return result;
	}
	
}
