package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.UserRole;
import net.cominfo.digiagent.persistence.domain.UserRoleCriteria;

public interface UserRoleDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int countByExample(UserRoleCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int deleteByExample(UserRoleCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	void insert(UserRole record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	void insertSelective(UserRole record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	List<UserRole> selectByExample(UserRoleCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByExampleSelective(UserRole record, UserRoleCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_userrole
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByExample(UserRole record, UserRoleCriteria example);
}