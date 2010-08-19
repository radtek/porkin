package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.SupplierDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class SupplierDao extends SupplierDAOImpl {

	@SuppressWarnings("unchecked")
	public List<Map> findByCondition(final Map condition) {
		return getSqlMapClientTemplate().queryForList("t_da_supplier_Custom.listByCondition", condition);
	}
	
}