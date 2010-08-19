package net.cominfo.digiagent.persistence.dao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.CityDAOImpl;

import org.springframework.stereotype.Repository;
 
@Repository
public class CityDao extends CityDAOImpl {

	@SuppressWarnings("unchecked")
	public List<Map> findByCondition(final Map condition) {
		return getSqlMapClientTemplate().queryForList("t_da_city_Custom.listByCondition", condition);
	}
	
}