package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.persistence.domain.LevelCriteria;
import name.huangzhoujin.registration.persistence.sqlmapdao.LevelMapper;
import name.huangzhoujin.registration.utils.SimpleCache;
import name.huangzhoujin.registration.utils.SystemConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {

	@Autowired
	private LevelMapper levelMapper;

	public int countAllLevel() {
		return levelMapper.countByExample(null);
	}
	
	@SuppressWarnings("unchecked")
	public List<Level> getAll(){
		List<Level> result = (List<Level>) SimpleCache.load(SystemConstants.LevelCache);
		if(result==null || result.size()==0){
			LevelCriteria criteria = new LevelCriteria();
			criteria.setOrderByClause("Level_ID");
			result = levelMapper.selectByExample(criteria);
			SimpleCache.refresh(SystemConstants.LevelCache, result);
		}
		return result;
	}
}
