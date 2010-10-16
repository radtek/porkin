package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.BrandDao;
import net.cominfo.digiagent.persistence.dao.CountryDao;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.BrandCriteria;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.persistence.domain.CountryCriteria;
import net.cominfo.digiagent.persistence.domain.CountryCriteria.Criteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private BrandDao brandDao;

	public int countCountry() {
		return countryDao.countByExample(new CountryCriteria());
	}
	
	public Country getById(Integer id){
		return countryDao.selectByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Country> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Country> page = new Page<Country>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("COUNTRY_ABBREVIATION");
		page.setOrder("ASC");
		page.setParam(param);
		return (List<Country>) countryDao.findPage(page, "t_da_country_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<Country> page = new Page<Country>();
		page.setParam(param);
		return countryDao.count(page, "t_da_country_Custom.countByCondition");
	}
	
	public Country insert(Country country,String userName) {
		country = validateCountryName(country);
		if (country.getCountryId() != null) {
			return country;
		} else {
			country.setCreatedBy(userName);
			country.setCreatedDate(new Date());
			country.setLastupdatedBy(userName);
			country.setLastupdatedDate(new Date());
			countryDao.insert(country);
			return country;
		}
	}
	
	public List<Country> getAllCountry(){
		CountryCriteria example = new CountryCriteria();
		example.createCriteria();
		return countryDao.selectByExample(example);
	}
	
	public Country update(Country country,String userName) {
		country = validateCountryName(country);
		if (country.getCountryId() == -1) {
			return country;
		} else {
			country.setLastupdatedBy(userName);
			country.setLastupdatedDate(new Date());
			countryDao.updateByPrimaryKey(country);
			return country;
		}
	}
	
	public String delete(Integer id){
		// 是否有品牌关联
		if (isReferenceBrand(id)) {
			return "reference";
		} else {
			countryDao.deleteByPrimaryKey(id);
			return "success";
		}
	}
	
	private Country validateCountryName(Country country) {
		CountryCriteria example = new CountryCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCountryNameEqualTo(country.getCountryName());
		if (country.getCountryId() != null) {
			criteria.andCountryIdNotEqualTo(country.getCountryId());
		}
		List<Country> list = countryDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			country.setCountryId(-1);
			return country;
		} else {
			return country;
		}
	}
	
	private boolean isReferenceBrand(Integer countryId) {
		BrandCriteria example = new BrandCriteria();
		net.cominfo.digiagent.persistence.domain.BrandCriteria.Criteria criteria = example.createCriteria();
		criteria.andCountryIdEqualTo(countryId);
		List<Brand> list = brandDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
