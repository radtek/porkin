package name.huangzhoujin.registration.persistence.sqlmapdao;

import java.util.List;
import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.domain.AreaCriteria;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int countByExample(AreaCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int deleteByExample(AreaCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int deleteByPrimaryKey(Integer areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int insert(Area record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int insertSelective(Area record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    List<Area> selectByExample(AreaCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    Area selectByPrimaryKey(Integer areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int updateByExample(@Param("record") Area record, @Param("example") AreaCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_area
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    int updateByPrimaryKey(Area record);
}