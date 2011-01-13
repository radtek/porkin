package net.cominfo.digiagent.service;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.SupplierDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SearchService {
	
	@Autowired
	private SupplierDao supplierDao;
	
	@SuppressWarnings("unchecked")
	public List<Map> fixedSearch(final Map map){
		return supplierDao.fixedSearchByCondition(map);
	}
	
	

}
