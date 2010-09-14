package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.persistence.domain.UserCriteria;

public interface UserDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	int countByExample(UserCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	int deleteByExample(UserCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	int deleteByPrimaryKey(Integer userId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	void insert(User record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	void insertSelective(User record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	List<User> selectByExample(UserCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	User selectByPrimaryKey(Integer userId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	int updateByExampleSelective(User record, UserCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	int updateByExample(User record, UserCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Tue Sep 14 21:24:55 CST 2010
	 */
	int updateByPrimaryKey(User record);
}