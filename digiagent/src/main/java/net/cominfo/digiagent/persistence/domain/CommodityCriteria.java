package net.cominfo.digiagent.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommodityCriteria {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public CommodityCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected CommodityCriteria(CommodityCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_commodity
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
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

		public Criteria andCommodityIdIsNull() {
			addCriterion("COMMODITY_ID is null");
			return this;
		}

		public Criteria andCommodityIdIsNotNull() {
			addCriterion("COMMODITY_ID is not null");
			return this;
		}

		public Criteria andCommodityIdEqualTo(Integer value) {
			addCriterion("COMMODITY_ID =", value, "commodityId");
			return this;
		}

		public Criteria andCommodityIdNotEqualTo(Integer value) {
			addCriterion("COMMODITY_ID <>", value, "commodityId");
			return this;
		}

		public Criteria andCommodityIdGreaterThan(Integer value) {
			addCriterion("COMMODITY_ID >", value, "commodityId");
			return this;
		}

		public Criteria andCommodityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMMODITY_ID >=", value, "commodityId");
			return this;
		}

		public Criteria andCommodityIdLessThan(Integer value) {
			addCriterion("COMMODITY_ID <", value, "commodityId");
			return this;
		}

		public Criteria andCommodityIdLessThanOrEqualTo(Integer value) {
			addCriterion("COMMODITY_ID <=", value, "commodityId");
			return this;
		}

		public Criteria andCommodityIdIn(List<Integer> values) {
			addCriterion("COMMODITY_ID in", values, "commodityId");
			return this;
		}

		public Criteria andCommodityIdNotIn(List<Integer> values) {
			addCriterion("COMMODITY_ID not in", values, "commodityId");
			return this;
		}

		public Criteria andCommodityIdBetween(Integer value1, Integer value2) {
			addCriterion("COMMODITY_ID between", value1, value2, "commodityId");
			return this;
		}

		public Criteria andCommodityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COMMODITY_ID not between", value1, value2,
					"commodityId");
			return this;
		}

		public Criteria andCommodityNameIsNull() {
			addCriterion("COMMODITY_NAME is null");
			return this;
		}

		public Criteria andCommodityNameIsNotNull() {
			addCriterion("COMMODITY_NAME is not null");
			return this;
		}

		public Criteria andCommodityNameEqualTo(String value) {
			addCriterion("COMMODITY_NAME =", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameNotEqualTo(String value) {
			addCriterion("COMMODITY_NAME <>", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameGreaterThan(String value) {
			addCriterion("COMMODITY_NAME >", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameGreaterThanOrEqualTo(String value) {
			addCriterion("COMMODITY_NAME >=", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameLessThan(String value) {
			addCriterion("COMMODITY_NAME <", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameLessThanOrEqualTo(String value) {
			addCriterion("COMMODITY_NAME <=", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameLike(String value) {
			addCriterion("COMMODITY_NAME like", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameNotLike(String value) {
			addCriterion("COMMODITY_NAME not like", value, "commodityName");
			return this;
		}

		public Criteria andCommodityNameIn(List<String> values) {
			addCriterion("COMMODITY_NAME in", values, "commodityName");
			return this;
		}

		public Criteria andCommodityNameNotIn(List<String> values) {
			addCriterion("COMMODITY_NAME not in", values, "commodityName");
			return this;
		}

		public Criteria andCommodityNameBetween(String value1, String value2) {
			addCriterion("COMMODITY_NAME between", value1, value2,
					"commodityName");
			return this;
		}

		public Criteria andCommodityNameNotBetween(String value1, String value2) {
			addCriterion("COMMODITY_NAME not between", value1, value2,
					"commodityName");
			return this;
		}

		public Criteria andCommodityDescriptionIsNull() {
			addCriterion("COMMODITY_DESCRIPTION is null");
			return this;
		}

		public Criteria andCommodityDescriptionIsNotNull() {
			addCriterion("COMMODITY_DESCRIPTION is not null");
			return this;
		}

		public Criteria andCommodityDescriptionEqualTo(String value) {
			addCriterion("COMMODITY_DESCRIPTION =", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionNotEqualTo(String value) {
			addCriterion("COMMODITY_DESCRIPTION <>", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionGreaterThan(String value) {
			addCriterion("COMMODITY_DESCRIPTION >", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("COMMODITY_DESCRIPTION >=", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionLessThan(String value) {
			addCriterion("COMMODITY_DESCRIPTION <", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionLessThanOrEqualTo(String value) {
			addCriterion("COMMODITY_DESCRIPTION <=", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionLike(String value) {
			addCriterion("COMMODITY_DESCRIPTION like", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionNotLike(String value) {
			addCriterion("COMMODITY_DESCRIPTION not like", value,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionIn(List<String> values) {
			addCriterion("COMMODITY_DESCRIPTION in", values,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionNotIn(List<String> values) {
			addCriterion("COMMODITY_DESCRIPTION not in", values,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionBetween(String value1,
				String value2) {
			addCriterion("COMMODITY_DESCRIPTION between", value1, value2,
					"commodityDescription");
			return this;
		}

		public Criteria andCommodityDescriptionNotBetween(String value1,
				String value2) {
			addCriterion("COMMODITY_DESCRIPTION not between", value1, value2,
					"commodityDescription");
			return this;
		}

		public Criteria andStartDateIsNull() {
			addCriterion("START_DATE is null");
			return this;
		}

		public Criteria andStartDateIsNotNull() {
			addCriterion("START_DATE is not null");
			return this;
		}

		public Criteria andStartDateEqualTo(Date value) {
			addCriterion("START_DATE =", value, "startDate");
			return this;
		}

		public Criteria andStartDateNotEqualTo(Date value) {
			addCriterion("START_DATE <>", value, "startDate");
			return this;
		}

		public Criteria andStartDateGreaterThan(Date value) {
			addCriterion("START_DATE >", value, "startDate");
			return this;
		}

		public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
			addCriterion("START_DATE >=", value, "startDate");
			return this;
		}

		public Criteria andStartDateLessThan(Date value) {
			addCriterion("START_DATE <", value, "startDate");
			return this;
		}

		public Criteria andStartDateLessThanOrEqualTo(Date value) {
			addCriterion("START_DATE <=", value, "startDate");
			return this;
		}

		public Criteria andStartDateIn(List<Date> values) {
			addCriterion("START_DATE in", values, "startDate");
			return this;
		}

		public Criteria andStartDateNotIn(List<Date> values) {
			addCriterion("START_DATE not in", values, "startDate");
			return this;
		}

		public Criteria andStartDateBetween(Date value1, Date value2) {
			addCriterion("START_DATE between", value1, value2, "startDate");
			return this;
		}

		public Criteria andStartDateNotBetween(Date value1, Date value2) {
			addCriterion("START_DATE not between", value1, value2, "startDate");
			return this;
		}

		public Criteria andEndDateIsNull() {
			addCriterion("END_DATE is null");
			return this;
		}

		public Criteria andEndDateIsNotNull() {
			addCriterion("END_DATE is not null");
			return this;
		}

		public Criteria andEndDateEqualTo(Date value) {
			addCriterion("END_DATE =", value, "endDate");
			return this;
		}

		public Criteria andEndDateNotEqualTo(Date value) {
			addCriterion("END_DATE <>", value, "endDate");
			return this;
		}

		public Criteria andEndDateGreaterThan(Date value) {
			addCriterion("END_DATE >", value, "endDate");
			return this;
		}

		public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
			addCriterion("END_DATE >=", value, "endDate");
			return this;
		}

		public Criteria andEndDateLessThan(Date value) {
			addCriterion("END_DATE <", value, "endDate");
			return this;
		}

		public Criteria andEndDateLessThanOrEqualTo(Date value) {
			addCriterion("END_DATE <=", value, "endDate");
			return this;
		}

		public Criteria andEndDateIn(List<Date> values) {
			addCriterion("END_DATE in", values, "endDate");
			return this;
		}

		public Criteria andEndDateNotIn(List<Date> values) {
			addCriterion("END_DATE not in", values, "endDate");
			return this;
		}

		public Criteria andEndDateBetween(Date value1, Date value2) {
			addCriterion("END_DATE between", value1, value2, "endDate");
			return this;
		}

		public Criteria andEndDateNotBetween(Date value1, Date value2) {
			addCriterion("END_DATE not between", value1, value2, "endDate");
			return this;
		}

		public Criteria andCommodityTypeIsNull() {
			addCriterion("COMMODITY_TYPE is null");
			return this;
		}

		public Criteria andCommodityTypeIsNotNull() {
			addCriterion("COMMODITY_TYPE is not null");
			return this;
		}

		public Criteria andCommodityTypeEqualTo(String value) {
			addCriterion("COMMODITY_TYPE =", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeNotEqualTo(String value) {
			addCriterion("COMMODITY_TYPE <>", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeGreaterThan(String value) {
			addCriterion("COMMODITY_TYPE >", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeGreaterThanOrEqualTo(String value) {
			addCriterion("COMMODITY_TYPE >=", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeLessThan(String value) {
			addCriterion("COMMODITY_TYPE <", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeLessThanOrEqualTo(String value) {
			addCriterion("COMMODITY_TYPE <=", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeLike(String value) {
			addCriterion("COMMODITY_TYPE like", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeNotLike(String value) {
			addCriterion("COMMODITY_TYPE not like", value, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeIn(List<String> values) {
			addCriterion("COMMODITY_TYPE in", values, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeNotIn(List<String> values) {
			addCriterion("COMMODITY_TYPE not in", values, "commodityType");
			return this;
		}

		public Criteria andCommodityTypeBetween(String value1, String value2) {
			addCriterion("COMMODITY_TYPE between", value1, value2,
					"commodityType");
			return this;
		}

		public Criteria andCommodityTypeNotBetween(String value1, String value2) {
			addCriterion("COMMODITY_TYPE not between", value1, value2,
					"commodityType");
			return this;
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

		public Criteria andCommodityPriceIsNull() {
			addCriterion("COMMODITY_PRICE is null");
			return this;
		}

		public Criteria andCommodityPriceIsNotNull() {
			addCriterion("COMMODITY_PRICE is not null");
			return this;
		}

		public Criteria andCommodityPriceEqualTo(Float value) {
			addCriterion("COMMODITY_PRICE =", value, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceNotEqualTo(Float value) {
			addCriterion("COMMODITY_PRICE <>", value, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceGreaterThan(Float value) {
			addCriterion("COMMODITY_PRICE >", value, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceGreaterThanOrEqualTo(Float value) {
			addCriterion("COMMODITY_PRICE >=", value, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceLessThan(Float value) {
			addCriterion("COMMODITY_PRICE <", value, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceLessThanOrEqualTo(Float value) {
			addCriterion("COMMODITY_PRICE <=", value, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceIn(List<Float> values) {
			addCriterion("COMMODITY_PRICE in", values, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceNotIn(List<Float> values) {
			addCriterion("COMMODITY_PRICE not in", values, "commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceBetween(Float value1, Float value2) {
			addCriterion("COMMODITY_PRICE between", value1, value2,
					"commodityPrice");
			return this;
		}

		public Criteria andCommodityPriceNotBetween(Float value1, Float value2) {
			addCriterion("COMMODITY_PRICE not between", value1, value2,
					"commodityPrice");
			return this;
		}
	}
}