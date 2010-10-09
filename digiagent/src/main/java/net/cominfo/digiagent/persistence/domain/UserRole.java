package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;

public class UserRole implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_userrole.USER_ID
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	private Integer userId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_userrole.ROLE_ID
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	private Integer roleId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_userrole.USER_ID
	 * @return  the value of t_da_userrole.USER_ID
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_userrole.USER_ID
	 * @param userId  the value for t_da_userrole.USER_ID
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_userrole.ROLE_ID
	 * @return  the value of t_da_userrole.ROLE_ID
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_userrole.ROLE_ID
	 * @param roleId  the value for t_da_userrole.ROLE_ID
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof UserRole)) {
			return false;
		}
		UserRole other = (UserRole) that;
		return this.getUserId() == null ? other == null : this.getUserId()
				.equals(other.getUserId())
				&& this.getRoleId() == null ? other == null : this.getRoleId()
				.equals(other.getRoleId());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getUserId() != null) {
			hash *= getUserId().hashCode();
		}
		if (getRoleId() != null) {
			hash *= getRoleId().hashCode();
		}
		return hash;
	}
}