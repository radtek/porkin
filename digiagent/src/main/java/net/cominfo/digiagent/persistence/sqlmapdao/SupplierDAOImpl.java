package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierCriteria;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class SupplierDAOImpl extends BaseDao implements SupplierDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public SupplierDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public int countByExample(SupplierCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_supplier.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public int deleteByExample(SupplierCriteria example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_supplier.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public int deleteByPrimaryKey(Integer supplierId) {
		Supplier key = new Supplier();
		key.setSupplierId(supplierId);
		int rows = getSqlMapClientTemplate().delete(
				"t_da_supplier.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void insert(Supplier record) {
		getSqlMapClientTemplate().insert(
				"t_da_supplier.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void insertSelective(Supplier record) {
		getSqlMapClientTemplate().insert(
				"t_da_supplier.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<Supplier> selectByExample(SupplierCriteria example) {
		List<Supplier> list = getSqlMapClientTemplate().queryForList(
				"t_da_supplier.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public Supplier selectByPrimaryKey(Integer supplierId) {
		Supplier key = new Supplier();
		key.setSupplierId(supplierId);
		Supplier record = (Supplier) getSqlMapClientTemplate().queryForObject(
				"t_da_supplier.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public int updateByExampleSelective(Supplier record,
			SupplierCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate()
				.update(
						"t_da_supplier.ibatorgenerated_updateByExampleSelective",
						parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public int updateByExample(Supplier record, SupplierCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_supplier.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public int updateByPrimaryKeySelective(Supplier record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_supplier.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public int updateByPrimaryKey(Supplier record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_supplier.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private static class UpdateByExampleParms extends SupplierCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, SupplierCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}