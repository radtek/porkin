package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.City;
import net.cominfo.digiagent.persistence.domain.CityCriteria;

public class CityDAOImpl extends BaseDao implements CityDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public CityDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public int countByExample(CityCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_city.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public int deleteByExample(CityCriteria example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_city.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public int deleteByPrimaryKey(Integer cityId) {
		City key = new City();
		key.setCityId(cityId);
		int rows = getSqlMapClientTemplate().delete(
				"t_da_city.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void insert(City record) {
		getSqlMapClientTemplate().insert("t_da_city.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void insertSelective(City record) {
		getSqlMapClientTemplate().insert(
				"t_da_city.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<City> selectByExample(CityCriteria example) {
		List<City> list = getSqlMapClientTemplate().queryForList(
				"t_da_city.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public City selectByPrimaryKey(Integer cityId) {
		City key = new City();
		key.setCityId(cityId);
		City record = (City) getSqlMapClientTemplate().queryForObject(
				"t_da_city.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public int updateByExampleSelective(City record, CityCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_city.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public int updateByExample(City record, CityCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_city.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public int updateByPrimaryKeySelective(City record) {
		int rows = getSqlMapClientTemplate()
				.update(
						"t_da_city.ibatorgenerated_updateByPrimaryKeySelective",
						record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public int updateByPrimaryKey(City record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_city.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_city
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private static class UpdateByExampleParms extends CityCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, CityCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}