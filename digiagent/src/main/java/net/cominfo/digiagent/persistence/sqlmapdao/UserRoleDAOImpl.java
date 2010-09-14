package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.UserRole;
import net.cominfo.digiagent.persistence.domain.UserRoleCriteria;

public class UserRoleDAOImpl extends BaseDao implements UserRoleDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    public UserRoleDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    public int countByExample(UserRoleCriteria example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_da_userrole.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    public int deleteByExample(UserRoleCriteria example) {
        int rows = getSqlMapClientTemplate().delete("t_da_userrole.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    public void insert(UserRole record) {
        getSqlMapClientTemplate().insert("t_da_userrole.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    public void insertSelective(UserRole record) {
        getSqlMapClientTemplate().insert("t_da_userrole.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<UserRole> selectByExample(UserRoleCriteria example) {
        List<UserRole> list = getSqlMapClientTemplate().queryForList("t_da_userrole.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    public int updateByExampleSelective(UserRole record, UserRoleCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_da_userrole.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    public int updateByExample(UserRole record, UserRoleCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_da_userrole.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_da_userrole
     *
     * @ibatorgenerated Tue Sep 14 18:50:40 CST 2010
     */
    private static class UpdateByExampleParms extends UserRoleCriteria {
        private Object record;

        public UpdateByExampleParms(Object record, UserRoleCriteria example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}