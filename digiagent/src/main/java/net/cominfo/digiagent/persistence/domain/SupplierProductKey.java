package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;

public class SupplierProductKey implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplierproduct.PRODUCTBRAND_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private Integer productbrandId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplierproduct.SUPPLIER_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private Integer supplierId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplierproduct.PRODUCTBRAND_ID
	 * @return  the value of t_da_supplierproduct.PRODUCTBRAND_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public Integer getProductbrandId() {
		return productbrandId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplierproduct.PRODUCTBRAND_ID
	 * @param productbrandId  the value for t_da_supplierproduct.PRODUCTBRAND_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setProductbrandId(Integer productbrandId) {
		this.productbrandId = productbrandId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplierproduct.SUPPLIER_ID
	 * @return  the value of t_da_supplierproduct.SUPPLIER_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public Integer getSupplierId() {
		return supplierId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplierproduct.SUPPLIER_ID
	 * @param supplierId  the value for t_da_supplierproduct.SUPPLIER_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof SupplierProductKey)) {
			return false;
		}
		SupplierProductKey other = (SupplierProductKey) that;
		return this.getProductbrandId() == null ? other == null : this
				.getProductbrandId().equals(other.getProductbrandId())
				&& this.getSupplierId() == null ? other == null : this
				.getSupplierId().equals(other.getSupplierId());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplierproduct
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getProductbrandId() != null) {
			hash *= getProductbrandId().hashCode();
		}
		if (getSupplierId() != null) {
			hash *= getSupplierId().hashCode();
		}
		return hash;
	}
}