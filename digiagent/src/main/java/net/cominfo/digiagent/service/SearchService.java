package net.cominfo.digiagent.service;

import net.cominfo.digiagent.persistence.dao.SupplierDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SearchService {
	
	@Autowired
	private SupplierDao supplierDao;
	
	

}
