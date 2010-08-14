package net.cominfo.digiagent.service;

import net.cominfo.digiagent.persistence.dao.BrandDao;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.BrandCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BrandService {

	@Autowired
	private BrandDao brandDao;

	public int countBrand() {
		return brandDao.countByExample(new BrandCriteria());
	}
	
	public Brand getById(Integer brandId){
		return brandDao.selectByPrimaryKey(brandId);
	}
	
}
