package net.cominfo.digiagent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CityDao;
import net.cominfo.digiagent.persistence.dao.ContactDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SupplierDao;
import net.cominfo.digiagent.persistence.dao.SupplierProductDao;
import net.cominfo.digiagent.persistence.domain.City;
import net.cominfo.digiagent.persistence.domain.CityCriteria;
import net.cominfo.digiagent.persistence.domain.Contact;
import net.cominfo.digiagent.persistence.domain.ContactCriteria;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;
import net.cominfo.digiagent.persistence.domain.SupplierProductCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.persistence.domain.UserRole;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SupplierService {

	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private SupplierProductDao supplierProductDao;
	@Autowired
	private ContactDao contactDao;
	@Autowired
	private UserService userService;

	@Autowired
	private SequenceDao sequenceDao;

	public int countSupplier() {
		return supplierDao.countByExample(new SupplierCriteria());
	}
	
	public SupplierWithBLOBs getById(Integer id){
		return supplierDao.selectByPrimaryKey(id);
	}
	

	public String getCityList(Integer provinceId) {
		CityCriteria example = new CityCriteria();
		net.cominfo.digiagent.persistence.domain.CityCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		List<City> cityList = new ArrayList<City>();
		if (provinceId != null && provinceId > 0) {
			criteria.andProvinceIdEqualTo(provinceId);
			example.setOrderByClause("CITY_NAME");
			cityDao.selectByExample(example);
			cityList = cityDao.selectByExample(example);
			for (City city : cityList) {
				buffer.append("<option value='");
				buffer.append(city.getCityId());
				buffer.append("'>");
				buffer.append(city.getCityName());
				buffer.append("</option>");
			}
		}
		return buffer.toString(); 
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplier> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Supplier> page = new Page<Supplier>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("PROVINCE_NAME,CITY_NAME,SUPPLIER_NAME");
		page.setOrder("ASC,ASC,ASC");
		page.setParam(param);
		return (List<Supplier>) supplierDao.findPage(page, "t_da_supplier_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<Supplier> page = new Page<Supplier>();
		page.setParam(param);
		return supplierDao.count(page, "t_da_supplier_Custom.countByCondition");
	}
	
	public SupplierWithBLOBs insert(SupplierWithBLOBs supplier, User user, UserRole userRole) {
		supplier = validateSupplierName(supplier);
		if (supplier.getSupplierId() != null) {
			return supplier;
		} else {
			// FIXME Role default 企业会员[4]
			user.setUserId(sequenceDao.getUserNexId());
			user.setUserName(String.valueOf(new Date().getTime()));
			user.setUserPassword(String.valueOf(new Date().getTime()));
			user.setActiveFlag("N");
			userRole.setRoleId(4);
			userService.insert(user, userRole);
			
			supplier.setSupplierId(sequenceDao.getSupplierNexId());
//			supplier.setUserId(user.getUserId());
			supplier.setUserId(1);
			supplier.setCreatedBy("sj");
			supplier.setCreatedDate(new Date());
			supplier.setLastupdatedBy("sj");
			supplier.setLastupdatedDate(new Date());
			supplierDao.insert(supplier);
			return supplier;
		}
	}
	
	public SupplierWithBLOBs update(SupplierWithBLOBs supplier) {
		supplier = validateSupplierName(supplier);
		if (supplier.getSupplierId() == -1) {
			return supplier;
		} else {
			supplier.setLastupdatedBy("sj");
			supplier.setLastupdatedDate(new Date());
			supplierDao.updateByPrimaryKey(supplier);
			return supplier;
		}
	}
	
	public String delete(Integer id){
		// 是否有商家产品关联
		if (isReferenceSupplierProduct(id)) {
			return "referenceSupplierProduct";
		} else if (isReferenceContact(id)) {
			// 是否有商家联系方式关联
			return "referenceContact";
		} else {
			supplierDao.deleteByPrimaryKey(id);
			return "success";
		}
	}
	
	@SuppressWarnings("unchecked")
	private SupplierWithBLOBs validateSupplierName(SupplierWithBLOBs supplier) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cityId", supplier.getCityId());
		paramMap.put("supplierName", supplier.getSupplierName());
		if (supplier.getSupplierId() != null) {
			paramMap.put("supplierId",supplier.getSupplierId());
		}
		List<Map> list = supplierDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			supplier.setSupplierId(-1);
			return supplier;
		} else {
			if (supplier.getSupplierImage() == null) {
				SupplierWithBLOBs oriSupplier = supplierDao.selectByPrimaryKey(supplier.getSupplierId());
				supplier.setSupplierImage(oriSupplier.getSupplierImage());
			}
			return supplier;
		}
	}
	
	private boolean isReferenceSupplierProduct(Integer supplierId) {
		SupplierProductCriteria example = new SupplierProductCriteria();
		net.cominfo.digiagent.persistence.domain.SupplierProductCriteria.Criteria criteria = example.createCriteria();
		criteria.andSupplierIdEqualTo(supplierId);
		List<SupplierProduct> list = supplierProductDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isReferenceContact(Integer supplierId) {
		ContactCriteria example = new ContactCriteria();
		net.cominfo.digiagent.persistence.domain.ContactCriteria.Criteria criteria = example.createCriteria();
		criteria.andSupplierIdEqualTo(supplierId);
		List<Contact> list = contactDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param supplierId
	 * @param type
	 * 		1:实名2：资质
	 * @return
	 */
	public byte[] getSupplierImage(Integer supplierId, Integer type) {
		SupplierWithBLOBs supplier = supplierDao.selectByPrimaryKey(supplierId);
		if (supplier != null) {
			switch (type) {
			case 1:
				return supplier.getSupplierCertify();
			case 2:
				return supplier.getSupplierQualify();
			default:
				return supplier.getSupplierImage();
			}
			
		} else {
			return null;
		}
	}
	
	/**
	 * @param supplierId
	 * @param type 联系方式类型
	 * 	T：电话,Q:QQ, E:Email M：手机
	 * @return
	 */
	public List<String> getContactBySupplierId(Integer supplierId,String type){
		ContactCriteria criteria = new ContactCriteria();
		criteria.createCriteria().andSupplierIdEqualTo(supplierId).andContactTypeEqualTo(type);
		List<Contact> contactList = contactDao.selectByExample(criteria);
		ArrayList<String> result = new ArrayList<String>();
		Iterator<Contact> iterator = contactList.iterator();
		Contact temp = null;
		while(iterator.hasNext()){
			temp = iterator.next();
			result.add(temp.getContactContent());
		}
		return result;
	}
	
	public List<String> getSupplierQQList(Integer supplierId){
		return getContactBySupplierId(supplierId,"Q");
	}
	
	public List<String> getSupplierEmailList(Integer supplierId){
		return getContactBySupplierId(supplierId,"E");
	}
	
	public List<String> getSupplierTelephoneList(Integer supplierId,String telephone){
		List<String> result = getContactBySupplierId(supplierId,"T");
		if(telephone!=null){
			result.add(telephone);
		}
		return result;
	}
	
	public List<String> getSupplierMobileList(Integer supplierId,String mobile){
		List<String> result = getContactBySupplierId(supplierId,"M");
		if(mobile!=null){
			result.add(mobile);
		}
		return result;
	}
	
	public List<Contact> getContactBySupplierId(Integer supplierId){
		ContactCriteria criteria = new ContactCriteria();
		criteria.createCriteria().andSupplierIdEqualTo(supplierId);
		return contactDao.selectByExample(criteria);
	}
	
	
	
	/**
	 * 更新访问次数
	 * @param supplier
	 */
	public void access(SupplierWithBLOBs supplier){
		int access = supplier.getSupplierAccess();
		++access;
		supplier.setSupplierAccess(access);
		supplierDao.updateByPrimaryKey(supplier);
		
	}
	
	public String getAreaInfoBySupplierId(Integer supplierid){
		return supplierDao.getSupplierAreaInfo(supplierid);
	}
	
}
