package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Commodity implements Serializable {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.COMMODITY_ID
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private Integer commodityId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.COMMODITY_NAME
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private String commodityName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.COMMODITY_DESCRIPTION
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private String commodityDescription;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.START_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private Date startDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.END_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private Date endDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.COMMODITY_TYPE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private String commodityType;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.USER_ID
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private Integer userId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.CREATED_BY
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private String createdBy;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.CREATED_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private Date createdDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.LASTUPDATED_BY
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private String lastupdatedBy;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.LASTUPDATED_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private Date lastupdatedDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_commodity.ACTIVE_FLAG
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private String activeFlag;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table t_da_commodity
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.COMMODITY_ID
     *
     * @return the value of t_da_commodity.COMMODITY_ID
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public Integer getCommodityId() {
        return commodityId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.COMMODITY_ID
     *
     * @param commodityId the value for t_da_commodity.COMMODITY_ID
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.COMMODITY_NAME
     *
     * @return the value of t_da_commodity.COMMODITY_NAME
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.COMMODITY_NAME
     *
     * @param commodityName the value for t_da_commodity.COMMODITY_NAME
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.COMMODITY_DESCRIPTION
     *
     * @return the value of t_da_commodity.COMMODITY_DESCRIPTION
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public String getCommodityDescription() {
        return commodityDescription;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.COMMODITY_DESCRIPTION
     *
     * @param commodityDescription the value for t_da_commodity.COMMODITY_DESCRIPTION
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setCommodityDescription(String commodityDescription) {
        this.commodityDescription = commodityDescription;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.START_DATE
     *
     * @return the value of t_da_commodity.START_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.START_DATE
     *
     * @param startDate the value for t_da_commodity.START_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.END_DATE
     *
     * @return the value of t_da_commodity.END_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.END_DATE
     *
     * @param endDate the value for t_da_commodity.END_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.COMMODITY_TYPE
     *
     * @return the value of t_da_commodity.COMMODITY_TYPE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public String getCommodityType() {
        return commodityType;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.COMMODITY_TYPE
     *
     * @param commodityType the value for t_da_commodity.COMMODITY_TYPE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.USER_ID
     *
     * @return the value of t_da_commodity.USER_ID
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.USER_ID
     *
     * @param userId the value for t_da_commodity.USER_ID
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.CREATED_BY
     *
     * @return the value of t_da_commodity.CREATED_BY
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.CREATED_BY
     *
     * @param createdBy the value for t_da_commodity.CREATED_BY
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.CREATED_DATE
     *
     * @return the value of t_da_commodity.CREATED_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.CREATED_DATE
     *
     * @param createdDate the value for t_da_commodity.CREATED_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.LASTUPDATED_BY
     *
     * @return the value of t_da_commodity.LASTUPDATED_BY
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.LASTUPDATED_BY
     *
     * @param lastupdatedBy the value for t_da_commodity.LASTUPDATED_BY
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.LASTUPDATED_DATE
     *
     * @return the value of t_da_commodity.LASTUPDATED_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public Date getLastupdatedDate() {
        return lastupdatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.LASTUPDATED_DATE
     *
     * @param lastupdatedDate the value for t_da_commodity.LASTUPDATED_DATE
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setLastupdatedDate(Date lastupdatedDate) {
        this.lastupdatedDate = lastupdatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_commodity.ACTIVE_FLAG
     *
     * @return the value of t_da_commodity.ACTIVE_FLAG
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public String getActiveFlag() {
        return activeFlag;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_commodity.ACTIVE_FLAG
     *
     * @param activeFlag the value for t_da_commodity.ACTIVE_FLAG
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodity
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof Commodity)) {
            return false;
        }
        Commodity other = (Commodity) that;
        return this.getCommodityId() == null ? other == null : this.getCommodityId().equals(other.getCommodityId())
            && this.getCommodityName() == null ? other == null : this.getCommodityName().equals(other.getCommodityName())
            && this.getCommodityDescription() == null ? other == null : this.getCommodityDescription().equals(other.getCommodityDescription())
            && this.getStartDate() == null ? other == null : this.getStartDate().equals(other.getStartDate())
            && this.getEndDate() == null ? other == null : this.getEndDate().equals(other.getEndDate())
            && this.getCommodityType() == null ? other == null : this.getCommodityType().equals(other.getCommodityType())
            && this.getUserId() == null ? other == null : this.getUserId().equals(other.getUserId())
            && this.getCreatedBy() == null ? other == null : this.getCreatedBy().equals(other.getCreatedBy())
            && this.getCreatedDate() == null ? other == null : this.getCreatedDate().equals(other.getCreatedDate())
            && this.getLastupdatedBy() == null ? other == null : this.getLastupdatedBy().equals(other.getLastupdatedBy())
            && this.getLastupdatedDate() == null ? other == null : this.getLastupdatedDate().equals(other.getLastupdatedDate())
            && this.getActiveFlag() == null ? other == null : this.getActiveFlag().equals(other.getActiveFlag());
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_commodity
     *
     * @ibatorgenerated Tue Sep 14 19:01:21 CST 2010
     */
    @Override
    public int hashCode() {
        int hash = 23;
        if (getCommodityId() != null) {
            hash *= getCommodityId().hashCode();
        }
        if (getCommodityName() != null) {
            hash *= getCommodityName().hashCode();
        }
        if (getCommodityDescription() != null) {
            hash *= getCommodityDescription().hashCode();
        }
        if (getStartDate() != null) {
            hash *= getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            hash *= getEndDate().hashCode();
        }
        if (getCommodityType() != null) {
            hash *= getCommodityType().hashCode();
        }
        if (getUserId() != null) {
            hash *= getUserId().hashCode();
        }
        if (getCreatedBy() != null) {
            hash *= getCreatedBy().hashCode();
        }
        if (getCreatedDate() != null) {
            hash *= getCreatedDate().hashCode();
        }
        if (getLastupdatedBy() != null) {
            hash *= getLastupdatedBy().hashCode();
        }
        if (getLastupdatedDate() != null) {
            hash *= getLastupdatedDate().hashCode();
        }
        if (getActiveFlag() != null) {
            hash *= getActiveFlag().hashCode();
        }
        return hash;
    }
}