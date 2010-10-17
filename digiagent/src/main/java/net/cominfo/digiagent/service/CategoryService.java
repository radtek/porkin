package net.cominfo.digiagent.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.ProductCriteria;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria.Criteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private SequenceDao sequenceDao;

	public int countCategory() {
		return categoryDao.countByExample(new CategoryCriteria());
	}

	public Category getById(Integer id) {
		return categoryDao.selectByPrimaryKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Category> query(int pageNo, int pageSize,
			Map<String, Object> param) {
		Page<Category> page = new Page<Category>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("CATEGORY_NAME");
		page.setOrder("ASC");
		page.setParam(param);
		return (List<Category>) categoryDao.findPage(page,
				"t_da_category_Custom.pageByCondition").getResult();
	}

	public Long count(Map<String, Object> param) {
		Page<Category> page = new Page<Category>();
		page.setParam(param);
		return categoryDao.count(page, "t_da_category_Custom.countByCondition");
	}

	public Category insert(Category category, String userName) {
		category = validateCategoryName(category);
		if (category.getCategoryId() != null) {
			return category;
		} else {
			category.setCategoryId(sequenceDao.getCategoryNexId());
			category.setCreatedBy(userName);
			category.setCreatedDate(new Date());
			category.setLastupdatedBy(userName);
			category.setLastupdatedDate(new Date());
			categoryDao.insert(category);
			return category;
		}
	}

	public Category update(Category category, String userName) {
		category = validateCategoryName(category);
		if (category.getCategoryId() == -1) {
			return category;
		} else {
			category.setLastupdatedBy(userName);
			category.setLastupdatedDate(new Date());
			categoryDao.updateByPrimaryKey(category);
			return category;
		}
	}

	public String delete(Integer id) {
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
		net.cominfo.digiagent.persistence.domain.ProductCriteria.Criteria criteria = example
				.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<Product> list = productDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Map> getCateogryList() throws SQLException {
		return (List<Map>) categoryDao.getSqlMapClient().queryForList(
				"t_da_category_Custom.listByCondition", new HashMap());
	}

	public List<Category> getAllCategory() {
		CategoryCriteria criteria = new CategoryCriteria();
		criteria.createCriteria();
		return categoryDao.selectByExample(criteria);
	}
}
