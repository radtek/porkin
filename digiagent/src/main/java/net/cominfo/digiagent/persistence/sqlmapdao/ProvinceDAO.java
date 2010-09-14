package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Province;
import net.cominfo.digiagent.persistence.domain.ProvinceCriteria;

public interface ProvinceDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	int countByExample(ProvinceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	int deleteByExample(ProvinceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	int deleteByPrimaryKey(Integer provinceId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	void insert(Province record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	void insertSelective(Province record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	List<Province> selectByExample(ProvinceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	Province selectByPrimaryKey(Integer provinceId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	int updateByExampleSelective(Province record, ProvinceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	int updateByExample(Province record, ProvinceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	int updateByPrimaryKeySelective(Province record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_province
	 * @ibatorgenerated  Tue Sep 14 18:50:40 CST 2010
	 */
	int updateByPrimaryKey(Province record);
}