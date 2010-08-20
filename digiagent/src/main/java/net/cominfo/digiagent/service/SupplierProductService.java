package net.cominfo.digiagent.service;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.SupplierProductDao;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;
import net.cominfo.digiagent.persistence.domain.SupplierProductCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierProductKey;
import net.cominfo.digiagent.persistence.domain.SupplierProductCriteria.Criteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SupplierProductService {
	@Autowired
	private SupplierProductDao supplierProductDao;
	
	@SuppressWarnings("unchecked")
	public List<SupplierProduct> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<SupplierProduct> page = new Page<SupplierProduct>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("PROVINCE_NAME,CITY_NAME,SUPPLIER_NAME,PRODUCT_COUNT");
		page.setOrder("ASC,ASC,ASC,DESC");
		page.setParam(param);
		return (List<SupplierProduct>) supplierProductDao.findPage(page, "t_da_supplierproduct_Custom.supplierPageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<SupplierProduct> page = new Page<SupplierProduct>();
		page.setParam(param);
		return supplierProductDao.count(page, "t_da_supplierproduct_Custom.supplierCountByCondition");
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductBrand> queryProduct(int pageNo, int pageSize, Map<String, Object> param){
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("COUNTRY_NAME,BRAND_NAME,CATEGORY_NAME,PRODUCT_NAME");
		page.setOrder("ASC,ASC,ASC,DESC");
		page.setParam(param);
		return (List<ProductBrand>) supplierProductDao.findPage(page, "t_da_supplierproduct_Custom.productPageByCondition").getResult();
	}
	
	public Long countProduct(Map<String, Object> param){
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setParam(param);
		return supplierProductDao.count(page, "t_da_supplierproduct_Custom.productCountByCondition");
	}
	
	public String addSupplierProduct(String[] productBrandIds, String supplierIdStr) {
		StringBuffer buffer = new StringBuffer();
		Integer supplierId = Integer.valueOf(supplierIdStr);
		for (String productBrandIdStr : productBrandIds) {
			Integer productBrandId = Integer.valueOf(productBrandIdStr);
			if (validateProductBrandIsExist(productBrandId, supplierId)) {
				buffer.append(productBrandId);
			} else {
				SupplierProductKey supplierProduct = new SupplierProductKey();
				supplierProduct.setProductbrandId(productBrandId);
				supplierProduct.setSupplierId(supplierId);
				supplierProductDao.insert(supplierProduct);
			}
		}
		if (buffer.toString().length() > 0) {
			return buffer.toString();
		} else {
			return "success";
		}
		
	}
	
	private boolean validateProductBrandIsExist(Integer productBrandId, Integer supplierId) {
		SupplierProductCriteria example = new SupplierProductCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andProductbrandIdEqualTo(productBrandId);
		criteria.andSupplierIdEqualTo(supplierId);
		List<SupplierProductKey> supplierProductList = supplierProductDao.selectByExample(example);
		if (supplierProductList != null && supplierProductList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
