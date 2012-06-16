package name.huangzhoujin.registration.persistence.domain;

import java.io.Serializable;

public class Memo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reg_memo.MEMO_ID
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    private Integer memoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reg_memo.MDEMO_DESCRIPTION
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    private String mdemoDescription;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reg_memo.MEMO_ID
     *
     * @return the value of t_reg_memo.MEMO_ID
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    public Integer getMemoId() {
        return memoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reg_memo.MEMO_ID
     *
     * @param memoId the value for t_reg_memo.MEMO_ID
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    public void setMemoId(Integer memoId) {
        this.memoId = memoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reg_memo.MDEMO_DESCRIPTION
     *
     * @return the value of t_reg_memo.MDEMO_DESCRIPTION
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    public String getMdemoDescription() {
        return mdemoDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reg_memo.MDEMO_DESCRIPTION
     *
     * @param mdemoDescription the value for t_reg_memo.MDEMO_DESCRIPTION
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    public void setMdemoDescription(String mdemoDescription) {
        this.mdemoDescription = mdemoDescription == null ? null : mdemoDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Memo other = (Memo) that;
        return (this.getMemoId() == null ? other.getMemoId() == null : this.getMemoId().equals(other.getMemoId()))
            && (this.getMdemoDescription() == null ? other.getMdemoDescription() == null : this.getMdemoDescription().equals(other.getMdemoDescription()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 11:45:44 CST 2012
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemoId() == null) ? 0 : getMemoId().hashCode());
        result = prime * result + ((getMdemoDescription() == null) ? 0 : getMdemoDescription().hashCode());
        return result;
    }
}