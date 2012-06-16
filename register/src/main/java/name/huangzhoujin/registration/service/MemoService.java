package name.huangzhoujin.registration.service;

import name.huangzhoujin.registration.persistence.domain.Memo;
import name.huangzhoujin.registration.persistence.sqlmapdao.MemoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoService {

	@Autowired
	private MemoMapper memoMapper;

	public Memo getById(Integer id) {
		return memoMapper.selectByPrimaryKey(id);
	}

	public boolean save(Memo memo) {
		int result = memoMapper.updateByPrimaryKey(memo);
		return result > 0;
	}
	
	public boolean create(Memo memo){
		int result = memoMapper.insertSelective(memo);
		return result>0;
	}

}
