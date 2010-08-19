package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.ContactDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class ContactDao extends ContactDAOImpl {

	@SuppressWarnings("unchecked")
	public List<Map> findByCondition(final Map condition) {
		return getSqlMapClientTemplate().queryForList("t_da_contact_Custom.listByCondition", condition);
	}
	
}