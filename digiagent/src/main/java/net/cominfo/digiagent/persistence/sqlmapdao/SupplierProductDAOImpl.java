package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.SupplierProductCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierProductKey;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class SupplierProductDAOImpl extends BaseDao implements SupplierProductDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public SupplierProductDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public int countByExample(SupplierProductCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_supplierproduct.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public int deleteByExample(SupplierProductCriteria example) {
		int rows = getSqlMapClientTemplate()
				.delete("t_da_supplierproduct.ibatorgenerated_deleteByExample",
						example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public int deleteByPrimaryKey(SupplierProductKey key) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_supplierproduct.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public void insert(SupplierProductKey record) {
		getSqlMapClientTemplate().insert(
				"t_da_supplierproduct.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public void insertSelective(SupplierProductKey record) {
		getSqlMapClientTemplate().insert(
				"t_da_supplierproduct.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<SupplierProductKey> selectByExample(
			SupplierProductCriteria example) {
		List<SupplierProductKey> list = getSqlMapClientTemplate()
				.queryForList(
						"t_da_supplierproduct.ibatorgenerated_selectByExample",
						example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public int updateByExampleSelective(SupplierProductKey record,
			SupplierProductCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate()
				.update(
						"t_da_supplierproduct.ibatorgenerated_updateByExampleSelective",
						parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	public int updateByExample(SupplierProductKey record,
			SupplierProductCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_supplierproduct.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	private static class UpdateByExampleParms extends SupplierProductCriteria {
		private Object record;

		public UpdateByExampleParms(Object record,
				SupplierProductCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}