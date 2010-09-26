package net.cominfo.digiagent.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommodityImageCriteria {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public CommodityImageCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected CommodityImageCriteria(CommodityImageCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_commodityimage
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_commodityimage
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

		public Criteria andCommodityimageIdIsNull() {
			addCriterion("COMMODITYIMAGE_ID is null");
			return this;
		}

		public Criteria andCommodityimageIdIsNotNull() {
			addCriterion("COMMODITYIMAGE_ID is not null");
			return this;
		}

		public Criteria andCommodityimageIdEqualTo(Integer value) {
			addCriterion("COMMODITYIMAGE_ID =", value, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdNotEqualTo(Integer value) {
			addCriterion("COMMODITYIMAGE_ID <>", value, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdGreaterThan(Integer value) {
			addCriterion("COMMODITYIMAGE_ID >", value, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMMODITYIMAGE_ID >=", value, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdLessThan(Integer value) {
			addCriterion("COMMODITYIMAGE_ID <", value, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdLessThanOrEqualTo(Integer value) {
			addCriterion("COMMODITYIMAGE_ID <=", value, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdIn(List<Integer> values) {
			addCriterion("COMMODITYIMAGE_ID in", values, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdNotIn(List<Integer> values) {
			addCriterion("COMMODITYIMAGE_ID not in", values, "commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdBetween(Integer value1,
				Integer value2) {
			addCriterion("COMMODITYIMAGE_ID between", value1, value2,
					"commodityimageId");
			return this;
		}

		public Criteria andCommodityimageIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("COMMODITYIMAGE_ID not between", value1, value2,
					"commodityimageId");
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
	}
}