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

	public int countAllPermission() {
		return userMapper.countByExample(null);
	}

	public List<User> getAll() {
		UserCriteria criteria = new UserCriteria();
		criteria.setOrderByClause("USER_ID");
		return userMapper.selectByExample(criteria);
	}

	public User login(String username, String password) {
		User result = null;
		UserCriteria criteria = new UserCriteria();
		criteria.createCriteria().andUsernameEqualTo(username)
				.andPasswordEqualTo(password)
				.andActiveEqualTo(SystemConstants.ActiveFlag);
		List<User> list = userMapper.selectByExample(criteria);
		if (list != null && list.size() > 0) {
			result = list.get(0);
		}
		return result;
	}

}
