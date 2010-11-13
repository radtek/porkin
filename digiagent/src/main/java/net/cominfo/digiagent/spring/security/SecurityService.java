package net.cominfo.digiagent.spring.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.RoleDao;
import net.cominfo.digiagent.persistence.dao.UserDao;
import net.cominfo.digiagent.persistence.dao.UserRoleDao;
import net.cominfo.digiagent.persistence.domain.Role;
import net.cominfo.digiagent.persistence.domain.RoleCriteria;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.persistence.domain.UserCriteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 703006677
 *
 */
@Service
@Transactional
public class SecurityService {

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
		example.createCriteria().andUserNameEqualTo(username)
				.andActiveFlagEqualTo("Y");
		List<User> userList = userDao.selectByExample(example);
		// 判断用户存在，如果不存在，则抛出异常。
		if (userList == null) {
			log.error(username + " is not exist",
					new UsernameNotFoundException(username + " is not exist"));
		}

		User user = userList.get(0);

		List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
		log.info("Rolel information of " + username);
		List<String> roleList = userRoleDao.getRoleNameList(username);

		return null;
	}

	public Role getRoleByName(String roleName) {
		RoleCriteria criteria = new RoleCriteria();
		criteria.createCriteria().andRoleNameEqualTo(roleName)
				.andActiveFlagEqualTo("Y");
		List<Role> roleList = roleDao.selectByExample(criteria);
		Role result = roleList.get(0);
		return result;
	}
	
	
	/**
	 * @param userName
	 * @param userPassword
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public User login(String userName, String userPassword, String type) {
		User result = null;
//		UserCriteria criteria = new UserCriteria();
//		criteria.createCriteria().andUserNameEqualTo(userName)
//				.andUserPasswordEqualTo(userPassword);
		Map param = new HashMap();
		param.put("userName", userName);
		param.put("userPassword", userPassword);
		param.put("roleName", type);
		List<User> userList = userDao.getSqlMapClientTemplate().queryForList("t_da_user_Custom.getUser", param);
		if (userList != null & userList.size() > 0) {
			result = userList.get(0);
			int newLogonSum = result.getLogonsum()+1;
			result.setLogonsum(newLogonSum);
			result.setLastlogintime(new Date());
			userDao.updateByPrimaryKey(result);
		}
		return result;
	}
	
	public boolean isExistByName(String userName){
		return (getUserByName(userName)!=null);
	}
	
	public User getUserByName(String userName){
		User result = null;
		UserCriteria criteria = new UserCriteria();
		criteria.createCriteria().andUserNameEqualTo(userName);
		List<User> userList = userDao.selectByExample(criteria);
		if(null!=userList && userList.size()>0 ){
			result = userList.get(0);
		}
		return result;
	}
	
	public boolean isExistByEmail(String eMail){
		return (getUserByEmail(eMail)!=null);
	}
	
	private User getUserByEmail(String eMail){
		User result = null;
		UserCriteria criteria = new UserCriteria();
		criteria.createCriteria().andUserEmailEqualTo(eMail);
		List<User> userList = userDao.selectByExample(criteria);
		if(null!=userList && userList.size()>0 ){
			result = userList.get(0);
		}
		return result;
	}
	

}
