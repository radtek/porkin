package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Country implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.COUNTRY_ID
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private Integer countryId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.COUNTRY_NAME
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private String countryName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.COUNTRY_ABBREVIATION
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private String countryAbbreviation;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_country.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_country
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.COUNTRY_ID
	 * @return  the value of t_da_country.COUNTRY_ID
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.COUNTRY_ID
	 * @param countryId  the value for t_da_country.COUNTRY_ID
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.COUNTRY_NAME
	 * @return  the value of t_da_country.COUNTRY_NAME
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.COUNTRY_NAME
	 * @param countryName  the value for t_da_country.COUNTRY_NAME
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.COUNTRY_ABBREVIATION
	 * @return  the value of t_da_country.COUNTRY_ABBREVIATION
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public String getCountryAbbreviation() {
		return countryAbbreviation;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.COUNTRY_ABBREVIATION
	 * @param countryAbbreviation  the value for t_da_country.COUNTRY_ABBREVIATION
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setCountryAbbreviation(String countryAbbreviation) {
		this.countryAbbreviation = countryAbbreviation;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.CREATED_BY
	 * @return  the value of t_da_country.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.CREATED_BY
	 * @param createdBy  the value for t_da_country.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.CREATED_DATE
	 * @return  the value of t_da_country.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.CREATED_DATE
	 * @param createdDate  the value for t_da_country.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.LASTUPDATED_BY
	 * @return  the value of t_da_country.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_country.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.LASTUPDATED_DATE
	 * @return  the value of t_da_country.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_country.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_country.ACTIVE_FLAG
	 * @return  the value of t_da_country.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_country.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_country.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Country)) {
			return false;
		}
		Country other = (Country) that;
		return this.getCountryId() == null ? other == null : this
				.getCountryId().equals(other.getCountryId())
				&& this.getCountryName() == null ? other == null : this
				.getCountryName().equals(other.getCountryName())
				&& this.getCountryAbbreviation() == null ? other == null : this
				.getCountryAbbreviation()
				.equals(other.getCountryAbbreviation())
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_country
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getCountryId() != null) {
			hash *= getCountryId().hashCode();
		}
		if (getCountryName() != null) {
			hash *= getCountryName().hashCode();
		}
		if (getCountryAbbreviation() != null) {
			hash *= getCountryAbbreviation().hashCode();
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