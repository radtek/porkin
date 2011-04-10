package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CommodityDAOImpl extends BaseDao implements CommodityDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public CommodityDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int countByExample(CommodityCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_commodity.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int deleteByExample(CommodityCriteria example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_commodity.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int deleteByPrimaryKey(Integer commodityId) {
		Commodity key = new Commodity();
		key.setCommodityId(commodityId);
		int rows = getSqlMapClientTemplate().delete(
				"t_da_commodity.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void insert(Commodity record) {
		getSqlMapClientTemplate().insert(
				"t_da_commodity.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void insertSelective(Commodity record) {
		getSqlMapClientTemplate().insert(
				"t_da_commodity.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	@SuppressWarnings("unchecked")
	public List<Commodity> selectByExample(CommodityCriteria example) {
		List<Commodity> list = getSqlMapClientTemplate().queryForList(
				"t_da_commodity.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public Commodity selectByPrimaryKey(Integer commodityId) {
		Commodity key = new Commodity();
		key.setCommodityId(commodityId);
		Commodity record = (Commodity) getSqlMapClientTemplate()
				.queryForObject(
						"t_da_commodity.ibatorgenerated_selectByPrimaryKey",
						key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByExampleSelective(Commodity record,
			CommodityCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_commodity.ibatorgenerated_updateByExampleSelective",
				parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByExample(Commodity record, CommodityCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_commodity.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByPrimaryKeySelective(Commodity record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_commodity.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByPrimaryKey(Commodity record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_commodity.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private static class UpdateByExampleParms extends CommodityCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, CommodityCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}