package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_history.HISTORY_ID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private Integer historyId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_history.HISTORY_TYPE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private String historyType;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_history.HISTORY_TYPEID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private Integer historyTypeid;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_history.HISTORY_ACCESSDATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private Date historyAccessdate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_history.HISTORY_FROMIP
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private String historyFromip;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_history.HISTORY_ID
	 * @return  the value of t_da_history.HISTORY_ID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public Integer getHistoryId() {
		return historyId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_history.HISTORY_ID
	 * @param historyId  the value for t_da_history.HISTORY_ID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_history.HISTORY_TYPE
	 * @return  the value of t_da_history.HISTORY_TYPE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public String getHistoryType() {
		return historyType;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_history.HISTORY_TYPE
	 * @param historyType  the value for t_da_history.HISTORY_TYPE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_history.HISTORY_TYPEID
	 * @return  the value of t_da_history.HISTORY_TYPEID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public Integer getHistoryTypeid() {
		return historyTypeid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_history.HISTORY_TYPEID
	 * @param historyTypeid  the value for t_da_history.HISTORY_TYPEID
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setHistoryTypeid(Integer historyTypeid) {
		this.historyTypeid = historyTypeid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_history.HISTORY_ACCESSDATE
	 * @return  the value of t_da_history.HISTORY_ACCESSDATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public Date getHistoryAccessdate() {
		return historyAccessdate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_history.HISTORY_ACCESSDATE
	 * @param historyAccessdate  the value for t_da_history.HISTORY_ACCESSDATE
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setHistoryAccessdate(Date historyAccessdate) {
		this.historyAccessdate = historyAccessdate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_history.HISTORY_FROMIP
	 * @return  the value of t_da_history.HISTORY_FROMIP
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public String getHistoryFromip() {
		return historyFromip;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_history.HISTORY_FROMIP
	 * @param historyFromip  the value for t_da_history.HISTORY_FROMIP
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	public void setHistoryFromip(String historyFromip) {
		this.historyFromip = historyFromip;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof History)) {
			return false;
		}
		History other = (History) that;
		return this.getHistoryId() == null ? other == null : this
				.getHistoryId().equals(other.getHistoryId())
				&& this.getHistoryType() == null ? other == null : this
				.getHistoryType().equals(other.getHistoryType())
				&& this.getHistoryTypeid() == null ? other == null : this
				.getHistoryTypeid().equals(other.getHistoryTypeid())
				&& this.getHistoryAccessdate() == null ? other == null : this
				.getHistoryAccessdate().equals(other.getHistoryAccessdate())
				&& this.getHistoryFromip() == null ? other == null : this
				.getHistoryFromip().equals(other.getHistoryFromip());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Sun Apr 10 20:46:03 CST 2011
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getHistoryId() != null) {
			hash *= getHistoryId().hashCode();
		}
		if (getHistoryType() != null) {
			hash *= getHistoryType().hashCode();
		}
		if (getHistoryTypeid() != null) {
			hash *= getHistoryTypeid().hashCode();
		}
		if (getHistoryAccessdate() != null) {
			hash *= getHistoryAccessdate().hashCode();
		}
		if (getHistoryFromip() != null) {
			hash *= getHistoryFromip().hashCode();
		}
		return hash;
	}
}