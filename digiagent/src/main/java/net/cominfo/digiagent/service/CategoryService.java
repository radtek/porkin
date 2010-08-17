package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.ProductCriteria;
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
	@Autowired
	private ProductDao productDao;

	public int countCategory() {
		return categoryDao.countByExample(new CategoryCriteria());
	}
	
	public Category getById(Integer id){
		return categoryDao.selectByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> query(int skipResults, int maxResults){
		PaginationContext paginationContext = new PaginationContext();
		paginationContext.setSkipResults(skipResults);
		paginationContext.setMaxResults(maxResults);
		CategoryCriteria example = new CategoryCriteria();
		example.setOrderByClause("CATEGORY_NAME");
		categoryDao.setCountSqlKey("t_da_category.ibatorgenerated_countByExample");
		categoryDao.setListSqlKey("t_da_category.ibatorgenerated_selectByExample");
		return (List<Category>) categoryDao.queryListByExample(example, paginationContext);
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
	
	public String delete(Integer id){
		// 是否有产品关联
		if (isReferenceProduct(id)) {
			return "reference";
		} else {
			categoryDao.deleteByPrimaryKey(id);
			return "success";
		}
	}
	
	private Category validateCategoryName(Category category) {
		CategoryCriteria example = new CategoryCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryNameEqualTo(category.getCategoryName());
		if (category.getCategoryId() != null) {
			criteria.andCategoryIdNotEqualTo(category.getCategoryId());
		}
		List<Category> list = categoryDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			category.setCategoryId(-1);
			return category;
		} else {
			return category;
		}
	}
	
	private boolean isReferenceProduct(Integer categoryId) {
		ProductCriteria example = new ProductCriteria();
		net.cominfo.digiagent.persistence.domain.ProductCriteria.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<Product> list = productDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
