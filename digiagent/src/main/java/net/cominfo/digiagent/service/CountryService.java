package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.BrandDao;
import net.cominfo.digiagent.persistence.dao.CountryDao;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.BrandCriteria;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.persistence.domain.CountryCriteria;
import net.cominfo.digiagent.persistence.domain.CountryCriteria.Criteria;
import net.cominfo.digiagent.persistence.sqlmapdao.PaginationContext;

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
	public List<Country> query(int skipResults, int maxResults){
		PaginationContext paginationContext = new PaginationContext();
		paginationContext.setSkipResults(skipResults);
		paginationContext.setMaxResults(maxResults);
		CountryCriteria example = new CountryCriteria();
		example.setOrderByClause("COUNTRY_ABBREVIATION");
		countryDao.setCountSqlKey("t_da_country.ibatorgenerated_countByExample");
		countryDao.setListSqlKey("t_da_country.ibatorgenerated_selectByExample");
		return (List<Country>) countryDao.queryListByExample(example, paginationContext);
	}
	
	public Country insert(Country country) {
		country = validateCountryName(country);
		if (country.getCountryId() != null) {
			return country;
		} else {
			country.setCreatedBy("sj");
			country.setCreatedDate(new Date());
			country.setLastupdatedBy("sj");
			country.setLastupdatedDate(new Date());
			countryDao.insert(country);
			return country;
		}
	}
	
	public Country update(Country country) {
		country = validateCountryName(country);
		if (country.getCountryId() == -1) {
			return country;
		} else {
			country.setLastupdatedBy("sj");
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
