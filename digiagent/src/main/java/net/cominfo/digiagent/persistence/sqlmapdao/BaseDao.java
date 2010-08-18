package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao extends SqlMapClientDaoSupport {
	
	@Autowired
	public void setSqlMapClientBase(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
	
	@SuppressWarnings("unchecked")
	public Page<?> findPage(final Page<?> page, String sqlKey) {	
		List result = getSqlMapClientTemplate().queryForList(sqlKey, page);
		page.setTotalCount(result.size());
		page.setResult(result);
		return page;
	}
	
	@SuppressWarnings("unchecked")
	public Long count(final Page<?> page, String sqlKey) {	
		Map result = (Map)getSqlMapClientTemplate().queryForObject(sqlKey, page);
		return (Long)result.get("total");
	}
	
}
