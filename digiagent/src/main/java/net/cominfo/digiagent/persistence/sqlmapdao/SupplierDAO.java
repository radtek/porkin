package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierCriteria;

public interface SupplierDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int countByExample(SupplierCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int deleteByExample(SupplierCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int deleteByPrimaryKey(Integer supplierId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	void insert(Supplier record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	void insertSelective(Supplier record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	List<Supplier> selectByExample(SupplierCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	Supplier selectByPrimaryKey(Integer supplierId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByExampleSelective(Supplier record, SupplierCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByExample(Supplier record, SupplierCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByPrimaryKeySelective(Supplier record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	int updateByPrimaryKey(Supplier record);
}