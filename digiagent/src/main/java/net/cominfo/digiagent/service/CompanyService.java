package net.cominfo.digiagent.service;

import java.util.Date;

import net.cominfo.digiagent.persistence.dao.UserDao;
import net.cominfo.digiagent.persistence.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private UserDao userDao;

	public User getUserById(Integer userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	public boolean validateUser(Integer userId, String password) {
		boolean result = false;
		User user = userDao.selectByPrimaryKey(userId);
		result = user.getUserPassword().equals(password);
		return result;
	}
	
	public void changePassword(Integer userId, String password){
		User user = userDao.selectByPrimaryKey(userId);
		user.setUserPassword(password);
		user.setLastupdatedBy(user.getUserName());
		user.setLastupdatedDate(new Date());
		userDao.updateByPrimaryKey(user);
	}
	
	public void changeEmail(Integer userId, String email){
		User user = userDao.selectByPrimaryKey(userId);
		user.setUserEmail(email);
		user.setLastupdatedBy(user.getUserName());
		user.setLastupdatedDate(new Date());
		userDao.updateByPrimaryKey(user);
	}

}
