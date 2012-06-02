package name.huangzhoujin.registration.service;

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

}
