package net.cominfo.digiagent.spring.security;

import java.util.ArrayList;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.RoleDao;
import net.cominfo.digiagent.persistence.dao.UserDao;
import net.cominfo.digiagent.persistence.dao.UserRoleDao;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.persistence.domain.UserCriteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class SecurityService implements UserDetailsService {

	private static Logger log = LoggerFactory.getLogger(SecurityService.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserRoleDao userRoleDao;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		if (username == null) {
			log.error("username is null");
		}
		if (userDao == null) {
			log.error("userDao is null");
		}

		UserCriteria example = new UserCriteria();
		example.createCriteria().andUserNameEqualTo(username).andActiveFlagEqualTo("Y");
		List<User> userList = userDao.selectByExample(example);
		// 判断用户存在，如果不存在，则抛出异常。
		if (userList == null) {
			log.error(username + " is not exist",
					new UsernameNotFoundException(username + " is not exist"));
		}
		
		User user = userList.get(0);
		
		 List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
		 log.info("Rolel information of "+ username);
		 List<String> roleList = userRoleDao.getRoleNameList(username);
		 
		return null;
	}

}
