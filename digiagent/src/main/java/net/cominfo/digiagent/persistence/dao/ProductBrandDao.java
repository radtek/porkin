package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.ProductBrandDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class ProductBrandDao extends ProductBrandDAOImpl {

	@SuppressWarnings("unchecked")
	public List<Map> findByCondition(final Map condition) {
		return getSqlMapClientTemplate().queryForList("t_da_productbrand_Custom.listByCondition", condition);
	}
	
}