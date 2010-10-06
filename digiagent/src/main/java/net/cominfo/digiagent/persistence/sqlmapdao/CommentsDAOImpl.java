package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Comments;
import net.cominfo.digiagent.persistence.domain.CommentsCriteria;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CommentsDAOImpl extends BaseDao implements CommentsDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public CommentsDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public int countByExample(CommentsCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_da_comments.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public int deleteByExample(CommentsCriteria example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_da_comments.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public int deleteByPrimaryKey(Integer commentId) {
		Comments key = new Comments();
		key.setCommentId(commentId);
		int rows = getSqlMapClientTemplate().delete(
				"t_da_comments.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void insert(Comments record) {
		getSqlMapClientTemplate().insert(
				"t_da_comments.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public void insertSelective(Comments record) {
		getSqlMapClientTemplate().insert(
				"t_da_comments.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<Comments> selectByExample(CommentsCriteria example) {
		List<Comments> list = getSqlMapClientTemplate().queryForList(
				"t_da_comments.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public Comments selectByPrimaryKey(Integer commentId) {
		Comments key = new Comments();
		key.setCommentId(commentId);
		Comments record = (Comments) getSqlMapClientTemplate().queryForObject(
				"t_da_comments.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public int updateByExampleSelective(Comments record,
			CommentsCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate()
				.update(
						"t_da_comments.ibatorgenerated_updateByExampleSelective",
						parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public int updateByExample(Comments record, CommentsCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_da_comments.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public int updateByPrimaryKeySelective(Comments record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_comments.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	public int updateByPrimaryKey(Comments record) {
		int rows = getSqlMapClientTemplate().update(
				"t_da_comments.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_comments
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	private static class UpdateByExampleParms extends CommentsCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, CommentsCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}