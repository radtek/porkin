package net.cominfo.digiagent.persistence.dao;

import java.util.List;

import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.sqlmapdao.BrandDAOImpl;
import net.cominfo.digiagent.utils.Page;

import org.springframework.stereotype.Repository;
 
@Repository
public class BrandDao extends BrandDAOImpl {

	public Page<Brand> findPage(final Page<Brand> page) {	
		List result = getSqlMapClientTemplate().queryForList("t_da_brand_Custom.pagebyId", page);
		page.setTotalCount(result.size());
		page.setResult(result);
		return page;
	}
	
}