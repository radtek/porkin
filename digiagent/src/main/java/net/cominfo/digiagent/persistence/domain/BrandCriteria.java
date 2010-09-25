package net.cominfo.digiagent.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandCriteria {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public BrandCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	protected BrandCriteria(BrandCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_da_brand
	 * @ibatorgenerated  Sat Sep 25 20:48:56 CST 2010
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

		public Criteria andBrandIdIsNull() {
			addCriterion("BRAND_ID is null");
			return this;
		}

		public Criteria andBrandIdIsNotNull() {
			addCriterion("BRAND_ID is not null");
			return this;
		}

		public Criteria andBrandIdEqualTo(Integer value) {
			addCriterion("BRAND_ID =", value, "brandId");
			return this;
		}

		public Criteria andBrandIdNotEqualTo(Integer value) {
			addCriterion("BRAND_ID <>", value, "brandId");
			return this;
		}

		public Criteria andBrandIdGreaterThan(Integer value) {
			addCriterion("BRAND_ID >", value, "brandId");
			return this;
		}

		public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BRAND_ID >=", value, "brandId");
			return this;
		}

		public Criteria andBrandIdLessThan(Integer value) {
			addCriterion("BRAND_ID <", value, "brandId");
			return this;
		}

		public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
			addCriterion("BRAND_ID <=", value, "brandId");
			return this;
		}

		public Criteria andBrandIdIn(List<Integer> values) {
			addCriterion("BRAND_ID in", values, "brandId");
			return this;
		}

		public Criteria andBrandIdNotIn(List<Integer> values) {
			addCriterion("BRAND_ID not in", values, "brandId");
			return this;
		}

		public Criteria andBrandIdBetween(Integer value1, Integer value2) {
			addCriterion("BRAND_ID between", value1, value2, "brandId");
			return this;
		}

		public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BRAND_ID not between", value1, value2, "brandId");
			return this;
		}

		public Criteria andBrandNameIsNull() {
			addCriterion("BRAND_NAME is null");
			return this;
		}

		public Criteria andBrandNameIsNotNull() {
			addCriterion("BRAND_NAME is not null");
			return this;
		}

		public Criteria andBrandNameEqualTo(String value) {
			addCriterion("BRAND_NAME =", value, "brandName");
			return this;
		}

		public Criteria andBrandNameNotEqualTo(String value) {
			addCriterion("BRAND_NAME <>", value, "brandName");
			return this;
		}

		public Criteria andBrandNameGreaterThan(String value) {
			addCriterion("BRAND_NAME >", value, "brandName");
			return this;
		}

		public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
			addCriterion("BRAND_NAME >=", value, "brandName");
			return this;
		}

		public Criteria andBrandNameLessThan(String value) {
			addCriterion("BRAND_NAME <", value, "brandName");
			return this;
		}

		public Criteria andBrandNameLessThanOrEqualTo(String value) {
			addCriterion("BRAND_NAME <=", value, "brandName");
			return this;
		}

		public Criteria andBrandNameLike(String value) {
			addCriterion("BRAND_NAME like", value, "brandName");
			return this;
		}

		public Criteria andBrandNameNotLike(String value) {
			addCriterion("BRAND_NAME not like", value, "brandName");
			return this;
		}

		public Criteria andBrandNameIn(List<String> values) {
			addCriterion("BRAND_NAME in", values, "brandName");
			return this;
		}

		public Criteria andBrandNameNotIn(List<String> values) {
			addCriterion("BRAND_NAME not in", values, "brandName");
			return this;
		}

		public Criteria andBrandNameBetween(String value1, String value2) {
			addCriterion("BRAND_NAME between", value1, value2, "brandName");
			return this;
		}

		public Criteria andBrandNameNotBetween(String value1, String value2) {
			addCriterion("BRAND_NAME not between", value1, value2, "brandName");
			return this;
		}

		public Criteria andBrandEnglishIsNull() {
			addCriterion("BRAND_ENGLISH is null");
			return this;
		}

		public Criteria andBrandEnglishIsNotNull() {
			addCriterion("BRAND_ENGLISH is not null");
			return this;
		}

		public Criteria andBrandEnglishEqualTo(String value) {
			addCriterion("BRAND_ENGLISH =", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishNotEqualTo(String value) {
			addCriterion("BRAND_ENGLISH <>", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishGreaterThan(String value) {
			addCriterion("BRAND_ENGLISH >", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishGreaterThanOrEqualTo(String value) {
			addCriterion("BRAND_ENGLISH >=", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishLessThan(String value) {
			addCriterion("BRAND_ENGLISH <", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishLessThanOrEqualTo(String value) {
			addCriterion("BRAND_ENGLISH <=", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishLike(String value) {
			addCriterion("BRAND_ENGLISH like", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishNotLike(String value) {
			addCriterion("BRAND_ENGLISH not like", value, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishIn(List<String> values) {
			addCriterion("BRAND_ENGLISH in", values, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishNotIn(List<String> values) {
			addCriterion("BRAND_ENGLISH not in", values, "brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishBetween(String value1, String value2) {
			addCriterion("BRAND_ENGLISH between", value1, value2,
					"brandEnglish");
			return this;
		}

		public Criteria andBrandEnglishNotBetween(String value1, String value2) {
			addCriterion("BRAND_ENGLISH not between", value1, value2,
					"brandEnglish");
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

		public Criteria andCountryIdIsNull() {
			addCriterion("COUNTRY_ID is null");
			return this;
		}

		public Criteria andCountryIdIsNotNull() {
			addCriterion("COUNTRY_ID is not null");
			return this;
		}

		public Criteria andCountryIdEqualTo(Integer value) {
			addCriterion("COUNTRY_ID =", value, "countryId");
			return this;
		}

		public Criteria andCountryIdNotEqualTo(Integer value) {
			addCriterion("COUNTRY_ID <>", value, "countryId");
			return this;
		}

		public Criteria andCountryIdGreaterThan(Integer value) {
			addCriterion("COUNTRY_ID >", value, "countryId");
			return this;
		}

		public Criteria andCountryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COUNTRY_ID >=", value, "countryId");
			return this;
		}

		public Criteria andCountryIdLessThan(Integer value) {
			addCriterion("COUNTRY_ID <", value, "countryId");
			return this;
		}

		public Criteria andCountryIdLessThanOrEqualTo(Integer value) {
			addCriterion("COUNTRY_ID <=", value, "countryId");
			return this;
		}

		public Criteria andCountryIdIn(List<Integer> values) {
			addCriterion("COUNTRY_ID in", values, "countryId");
			return this;
		}

		public Criteria andCountryIdNotIn(List<Integer> values) {
			addCriterion("COUNTRY_ID not in", values, "countryId");
			return this;
		}

		public Criteria andCountryIdBetween(Integer value1, Integer value2) {
			addCriterion("COUNTRY_ID between", value1, value2, "countryId");
			return this;
		}

		public Criteria andCountryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COUNTRY_ID not between", value1, value2, "countryId");
			return this;
		}
	}
}