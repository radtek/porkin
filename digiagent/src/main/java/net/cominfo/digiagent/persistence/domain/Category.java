package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_category.CATEGORY_ID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private Integer categoryId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_category.CATEGORY_NAME
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private String categoryName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_category.CREATED_BY
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_category.CREATED_DATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_category.LASTUPDATED_BY
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_category.LASTUPDATED_DATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_category.ACTIVE_FLAG
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_category
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_category.CATEGORY_ID
	 * @return  the value of t_da_category.CATEGORY_ID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_category.CATEGORY_ID
	 * @param categoryId  the value for t_da_category.CATEGORY_ID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_category.CATEGORY_NAME
	 * @return  the value of t_da_category.CATEGORY_NAME
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_category.CATEGORY_NAME
	 * @param categoryName  the value for t_da_category.CATEGORY_NAME
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_category.CREATED_BY
	 * @return  the value of t_da_category.CREATED_BY
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_category.CREATED_BY
	 * @param createdBy  the value for t_da_category.CREATED_BY
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_category.CREATED_DATE
	 * @return  the value of t_da_category.CREATED_DATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_category.CREATED_DATE
	 * @param createdDate  the value for t_da_category.CREATED_DATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_category.LASTUPDATED_BY
	 * @return  the value of t_da_category.LASTUPDATED_BY
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_category.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_category.LASTUPDATED_BY
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_category.LASTUPDATED_DATE
	 * @return  the value of t_da_category.LASTUPDATED_DATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_category.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_category.LASTUPDATED_DATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_category.ACTIVE_FLAG
	 * @return  the value of t_da_category.ACTIVE_FLAG
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_category.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_category.ACTIVE_FLAG
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_category
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Category)) {
			return false;
		}
		Category other = (Category) that;
		return this.getCategoryId() == null ? other == null : this
				.getCategoryId().equals(other.getCategoryId())
				&& this.getCategoryName() == null ? other == null : this
				.getCategoryName().equals(other.getCategoryName())
				&& this.getCreatedBy() == null ? other == null : this
				.getCreatedBy().equals(other.getCreatedBy())
				&& this.getCreatedDate() == null ? other == null : this
				.getCreatedDate().equals(other.getCreatedDate())
				&& this.getLastupdatedBy() == null ? other == null : this
				.getLastupdatedBy().equals(other.getLastupdatedBy())
				&& this.getLastupdatedDate() == null ? other == null : this
				.getLastupdatedDate().equals(other.getLastupdatedDate())
				&& this.getActiveFlag() == null ? other == null : this
				.getActiveFlag().equals(other.getActiveFlag());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_category
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getCategoryId() != null) {
			hash *= getCategoryId().hashCode();
		}
		if (getCategoryName() != null) {
			hash *= getCategoryName().hashCode();
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
		return hash;
	}
}