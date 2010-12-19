package net.cominfo.digiagent.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SortableDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.ProductCriteria;
import net.cominfo.digiagent.persistence.domain.Sortable;
import net.cominfo.digiagent.persistence.domain.SortableCriteria;
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

	@Autowired
	private SortableDao sortableDao;

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
			int categoryId = sequenceDao.getCategoryNexId();
			category.setCategoryId(categoryId);
			category.setCreatedBy(userName);
			category.setCreatedDate(new Date());
			category.setLastupdatedBy(userName);
			category.setLastupdatedDate(new Date());
			categoryDao.insert(category);

			// 追加Sortable 记录
			Sortable sortable = new Sortable();
			sortable.setSortableId(sequenceDao.getSortableNexId());
			sortable.setSortableKey(categoryId);
			sortable.setSortableOrder(sequenceDao.getSortOrderNexId());
			sortable.setSortableType(SortableType.Category.getFlag());
			sortable.setParentId(null);
			sortableDao.insert(sortable);
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

			// 删除Sortable 记录
			SortableCriteria criteria = new SortableCriteria();
			criteria.createCriteria().andSortableKeyEqualTo(id)
					.andSortableTypeEqualTo(SortableType.Category.getFlag());
			sortableDao.deleteByExample(criteria);
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
		List<Map> result = (List<Map>) categoryDao.getSqlMapClient()
				.queryForList("t_da_category_Custom.listSortableByCondition",
						new HashMap());
		if (result != null && result.size() > 0) {
			return result;
		} else {
			return (List<Map>) categoryDao.getSqlMapClient().queryForList(
					"t_da_category_Custom.listByCondition", new HashMap());
		}
	}

	public List<Category> getAllCategory() {
		CategoryCriteria criteria = new CategoryCriteria();
		criteria.createCriteria();
		return categoryDao.selectByExample(criteria);
	}
}
