package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CityDao;
import net.cominfo.digiagent.persistence.dao.ProvinceDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.City;
import net.cominfo.digiagent.persistence.domain.CityCriteria;
import net.cominfo.digiagent.persistence.domain.Province;
import net.cominfo.digiagent.persistence.domain.ProvinceCriteria;
import net.cominfo.digiagent.persistence.domain.ProvinceCriteria.Criteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProvinceService {

	@Autowired
	private ProvinceDao provinceDao;

	@Autowired
	private CityDao cityDao;

	@Autowired
	private SequenceDao sequenceDao;

	public int countProvince() {
		return provinceDao.countByExample(new ProvinceCriteria());
	}

	public Province getById(Integer id) {
		return provinceDao.selectByPrimaryKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Province> query(int pageNo, int pageSize,
			Map<String, Object> param) {
		Page<Province> page = new Page<Province>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("PROVINCE_ABBREVIATION");
		page.setOrder("ASC");
		page.setParam(param);
		return (List<Province>) provinceDao.findPage(page,
				"t_da_province_Custom.pageByCondition").getResult();
	}

	public Long count(Map<String, Object> param) {
		Page<Province> page = new Page<Province>();
		page.setParam(param);
		return provinceDao.count(page, "t_da_province_Custom.countByCondition");
	}

	public Province insert(Province province, String userName) {
		province = validateProvinceName(province);
		if (province.getProvinceId() != null) {
			return province;
		} else {
			province.setProvinceId(sequenceDao.getProvinceNexId());
			province.setCreatedBy(userName);
			province.setCreatedDate(new Date());
			province.setLastupdatedBy(userName);
			province.setLastupdatedDate(new Date());
			provinceDao.insert(province);
			return province;
		}
	}

	public Province update(Province province, String userName) {
		province = validateProvinceName(province);
		if (province.getProvinceId() == -1) {
			return province;
		} else {
			province.setLastupdatedBy(userName);
			province.setLastupdatedDate(new Date());
			provinceDao.updateByPrimaryKey(province);
			return province;
		}
	}

	public String delete(Integer id) {
		// 是否有品牌关联
		if (isReferenceCity(id)) {
			return "reference";
		} else {
			provinceDao.deleteByPrimaryKey(id);
			return "success";
		}
	}

	private Province validateProvinceName(Province province) {
		ProvinceCriteria example = new ProvinceCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andProvinceNameEqualTo(province.getProvinceName());
		if (province.getProvinceId() != null) {
			criteria.andProvinceIdNotEqualTo(province.getProvinceId());
		}
		List<Province> list = provinceDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			province.setProvinceId(-1);
			return province;
		} else {
			return province;
		}
	}

	private boolean isReferenceCity(Integer provinceId) {
		CityCriteria example = new CityCriteria();
		net.cominfo.digiagent.persistence.domain.CityCriteria.Criteria criteria = example
				.createCriteria();
		criteria.andProvinceIdEqualTo(provinceId);
		List<City> list = cityDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
