package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.ProductDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class ProductDao extends ProductDAOImpl {
	@SuppressWarnings("unchecked")
	public List<Map> findByCondition(final Map condition) {
		return getSqlMapClientTemplate().queryForList("t_da_product_Custom.listByCondition", condition);
	}
}