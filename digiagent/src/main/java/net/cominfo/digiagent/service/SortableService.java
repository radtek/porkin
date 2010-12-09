package net.cominfo.digiagent.service;

import net.cominfo.digiagent.persistence.dao.SortableDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SortableService {
	
	@Autowired
	private SortableDao sortableDao;
	
	public void sortCategory(){
		//sortableDao
		
	}
	
	public void sortProduc(){
		
	}
	
	public void sortBrand(){
		
	}
}
