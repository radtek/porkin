package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.History;
import net.cominfo.digiagent.persistence.domain.HistoryCriteria;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class HistoryDAOImpl extends BaseDao implements HistoryDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public HistoryDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int countByExample(HistoryCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_history.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int deleteByExample(HistoryCriteria example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_history.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int deleteByPrimaryKey(Integer historyId) {
		History key = new History();
		key.setHistoryId(historyId);
		int rows = getSqlMapClientTemplate().delete(
				"t_da_history.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void insert(History record) {
		getSqlMapClientTemplate().insert("t_da_history.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void insertSelective(History record) {
		getSqlMapClientTemplate().insert(
				"t_da_history.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	@SuppressWarnings("unchecked")
	public List<History> selectByExample(HistoryCriteria example) {
		List<History> list = getSqlMapClientTemplate().queryForList(
				"t_da_history.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public History selectByPrimaryKey(Integer historyId) {
		History key = new History();
		key.setHistoryId(historyId);
		History record = (History) getSqlMapClientTemplate().queryForObject(
				"t_da_history.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByExampleSelective(History record, HistoryCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_history.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByExample(History record, HistoryCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_history.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByPrimaryKeySelective(History record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_history.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByPrimaryKey(History record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_history.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private static class UpdateByExampleParms extends HistoryCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, HistoryCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}