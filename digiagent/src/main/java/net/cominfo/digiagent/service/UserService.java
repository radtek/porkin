package net.cominfo.digiagent.service;

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
import net.cominfo.digiagent.persistence.domain.UserRole;
import net.cominfo.digiagent.persistence.domain.UserRoleCriteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserRoleDao userRoleDao;

	public int countUser() {
		return userDao.countByExample(new UserCriteria());
	}
	
	public User getById(Integer id){
		return userDao.selectByPrimaryKey(id);
	}
	

	@SuppressWarnings("unchecked")
	public Map getUserInfo(Map condition){
		return userDao.getUserInfo(condition);
	}
	
	public String getRoleList() {
		RoleCriteria example = new RoleCriteria();
		net.cominfo.digiagent.persistence.domain.RoleCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		example.setOrderByClause("ROLE_NAME");
		List<Role> roleList = roleDao.selectByExample(example);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		for (Role role : roleList) {
			buffer.append("<option value='");
			buffer.append(role.getRoleId());
			buffer.append("'>");
			buffer.append(role.getRoleName());
			buffer.append("</option>");
		}
		return buffer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<User> page = new Page<User>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("USER_NAME");
		page.setOrder("ASC");
		page.setParam(param);
		return (List<User>) userDao.findPage(page, "t_da_user_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<User> page = new Page<User>();
		page.setParam(param);
		return userDao.count(page, "t_da_user_Custom.countByCondition");
	}
	
	public User insert(User user, UserRole userRole) {
		user.setCreatedBy("sj");
		user.setCreatedDate(new Date());
		user.setLastupdatedBy("sj");
		user.setLastupdatedDate(new Date());
		user.setLastlogintime(new Date());
		user.setRegistertime(new Date());
		user.setLogonsum(0);
		user.setActiveFlag("Y");
		userDao.insert(user);		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", user.getUserName());
		
		if (user.getUserId() != null) {
			userRole.setUserId(user.getUserId());
			userRoleDao.insert(userRole);
			return user;
		} else {
			return user;
		}
	}
	
	public User update(User user, UserRole userRole) {
		user = validateUserName(user);
		if (user.getUserId() == -1) {
			return user;
		} else {
			user.setLastupdatedBy("sj");
			user.setLastupdatedDate(new Date());
			userDao.updateByPrimaryKey(user);
			UserRoleCriteria example = new UserRoleCriteria();
			net.cominfo.digiagent.persistence.domain.UserRoleCriteria.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userRole.getUserId());
			userRoleDao.updateByExample(userRole, example);
			return user;
		}
	}
	
	public String delete(Integer id){
		// 是否有用户角色关联
//		if (isReferenceRoleUser(id)) {
			UserRoleCriteria example = new UserRoleCriteria();
			net.cominfo.digiagent.persistence.domain.UserRoleCriteria.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(id);
			userRoleDao.deleteByExample(example);
//			return "reference";
//		} 
		userDao.deleteByPrimaryKey(id);
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	private User validateUserName(User user) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", user.getUserName());
		if (user.getUserId() != null) {
			paramMap.put("userId",user.getUserId());
		}
		List<Map> list = userDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			user.setUserId(-1);
			return user;
		} else {
			return user;
		}
	}
	
	
	@SuppressWarnings("unused")
	private boolean isReferenceRoleUser(Integer userId) {
		UserRoleCriteria example = new UserRoleCriteria();
		net.cominfo.digiagent.persistence.domain.UserRoleCriteria.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserRole> list = userRoleDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
