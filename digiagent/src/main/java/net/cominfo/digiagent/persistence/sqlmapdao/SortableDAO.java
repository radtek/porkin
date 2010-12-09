package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Sortable;
import net.cominfo.digiagent.persistence.domain.SortableCriteria;

public interface SortableDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	int countByExample(SortableCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	int deleteByExample(SortableCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	int deleteByPrimaryKey(Integer sortableId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	void insert(Sortable record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	void insertSelective(Sortable record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	List<Sortable> selectByExample(SortableCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	Sortable selectByPrimaryKey(Integer sortableId);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	int updateByExampleSelective(Sortable record, SortableCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	int updateByExample(Sortable record, SortableCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	int updateByPrimaryKeySelective(Sortable record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sortable
	 * @ibatorgenerated  Fri Dec 10 00:42:26 CST 2010
	 */
	int updateByPrimaryKey(Sortable record);
}