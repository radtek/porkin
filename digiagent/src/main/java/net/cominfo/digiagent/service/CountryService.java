package net.cominfo.digiagent.service;

import java.util.List;

import net.cominfo.digiagent.persistence.dao.CountryDao;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.persistence.domain.CountryCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryDao countryDao;

	public List<Country> getAllCountry() {
		return countryDao.selectByExample(new CountryCriteria());
	}

	public Country getCountryById(Integer id) {
		return countryDao.selectByPrimaryKey(id);
	}

	public void create(Country record) {
		countryDao.insert(record);
	}

}
