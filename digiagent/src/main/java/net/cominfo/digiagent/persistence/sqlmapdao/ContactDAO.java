package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.Contact;
import net.cominfo.digiagent.persistence.domain.ContactCriteria;

public interface ContactDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    int countByExample(ContactCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    int deleteByExample(ContactCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    int deleteByPrimaryKey(Integer contactId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    void insert(Contact record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    void insertSelective(Contact record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    List<Contact> selectByExample(ContactCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    Contact selectByPrimaryKey(Integer contactId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    int updateByExampleSelective(Contact record, ContactCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    int updateByExample(Contact record, ContactCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    int updateByPrimaryKeySelective(Contact record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_contact
     *
     * @ibatorgenerated Tue Sep 14 19:01:20 CST 2010
     */
    int updateByPrimaryKey(Contact record);
}