package net.cominfo.digiagent.service;

import java.util.List;

import net.cominfo.digiagent.persistence.dao.UserRoleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	@SuppressWarnings("unchecked")
	public List<String> getRoleIdListByUserName(String userName) {
		List<String> list = (List<String>) userRoleDao
				.getSqlMapClientTemplate().queryForList(
						"t_da_userrole_Custom.getRoleIdListByUsername",
						userName);
		return list;

	}
}
