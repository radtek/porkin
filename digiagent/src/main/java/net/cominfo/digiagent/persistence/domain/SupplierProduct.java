package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;

public class SupplierProduct implements Serializable {

	private static final long serialVersionUID = -7732141286664910567L;
	
	private Integer supplierId;
	private String supplierName;
	private Integer cityId;
	private String cityName;
	private String cityAbbreviation;
	private Integer province_id;
	private String provinceName;
	private String provinceAbbreviation;
	private Integer productId;
	private String productName;
	private Integer categoryId;
	private String categoryName;
	private Integer brandId;
	private String brandName;
	private String brandEnglish;
	private Integer countryId;
	private String countryName;
	private String countryAbbreviation;
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityAbbreviation() {
		return cityAbbreviation;
	}
	public void setCityAbbreviation(String cityAbbreviation) {
		this.cityAbbreviation = cityAbbreviation;
	}
	public Integer getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Integer provinceId) {
		province_id = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getProvinceAbbreviation() {
		return provinceAbbreviation;
	}
	public void setProvinceAbbreviation(String provinceAbbreviation) {
		this.provinceAbbreviation = provinceAbbreviation;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandEnglish() {
		return brandEnglish;
	}
	public void setBrandEnglish(String brandEnglish) {
		this.brandEnglish = brandEnglish;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryAbbreviation() {
		return countryAbbreviation;
	}
	public void setCountryAbbreviation(String countryAbbreviation) {
		this.countryAbbreviation = countryAbbreviation;
	}
	
	
	
}
