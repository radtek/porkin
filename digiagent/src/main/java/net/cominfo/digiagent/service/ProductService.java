package net.cominfo.digiagent.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.ProductCriteria;
import net.cominfo.digiagent.persistence.domain.ProductCriteria.Criteria;
import net.cominfo.digiagent.persistence.sqlmapdao.PaginationContext;

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

	public int countProduct() {
		return productDao.countByExample(new ProductCriteria());
	}
	
	public Product getById(Integer id){
		return productDao.selectByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
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
	public List<Product> query(int skipResults, int maxResults){
		PaginationContext paginationContext = new PaginationContext();
		paginationContext.setSkipResults(skipResults);
		paginationContext.setMaxResults(maxResults);
		ProductCriteria example = new ProductCriteria();
		example.setOrderByClause("CATEGORY_NAME");
		productDao.setCountSqlKey("t_da_product.ibatorgenerated_countByExample");
		productDao.setListSqlKey("t_da_product.ibatorgenerated_selectByExample");
		return (List<Product>) productDao.queryListByExample(example, paginationContext);
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
	
	public void delete(Integer id){
		productDao.deleteByPrimaryKey(id);
	}
	
	private Product validateProductName(Product product) {
		ProductCriteria example = new ProductCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(product.getCategoryId());
		criteria.andProductNameEqualTo(product.getProductName());
		if (product.getProductId() != null) {
			criteria.andProductIdNotEqualTo(product.getProductId());
		}
		List<Product> list = productDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			product.setProductId(-1);
			return product;
		} else {
			return product;
		}
	}
}
