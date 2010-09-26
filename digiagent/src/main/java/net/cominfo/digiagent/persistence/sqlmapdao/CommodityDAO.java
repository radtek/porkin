package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria;

public interface CommodityDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	int countByExample(CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	int deleteByExample(CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	int deleteByPrimaryKey(Integer commodityId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	void insert(Commodity record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	void insertSelective(Commodity record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	List<Commodity> selectByExample(CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	Commodity selectByPrimaryKey(Integer commodityId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	int updateByExampleSelective(Commodity record, CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	int updateByExample(Commodity record, CommodityCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	int updateByPrimaryKeySelective(Commodity record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	int updateByPrimaryKey(Commodity record);
}