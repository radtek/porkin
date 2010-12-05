package net.cominfo.digiagent.persistence.dao;

import org.springframework.stereotype.Repository;

import net.cominfo.digiagent.persistence.sqlmapdao.CommentsDAOImpl;

@Repository
public class CommentsDao extends CommentsDAOImpl {

	public Long sumScore(int supplierId) {
		return (Long) getSqlMapClientTemplate()
				.queryForObject("t_da_comments_Custom.sumBySupplierID",
						new Integer(supplierId));
	}

}
