package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Sequence;
import net.cominfo.digiagent.persistence.domain.SequenceCriteria;

public interface SequenceDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int countByExample(SequenceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int deleteByExample(SequenceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int deleteByPrimaryKey(String name);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	void insert(Sequence record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	void insertSelective(Sequence record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	List<Sequence> selectByExample(SequenceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	Sequence selectByPrimaryKey(String name);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByExampleSelective(Sequence record, SequenceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByExample(Sequence record, SequenceCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByPrimaryKeySelective(Sequence record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 13:56:41 CST 2010
	 */
	int updateByPrimaryKey(Sequence record);
}