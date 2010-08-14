package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.persistence.domain.CountryCriteria;

public interface CountryDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int countByExample(CountryCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int deleteByExample(CountryCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int deleteByPrimaryKey(Integer countryId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	void insert(Country record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	void insertSelective(Country record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	List<Country> selectByExample(CountryCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	Country selectByPrimaryKey(Integer countryId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByExampleSelective(Country record, CountryCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByExample(Country record, CountryCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByPrimaryKeySelective(Country record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByPrimaryKey(Country record);
}