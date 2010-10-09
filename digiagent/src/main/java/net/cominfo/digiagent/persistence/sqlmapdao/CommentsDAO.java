package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Comments;
import net.cominfo.digiagent.persistence.domain.CommentsCriteria;

public interface CommentsDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	int countByExample(CommentsCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	int deleteByExample(CommentsCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	int deleteByPrimaryKey(Integer commentId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	void insert(Comments record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	void insertSelective(Comments record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	List<Comments> selectByExample(CommentsCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	Comments selectByPrimaryKey(Integer commentId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	int updateByExampleSelective(Comments record, CommentsCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	int updateByExample(Comments record, CommentsCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	int updateByPrimaryKeySelective(Comments record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	int updateByPrimaryKey(Comments record);
}