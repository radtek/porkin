package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.ProductBrandCriteria;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ProductBrandDAOImpl extends BaseDao implements ProductBrandDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public ProductBrandDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int countByExample(ProductBrandCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_productbrand.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int deleteByExample(ProductBrandCriteria example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_productbrand.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int deleteByPrimaryKey(Integer productbrandId) {
		ProductBrand key = new ProductBrand();
		key.setProductbrandId(productbrandId);
		int rows = getSqlMapClientTemplate().delete(
				"t_da_productbrand.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void insert(ProductBrand record) {
		getSqlMapClientTemplate().insert(
				"t_da_productbrand.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void insertSelective(ProductBrand record) {
		getSqlMapClientTemplate().insert(
				"t_da_productbrand.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	@SuppressWarnings("unchecked")
	public List<ProductBrand> selectByExample(ProductBrandCriteria example) {
		List<ProductBrand> list = getSqlMapClientTemplate().queryForList(
				"t_da_productbrand.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public ProductBrand selectByPrimaryKey(Integer productbrandId) {
		ProductBrand key = new ProductBrand();
		key.setProductbrandId(productbrandId);
		ProductBrand record = (ProductBrand) getSqlMapClientTemplate()
				.queryForObject(
						"t_da_productbrand.ibatorgenerated_selectByPrimaryKey",
						key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByExampleSelective(ProductBrand record,
			ProductBrandCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_productbrand.ibatorgenerated_updateByExampleSelective",
				parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByExample(ProductBrand record, ProductBrandCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_productbrand.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByPrimaryKeySelective(ProductBrand record) {
		int rows = getSqlMapClientTemplate()
				.update(
						"t_da_productbrand.ibatorgenerated_updateByPrimaryKeySelective",
						record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public int updateByPrimaryKey(ProductBrand record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_productbrand.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_productbrand
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private static class UpdateByExampleParms extends ProductBrandCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, ProductBrandCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}