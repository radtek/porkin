package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.SupplierDao;
import net.cominfo.digiagent.persistence.dao.UserDao;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SupplierDao supplierDao;

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
	
	public SupplierWithBLOBs getCompanyByUserId(Integer userId){
		SupplierWithBLOBs result = null;
		SupplierCriteria supplierCriteria = new SupplierCriteria();
		supplierCriteria.createCriteria().andUserIdEqualTo(userId);
		List<SupplierWithBLOBs> supplirList = supplierDao.selectByExampleWithBLOBs(supplierCriteria);
		if(supplirList!=null && supplirList.size()>0){
			result = supplirList.get(0);
		}
		return result;
	}
	
	public void updateSupplier(SupplierWithBLOBs supplier){
		supplierDao.updateByPrimaryKey(supplier);
	}
		

}
