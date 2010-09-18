package net.cominfo.digiagent.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.dao.ProductBrandDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.ProductBrandCriteria;
import net.cominfo.digiagent.persistence.domain.ProductCriteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductBrandDao productBrandDao;

	public int countProduct() {
		return productDao.countByExample(new ProductCriteria());
	}
	
	public Product getById(Integer id){
		return productDao.selectByPrimaryKey(id);
	}
	
	public String getCategoryList() {
		CategoryCriteria example = new CategoryCriteria();
		net.cominfo.digiagent.persistence.domain.CategoryCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		example.setOrderByClause("CATEGORY_NAME");
		List<Category> categoryList = categoryDao.selectByExample(example);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		for (Category category : categoryList) {
			buffer.append("<option value='");
			buffer.append(category.getCategoryId());
			buffer.append("'>");
			buffer.append(category.getCategoryName());
			buffer.append("</option>");
		}
		return buffer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Product> page = new Page<Product>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("CATEGORY_NAME,PRODUCT_NAME");
		page.setOrder("ASC,ASC");
		page.setParam(param);
		return (List<Product>) productDao.findPage(page, "t_da_product_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<Product> page = new Page<Product>();
		page.setParam(param);
		return productDao.count(page, "t_da_product_Custom.countByCondition");
	}
	
	public Product insert(Product product) {
		product = validateProductName(product);
		if (product.getProductId() != null) {
			return product;
		} else {
			product.setCreatedBy("sj");
			product.setCreatedDate(new Date());
			product.setLastupdatedBy("sj");
			product.setLastupdatedDate(new Date());
			productDao.insert(product);
			return product;
		}
	}
	
	public Product update(Product product) {
		product = validateProductName(product);
		if (product.getProductId() == -1) {
			return product;
		} else {
			product.setLastupdatedBy("sj");
			product.setLastupdatedDate(new Date());
			productDao.updateByPrimaryKey(product);
			return product;
		}
	}
	
	public String delete(Integer id){
		// 是否有品牌产品关联
		if (isReferenceProductBrand(id)) {
			return "reference";
		} else {
			productDao.deleteByPrimaryKey(id);
			return "success";
		}
	}
	
	@SuppressWarnings("unchecked")
	private Product validateProductName(Product product) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("categoryId", product.getCategoryId());
		paramMap.put("productName", product.getProductName());
		if (product.getCategoryId() != null) {
			paramMap.put("productId",product.getProductId());
		}
		List<Map> list = productDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			product.setProductId(-1);
			return product;
		} else {
			return product;
		}
	}
	
	private boolean isReferenceProductBrand(Integer productId) {
		ProductBrandCriteria example = new ProductBrandCriteria();
		net.cominfo.digiagent.persistence.domain.ProductBrandCriteria.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		List<ProductBrand> list = productBrandDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Map> getProductList(Map condition) throws SQLException {
		return (List<Map>) productDao.getSqlMapClient().queryForList("t_da_product_Custom.listByCondition", condition);
	}
}
