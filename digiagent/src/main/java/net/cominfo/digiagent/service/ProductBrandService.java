package net.cominfo.digiagent.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.BrandDao;
import net.cominfo.digiagent.persistence.dao.ProductBrandDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.dao.SupplierProductDao;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.BrandCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.ProductBrandCriteria;
import net.cominfo.digiagent.persistence.domain.ProductCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;
import net.cominfo.digiagent.persistence.domain.SupplierProductCriteria;
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
	@Autowired
	private SupplierProductDao supplierProductDao;

	public int countProductBrand() {
		return productBrandDao.countByExample(new ProductBrandCriteria());
	}
	
	public ProductBrand getById(Integer id){
		return productBrandDao.selectByPrimaryKey(id);
	}
	
	public String getBrandList(Integer countryId) {
		BrandCriteria example = new BrandCriteria();
		net.cominfo.digiagent.persistence.domain.BrandCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		List<Brand> brandList = new ArrayList<Brand>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		if (countryId != null && countryId > 0) {
			criteria.andCountryIdEqualTo(countryId);
			example.setOrderByClause("BRAND_NAME");
			brandList = brandDao.selectByExample(example);
			for (Brand brand : brandList) {
				buffer.append("<option value='");
				buffer.append(brand.getBrandId());
				buffer.append("'>");
				buffer.append(brand.getBrandName());
				buffer.append("</option>");
			}
		}
		return buffer.toString();
	}
	
	public String getProductList(Integer categoryId) {
		ProductCriteria example = new ProductCriteria();
		net.cominfo.digiagent.persistence.domain.ProductCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		List<Product> productList = new ArrayList<Product>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		if (categoryId != null && categoryId > 0) {
			criteria.andCategoryIdEqualTo(categoryId);
			example.setOrderByClause("PRODUCT_NAME");
			productList = productDao.selectByExample(example);
			for (Product product : productList) {
				buffer.append("<option value='");
				buffer.append(product.getProductId());
				buffer.append("'>");
				buffer.append(product.getProductName());
				buffer.append("</option>");
			}
		}
		return buffer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductBrand> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("COUNTRY_NAME,BRAND_NAME,CATEGORY_NAME,PRODUCT_NAME");
		page.setOrder("ASC,ASC,ASC,ASC");
		page.setParam(param);
		return (List<ProductBrand>) productBrandDao.findPage(page, "t_da_productbrand_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setParam(param);
		return productBrandDao.count(page, "t_da_productbrand_Custom.countByCondition");
	}
	
	public ProductBrand insert(ProductBrand productBrand,String userName) {
		productBrand = validateProductBrandName(productBrand);
		if (productBrand.getProductbrandId() != null) {
			return productBrand;
		} else {
			productBrand.setCreatedBy(userName);
			productBrand.setCreatedDate(new Date());
			productBrand.setLastupdatedBy(userName);
			productBrand.setLastupdatedDate(new Date());
			productBrandDao.insert(productBrand);
			return productBrand;
		}
	}
	
	public ProductBrand update(ProductBrand productBrand,String userName) {
		productBrand = validateProductBrandName(productBrand);
		if (productBrand.getProductbrandId() == -1) {
			return productBrand;
		} else {
			productBrand.setLastupdatedBy(userName);
			productBrand.setLastupdatedDate(new Date());
			productBrandDao.updateByPrimaryKey(productBrand);
			return productBrand;
		}
	}
	
	public String delete(Integer id){
		// 是否有商家与品牌产品关联
		if (isReferenceSupplierProduct(id)) {
			return "reference";
		} else {
			productBrandDao.deleteByPrimaryKey(id);
			return "success";
		}
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
	

	private boolean isReferenceSupplierProduct(Integer productBrandId) {
		SupplierProductCriteria example = new SupplierProductCriteria();
		net.cominfo.digiagent.persistence.domain.SupplierProductCriteria.Criteria criteria = example.createCriteria();
		criteria.andProductbrandIdEqualTo(productBrandId);
		List<SupplierProduct> list = supplierProductDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Map> getBrandList(Map condition) throws SQLException {
		return (List<Map>) supplierProductDao.getSqlMapClient().queryForList("t_da_productbrand_Custom.listByCondition", condition);
	}
}
