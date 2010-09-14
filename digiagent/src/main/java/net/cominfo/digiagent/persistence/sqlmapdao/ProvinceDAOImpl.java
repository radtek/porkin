package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Province;
import net.cominfo.digiagent.persistence.domain.ProvinceCriteria;

public class ProvinceDAOImpl extends BaseDao implements ProvinceDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public ProvinceDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public int countByExample(ProvinceCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_province.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public int deleteByExample(ProvinceCriteria example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_province.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public int deleteByPrimaryKey(Integer provinceId) {
		Province key = new Province();
		key.setProvinceId(provinceId);
		int rows = getSqlMapClientTemplate().delete(
				"t_da_province.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public void insert(Province record) {
		getSqlMapClientTemplate().insert(
				"t_da_province.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public void insertSelective(Province record) {
		getSqlMapClientTemplate().insert(
				"t_da_province.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<Province> selectByExample(ProvinceCriteria example) {
		List<Province> list = getSqlMapClientTemplate().queryForList(
				"t_da_province.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public Province selectByPrimaryKey(Integer provinceId) {
		Province key = new Province();
		key.setProvinceId(provinceId);
		Province record = (Province) getSqlMapClientTemplate().queryForObject(
				"t_da_province.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public int updateByExampleSelective(Province record,
			ProvinceCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate()
				.update(
						"t_da_province.ibatorgenerated_updateByExampleSelective",
						parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public int updateByExample(Province record, ProvinceCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_province.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public int updateByPrimaryKeySelective(Province record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_province.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	public int updateByPrimaryKey(Province record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_province.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	private static class UpdateByExampleParms extends ProvinceCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, ProvinceCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}