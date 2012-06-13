package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.User;
import name.huangzhoujin.registration.persistence.domain.UserCriteria;
import name.huangzhoujin.registration.persistence.sqlmapdao.UserMapper;
import name.huangzhoujin.registration.utils.SystemConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public int countAlluser() {
		return userMapper.countByExample(null);
	}

	public List<User> getAll() {
		UserCriteria criteria = new UserCriteria();
		criteria.setOrderByClause("User_ID");
		return userMapper.selectByExample(criteria);
	}

	public boolean delete(int id) {
		int result = userMapper.deleteByPrimaryKey(id);
		return result > 0;
	}

	public boolean save(User record) {
		int result = userMapper.updateByPrimaryKey(record);
		return result > 0;
	}

	public boolean create(User record) {
		int result = userMapper.insertSelective(record);
		return result > 0;
	}

	public User getById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public List<User> getByPage(int first, int pageSize) {
		UserCriteria criteria = new UserCriteria();
		criteria.setFirst(first);
		criteria.setPageSize(pageSize);
		criteria.setOrderByClause("User_ID");
		return userMapper.selectByExample(criteria);
	}

	public User login(String username, String password) {
		UserCriteria criteria = new UserCriteria();
		criteria.createCriteria().andActiveEqualTo(SystemConstants.ActiveFlag)
				.andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(criteria);
		User result = null;
		if(userList!=null && userList.size()>0){
			result = userList.get(0);
		}
		return result;
	}
	
	public boolean existedUser(String username){
		UserCriteria criteria = new UserCriteria();
		criteria.createCriteria().andActiveEqualTo(SystemConstants.ActiveFlag)
				.andUsernameEqualTo(username);
		List<User> userList = userMapper.selectByExample(criteria);
		boolean result = false;
		if(userList!=null && userList.size()>0){
			result = true;
		}
		return result;
	}

}
