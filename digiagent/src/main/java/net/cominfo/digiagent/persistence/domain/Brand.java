package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Brand implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.BRAND_ID
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private Integer brandId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.BRAND_NAME
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private String brandName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.BRAND_ENGLISH
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private String brandEnglish;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.CREATED_BY
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.CREATED_DATE
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.LASTUPDATED_BY
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.LASTUPDATED_DATE
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.ACTIVE_FLAG
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_brand.COUNTRY_ID
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private Integer countryId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.BRAND_ID
	 * @return  the value of t_da_brand.BRAND_ID
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public Integer getBrandId() {
		return brandId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.BRAND_ID
	 * @param brandId  the value for t_da_brand.BRAND_ID
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.BRAND_NAME
	 * @return  the value of t_da_brand.BRAND_NAME
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.BRAND_NAME
	 * @param brandName  the value for t_da_brand.BRAND_NAME
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.BRAND_ENGLISH
	 * @return  the value of t_da_brand.BRAND_ENGLISH
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public String getBrandEnglish() {
		return brandEnglish;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.BRAND_ENGLISH
	 * @param brandEnglish  the value for t_da_brand.BRAND_ENGLISH
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setBrandEnglish(String brandEnglish) {
		this.brandEnglish = brandEnglish;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.CREATED_BY
	 * @return  the value of t_da_brand.CREATED_BY
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.CREATED_BY
	 * @param createdBy  the value for t_da_brand.CREATED_BY
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.CREATED_DATE
	 * @return  the value of t_da_brand.CREATED_DATE
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.CREATED_DATE
	 * @param createdDate  the value for t_da_brand.CREATED_DATE
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.LASTUPDATED_BY
	 * @return  the value of t_da_brand.LASTUPDATED_BY
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_brand.LASTUPDATED_BY
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.LASTUPDATED_DATE
	 * @return  the value of t_da_brand.LASTUPDATED_DATE
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_brand.LASTUPDATED_DATE
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.ACTIVE_FLAG
	 * @return  the value of t_da_brand.ACTIVE_FLAG
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_brand.ACTIVE_FLAG
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_brand.COUNTRY_ID
	 * @return  the value of t_da_brand.COUNTRY_ID
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_brand.COUNTRY_ID
	 * @param countryId  the value for t_da_brand.COUNTRY_ID
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Brand)) {
			return false;
		}
		Brand other = (Brand) that;
		return this.getBrandId() == null ? other == null : this.getBrandId()
				.equals(other.getBrandId())
				&& this.getBrandName() == null ? other == null : this
				.getBrandName().equals(other.getBrandName())
				&& this.getBrandEnglish() == null ? other == null : this
				.getBrandEnglish().equals(other.getBrandEnglish())
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
				&& this.getCountryId() == null ? other == null : this
				.getCountryId().equals(other.getCountryId());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Aug 14 12:47:37 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getBrandId() != null) {
			hash *= getBrandId().hashCode();
		}
		if (getBrandName() != null) {
			hash *= getBrandName().hashCode();
		}
		if (getBrandEnglish() != null) {
			hash *= getBrandEnglish().hashCode();
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
		if (getCountryId() != null) {
			hash *= getCountryId().hashCode();
		}
		return hash;
	}
}