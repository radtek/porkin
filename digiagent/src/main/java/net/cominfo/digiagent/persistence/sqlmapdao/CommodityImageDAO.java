package net.cominfo.digiagent.persistence.sqlmapdao;

import java.util.List;
import net.cominfo.digiagent.persistence.domain.CommodityImage;
import net.cominfo.digiagent.persistence.domain.CommodityImageCriteria;

public interface CommodityImageDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int countByExample(CommodityImageCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int deleteByExample(CommodityImageCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int deleteByPrimaryKey(Integer commodityimageId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    void insert(CommodityImage record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    void insertSelective(CommodityImage record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    List<CommodityImage> selectByExampleWithBLOBs(CommodityImageCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    List<CommodityImage> selectByExampleWithoutBLOBs(CommodityImageCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    CommodityImage selectByPrimaryKey(Integer commodityimageId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int updateByExampleSelective(CommodityImage record, CommodityImageCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int updateByExampleWithBLOBs(CommodityImage record, CommodityImageCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int updateByExampleWithoutBLOBs(CommodityImage record, CommodityImageCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int updateByPrimaryKeySelective(CommodityImage record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int updateByPrimaryKeyWithBLOBs(CommodityImage record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodityimage
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    int updateByPrimaryKeyWithoutBLOBs(CommodityImage record);
}