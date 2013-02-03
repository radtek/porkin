package name.huangzhoujin.mymaven.service;

import java.util.List;

import name.huangzhoujin.mymaven.persistence.domain.Repository;
import name.huangzhoujin.mymaven.persistence.domain.RepositoryExample;
import name.huangzhoujin.mymaven.persistence.sqlmapdao.CustomMapper;
import name.huangzhoujin.mymaven.persistence.sqlmapdao.RepositoryMapper;
import name.huangzhoujin.mymaven.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {

	@Autowired
	private RepositoryMapper repositoryMapper;

	@Autowired
	private CustomMapper customMapper;

	public int countAll() {
		return repositoryMapper.countByExample(null);
	}

	public boolean delete(int id) {
		int result = repositoryMapper.deleteByPrimaryKey(id);
		return result > 0;
	}

	public Repository load(int id) {
		Repository result = repositoryMapper
				.selectByPrimaryKey(new Integer(id));
		return result;
	}

	public Repository loadByUnusedAndId(int id) {
		Repository result = null;
		RepositoryExample example = new RepositoryExample();
		example.createCriteria().andRepIdEqualTo(id)
				.andUsedFlagEqualTo(Constants.USED_FLAG_NO);
		List<Repository> list = repositoryMapper.selectByExample(example);
		if (list != null & list.size() > 0) {
			result = list.get(0);
		}
		return result;
	}

	public boolean create(Repository record) {
		boolean result = false;
		int count = 0;
		String url = record.getRepUrl();
		RepositoryExample example = new RepositoryExample();
		example.createCriteria().andRepUrlEqualTo(url);
		count = repositoryMapper.countByExample(example);
		// count = customMapper.countByRepURL(url).intValue();
		if (count > 0) {
			result = false;
		} else {
			record.setUsedFlag(Constants.USED_FLAG_NO);
			result = repositoryMapper.insert(record) > 0;
		}
		return result;
	}

	public boolean create(String url) {
		Repository record = new Repository();
		record.setRepUrl(url);
		return create(record);
	}

	public boolean update(Repository record) {
		int result = repositoryMapper.updateByPrimaryKey(record);
		return result > 0;
	}

	public boolean resetRepositoryByRange(int from, int to) {
		Repository record = new Repository();
		record.setUsedFlag(Constants.USED_FLAG_NO);
		RepositoryExample example = new RepositoryExample();
		example.createCriteria().andRepIdGreaterThanOrEqualTo(from)
				.andRepIdLessThanOrEqualTo(to);
		int result = repositoryMapper.updateByExampleSelective(record, example);
		return result > 0;
	}

	public List<Repository> loadRepositoryByRange(int from, int to) {
		RepositoryExample example = new RepositoryExample();
		example.createCriteria().andRepIdGreaterThanOrEqualTo(from)
				.andRepIdLessThanOrEqualTo(to);
		return repositoryMapper.selectByExample(example);
	}
	
	public boolean existedRepository(String url){
		RepositoryExample example = new RepositoryExample();
		example.createCriteria().andRepUrlLike("%"+url+"%");
		return repositoryMapper.countByExample(example)>0;
	}
	
	public void clearRepository(){
		RepositoryExample example = null;
		repositoryMapper.deleteByExample(example);
	}

}
