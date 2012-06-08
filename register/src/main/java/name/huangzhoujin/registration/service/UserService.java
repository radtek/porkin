package name.huangzhoujin.registration.service;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.User;
import name.huangzhoujin.registration.persistence.sqlmapdao.UserMapper;

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
		return userMapper.selectByExample(null);
	}

}
