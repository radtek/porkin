package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.persistence.domain.CountryCriteria;

public class CountryDAOImpl extends BaseDao implements CountryDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public CountryDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public int countByExample(CountryCriteria example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_da_country.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public int deleteByExample(CountryCriteria example) {
        int rows = getSqlMapClientTemplate().delete("t_da_country.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public int deleteByPrimaryKey(Integer countryId) {
        Country key = new Country();
        key.setCountryId(countryId);
        int rows = getSqlMapClientTemplate().delete("t_da_country.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void insert(Country record) {
        getSqlMapClientTemplate().insert("t_da_country.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void insertSelective(Country record) {
        getSqlMapClientTemplate().insert("t_da_country.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<Country> selectByExample(CountryCriteria example) {
        List<Country> list = getSqlMapClientTemplate().queryForList("t_da_country.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public Country selectByPrimaryKey(Integer countryId) {
        Country key = new Country();
        key.setCountryId(countryId);
        Country record = (Country) getSqlMapClientTemplate().queryForObject("t_da_country.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public int updateByExampleSelective(Country record, CountryCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_da_country.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public int updateByExample(Country record, CountryCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_da_country.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public int updateByPrimaryKeySelective(Country record) {
        int rows = getSqlMapClientTemplate().update("t_da_country.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public int updateByPrimaryKey(Country record) {
        int rows = getSqlMapClientTemplate().update("t_da_country.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_da_country
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private static class UpdateByExampleParms extends CountryCriteria {
        private Object record;

        public UpdateByExampleParms(Object record, CountryCriteria example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}