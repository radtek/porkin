package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.USER_ID
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private Integer userId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.USER_NAME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private String userName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.USER_EMAIL
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private String userEmail;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.USER_PASSWORD
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private String userPassword;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.LASTLOGINTIME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private Date lastlogintime;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.REGISTERTIME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private Date registertime;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.LOGONSUM
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private Integer logonsum;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.CREATED_BY
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.CREATED_DATE
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.LASTUPDATED_BY
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.LASTUPDATED_DATE
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_user.ACTIVE_FLAG
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_user
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.USER_ID
	 * @return  the value of t_da_user.USER_ID
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.USER_ID
	 * @param userId  the value for t_da_user.USER_ID
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.USER_NAME
	 * @return  the value of t_da_user.USER_NAME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.USER_NAME
	 * @param userName  the value for t_da_user.USER_NAME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.USER_EMAIL
	 * @return  the value of t_da_user.USER_EMAIL
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.USER_EMAIL
	 * @param userEmail  the value for t_da_user.USER_EMAIL
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.USER_PASSWORD
	 * @return  the value of t_da_user.USER_PASSWORD
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.USER_PASSWORD
	 * @param userPassword  the value for t_da_user.USER_PASSWORD
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.LASTLOGINTIME
	 * @return  the value of t_da_user.LASTLOGINTIME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public Date getLastlogintime() {
		return lastlogintime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.LASTLOGINTIME
	 * @param lastlogintime  the value for t_da_user.LASTLOGINTIME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.REGISTERTIME
	 * @return  the value of t_da_user.REGISTERTIME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public Date getRegistertime() {
		return registertime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.REGISTERTIME
	 * @param registertime  the value for t_da_user.REGISTERTIME
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.LOGONSUM
	 * @return  the value of t_da_user.LOGONSUM
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public Integer getLogonsum() {
		return logonsum;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.LOGONSUM
	 * @param logonsum  the value for t_da_user.LOGONSUM
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setLogonsum(Integer logonsum) {
		this.logonsum = logonsum;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.CREATED_BY
	 * @return  the value of t_da_user.CREATED_BY
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.CREATED_BY
	 * @param createdBy  the value for t_da_user.CREATED_BY
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.CREATED_DATE
	 * @return  the value of t_da_user.CREATED_DATE
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.CREATED_DATE
	 * @param createdDate  the value for t_da_user.CREATED_DATE
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.LASTUPDATED_BY
	 * @return  the value of t_da_user.LASTUPDATED_BY
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_user.LASTUPDATED_BY
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.LASTUPDATED_DATE
	 * @return  the value of t_da_user.LASTUPDATED_DATE
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_user.LASTUPDATED_DATE
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_user.ACTIVE_FLAG
	 * @return  the value of t_da_user.ACTIVE_FLAG
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_user.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_user.ACTIVE_FLAG
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof User)) {
			return false;
		}
		User other = (User) that;
		return this.getUserId() == null ? other == null : this.getUserId()
				.equals(other.getUserId())
				&& this.getUserName() == null ? other == null : this
				.getUserName().equals(other.getUserName())
				&& this.getUserEmail() == null ? other == null : this
				.getUserEmail().equals(other.getUserEmail())
				&& this.getUserPassword() == null ? other == null : this
				.getUserPassword().equals(other.getUserPassword())
				&& this.getLastlogintime() == null ? other == null : this
				.getLastlogintime().equals(other.getLastlogintime())
				&& this.getRegistertime() == null ? other == null : this
				.getRegistertime().equals(other.getRegistertime())
				&& this.getLogonsum() == null ? other == null : this
				.getLogonsum().equals(other.getLogonsum())
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getUserId() != null) {
			hash *= getUserId().hashCode();
		}
		if (getUserName() != null) {
			hash *= getUserName().hashCode();
		}
		if (getUserEmail() != null) {
			hash *= getUserEmail().hashCode();
		}
		if (getUserPassword() != null) {
			hash *= getUserPassword().hashCode();
		}
		if (getLastlogintime() != null) {
			hash *= getLastlogintime().hashCode();
		}
		if (getRegistertime() != null) {
			hash *= getRegistertime().hashCode();
		}
		if (getLogonsum() != null) {
			hash *= getLogonsum().hashCode();
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