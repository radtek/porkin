package net.cominfo.digiagent.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.ProductBrandDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SortableDao;
import net.cominfo.digiagent.persistence.dao.SupplierProductDao;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.Sortable;
import net.cominfo.digiagent.persistence.domain.SortableCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;
import net.cominfo.digiagent.persistence.domain.SupplierProductKey;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierProductService {

	@Autowired
	private SupplierProductDao supplierProductDao;

	@Autowired
	private ProductBrandDao productBrandDao;

	@Autowired
	private SortableDao sortableDao;
	
	@Autowired
	private SequenceDao sequenceDao;
	

	@SuppressWarnings("unchecked")
	public List<SupplierProductKey> query(int pageNo, int pageSize,
			Map<String, Object> param) {
		Page<SupplierProductKey> page = new Page<SupplierProductKey>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("PROVINCE_NAME,CITY_NAME,SUPPLIER_NAME,PRODUCT_COUNT");
		page.setOrder("ASC,ASC,ASC,DESC");
		page.setParam(param);
		return (List<SupplierProductKey>) supplierProductDao.findPage(page,
				"t_da_supplierproduct_Custom.supplierPageByCondition")
				.getResult();
	}

	public Long count(Map<String, Object> param) {
		Page<SupplierProductKey> page = new Page<SupplierProductKey>();
		page.setParam(param);
		return supplierProductDao.count(page,
				"t_da_supplierproduct_Custom.supplierCountByCondition");
	}

	@SuppressWarnings("unchecked")
	public List<ProductBrand> queryProduct(int pageNo, int pageSize,
			Map<String, Object> param) {
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("COUNTRY_NAME,BRAND_NAME,CATEGORY_NAME,PRODUCT_NAME");
		page.setOrder("ASC,ASC,ASC,DESC");
		page.setParam(param);
		return (List<ProductBrand>) supplierProductDao.findPage(page,
				"t_da_supplierproduct_Custom.productPageByCondition")
				.getResult();
	}

	public Long countProduct(Map<String, Object> param) {
		Page<ProductBrand> page = new Page<ProductBrand>();
		page.setParam(param);
		return supplierProductDao.count(page,
				"t_da_supplierproduct_Custom.productCountByCondition");
	}

	public String addSupplierProduct(String[] productBrandIds,
			String supplierIdStr) {
		StringBuffer buffer = new StringBuffer();
		Integer supplierId = Integer.valueOf(supplierIdStr);
		for (String productBrandIdStr : productBrandIds) {
			Integer productBrandId = Integer.valueOf(productBrandIdStr);
			if (validateProductBrandIsExist(productBrandId, supplierId)) {
				// 品牌产品已存在
				buffer.append(productBrandId);
				buffer.append(",");
			} else {
				SupplierProduct supplierProduct = new SupplierProduct();
				supplierProduct.setProductbrandId(productBrandId);
				supplierProduct.setSupplierId(supplierId);
				supplierProduct.setCreateDate(new Date());
				supplierProductDao.insert(supplierProduct);
				
				//增加品牌下的一个供应商
				ProductBrand productBrand = productBrandDao.selectByPrimaryKey(productBrandId);
				Integer brandId = productBrand.getBrandId();
				SortableCriteria brandSortableCriteria = new SortableCriteria();
				brandSortableCriteria.createCriteria().andSortableKeyEqualTo(brandId).andSortableTypeEqualTo(SortableType.Brand.getFlag());
				List<Sortable> brandSortableList = sortableDao.selectByExample(brandSortableCriteria);
				if(brandSortableList!=null && brandSortableList.size()>0){
					Sortable brandSortable = brandSortableList.get(0);
					Integer parentId = brandSortable.getSortableId();
					Sortable supplierSortable = new Sortable();
					supplierSortable.setSortableId(sequenceDao.getSortableNexId());
					supplierSortable.setSortableKey(supplierId);
					supplierSortable.setSortableOrder(sequenceDao.getSortOrderNexId());
					supplierSortable.setSortableType(SortableType.Supplier.getFlag());
					supplierSortable.setParentId(parentId);
					sortableDao.insert(supplierSortable);
				}
				
			}
		}
		if (buffer.toString().length() > 0) {
			return getProductNames(buffer.toString().replaceAll(",$", ""));
		} else {
			return "success";
		}
	}

	public String updateSupplierProduct(SupplierProduct supplierProduct) {
		try {
			supplierProductDao.updateByPrimaryKeySelective(supplierProduct);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}

	public String deleteSupplierProduct(String[] productBrandIds,
			String supplierIdStr) {
		StringBuffer buffer = new StringBuffer();
		Integer supplierId = Integer.valueOf(supplierIdStr);
		for (String productBrandIdStr : productBrandIds) {
			Integer productBrandId = Integer.valueOf(productBrandIdStr);
			if (validateProductBrandIsExist(productBrandId, supplierId)) {
				SupplierProductKey supplierProduct = new SupplierProductKey();
				supplierProduct.setProductbrandId(productBrandId);
				supplierProduct.setSupplierId(supplierId);
				supplierProductDao.deleteByPrimaryKey(supplierProduct);
				
				// 相当于删除品牌下的一个供应商
				ProductBrand productBrand = productBrandDao
						.selectByPrimaryKey(productBrandId);
				Integer brandId = productBrand.getBrandId();
				SortableCriteria brandSortableCriteria = new SortableCriteria();
				brandSortableCriteria.createCriteria().andSortableKeyEqualTo(brandId)
						.andSortableTypeEqualTo(SortableType.Brand.getFlag());
				List<Sortable> brandSortableList = sortableDao
						.selectByExample(brandSortableCriteria);
				if (brandSortableList != null && brandSortableList.size() > 0) {
					Sortable brandSortable = brandSortableList.get(0);
					Integer parentId = brandSortable.getSortableId();
					SortableCriteria supplierSortableCriteria = new SortableCriteria();
					supplierSortableCriteria.createCriteria().andParentIdEqualTo(
							parentId).andSortableKeyEqualTo(supplierId)
							.andSortableTypeEqualTo(SortableType.Supplier.getFlag());
					sortableDao.deleteByExample(supplierSortableCriteria);
				}
			} else {
				// 品牌产品不存在
				buffer.append(productBrandId);
				buffer.append(",");
			}
		}
		if (buffer.toString().length() > 0) {
			return getProductNames(buffer.toString().replaceAll(",$", ""));
		} else {
			return "success";
		}
	}

	public void deleteSupplierProduct(Integer productBrandId, Integer supplierId) {
		SupplierProductKey supplierProduct = new SupplierProductKey();
		supplierProduct.setProductbrandId(productBrandId);
		supplierProduct.setSupplierId(supplierId);
		supplierProductDao.deleteByPrimaryKey(supplierProduct);

		// 相当于删除品牌下的一个供应商
		ProductBrand productBrand = productBrandDao
				.selectByPrimaryKey(productBrandId);
		Integer brandId = productBrand.getBrandId();
		SortableCriteria brandSortableCriteria = new SortableCriteria();
		brandSortableCriteria.createCriteria().andSortableKeyEqualTo(brandId)
				.andSortableTypeEqualTo(SortableType.Brand.getFlag());
		List<Sortable> brandSortableList = sortableDao
				.selectByExample(brandSortableCriteria);
		if (brandSortableList != null && brandSortableList.size() > 0) {
			Sortable brandSortable = brandSortableList.get(0);
			Integer parentId = brandSortable.getSortableId();
			SortableCriteria supplierSortableCriteria = new SortableCriteria();
			supplierSortableCriteria.createCriteria().andParentIdEqualTo(
					parentId).andSortableKeyEqualTo(supplierId)
					.andSortableTypeEqualTo(SortableType.Supplier.getFlag());
			sortableDao.deleteByExample(supplierSortableCriteria);
		}

	}

	private boolean validateProductBrandIsExist(Integer productBrandId,
			Integer supplierId) {
		SupplierProductKey spKey = new SupplierProductKey();
		spKey.setProductbrandId(productBrandId);
		spKey.setSupplierId(supplierId);
		SupplierProduct supplierProduct = supplierProductDao
				.selectByPrimaryKey(spKey);
		if (supplierProduct != null) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private String getProductNames(String productBrandIds) {
		List productBrandIdList = Arrays.asList(productBrandIds.split(","));
		List<Map> productNameList = (List<Map>) supplierProductDao
				.getProductListByCondition(productBrandIdList);
		StringBuffer rstBuf = new StringBuffer();
		for (Map map : productNameList) {
			rstBuf.append(map.get("productName"));
			rstBuf.append(",");
		}
		return rstBuf.toString().replaceAll(",$", "");
	}

	@SuppressWarnings("unchecked")
	public List<Map> getSupplierList(Map condition) throws SQLException {
		List<Map> result = (List<Map>) supplierProductDao.getSqlMapClient()
				.queryForList(
						"t_da_supplierproduct_Custom.listSortableByCondition",
						condition);
		if (result != null && result.size() > 0) {
			return result;
		} else {
			return (List<Map>) supplierProductDao
					.getSqlMapClient()
					.queryForList(
							"t_da_supplierproduct_Custom.supplierInfoListByCondition",
							condition);
		}

	}
}
