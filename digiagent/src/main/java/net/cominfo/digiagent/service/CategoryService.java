package net.cominfo.digiagent.service;

import java.util.List;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public int countCategory() {
		return categoryDao.countByExample(new CategoryCriteria());
	}
	
	public Category getById(Integer brandId){
		return categoryDao.selectByPrimaryKey(brandId);
	}
	
	public List<Category> getAll(){
		CategoryCriteria example = new CategoryCriteria();
		example.setOrderByClause("CATEGORY_NAME");
		return categoryDao.selectByExample(example);
	}
	
	public void insertCategory(Category category) {
		categoryDao.insert(category);
	}
}
