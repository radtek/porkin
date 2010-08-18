package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.BrandDao;
import net.cominfo.digiagent.persistence.dao.CountryDao;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.BrandCriteria;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.persistence.domain.CountryCriteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BrandService {

	@Autowired
	private BrandDao brandDao;
	@Autowired
	private CountryDao countryDao;

	public int countBrand() {
		return brandDao.countByExample(new BrandCriteria());
	}
	
	public Brand getById(Integer id){
		return brandDao.selectByPrimaryKey(id);
	}
	
	public String getCountryList() {
		CountryCriteria example = new CountryCriteria();
		net.cominfo.digiagent.persistence.domain.CountryCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		example.setOrderByClause("COUNTRY_NAME");
		List<Country> countryList = countryDao.selectByExample(example);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		for (Country country : countryList) {
			buffer.append("<option value='");
			buffer.append(country.getCountryId());
			buffer.append("'>");
			buffer.append(country.getCountryName());
			buffer.append("</option>");
		}
		return buffer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<Brand> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Brand> page = new Page<Brand>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("COUNTRY_NAME,BRAND_NAME");
		page.setOrder("ASC,ASC");
		page.setParam(param);
		return (List<Brand>) brandDao.findPage(page, "t_da_brand_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<Brand> page = new Page<Brand>();
		page.setParam(param);
		return brandDao.count(page, "t_da_brand_Custom.countByCondition");
	}
	
	public Brand insert(Brand brand) {
		brand = validateBrandName(brand);
		if (brand.getBrandId() != null) {
			return brand;
		} else {
			brand.setCreatedBy("sj");
			brand.setCreatedDate(new Date());
			brand.setLastupdatedBy("sj");
			brand.setLastupdatedDate(new Date());
			brandDao.insert(brand);
			return brand;
		}
	}
	
	public Brand update(Brand brand) {
		brand = validateBrandName(brand);
		if (brand.getBrandId() == -1) {
			return brand;
		} else {
			brand.setLastupdatedBy("sj");
			brand.setLastupdatedDate(new Date());
			brandDao.updateByPrimaryKey(brand);
			return brand;
		}
	}
	
	public void delete(Integer id){
		brandDao.deleteByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	private Brand validateBrandName(Brand brand) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("countryId", brand.getCountryId());
		paramMap.put("brandName", brand.getBrandName());
		if (brand.getBrandId() != null) {
			paramMap.put("brandId",brand.getBrandId());
		}
		List<Map> list = brandDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			brand.setBrandId(-1);
			return brand;
		} else {
			return brand;
		}
	}
}
