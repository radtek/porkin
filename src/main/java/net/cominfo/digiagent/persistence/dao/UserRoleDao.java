package net.cominfo.digiagent.persistence.dao;

import java.util.List;

import net.cominfo.digiagent.persistence.sqlmapdao.UserRoleDAOImpl;

import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDao extends UserRoleDAOImpl {

	@SuppressWarnings("unchecked")
	public List<String> getRoleNameList(String name) {
		return (List<String>) getSqlMapClientTemplate().queryForList(
				"t_da_userrole_Custom.getRoleInfoByUsername");
	}
}
