package net.cominfo.digiagent.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCriteria {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public ProductCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected ProductCriteria(ProductCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_product
	 * @ibatorgenerated  Mon Sep 27 00:16:04 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_product
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

		public Criteria andProductIdIsNull() {
			addCriterion("PRODUCT_ID is null");
			return this;
		}

		public Criteria andProductIdIsNotNull() {
			addCriterion("PRODUCT_ID is not null");
			return this;
		}

		public Criteria andProductIdEqualTo(Integer value) {
			addCriterion("PRODUCT_ID =", value, "productId");
			return this;
		}

		public Criteria andProductIdNotEqualTo(Integer value) {
			addCriterion("PRODUCT_ID <>", value, "productId");
			return this;
		}

		public Criteria andProductIdGreaterThan(Integer value) {
			addCriterion("PRODUCT_ID >", value, "productId");
			return this;
		}

		public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PRODUCT_ID >=", value, "productId");
			return this;
		}

		public Criteria andProductIdLessThan(Integer value) {
			addCriterion("PRODUCT_ID <", value, "productId");
			return this;
		}

		public Criteria andProductIdLessThanOrEqualTo(Integer value) {
			addCriterion("PRODUCT_ID <=", value, "productId");
			return this;
		}

		public Criteria andProductIdIn(List<Integer> values) {
			addCriterion("PRODUCT_ID in", values, "productId");
			return this;
		}

		public Criteria andProductIdNotIn(List<Integer> values) {
			addCriterion("PRODUCT_ID not in", values, "productId");
			return this;
		}

		public Criteria andProductIdBetween(Integer value1, Integer value2) {
			addCriterion("PRODUCT_ID between", value1, value2, "productId");
			return this;
		}

		public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PRODUCT_ID not between", value1, value2, "productId");
			return this;
		}

		public Criteria andProductNameIsNull() {
			addCriterion("PRODUCT_NAME is null");
			return this;
		}

		public Criteria andProductNameIsNotNull() {
			addCriterion("PRODUCT_NAME is not null");
			return this;
		}

		public Criteria andProductNameEqualTo(String value) {
			addCriterion("PRODUCT_NAME =", value, "productName");
			return this;
		}

		public Criteria andProductNameNotEqualTo(String value) {
			addCriterion("PRODUCT_NAME <>", value, "productName");
			return this;
		}

		public Criteria andProductNameGreaterThan(String value) {
			addCriterion("PRODUCT_NAME >", value, "productName");
			return this;
		}

		public Criteria andProductNameGreaterThanOrEqualTo(String value) {
			addCriterion("PRODUCT_NAME >=", value, "productName");
			return this;
		}

		public Criteria andProductNameLessThan(String value) {
			addCriterion("PRODUCT_NAME <", value, "productName");
			return this;
		}

		public Criteria andProductNameLessThanOrEqualTo(String value) {
			addCriterion("PRODUCT_NAME <=", value, "productName");
			return this;
		}

		public Criteria andProductNameLike(String value) {
			addCriterion("PRODUCT_NAME like", value, "productName");
			return this;
		}

		public Criteria andProductNameNotLike(String value) {
			addCriterion("PRODUCT_NAME not like", value, "productName");
			return this;
		}

		public Criteria andProductNameIn(List<String> values) {
			addCriterion("PRODUCT_NAME in", values, "productName");
			return this;
		}

		public Criteria andProductNameNotIn(List<String> values) {
			addCriterion("PRODUCT_NAME not in", values, "productName");
			return this;
		}

		public Criteria andProductNameBetween(String value1, String value2) {
			addCriterion("PRODUCT_NAME between", value1, value2, "productName");
			return this;
		}

		public Criteria andProductNameNotBetween(String value1, String value2) {
			addCriterion("PRODUCT_NAME not between", value1, value2,
					"productName");
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

		public Criteria andCategoryIdIsNull() {
			addCriterion("CATEGORY_ID is null");
			return this;
		}

		public Criteria andCategoryIdIsNotNull() {
			addCriterion("CATEGORY_ID is not null");
			return this;
		}

		public Criteria andCategoryIdEqualTo(Integer value) {
			addCriterion("CATEGORY_ID =", value, "categoryId");
			return this;
		}

		public Criteria andCategoryIdNotEqualTo(Integer value) {
			addCriterion("CATEGORY_ID <>", value, "categoryId");
			return this;
		}

		public Criteria andCategoryIdGreaterThan(Integer value) {
			addCriterion("CATEGORY_ID >", value, "categoryId");
			return this;
		}

		public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CATEGORY_ID >=", value, "categoryId");
			return this;
		}

		public Criteria andCategoryIdLessThan(Integer value) {
			addCriterion("CATEGORY_ID <", value, "categoryId");
			return this;
		}

		public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("CATEGORY_ID <=", value, "categoryId");
			return this;
		}

		public Criteria andCategoryIdIn(List<Integer> values) {
			addCriterion("CATEGORY_ID in", values, "categoryId");
			return this;
		}

		public Criteria andCategoryIdNotIn(List<Integer> values) {
			addCriterion("CATEGORY_ID not in", values, "categoryId");
			return this;
		}

		public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
			addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
			return this;
		}

		public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CATEGORY_ID not between", value1, value2,
					"categoryId");
			return this;
		}
	}
}