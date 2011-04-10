package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria;

public interface CommodityDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	int countByExample(CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	int deleteByExample(CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	int deleteByPrimaryKey(Integer commodityId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	void insert(Commodity record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	void insertSelective(Commodity record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	List<Commodity> selectByExample(CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	Commodity selectByPrimaryKey(Integer commodityId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	int updateByExampleSelective(Commodity record, CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	int updateByExample(Commodity record, CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	int updateByPrimaryKeySelective(Commodity record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	int updateByPrimaryKey(Commodity record);
}