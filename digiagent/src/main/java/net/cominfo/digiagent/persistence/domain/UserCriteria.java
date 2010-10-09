package net.cominfo.digiagent.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCriteria {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public UserCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	protected UserCriteria(UserCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_user
	 * @ibatorgenerated  Sat Oct 09 22:21:31 CST 2010
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

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("USER_ID =", value, "userId");
			return this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("USER_ID <>", value, "userId");
			return this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("USER_ID >", value, "userId");
			return this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_ID >=", value, "userId");
			return this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("USER_ID <", value, "userId");
			return this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("USER_ID <=", value, "userId");
			return this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("USER_ID in", values, "userId");
			return this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("USER_ID not in", values, "userId");
			return this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
			return this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("USER_NAME is null");
			return this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("USER_NAME is not null");
			return this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("USER_NAME =", value, "userName");
			return this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("USER_NAME <>", value, "userName");
			return this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("USER_NAME >", value, "userName");
			return this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NAME >=", value, "userName");
			return this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("USER_NAME <", value, "userName");
			return this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("USER_NAME <=", value, "userName");
			return this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("USER_NAME like", value, "userName");
			return this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("USER_NAME not like", value, "userName");
			return this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("USER_NAME in", values, "userName");
			return this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("USER_NAME not in", values, "userName");
			return this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("USER_NAME between", value1, value2, "userName");
			return this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("USER_NAME not between", value1, value2, "userName");
			return this;
		}

		public Criteria andUserEmailIsNull() {
			addCriterion("USER_EMAIL is null");
			return this;
		}

		public Criteria andUserEmailIsNotNull() {
			addCriterion("USER_EMAIL is not null");
			return this;
		}

		public Criteria andUserEmailEqualTo(String value) {
			addCriterion("USER_EMAIL =", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotEqualTo(String value) {
			addCriterion("USER_EMAIL <>", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailGreaterThan(String value) {
			addCriterion("USER_EMAIL >", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
			addCriterion("USER_EMAIL >=", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailLessThan(String value) {
			addCriterion("USER_EMAIL <", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailLessThanOrEqualTo(String value) {
			addCriterion("USER_EMAIL <=", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailLike(String value) {
			addCriterion("USER_EMAIL like", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotLike(String value) {
			addCriterion("USER_EMAIL not like", value, "userEmail");
			return this;
		}

		public Criteria andUserEmailIn(List<String> values) {
			addCriterion("USER_EMAIL in", values, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotIn(List<String> values) {
			addCriterion("USER_EMAIL not in", values, "userEmail");
			return this;
		}

		public Criteria andUserEmailBetween(String value1, String value2) {
			addCriterion("USER_EMAIL between", value1, value2, "userEmail");
			return this;
		}

		public Criteria andUserEmailNotBetween(String value1, String value2) {
			addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
			return this;
		}

		public Criteria andUserPasswordIsNull() {
			addCriterion("USER_PASSWORD is null");
			return this;
		}

		public Criteria andUserPasswordIsNotNull() {
			addCriterion("USER_PASSWORD is not null");
			return this;
		}

		public Criteria andUserPasswordEqualTo(String value) {
			addCriterion("USER_PASSWORD =", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordNotEqualTo(String value) {
			addCriterion("USER_PASSWORD <>", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordGreaterThan(String value) {
			addCriterion("USER_PASSWORD >", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("USER_PASSWORD >=", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordLessThan(String value) {
			addCriterion("USER_PASSWORD <", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordLessThanOrEqualTo(String value) {
			addCriterion("USER_PASSWORD <=", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordLike(String value) {
			addCriterion("USER_PASSWORD like", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordNotLike(String value) {
			addCriterion("USER_PASSWORD not like", value, "userPassword");
			return this;
		}

		public Criteria andUserPasswordIn(List<String> values) {
			addCriterion("USER_PASSWORD in", values, "userPassword");
			return this;
		}

		public Criteria andUserPasswordNotIn(List<String> values) {
			addCriterion("USER_PASSWORD not in", values, "userPassword");
			return this;
		}

		public Criteria andUserPasswordBetween(String value1, String value2) {
			addCriterion("USER_PASSWORD between", value1, value2,
					"userPassword");
			return this;
		}

		public Criteria andUserPasswordNotBetween(String value1, String value2) {
			addCriterion("USER_PASSWORD not between", value1, value2,
					"userPassword");
			return this;
		}

		public Criteria andLastlogintimeIsNull() {
			addCriterion("LASTLOGINTIME is null");
			return this;
		}

		public Criteria andLastlogintimeIsNotNull() {
			addCriterion("LASTLOGINTIME is not null");
			return this;
		}

		public Criteria andLastlogintimeEqualTo(Date value) {
			addCriterion("LASTLOGINTIME =", value, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeNotEqualTo(Date value) {
			addCriterion("LASTLOGINTIME <>", value, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeGreaterThan(Date value) {
			addCriterion("LASTLOGINTIME >", value, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LASTLOGINTIME >=", value, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeLessThan(Date value) {
			addCriterion("LASTLOGINTIME <", value, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeLessThanOrEqualTo(Date value) {
			addCriterion("LASTLOGINTIME <=", value, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeIn(List<Date> values) {
			addCriterion("LASTLOGINTIME in", values, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeNotIn(List<Date> values) {
			addCriterion("LASTLOGINTIME not in", values, "lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeBetween(Date value1, Date value2) {
			addCriterion("LASTLOGINTIME between", value1, value2,
					"lastlogintime");
			return this;
		}

		public Criteria andLastlogintimeNotBetween(Date value1, Date value2) {
			addCriterion("LASTLOGINTIME not between", value1, value2,
					"lastlogintime");
			return this;
		}

		public Criteria andRegistertimeIsNull() {
			addCriterion("REGISTERTIME is null");
			return this;
		}

		public Criteria andRegistertimeIsNotNull() {
			addCriterion("REGISTERTIME is not null");
			return this;
		}

		public Criteria andRegistertimeEqualTo(Date value) {
			addCriterion("REGISTERTIME =", value, "registertime");
			return this;
		}

		public Criteria andRegistertimeNotEqualTo(Date value) {
			addCriterion("REGISTERTIME <>", value, "registertime");
			return this;
		}

		public Criteria andRegistertimeGreaterThan(Date value) {
			addCriterion("REGISTERTIME >", value, "registertime");
			return this;
		}

		public Criteria andRegistertimeGreaterThanOrEqualTo(Date value) {
			addCriterion("REGISTERTIME >=", value, "registertime");
			return this;
		}

		public Criteria andRegistertimeLessThan(Date value) {
			addCriterion("REGISTERTIME <", value, "registertime");
			return this;
		}

		public Criteria andRegistertimeLessThanOrEqualTo(Date value) {
			addCriterion("REGISTERTIME <=", value, "registertime");
			return this;
		}

		public Criteria andRegistertimeIn(List<Date> values) {
			addCriterion("REGISTERTIME in", values, "registertime");
			return this;
		}

		public Criteria andRegistertimeNotIn(List<Date> values) {
			addCriterion("REGISTERTIME not in", values, "registertime");
			return this;
		}

		public Criteria andRegistertimeBetween(Date value1, Date value2) {
			addCriterion("REGISTERTIME between", value1, value2, "registertime");
			return this;
		}

		public Criteria andRegistertimeNotBetween(Date value1, Date value2) {
			addCriterion("REGISTERTIME not between", value1, value2,
					"registertime");
			return this;
		}

		public Criteria andLogonsumIsNull() {
			addCriterion("LOGONSUM is null");
			return this;
		}

		public Criteria andLogonsumIsNotNull() {
			addCriterion("LOGONSUM is not null");
			return this;
		}

		public Criteria andLogonsumEqualTo(Integer value) {
			addCriterion("LOGONSUM =", value, "logonsum");
			return this;
		}

		public Criteria andLogonsumNotEqualTo(Integer value) {
			addCriterion("LOGONSUM <>", value, "logonsum");
			return this;
		}

		public Criteria andLogonsumGreaterThan(Integer value) {
			addCriterion("LOGONSUM >", value, "logonsum");
			return this;
		}

		public Criteria andLogonsumGreaterThanOrEqualTo(Integer value) {
			addCriterion("LOGONSUM >=", value, "logonsum");
			return this;
		}

		public Criteria andLogonsumLessThan(Integer value) {
			addCriterion("LOGONSUM <", value, "logonsum");
			return this;
		}

		public Criteria andLogonsumLessThanOrEqualTo(Integer value) {
			addCriterion("LOGONSUM <=", value, "logonsum");
			return this;
		}

		public Criteria andLogonsumIn(List<Integer> values) {
			addCriterion("LOGONSUM in", values, "logonsum");
			return this;
		}

		public Criteria andLogonsumNotIn(List<Integer> values) {
			addCriterion("LOGONSUM not in", values, "logonsum");
			return this;
		}

		public Criteria andLogonsumBetween(Integer value1, Integer value2) {
			addCriterion("LOGONSUM between", value1, value2, "logonsum");
			return this;
		}

		public Criteria andLogonsumNotBetween(Integer value1, Integer value2) {
			addCriterion("LOGONSUM not between", value1, value2, "logonsum");
			return this;
		}

		public Criteria andCreatedByIsNull() {
			addCriterion("CREATED_BY is null");
			return this;
		}

		public Criteria andCreatedByIsNotNull() {
			addCriterion("CREATED_BY is not null");
			return this;
		}

		public Criteria andCreatedByEqualTo(String value) {
			addCriterion("CREATED_BY =", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByNotEqualTo(String value) {
			addCriterion("CREATED_BY <>", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByGreaterThan(String value) {
			addCriterion("CREATED_BY >", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
			addCriterion("CREATED_BY >=", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByLessThan(String value) {
			addCriterion("CREATED_BY <", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByLessThanOrEqualTo(String value) {
			addCriterion("CREATED_BY <=", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByLike(String value) {
			addCriterion("CREATED_BY like", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByNotLike(String value) {
			addCriterion("CREATED_BY not like", value, "createdBy");
			return this;
		}

		public Criteria andCreatedByIn(List<String> values) {
			addCriterion("CREATED_BY in", values, "createdBy");
			return this;
		}

		public Criteria andCreatedByNotIn(List<String> values) {
			addCriterion("CREATED_BY not in", values, "createdBy");
			return this;
		}

		public Criteria andCreatedByBetween(String value1, String value2) {
			addCriterion("CREATED_BY between", value1, value2, "createdBy");
			return this;
		}

		public Criteria andCreatedByNotBetween(String value1, String value2) {
			addCriterion("CREATED_BY not between", value1, value2, "createdBy");
			return this;
		}

		public Criteria andCreatedDateIsNull() {
			addCriterion("CREATED_DATE is null");
			return this;
		}

		public Criteria andCreatedDateIsNotNull() {
			addCriterion("CREATED_DATE is not null");
			return this;
		}

		public Criteria andCreatedDateEqualTo(Date value) {
			addCriterion("CREATED_DATE =", value, "createdDate");
			return this;
		}

		public Criteria andCreatedDateNotEqualTo(Date value) {
			addCriterion("CREATED_DATE <>", value, "createdDate");
			return this;
		}

		public Criteria andCreatedDateGreaterThan(Date value) {
			addCriterion("CREATED_DATE >", value, "createdDate");
			return this;
		}

		public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATED_DATE >=", value, "createdDate");
			return this;
		}

		public Criteria andCreatedDateLessThan(Date value) {
			addCriterion("CREATED_DATE <", value, "createdDate");
			return this;
		}

		public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
			addCriterion("CREATED_DATE <=", value, "createdDate");
			return this;
		}

		public Criteria andCreatedDateIn(List<Date> values) {
			addCriterion("CREATED_DATE in", values, "createdDate");
			return this;
		}

		public Criteria andCreatedDateNotIn(List<Date> values) {
			addCriterion("CREATED_DATE not in", values, "createdDate");
			return this;
		}

		public Criteria andCreatedDateBetween(Date value1, Date value2) {
			addCriterion("CREATED_DATE between", value1, value2, "createdDate");
			return this;
		}

		public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
			addCriterion("CREATED_DATE not between", value1, value2,
					"createdDate");
			return this;
		}

		public Criteria andLastupdatedByIsNull() {
			addCriterion("LASTUPDATED_BY is null");
			return this;
		}

		public Criteria andLastupdatedByIsNotNull() {
			addCriterion("LASTUPDATED_BY is not null");
			return this;
		}

		public Criteria andLastupdatedByEqualTo(String value) {
			addCriterion("LASTUPDATED_BY =", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByNotEqualTo(String value) {
			addCriterion("LASTUPDATED_BY <>", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByGreaterThan(String value) {
			addCriterion("LASTUPDATED_BY >", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByGreaterThanOrEqualTo(String value) {
			addCriterion("LASTUPDATED_BY >=", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByLessThan(String value) {
			addCriterion("LASTUPDATED_BY <", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByLessThanOrEqualTo(String value) {
			addCriterion("LASTUPDATED_BY <=", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByLike(String value) {
			addCriterion("LASTUPDATED_BY like", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByNotLike(String value) {
			addCriterion("LASTUPDATED_BY not like", value, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByIn(List<String> values) {
			addCriterion("LASTUPDATED_BY in", values, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByNotIn(List<String> values) {
			addCriterion("LASTUPDATED_BY not in", values, "lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByBetween(String value1, String value2) {
			addCriterion("LASTUPDATED_BY between", value1, value2,
					"lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedByNotBetween(String value1, String value2) {
			addCriterion("LASTUPDATED_BY not between", value1, value2,
					"lastupdatedBy");
			return this;
		}

		public Criteria andLastupdatedDateIsNull() {
			addCriterion("LASTUPDATED_DATE is null");
			return this;
		}

		public Criteria andLastupdatedDateIsNotNull() {
			addCriterion("LASTUPDATED_DATE is not null");
			return this;
		}

		public Criteria andLastupdatedDateEqualTo(Date value) {
			addCriterion("LASTUPDATED_DATE =", value, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateNotEqualTo(Date value) {
			addCriterion("LASTUPDATED_DATE <>", value, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateGreaterThan(Date value) {
			addCriterion("LASTUPDATED_DATE >", value, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("LASTUPDATED_DATE >=", value, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateLessThan(Date value) {
			addCriterion("LASTUPDATED_DATE <", value, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateLessThanOrEqualTo(Date value) {
			addCriterion("LASTUPDATED_DATE <=", value, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateIn(List<Date> values) {
			addCriterion("LASTUPDATED_DATE in", values, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateNotIn(List<Date> values) {
			addCriterion("LASTUPDATED_DATE not in", values, "lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateBetween(Date value1, Date value2) {
			addCriterion("LASTUPDATED_DATE between", value1, value2,
					"lastupdatedDate");
			return this;
		}

		public Criteria andLastupdatedDateNotBetween(Date value1, Date value2) {
			addCriterion("LASTUPDATED_DATE not between", value1, value2,
					"lastupdatedDate");
			return this;
		}

		public Criteria andActiveFlagIsNull() {
			addCriterion("ACTIVE_FLAG is null");
			return this;
		}

		public Criteria andActiveFlagIsNotNull() {
			addCriterion("ACTIVE_FLAG is not null");
			return this;
		}

		public Criteria andActiveFlagEqualTo(String value) {
			addCriterion("ACTIVE_FLAG =", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagNotEqualTo(String value) {
			addCriterion("ACTIVE_FLAG <>", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagGreaterThan(String value) {
			addCriterion("ACTIVE_FLAG >", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagGreaterThanOrEqualTo(String value) {
			addCriterion("ACTIVE_FLAG >=", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagLessThan(String value) {
			addCriterion("ACTIVE_FLAG <", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagLessThanOrEqualTo(String value) {
			addCriterion("ACTIVE_FLAG <=", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagLike(String value) {
			addCriterion("ACTIVE_FLAG like", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagNotLike(String value) {
			addCriterion("ACTIVE_FLAG not like", value, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagIn(List<String> values) {
			addCriterion("ACTIVE_FLAG in", values, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagNotIn(List<String> values) {
			addCriterion("ACTIVE_FLAG not in", values, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagBetween(String value1, String value2) {
			addCriterion("ACTIVE_FLAG between", value1, value2, "activeFlag");
			return this;
		}

		public Criteria andActiveFlagNotBetween(String value1, String value2) {
			addCriterion("ACTIVE_FLAG not between", value1, value2,
					"activeFlag");
			return this;
		}
	}
}