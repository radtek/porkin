package net.cominfo.digiagent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CityDao;
import net.cominfo.digiagent.persistence.dao.ProvinceDao;
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
@Transactional
public class SupplierService {

	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;

	public int countSupplier() {
		return supplierDao.countByExample(new SupplierCriteria());
	}
	
	public Supplier getById(Integer id){
		return supplierDao.selectByPrimaryKey(id);
	}
	
	public String getProvinceList() {
		ProvinceCriteria example = new ProvinceCriteria();
		net.cominfo.digiagent.persistence.domain.ProvinceCriteria.Criteria criteria = example.createCriteria();
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

	
	public String getCityList(Integer provinceId) {
		CityCriteria example = new CityCriteria();
		net.cominfo.digiagent.persistence.domain.CityCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		List<City> cityList = new ArrayList<City>();
		if (provinceId != null && provinceId > 0) {
			criteria.andProvinceIdEqualTo(provinceId);
			example.setOrderByClause("CITY_NAME");
			cityDao.selectByExample(example);
			cityList = cityDao.selectByExample(example);
			buffer = new StringBuffer();
			for (City city : cityList) {
				buffer.append("<option value='");
				buffer.append(city.getCityId());
				buffer.append("'>");
				buffer.append(city.getCityName());
				buffer.append("</option>");
			}
		}
		return buffer.toString(); 
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplier> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Supplier> page = new Page<Supplier>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("PROVINCE_NAME,CITY_NAME,SUPPLIER_NAME");
		page.setOrder("ASC,ASC,ASC");
		page.setParam(param);
		return (List<Supplier>) supplierDao.findPage(page, "t_da_supplier_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<Supplier> page = new Page<Supplier>();
		page.setParam(param);
		return supplierDao.count(page, "t_da_supplier_Custom.countByCondition");
	}
	
	public Supplier insert(Supplier supplier) {
		supplier = validateSupplierName(supplier);
		if (supplier.getSupplierId() != null) {
			return supplier;
		} else {
			supplier.setCreatedBy("sj");
			supplier.setCreatedDate(new Date());
			supplier.setLastupdatedBy("sj");
			supplier.setLastupdatedDate(new Date());
			supplierDao.insert(supplier);
			return supplier;
		}
	}
	
	public Supplier update(Supplier supplier) {
		supplier = validateSupplierName(supplier);
		if (supplier.getSupplierId() == -1) {
			return supplier;
		} else {
			supplier.setLastupdatedBy("sj");
			supplier.setLastupdatedDate(new Date());
			supplierDao.updateByPrimaryKey(supplier);
			return supplier;
		}
	}
	
	public void delete(Integer id){
		supplierDao.deleteByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	private Supplier validateSupplierName(Supplier supplier) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cityId", supplier.getCityId());
		paramMap.put("supplierName", supplier.getSupplierName());
		if (supplier.getSupplierId() != null) {
			paramMap.put("supplierId",supplier.getSupplierId());
		}
		List<Map> list = supplierDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			supplier.setSupplierId(-1);
			return supplier;
		} else {
			return supplier;
		}
	}
}
