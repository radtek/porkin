package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.BrandCriteria;

public interface BrandDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	int countByExample(BrandCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	int deleteByExample(BrandCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	int deleteByPrimaryKey(Integer brandId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	void insert(Brand record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	void insertSelective(Brand record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	List<Brand> selectByExample(BrandCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	Brand selectByPrimaryKey(Integer brandId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	int updateByExampleSelective(Brand record, BrandCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	int updateByExample(Brand record, BrandCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	int updateByPrimaryKeySelective(Brand record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	int updateByPrimaryKey(Brand record);
}