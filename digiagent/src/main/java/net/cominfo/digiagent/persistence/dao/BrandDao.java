package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.BrandDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class BrandDao extends BrandDAOImpl {

	@SuppressWarnings("unchecked")
	public List<Map> findByCondition(final Map condition) {
		return getSqlMapClientTemplate().queryForList("t_da_brand_Custom.listByCondition", condition);
	}
	
}