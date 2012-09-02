package name.huangzhoujin.registration.persistence.sqlmapdao;

import java.util.List;
import name.huangzhoujin.registration.persistence.domain.Memo;
import name.huangzhoujin.registration.persistence.domain.MemoCriteria;
import org.apache.ibatis.annotations.Param;

public interface MemoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int countByExample(MemoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int deleteByExample(MemoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int deleteByPrimaryKey(Integer memoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int insert(Memo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int insertSelective(Memo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    List<Memo> selectByExample(MemoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    Memo selectByPrimaryKey(Integer memoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int updateByExampleSelective(@Param("record") Memo record, @Param("example") MemoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int updateByExample(@Param("record") Memo record, @Param("example") MemoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int updateByPrimaryKeySelective(Memo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    int updateByPrimaryKey(Memo record);
}