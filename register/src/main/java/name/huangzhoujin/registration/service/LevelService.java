package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.persistence.domain.LevelCriteria;
import name.huangzhoujin.registration.persistence.sqlmapdao.LevelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {

	@Autowired
	private LevelMapper levelMapper;

	public int countAllLevel() {
		return levelMapper.countByExample(null);
	}
	
	public List<Level> getAll(){
		LevelCriteria criteria = new LevelCriteria();
		criteria.setOrderByClause("Level_ID");
		return levelMapper.selectByExample(criteria);
	}
}