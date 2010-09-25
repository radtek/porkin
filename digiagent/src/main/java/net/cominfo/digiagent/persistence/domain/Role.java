package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.ROLE_ID
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private Integer roleId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.ROLE_NAME
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private String roleName;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.ROLE_DESCRIPTION
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private String roleDescription;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.CREATED_BY
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private String createdBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.CREATED_DATE
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private Date createdDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.LASTUPDATED_BY
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private String lastupdatedBy;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.LASTUPDATED_DATE
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private Date lastupdatedDate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_role.ACTIVE_FLAG
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private String activeFlag;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_role
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.ROLE_ID
	 * @return  the value of t_da_role.ROLE_ID
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.ROLE_ID
	 * @param roleId  the value for t_da_role.ROLE_ID
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.ROLE_NAME
	 * @return  the value of t_da_role.ROLE_NAME
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.ROLE_NAME
	 * @param roleName  the value for t_da_role.ROLE_NAME
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.ROLE_DESCRIPTION
	 * @return  the value of t_da_role.ROLE_DESCRIPTION
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.ROLE_DESCRIPTION
	 * @param roleDescription  the value for t_da_role.ROLE_DESCRIPTION
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.CREATED_BY
	 * @return  the value of t_da_role.CREATED_BY
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.CREATED_BY
	 * @param createdBy  the value for t_da_role.CREATED_BY
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.CREATED_DATE
	 * @return  the value of t_da_role.CREATED_DATE
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.CREATED_DATE
	 * @param createdDate  the value for t_da_role.CREATED_DATE
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.LASTUPDATED_BY
	 * @return  the value of t_da_role.LASTUPDATED_BY
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.LASTUPDATED_BY
	 * @param lastupdatedBy  the value for t_da_role.LASTUPDATED_BY
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.LASTUPDATED_DATE
	 * @return  the value of t_da_role.LASTUPDATED_DATE
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.LASTUPDATED_DATE
	 * @param lastupdatedDate  the value for t_da_role.LASTUPDATED_DATE
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_role.ACTIVE_FLAG
	 * @return  the value of t_da_role.ACTIVE_FLAG
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_role.ACTIVE_FLAG
	 * @param activeFlag  the value for t_da_role.ACTIVE_FLAG
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_role
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Role)) {
			return false;
		}
		Role other = (Role) that;
		return this.getRoleId() == null ? other == null : this.getRoleId()
				.equals(other.getRoleId())
				&& this.getRoleName() == null ? other == null : this
				.getRoleName().equals(other.getRoleName())
				&& this.getRoleDescription() == null ? other == null : this
				.getRoleDescription().equals(other.getRoleDescription())
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_role
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getRoleId() != null) {
			hash *= getRoleId().hashCode();
		}
		if (getRoleName() != null) {
			hash *= getRoleName().hashCode();
		}
		if (getRoleDescription() != null) {
			hash *= getRoleDescription().hashCode();
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