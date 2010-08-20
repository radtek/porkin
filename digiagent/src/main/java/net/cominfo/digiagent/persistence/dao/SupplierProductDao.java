package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.SupplierProductDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class SupplierProductDao extends SupplierProductDAOImpl {

	@SuppressWarnings("unchecked")
	public List<Map> getProductListByCondition(final List condition) {
		return getSqlMapClientTemplate().queryForList("t_da_supplierproduct_Custom.getProductListByCondition", condition);
	}
	
}