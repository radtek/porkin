package net.cominfo.digiagent.service;

import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.SupplierProductDao;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;
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
		page.setOrderBy("SUPPLIER_NAME,BRAND_NAME");
		page.setOrder("ASC,ASC");
		page.setParam(param);
		return (List<SupplierProduct>) supplierProductDao.findPage(page, "t_da_supplierproduct_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<SupplierProduct> page = new Page<SupplierProduct>();
		page.setParam(param);
		return supplierProductDao.count(page, "t_da_supplierproduct_Custom.countByCondition");
	}
}
