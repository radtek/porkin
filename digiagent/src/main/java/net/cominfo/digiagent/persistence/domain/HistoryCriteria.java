package net.cominfo.digiagent.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryCriteria {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public HistoryCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	protected HistoryCriteria(HistoryCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_history
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public static class Criteria {
		protected List<String> criteriaWithoutValue;
		protected List<Map<String, Object>> criteriaWithSingleValue;
		protected List<Map<String, Object>> criteriaWithListValue;
		protected List<Map<String, Object>> criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList<String>();
			criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
			criteriaWithListValue = new ArrayList<Map<String, Object>>();
			criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List<String> getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List<Map<String, Object>> getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List<Map<String, Object>> getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List<Map<String, Object>> getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition,
				List<? extends Object> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(value1);
			list.add(value2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andHistoryIdIsNull() {
			addCriterion("HISTORY_ID is null");
			return this;
		}

		public Criteria andHistoryIdIsNotNull() {
			addCriterion("HISTORY_ID is not null");
			return this;
		}

		public Criteria andHistoryIdEqualTo(Integer value) {
			addCriterion("HISTORY_ID =", value, "historyId");
			return this;
		}

		public Criteria andHistoryIdNotEqualTo(Integer value) {
			addCriterion("HISTORY_ID <>", value, "historyId");
			return this;
		}

		public Criteria andHistoryIdGreaterThan(Integer value) {
			addCriterion("HISTORY_ID >", value, "historyId");
			return this;
		}

		public Criteria andHistoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("HISTORY_ID >=", value, "historyId");
			return this;
		}

		public Criteria andHistoryIdLessThan(Integer value) {
			addCriterion("HISTORY_ID <", value, "historyId");
			return this;
		}

		public Criteria andHistoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("HISTORY_ID <=", value, "historyId");
			return this;
		}

		public Criteria andHistoryIdIn(List<Integer> values) {
			addCriterion("HISTORY_ID in", values, "historyId");
			return this;
		}

		public Criteria andHistoryIdNotIn(List<Integer> values) {
			addCriterion("HISTORY_ID not in", values, "historyId");
			return this;
		}

		public Criteria andHistoryIdBetween(Integer value1, Integer value2) {
			addCriterion("HISTORY_ID between", value1, value2, "historyId");
			return this;
		}

		public Criteria andHistoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("HISTORY_ID not between", value1, value2, "historyId");
			return this;
		}

		public Criteria andHistoryTypeIsNull() {
			addCriterion("HISTORY_TYPE is null");
			return this;
		}

		public Criteria andHistoryTypeIsNotNull() {
			addCriterion("HISTORY_TYPE is not null");
			return this;
		}

		public Criteria andHistoryTypeEqualTo(String value) {
			addCriterion("HISTORY_TYPE =", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeNotEqualTo(String value) {
			addCriterion("HISTORY_TYPE <>", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeGreaterThan(String value) {
			addCriterion("HISTORY_TYPE >", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeGreaterThanOrEqualTo(String value) {
			addCriterion("HISTORY_TYPE >=", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeLessThan(String value) {
			addCriterion("HISTORY_TYPE <", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeLessThanOrEqualTo(String value) {
			addCriterion("HISTORY_TYPE <=", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeLike(String value) {
			addCriterion("HISTORY_TYPE like", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeNotLike(String value) {
			addCriterion("HISTORY_TYPE not like", value, "historyType");
			return this;
		}

		public Criteria andHistoryTypeIn(List<String> values) {
			addCriterion("HISTORY_TYPE in", values, "historyType");
			return this;
		}

		public Criteria andHistoryTypeNotIn(List<String> values) {
			addCriterion("HISTORY_TYPE not in", values, "historyType");
			return this;
		}

		public Criteria andHistoryTypeBetween(String value1, String value2) {
			addCriterion("HISTORY_TYPE between", value1, value2, "historyType");
			return this;
		}

		public Criteria andHistoryTypeNotBetween(String value1, String value2) {
			addCriterion("HISTORY_TYPE not between", value1, value2,
					"historyType");
			return this;
		}

		public Criteria andHistoryTypeidIsNull() {
			addCriterion("HISTORY_TYPEID is null");
			return this;
		}

		public Criteria andHistoryTypeidIsNotNull() {
			addCriterion("HISTORY_TYPEID is not null");
			return this;
		}

		public Criteria andHistoryTypeidEqualTo(Integer value) {
			addCriterion("HISTORY_TYPEID =", value, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidNotEqualTo(Integer value) {
			addCriterion("HISTORY_TYPEID <>", value, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidGreaterThan(Integer value) {
			addCriterion("HISTORY_TYPEID >", value, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidGreaterThanOrEqualTo(Integer value) {
			addCriterion("HISTORY_TYPEID >=", value, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidLessThan(Integer value) {
			addCriterion("HISTORY_TYPEID <", value, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidLessThanOrEqualTo(Integer value) {
			addCriterion("HISTORY_TYPEID <=", value, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidIn(List<Integer> values) {
			addCriterion("HISTORY_TYPEID in", values, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidNotIn(List<Integer> values) {
			addCriterion("HISTORY_TYPEID not in", values, "historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidBetween(Integer value1, Integer value2) {
			addCriterion("HISTORY_TYPEID between", value1, value2,
					"historyTypeid");
			return this;
		}

		public Criteria andHistoryTypeidNotBetween(Integer value1,
				Integer value2) {
			addCriterion("HISTORY_TYPEID not between", value1, value2,
					"historyTypeid");
			return this;
		}

		public Criteria andHistoryAccessdateIsNull() {
			addCriterion("HISTORY_ACCESSDATE is null");
			return this;
		}

		public Criteria andHistoryAccessdateIsNotNull() {
			addCriterion("HISTORY_ACCESSDATE is not null");
			return this;
		}

		public Criteria andHistoryAccessdateEqualTo(Date value) {
			addCriterion("HISTORY_ACCESSDATE =", value, "historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateNotEqualTo(Date value) {
			addCriterion("HISTORY_ACCESSDATE <>", value, "historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateGreaterThan(Date value) {
			addCriterion("HISTORY_ACCESSDATE >", value, "historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateGreaterThanOrEqualTo(Date value) {
			addCriterion("HISTORY_ACCESSDATE >=", value, "historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateLessThan(Date value) {
			addCriterion("HISTORY_ACCESSDATE <", value, "historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateLessThanOrEqualTo(Date value) {
			addCriterion("HISTORY_ACCESSDATE <=", value, "historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateIn(List<Date> values) {
			addCriterion("HISTORY_ACCESSDATE in", values, "historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateNotIn(List<Date> values) {
			addCriterion("HISTORY_ACCESSDATE not in", values,
					"historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateBetween(Date value1, Date value2) {
			addCriterion("HISTORY_ACCESSDATE between", value1, value2,
					"historyAccessdate");
			return this;
		}

		public Criteria andHistoryAccessdateNotBetween(Date value1, Date value2) {
			addCriterion("HISTORY_ACCESSDATE not between", value1, value2,
					"historyAccessdate");
			return this;
		}

		public Criteria andHistoryFromipIsNull() {
			addCriterion("HISTORY_FROMIP is null");
			return this;
		}

		public Criteria andHistoryFromipIsNotNull() {
			addCriterion("HISTORY_FROMIP is not null");
			return this;
		}

		public Criteria andHistoryFromipEqualTo(String value) {
			addCriterion("HISTORY_FROMIP =", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipNotEqualTo(String value) {
			addCriterion("HISTORY_FROMIP <>", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipGreaterThan(String value) {
			addCriterion("HISTORY_FROMIP >", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipGreaterThanOrEqualTo(String value) {
			addCriterion("HISTORY_FROMIP >=", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipLessThan(String value) {
			addCriterion("HISTORY_FROMIP <", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipLessThanOrEqualTo(String value) {
			addCriterion("HISTORY_FROMIP <=", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipLike(String value) {
			addCriterion("HISTORY_FROMIP like", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipNotLike(String value) {
			addCriterion("HISTORY_FROMIP not like", value, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipIn(List<String> values) {
			addCriterion("HISTORY_FROMIP in", values, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipNotIn(List<String> values) {
			addCriterion("HISTORY_FROMIP not in", values, "historyFromip");
			return this;
		}

		public Criteria andHistoryFromipBetween(String value1, String value2) {
			addCriterion("HISTORY_FROMIP between", value1, value2,
					"historyFromip");
			return this;
		}

		public Criteria andHistoryFromipNotBetween(String value1, String value2) {
			addCriterion("HISTORY_FROMIP not between", value1, value2,
					"historyFromip");
			return this;
		}
	}
}