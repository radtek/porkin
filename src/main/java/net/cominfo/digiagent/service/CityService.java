package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CityDao;
import net.cominfo.digiagent.persistence.dao.ProvinceDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SupplierDao;
import net.cominfo.digiagent.persistence.domain.City;
import net.cominfo.digiagent.persistence.domain.CityCriteria;
import net.cominfo.digiagent.persistence.domain.Province;
import net.cominfo.digiagent.persistence.domain.ProvinceCriteria;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierCriteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CityService {

	@Autowired
	private CityDao cityDao;

	@Autowired
	private ProvinceDao provinceDao;

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private SequenceDao sequenceDao;

	public int countCity() {
		return cityDao.countByExample(new CityCriteria());
	}

	public City getById(Integer id) {
		return cityDao.selectByPrimaryKey(id);
	}

	public String getProvinceList() {
		ProvinceCriteria example = new ProvinceCriteria();
		net.cominfo.digiagent.persistence.domain.ProvinceCriteria.Criteria criteria = example
				.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		example.setOrderByClause("PROVINCE_NAME");
		List<Province> provinceList = provinceDao.selectByExample(example);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		for (Province province : provinceList) {
			buffer.append("<option value='");
			buffer.append(province.getProvinceId());
			buffer.append("'>");
			buffer.append(province.getProvinceName());
			buffer.append("</option>");
		}
		return buffer.toString();
	}

	@SuppressWarnings("unchecked")
	public List<City> query(int pageNo, int pageSize, Map<String, Object> param) {
		Page<City> page = new Page<City>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("PROVINCE_NAME,CITY_NAME");
		page.setOrder("ASC,ASC");
		page.setParam(param);
		return (List<City>) cityDao.findPage(page,
				"t_da_city_Custom.pageByCondition").getResult();
	}

	public Long count(Map<String, Object> param) {
		Page<City> page = new Page<City>();
		page.setParam(param);
		return cityDao.count(page, "t_da_city_Custom.countByCondition");
	}

	public City insert(City city, String userName) {
		city = validateCityName(city);
		if (city.getCityId() != null) {
			return city;
		} else {
			city.setCityId(sequenceDao.getCityNexId());
			city.setCreatedBy(userName);
			city.setCreatedDate(new Date());
			city.setLastupdatedBy(userName);
			city.setLastupdatedDate(new Date());
			cityDao.insert(city);
			return city;
		}
	}

	public City update(City city, String userName) {
		city = validateCityName(city);
		if (city.getCityId() == -1) {
			return city;
		} else {
			city.setLastupdatedBy(userName);
			city.setLastupdatedDate(new Date());
			cityDao.updateByPrimaryKey(city);
			return city;
		}
	}

	public String delete(Integer id) {
		// 是否有商家关联
		if (isReferenceSupplier(id)) {
			return "reference";
		} else {
			cityDao.deleteByPrimaryKey(id);
			return "success";
		}
	}

	@SuppressWarnings("unchecked")
	private City validateCityName(City city) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("provinceId", city.getProvinceId());
		paramMap.put("cityName", city.getCityName());
		if (city.getCityId() != null) {
			paramMap.put("cityId", city.getCityId());
		}
		List<Map> list = cityDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			city.setCityId(-1);
			return city;
		} else {
			return city;
		}
	}

	private boolean isReferenceSupplier(Integer cityId) {
		SupplierCriteria example = new SupplierCriteria();
		net.cominfo.digiagent.persistence.domain.SupplierCriteria.Criteria criteria = example
				.createCriteria();
		criteria.andCityIdEqualTo(cityId);
		List<Supplier> list = supplierDao.selectByExampleWithoutBLOBs(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
