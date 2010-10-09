package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;

public class SupplierWithBLOBs extends Supplier implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_IMAGE
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	private byte[] supplierImage;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_CERTIFY
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	private byte[] supplierCertify;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_QUALIFY
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	private byte[] supplierQualify;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_IMAGE
	 * @return  the value of t_da_supplier.SUPPLIER_IMAGE
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public byte[] getSupplierImage() {
		return supplierImage;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_IMAGE
	 * @param supplierImage  the value for t_da_supplier.SUPPLIER_IMAGE
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void setSupplierImage(byte[] supplierImage) {
		this.supplierImage = supplierImage;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_CERTIFY
	 * @return  the value of t_da_supplier.SUPPLIER_CERTIFY
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public byte[] getSupplierCertify() {
		return supplierCertify;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_CERTIFY
	 * @param supplierCertify  the value for t_da_supplier.SUPPLIER_CERTIFY
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void setSupplierCertify(byte[] supplierCertify) {
		this.supplierCertify = supplierCertify;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_QUALIFY
	 * @return  the value of t_da_supplier.SUPPLIER_QUALIFY
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public byte[] getSupplierQualify() {
		return supplierQualify;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_QUALIFY
	 * @param supplierQualify  the value for t_da_supplier.SUPPLIER_QUALIFY
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void setSupplierQualify(byte[] supplierQualify) {
		this.supplierQualify = supplierQualify;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof SupplierWithBLOBs)) {
			return false;
		}
		SupplierWithBLOBs other = (SupplierWithBLOBs) that;
		return this.getSupplierId() == null ? other == null : this
				.getSupplierId().equals(other.getSupplierId())
				&& this.getSupplierName() == null ? other == null : this
				.getSupplierName().equals(other.getSupplierName())
				&& this.getSupplierContactname() == null ? other == null : this
				.getSupplierContactname()
				.equals(other.getSupplierContactname())
				&& this.getSupplierZip() == null ? other == null : this
				.getSupplierZip().equals(other.getSupplierZip())
				&& this.getSupplierDescription() == null ? other == null : this
				.getSupplierDescription()
				.equals(other.getSupplierDescription())
				&& this.getSupplierFax() == null ? other == null : this
				.getSupplierFax().equals(other.getSupplierFax())
				&& this.getSupplierMobile() == null ? other == null : this
				.getSupplierMobile().equals(other.getSupplierMobile())
				&& this.getSupplierTelephone() == null ? other == null : this
				.getSupplierTelephone().equals(other.getSupplierTelephone())
				&& this.getSupplierAddress() == null ? other == null : this
				.getSupplierAddress().equals(other.getSupplierAddress())
				&& this.getSupplierAccess() == null ? other == null : this
				.getSupplierAccess().equals(other.getSupplierAccess())
				&& this.getSupplierScore() == null ? other == null : this
				.getSupplierScore().equals(other.getSupplierScore())
				&& this.getCityId() == null ? other == null : this.getCityId()
				.equals(other.getCityId())
				&& this.getUserId() == null ? other == null : this.getUserId()
				.equals(other.getUserId())
				&& this.getCreatedBy() == null ? other == null : this
				.getCreatedBy().equals(other.getCreatedBy())
				&& this.getCreatedDate() == null ? other == null : this
				.getCreatedDate().equals(other.getCreatedDate())
				&& this.getLastupdatedBy() == null ? other == null : this
				.getLastupdatedBy().equals(other.getLastupdatedBy())
				&& this.getLastupdatedDate() == null ? other == null : this
				.getLastupdatedDate().equals(other.getLastupdatedDate())
				&& this.getActiveFlag() == null ? other == null : this
				.getActiveFlag().equals(other.getActiveFlag())
				&& this.getSupplierImage() == null ? other == null : this
				.getSupplierImage().equals(other.getSupplierImage())
				&& this.getSupplierCertify() == null ? other == null : this
				.getSupplierCertify().equals(other.getSupplierCertify())
				&& this.getSupplierQualify() == null ? other == null : this
				.getSupplierQualify().equals(other.getSupplierQualify());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getSupplierId() != null) {
			hash *= getSupplierId().hashCode();
		}
		if (getSupplierName() != null) {
			hash *= getSupplierName().hashCode();
		}
		if (getSupplierContactname() != null) {
			hash *= getSupplierContactname().hashCode();
		}
		if (getSupplierZip() != null) {
			hash *= getSupplierZip().hashCode();
		}
		if (getSupplierDescription() != null) {
			hash *= getSupplierDescription().hashCode();
		}
		if (getSupplierFax() != null) {
			hash *= getSupplierFax().hashCode();
		}
		if (getSupplierMobile() != null) {
			hash *= getSupplierMobile().hashCode();
		}
		if (getSupplierTelephone() != null) {
			hash *= getSupplierTelephone().hashCode();
		}
		if (getSupplierAddress() != null) {
			hash *= getSupplierAddress().hashCode();
		}
		if (getSupplierAccess() != null) {
			hash *= getSupplierAccess().hashCode();
		}
		if (getSupplierScore() != null) {
			hash *= getSupplierScore().hashCode();
		}
		if (getCityId() != null) {
			hash *= getCityId().hashCode();
		}
		if (getUserId() != null) {
			hash *= getUserId().hashCode();
		}
		if (getCreatedBy() != null) {
			hash *= getCreatedBy().hashCode();
		}
		if (getCreatedDate() != null) {
			hash *= getCreatedDate().hashCode();
		}
		if (getLastupdatedBy() != null) {
			hash *= getLastupdatedBy().hashCode();
		}
		if (getLastupdatedDate() != null) {
			hash *= getLastupdatedDate().hashCode();
		}
		if (getActiveFlag() != null) {
			hash *= getActiveFlag().hashCode();
		}
		if (getSupplierImage() != null) {
			hash *= getSupplierImage().hashCode();
		}
		if (getSupplierCertify() != null) {
			hash *= getSupplierCertify().hashCode();
		}
		if (getSupplierQualify() != null) {
			hash *= getSupplierQualify().hashCode();
		}
		return hash;
	}
}