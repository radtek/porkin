package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.UserDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class UserDao extends UserDAOImpl {

	@SuppressWarnings("unchecked")
	public List<Map> findByCondition(final Map condition) {
		return getSqlMapClientTemplate().queryForList("t_da_user_Custom.listByCondition", condition);
	}
	
	@SuppressWarnings("unchecked")
	public Map getUserInfo(final Map condition) {
		return (Map)getSqlMapClientTemplate().queryForObject("t_da_user_Custom.getUserInfo", condition);
	}
	
}