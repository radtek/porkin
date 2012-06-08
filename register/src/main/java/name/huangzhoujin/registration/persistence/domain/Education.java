package name.huangzhoujin.registration.persistence.domain;

import java.io.Serializable;

public class Education implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reg_education.EDUCATION_ID
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    private Integer educationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reg_education.EDUCATION_NAME
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    private String educationName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_reg_education
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reg_education.EDUCATION_ID
     *
     * @return the value of t_reg_education.EDUCATION_ID
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    public Integer getEducationId() {
        return educationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reg_education.EDUCATION_ID
     *
     * @param educationId the value for t_reg_education.EDUCATION_ID
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reg_education.EDUCATION_NAME
     *
     * @return the value of t_reg_education.EDUCATION_NAME
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    public String getEducationName() {
        return educationName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reg_education.EDUCATION_NAME
     *
     * @param educationName the value for t_reg_education.EDUCATION_NAME
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    public void setEducationName(String educationName) {
        this.educationName = educationName == null ? null : educationName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_education
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
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
        Education other = (Education) that;
        return (this.getEducationId() == null ? other.getEducationId() == null : this.getEducationId().equals(other.getEducationId()))
            && (this.getEducationName() == null ? other.getEducationName() == null : this.getEducationName().equals(other.getEducationName()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_education
     *
     * @mbggenerated Sun Jun 03 01:05:59 CST 2012
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEducationId() == null) ? 0 : getEducationId().hashCode());
        result = prime * result + ((getEducationName() == null) ? 0 : getEducationName().hashCode());
        return result;
    }
}