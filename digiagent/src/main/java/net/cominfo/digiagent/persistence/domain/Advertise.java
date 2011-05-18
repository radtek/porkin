package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class Advertise implements Serializable {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_advertise.ADVERTISE_ID
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private Integer advertiseId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_advertise.ADVERTISE_DESCRIPTION
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private String advertiseDescription;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_advertise.CREATED_BY
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private String createdBy;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_advertise.CREATED_DATE
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private Date createdDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_advertise.LASTUPDATED_BY
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private String lastupdatedBy;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_advertise.LASTUPDATED_DATE
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private Date lastupdatedDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_da_advertise.ACTIVE_FLAG
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private String activeFlag;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table t_da_advertise
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_advertise.ADVERTISE_ID
     *
     * @return the value of t_da_advertise.ADVERTISE_ID
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public Integer getAdvertiseId() {
        return advertiseId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_advertise.ADVERTISE_ID
     *
     * @param advertiseId the value for t_da_advertise.ADVERTISE_ID
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public void setAdvertiseId(Integer advertiseId) {
        this.advertiseId = advertiseId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_advertise.ADVERTISE_DESCRIPTION
     *
     * @return the value of t_da_advertise.ADVERTISE_DESCRIPTION
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public String getAdvertiseDescription() {
        return advertiseDescription;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_advertise.ADVERTISE_DESCRIPTION
     *
     * @param advertiseDescription the value for t_da_advertise.ADVERTISE_DESCRIPTION
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public void setAdvertiseDescription(String advertiseDescription) {
        this.advertiseDescription = advertiseDescription;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_advertise.CREATED_BY
     *
     * @return the value of t_da_advertise.CREATED_BY
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_advertise.CREATED_BY
     *
     * @param createdBy the value for t_da_advertise.CREATED_BY
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_advertise.CREATED_DATE
     *
     * @return the value of t_da_advertise.CREATED_DATE
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_advertise.CREATED_DATE
     *
     * @param createdDate the value for t_da_advertise.CREATED_DATE
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_advertise.LASTUPDATED_BY
     *
     * @return the value of t_da_advertise.LASTUPDATED_BY
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_advertise.LASTUPDATED_BY
     *
     * @param lastupdatedBy the value for t_da_advertise.LASTUPDATED_BY
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_advertise.LASTUPDATED_DATE
     *
     * @return the value of t_da_advertise.LASTUPDATED_DATE
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public Date getLastupdatedDate() {
        return lastupdatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_advertise.LASTUPDATED_DATE
     *
     * @param lastupdatedDate the value for t_da_advertise.LASTUPDATED_DATE
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public void setLastupdatedDate(Date lastupdatedDate) {
        this.lastupdatedDate = lastupdatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_da_advertise.ACTIVE_FLAG
     *
     * @return the value of t_da_advertise.ACTIVE_FLAG
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public String getActiveFlag() {
        return activeFlag;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_da_advertise.ACTIVE_FLAG
     *
     * @param activeFlag the value for t_da_advertise.ACTIVE_FLAG
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_advertise
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof Advertise)) {
            return false;
        }
        Advertise other = (Advertise) that;
        return this.getAdvertiseId() == null ? other == null : this.getAdvertiseId().equals(other.getAdvertiseId())
            && this.getAdvertiseDescription() == null ? other == null : this.getAdvertiseDescription().equals(other.getAdvertiseDescription())
            && this.getCreatedBy() == null ? other == null : this.getCreatedBy().equals(other.getCreatedBy())
            && this.getCreatedDate() == null ? other == null : this.getCreatedDate().equals(other.getCreatedDate())
            && this.getLastupdatedBy() == null ? other == null : this.getLastupdatedBy().equals(other.getLastupdatedBy())
            && this.getLastupdatedDate() == null ? other == null : this.getLastupdatedDate().equals(other.getLastupdatedDate())
            && this.getActiveFlag() == null ? other == null : this.getActiveFlag().equals(other.getActiveFlag());
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_da_advertise
     *
     * @ibatorgenerated Sun Apr 10 20:46:03 CST 2011
     */
    @Override
    public int hashCode() {
        int hash = 23;
        if (getAdvertiseId() != null) {
            hash *= getAdvertiseId().hashCode();
        }
        if (getAdvertiseDescription() != null) {
            hash *= getAdvertiseDescription().hashCode();
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