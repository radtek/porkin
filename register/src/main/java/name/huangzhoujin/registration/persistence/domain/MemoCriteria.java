package name.huangzhoujin.registration.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class MemoCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public MemoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMemoIdIsNull() {
            addCriterion("MEMO_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemoIdIsNotNull() {
            addCriterion("MEMO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemoIdEqualTo(Integer value) {
            addCriterion("MEMO_ID =", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdNotEqualTo(Integer value) {
            addCriterion("MEMO_ID <>", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdGreaterThan(Integer value) {
            addCriterion("MEMO_ID >", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEMO_ID >=", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdLessThan(Integer value) {
            addCriterion("MEMO_ID <", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdLessThanOrEqualTo(Integer value) {
            addCriterion("MEMO_ID <=", value, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdIn(List<Integer> values) {
            addCriterion("MEMO_ID in", values, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdNotIn(List<Integer> values) {
            addCriterion("MEMO_ID not in", values, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdBetween(Integer value1, Integer value2) {
            addCriterion("MEMO_ID between", value1, value2, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MEMO_ID not between", value1, value2, "memoId");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionIsNull() {
            addCriterion("MEMO_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionIsNotNull() {
            addCriterion("MEMO_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionEqualTo(String value) {
            addCriterion("MEMO_DESCRIPTION =", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionNotEqualTo(String value) {
            addCriterion("MEMO_DESCRIPTION <>", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionGreaterThan(String value) {
            addCriterion("MEMO_DESCRIPTION >", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO_DESCRIPTION >=", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionLessThan(String value) {
            addCriterion("MEMO_DESCRIPTION <", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionLessThanOrEqualTo(String value) {
            addCriterion("MEMO_DESCRIPTION <=", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionLike(String value) {
            addCriterion("MEMO_DESCRIPTION like", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionNotLike(String value) {
            addCriterion("MEMO_DESCRIPTION not like", value, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionIn(List<String> values) {
            addCriterion("MEMO_DESCRIPTION in", values, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionNotIn(List<String> values) {
            addCriterion("MEMO_DESCRIPTION not in", values, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionBetween(String value1, String value2) {
            addCriterion("MEMO_DESCRIPTION between", value1, value2, "memoDescription");
            return (Criteria) this;
        }

        public Criteria andMemoDescriptionNotBetween(String value1, String value2) {
            addCriterion("MEMO_DESCRIPTION not between", value1, value2, "memoDescription");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_reg_memo
     *
     * @mbggenerated do_not_delete_during_merge Sat Jun 16 13:27:28 CST 2012
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_reg_memo
     *
     * @mbggenerated Sat Jun 16 13:27:28 CST 2012
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}