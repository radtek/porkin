package name.huangzhoujin.registration.service;

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
}
