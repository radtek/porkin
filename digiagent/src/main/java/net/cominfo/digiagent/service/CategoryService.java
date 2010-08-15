package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria.Criteria;
import net.cominfo.digiagent.persistence.sqlmapdao.PaginationContext;

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
	
	public Category getById(Integer id){
		return categoryDao.selectByPrimaryKey(id);
	}
	
	public List<Category> query(int skipResults, int maxResults){
		PaginationContext paginationContext = new PaginationContext();
		paginationContext.setSkipResults(skipResults);
		paginationContext.setMaxResults(maxResults);
		CategoryCriteria example = new CategoryCriteria();
		example.setOrderByClause("CATEGORY_NAME");
		return categoryDao.queryListByExample(example, paginationContext);
	}
	
	public Category insert(Category category) {
		category = validateCategoryName(category);
		if (category.getCategoryId() != null) {
			return category;
		} else {
			category.setCreatedBy("sj");
			category.setCreatedDate(new Date());
			category.setLastupdatedBy("sj");
			category.setLastupdatedDate(new Date());
			categoryDao.insert(category);
			return category;
		}
	}
	
	public Category update(Category category) {
		category = validateCategoryName(category);
		if (category.getCategoryId() == -1) {
			return category;
		} else {
			category.setLastupdatedBy("sj");
			category.setLastupdatedDate(new Date());
			categoryDao.updateByPrimaryKey(category);
			return category;
		}
	}
	
	public void delete(Integer id){
		categoryDao.deleteByPrimaryKey(id);
	}
	
	private Category validateCategoryName(Category category) {
		CategoryCriteria example = new CategoryCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryNameEqualTo(category.getCategoryName());
		List<Category> list = categoryDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			category.setCategoryId(-1);
			return category;
		} else {
			return category;
		}
	}
}
