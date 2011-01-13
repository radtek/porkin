package net.cominfo.digiagent.persistence.dao;

import java.util.HashMap;
import java.util.List;

import net.cominfo.digiagent.persistence.sqlmapdao.HistoryDAOImpl;

import org.springframework.stereotype.Repository;

@Repository
public class HistoryDao extends HistoryDAOImpl {
	
	@SuppressWarnings("unchecked")
	public List<HashMap> countSupplierAccessByDays(Integer days){
		return (List<HashMap>)getSqlMapClientTemplate().queryForList("t_da_history_Custom.supplierReportByDays",days);
	}
}
