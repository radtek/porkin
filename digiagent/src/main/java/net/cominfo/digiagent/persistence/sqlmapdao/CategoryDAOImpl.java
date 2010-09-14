package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;

public class CategoryDAOImpl extends BaseDao implements CategoryDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public CategoryDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public int countByExample(CategoryCriteria example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_da_category.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public int deleteByExample(CategoryCriteria example) {
        int rows = getSqlMapClientTemplate().delete("t_da_category.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public int deleteByPrimaryKey(Integer categoryId) {
        Category key = new Category();
        key.setCategoryId(categoryId);
        int rows = getSqlMapClientTemplate().delete("t_da_category.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public void insert(Category record) {
        getSqlMapClientTemplate().insert("t_da_category.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public void insertSelective(Category record) {
        getSqlMapClientTemplate().insert("t_da_category.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<Category> selectByExample(CategoryCriteria example) {
        List<Category> list = getSqlMapClientTemplate().queryForList("t_da_category.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public Category selectByPrimaryKey(Integer categoryId) {
        Category key = new Category();
        key.setCategoryId(categoryId);
        Category record = (Category) getSqlMapClientTemplate().queryForObject("t_da_category.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public int updateByExampleSelective(Category record, CategoryCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_da_category.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public int updateByExample(Category record, CategoryCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_da_category.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public int updateByPrimaryKeySelective(Category record) {
        int rows = getSqlMapClientTemplate().update("t_da_category.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    public int updateByPrimaryKey(Category record) {
        int rows = getSqlMapClientTemplate().update("t_da_category.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_da_category
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    private static class UpdateByExampleParms extends CategoryCriteria {
        private Object record;

        public UpdateByExampleParms(Object record, CategoryCriteria example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}