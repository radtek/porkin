package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class City implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.CITY_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private Integer cityId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.CITY_NAME
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private String cityName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.CITY_ABBREVIATION
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private String cityAbbreviation;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_city.PROVINCE_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private Integer provinceId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_city
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.CITY_ID
	 * @return  the value of t_da_city.CITY_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.CITY_ID
	 * @param cityId  the value for t_da_city.CITY_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.CITY_NAME
	 * @return  the value of t_da_city.CITY_NAME
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.CITY_NAME
	 * @param cityName  the value for t_da_city.CITY_NAME
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.CITY_ABBREVIATION
	 * @return  the value of t_da_city.CITY_ABBREVIATION
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public String getCityAbbreviation() {
		return cityAbbreviation;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.CITY_ABBREVIATION
	 * @param cityAbbreviation  the value for t_da_city.CITY_ABBREVIATION
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setCityAbbreviation(String cityAbbreviation) {
		this.cityAbbreviation = cityAbbreviation;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.CREATED_BY
	 * @return  the value of t_da_city.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.CREATED_BY
	 * @param createdBy  the value for t_da_city.CREATED_BY
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.CREATED_DATE
	 * @return  the value of t_da_city.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.CREATED_DATE
	 * @param createdDate  the value for t_da_city.CREATED_DATE
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.LASTUPDATED_BY
	 * @return  the value of t_da_city.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_city.LASTUPDATED_BY
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.LASTUPDATED_DATE
	 * @return  the value of t_da_city.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_city.LASTUPDATED_DATE
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.ACTIVE_FLAG
	 * @return  the value of t_da_city.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_city.ACTIVE_FLAG
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_city.PROVINCE_ID
	 * @return  the value of t_da_city.PROVINCE_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_city.PROVINCE_ID
	 * @param provinceId  the value for t_da_city.PROVINCE_ID
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof City)) {
			return false;
		}
		City other = (City) that;
		return this.getCityId() == null ? other == null : this.getCityId()
				.equals(other.getCityId())
				&& this.getCityName() == null ? other == null : this
				.getCityName().equals(other.getCityName())
				&& this.getCityAbbreviation() == null ? other == null : this
				.getCityAbbreviation().equals(other.getCityAbbreviation())
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
				&& this.getProvinceId() == null ? other == null : this
				.getProvinceId().equals(other.getProvinceId());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_city
	 * @ibatorgenerated  Wed Oct 06 11:10:02 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getCityId() != null) {
			hash *= getCityId().hashCode();
		}
		if (getCityName() != null) {
			hash *= getCityName().hashCode();
		}
		if (getCityAbbreviation() != null) {
			hash *= getCityAbbreviation().hashCode();
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
		if (getProvinceId() != null) {
			hash *= getProvinceId().hashCode();
		}
		return hash;
	}
}