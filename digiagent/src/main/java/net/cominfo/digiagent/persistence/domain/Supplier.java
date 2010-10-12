package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private Integer supplierId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_NAME
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_CONTACTNAME
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierContactname;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_ZIP
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierZip;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_DESCRIPTION
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierDescription;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_FAX
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierFax;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_MOBILE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierMobile;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_TELEPHONE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierTelephone;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_ADDRESS
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierAddress;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_ACCESS
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private Integer supplierAccess;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_SCORE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private Integer supplierScore;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.CITY_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private Integer cityId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.USER_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private Integer userId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.CREATED_BY
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.CREATED_DATE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.LASTUPDATED_BY
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.LASTUPDATED_DATE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.ACTIVE_FLAG
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_supplier.SUPPLIER_WEBSITE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private String supplierWebsite;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_ID
	 * @return  the value of t_da_supplier.SUPPLIER_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public Integer getSupplierId() {
		return supplierId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_ID
	 * @param supplierId  the value for t_da_supplier.SUPPLIER_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_NAME
	 * @return  the value of t_da_supplier.SUPPLIER_NAME
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_NAME
	 * @param supplierName  the value for t_da_supplier.SUPPLIER_NAME
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_CONTACTNAME
	 * @return  the value of t_da_supplier.SUPPLIER_CONTACTNAME
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierContactname() {
		return supplierContactname;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_CONTACTNAME
	 * @param supplierContactname  the value for t_da_supplier.SUPPLIER_CONTACTNAME
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierContactname(String supplierContactname) {
		this.supplierContactname = supplierContactname;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_ZIP
	 * @return  the value of t_da_supplier.SUPPLIER_ZIP
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierZip() {
		return supplierZip;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_ZIP
	 * @param supplierZip  the value for t_da_supplier.SUPPLIER_ZIP
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierZip(String supplierZip) {
		this.supplierZip = supplierZip;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_DESCRIPTION
	 * @return  the value of t_da_supplier.SUPPLIER_DESCRIPTION
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierDescription() {
		return supplierDescription;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_DESCRIPTION
	 * @param supplierDescription  the value for t_da_supplier.SUPPLIER_DESCRIPTION
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_FAX
	 * @return  the value of t_da_supplier.SUPPLIER_FAX
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierFax() {
		return supplierFax;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_FAX
	 * @param supplierFax  the value for t_da_supplier.SUPPLIER_FAX
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierFax(String supplierFax) {
		this.supplierFax = supplierFax;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_MOBILE
	 * @return  the value of t_da_supplier.SUPPLIER_MOBILE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierMobile() {
		return supplierMobile;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_MOBILE
	 * @param supplierMobile  the value for t_da_supplier.SUPPLIER_MOBILE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierMobile(String supplierMobile) {
		this.supplierMobile = supplierMobile;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_TELEPHONE
	 * @return  the value of t_da_supplier.SUPPLIER_TELEPHONE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierTelephone() {
		return supplierTelephone;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_TELEPHONE
	 * @param supplierTelephone  the value for t_da_supplier.SUPPLIER_TELEPHONE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierTelephone(String supplierTelephone) {
		this.supplierTelephone = supplierTelephone;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_ADDRESS
	 * @return  the value of t_da_supplier.SUPPLIER_ADDRESS
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierAddress() {
		return supplierAddress;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_ADDRESS
	 * @param supplierAddress  the value for t_da_supplier.SUPPLIER_ADDRESS
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_ACCESS
	 * @return  the value of t_da_supplier.SUPPLIER_ACCESS
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public Integer getSupplierAccess() {
		return supplierAccess;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_ACCESS
	 * @param supplierAccess  the value for t_da_supplier.SUPPLIER_ACCESS
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierAccess(Integer supplierAccess) {
		this.supplierAccess = supplierAccess;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_SCORE
	 * @return  the value of t_da_supplier.SUPPLIER_SCORE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public Integer getSupplierScore() {
		return supplierScore;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_SCORE
	 * @param supplierScore  the value for t_da_supplier.SUPPLIER_SCORE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierScore(Integer supplierScore) {
		this.supplierScore = supplierScore;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.CITY_ID
	 * @return  the value of t_da_supplier.CITY_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.CITY_ID
	 * @param cityId  the value for t_da_supplier.CITY_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.USER_ID
	 * @return  the value of t_da_supplier.USER_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.USER_ID
	 * @param userId  the value for t_da_supplier.USER_ID
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.CREATED_BY
	 * @return  the value of t_da_supplier.CREATED_BY
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.CREATED_BY
	 * @param createdBy  the value for t_da_supplier.CREATED_BY
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.CREATED_DATE
	 * @return  the value of t_da_supplier.CREATED_DATE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.CREATED_DATE
	 * @param createdDate  the value for t_da_supplier.CREATED_DATE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.LASTUPDATED_BY
	 * @return  the value of t_da_supplier.LASTUPDATED_BY
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_supplier.LASTUPDATED_BY
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.LASTUPDATED_DATE
	 * @return  the value of t_da_supplier.LASTUPDATED_DATE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_supplier.LASTUPDATED_DATE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.ACTIVE_FLAG
	 * @return  the value of t_da_supplier.ACTIVE_FLAG
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_supplier.ACTIVE_FLAG
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_supplier.SUPPLIER_WEBSITE
	 * @return  the value of t_da_supplier.SUPPLIER_WEBSITE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public String getSupplierWebsite() {
		return supplierWebsite;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_supplier.SUPPLIER_WEBSITE
	 * @param supplierWebsite  the value for t_da_supplier.SUPPLIER_WEBSITE
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	public void setSupplierWebsite(String supplierWebsite) {
		this.supplierWebsite = supplierWebsite;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Supplier)) {
			return false;
		}
		Supplier other = (Supplier) that;
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
				&& this.getSupplierWebsite() == null ? other == null : this
				.getSupplierWebsite().equals(other.getSupplierWebsite());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_supplier
	 * @ibatorgenerated  Tue Oct 12 21:05:52 CST 2010
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
		if (getSupplierWebsite() != null) {
			hash *= getSupplierWebsite().hashCode();
		}
		return hash;
	}
}