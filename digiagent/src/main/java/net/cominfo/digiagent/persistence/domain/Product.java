package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.PRODUCT_ID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private Integer productId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.PRODUCT_NAME
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private String productName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_product.CATEGORY_ID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private Integer categoryId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_product
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.PRODUCT_ID
	 * @return  the value of t_da_product.PRODUCT_ID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.PRODUCT_ID
	 * @param productId  the value for t_da_product.PRODUCT_ID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.PRODUCT_NAME
	 * @return  the value of t_da_product.PRODUCT_NAME
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.PRODUCT_NAME
	 * @param productName  the value for t_da_product.PRODUCT_NAME
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.CREATED_BY
	 * @return  the value of t_da_product.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.CREATED_BY
	 * @param createdBy  the value for t_da_product.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.CREATED_DATE
	 * @return  the value of t_da_product.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.CREATED_DATE
	 * @param createdDate  the value for t_da_product.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.LASTUPDATED_BY
	 * @return  the value of t_da_product.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_product.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.LASTUPDATED_DATE
	 * @return  the value of t_da_product.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_product.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.ACTIVE_FLAG
	 * @return  the value of t_da_product.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_product.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_product.CATEGORY_ID
	 * @return  the value of t_da_product.CATEGORY_ID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_product.CATEGORY_ID
	 * @param categoryId  the value for t_da_product.CATEGORY_ID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Product)) {
			return false;
		}
		Product other = (Product) that;
		return this.getProductId() == null ? other == null : this
				.getProductId().equals(other.getProductId())
				&& this.getProductName() == null ? other == null : this
				.getProductName().equals(other.getProductName())
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
				&& this.getCategoryId() == null ? other == null : this
				.getCategoryId().equals(other.getCategoryId());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getProductId() != null) {
			hash *= getProductId().hashCode();
		}
		if (getProductName() != null) {
			hash *= getProductName().hashCode();
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
		if (getCategoryId() != null) {
			hash *= getCategoryId().hashCode();
		}
		return hash;
	}
}