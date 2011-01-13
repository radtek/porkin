package net.cominfo.digiagent.persistence.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.sqlmapdao.SortableDAOImpl;

import org.springframework.stereotype.Repository;

@Repository
public class SortableDao extends SortableDAOImpl {

	public void batchDelete(List<Integer> sortableIds) {
		getSqlMapClientTemplate().delete(
				"t_da_sortable_Custom.batchdeleteByPrimaryKey", sortableIds);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getAllChildId(Integer rootId) {
		Map parameterMap = new HashMap();
		parameterMap.put("IN_ID", rootId);
		parameterMap.put("OUT_IDS", null);
		getSqlMapClientTemplate().insert(
				"t_da_sortable_Custom.getSortableChildIds", parameterMap);
		String outputStr = (String) parameterMap.get("OUT_IDS");

		List<Integer> result = new ArrayList<Integer>();
		if (outputStr != null & outputStr.trim().length() > 0) {
			String[] ouputStrList = outputStr.split(",");
			Integer temp = null;
			for (String str : ouputStrList) {
				temp = Integer.valueOf(str);
				result.add(temp);
			}
		}
		return result;
	}

	public void cleanAll() {
		getSqlMapClientTemplate().delete(
				"t_da_sortable_Custom.cleanSortableTable");
	}

}
