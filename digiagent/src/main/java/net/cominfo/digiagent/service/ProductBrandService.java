package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.BrandDao;
import net.cominfo.digiagent.persistence.dao.ProductBrandDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.BrandCriteria;
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
public class ProductBrandService {

	@Autowired
	private ProductBrandDao productBrandDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ProductDao productDao;

	public int countProductBrand() {
		return productBrandDao.countByExample(new ProductBrandCriteria());
	}
	
	public ProductBrand getById(Integer id){
		return productBrandDao.selectByPrimaryKey(id);
	}
	
	public String getBrandList() {
		BrandCriteria example = new BrandCriteria();
		net.cominfo.digiagent.persistence.domain.BrandCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		example.setOrderByClause("BRAND_NAME");
		List<Brand> brandList = brandDao.selectByExample(example);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		for (Brand brand : brandList) {
			buffer.append("<option value='");
			buffer.append(brand.getBrandId());
			buffer.append("'>");
			buffer.append(brand.getBrandName());
			buffer.append("</option>");
		}
		return buffer.toString();
	}
	
	public String getProductList() {
		ProductCriteria example = new ProductCriteria();
		net.cominfo.digiagent.persistence.domain.ProductCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		example.setOrderByClause("PRODUCT_NAME");
		List<Product> productList = productDao.selectByExample(example);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		for (Product product : productList) {
			buffer.append("<option value='");
			buffer.append(product.getProductId());
			buffer.append("'>");
			buffer.append(product.getProductName());
			buffer.append("</option>");
		}
		return buffer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductBrand> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("BRAND_NAME,PRODUCT_NAME");
		page.setOrder("ASC,ASC");
		page.setParam(param);
		return (List<ProductBrand>) productBrandDao.findPage(page, "t_da_productbrand_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setParam(param);
		return productBrandDao.count(page, "t_da_productbrand_Custom.countByCondition");
	}
	
	public ProductBrand insert(ProductBrand productBrand) {
		productBrand = validateProductBrandName(productBrand);
		if (productBrand.getProductbrandId() != null) {
			return productBrand;
		} else {
			productBrand.setCreatedBy("sj");
			productBrand.setCreatedDate(new Date());
			productBrand.setLastupdatedBy("sj");
			productBrand.setLastupdatedDate(new Date());
			productBrandDao.insert(productBrand);
			return productBrand;
		}
	}
	
	public ProductBrand update(ProductBrand productBrand) {
		productBrand = validateProductBrandName(productBrand);
		if (productBrand.getProductbrandId() == -1) {
			return productBrand;
		} else {
			productBrand.setLastupdatedBy("sj");
			productBrand.setLastupdatedDate(new Date());
			productBrandDao.updateByPrimaryKey(productBrand);
			return productBrand;
		}
	}
	
	public void delete(Integer id){
		productBrandDao.deleteByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	private ProductBrand validateProductBrandName(ProductBrand productBrand) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("brandId", productBrand.getBrandId());
		paramMap.put("productId", productBrand.getProductId());
		if (productBrand.getProductbrandId() != null) {
			paramMap.put("productbrandId",productBrand.getProductbrandId());
		}
		List<Map> list = productBrandDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			productBrand.setProductbrandId(-1);
			return productBrand;
		} else {
			return productBrand;
		}
	}
}
