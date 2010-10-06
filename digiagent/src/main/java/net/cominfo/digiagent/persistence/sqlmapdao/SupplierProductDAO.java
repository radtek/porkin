package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.SupplierProductCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierProductKey;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;

public interface SupplierProductDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int countByExample(SupplierProductCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int deleteByExample(SupplierProductCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int deleteByPrimaryKey(SupplierProductKey key);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	void insert(SupplierProduct record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	void insertSelective(SupplierProduct record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	List<SupplierProduct> selectByExample(SupplierProductCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	SupplierProduct selectByPrimaryKey(SupplierProductKey key);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByExampleSelective(SupplierProduct record,
			SupplierProductCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByExample(SupplierProduct record, SupplierProductCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByPrimaryKeySelective(SupplierProduct record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByPrimaryKey(SupplierProduct record);
}