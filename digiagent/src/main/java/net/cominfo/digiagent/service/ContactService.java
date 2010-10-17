package net.cominfo.digiagent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.ContactDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SupplierDao;
import net.cominfo.digiagent.persistence.domain.Contact;
import net.cominfo.digiagent.persistence.domain.ContactCriteria;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierCriteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class ContactService {

	@Autowired
	private ContactDao contactDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private SequenceDao sequenceDao;

	public int countContact() {
		return contactDao.countByExample(new ContactCriteria());
	}
	
	public Contact getById(Integer id){
		return contactDao.selectByPrimaryKey(id);
	}
	
	public String getSupplierList(Integer cityId) {
		SupplierCriteria example = new SupplierCriteria();
		net.cominfo.digiagent.persistence.domain.SupplierCriteria.Criteria criteria = example.createCriteria();
		criteria.andActiveFlagEqualTo("Y");
		List<Supplier> supplierList = new ArrayList<Supplier>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("<option value='' selected='selected'>请选择...</option>");
		if (cityId != null && cityId > 0) {
			criteria.andCityIdEqualTo(cityId);
			example.setOrderByClause("SUPPLIER_NAME");
			supplierList = supplierDao.selectByExampleWithoutBLOBs(example);
			for (Supplier supplier : supplierList) {
				buffer.append("<option value='");
				buffer.append(supplier.getSupplierId());
				buffer.append("'>");
				buffer.append(supplier.getSupplierName());
				buffer.append("</option>");
			}
		}
		return buffer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Contact> page = new Page<Contact>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("SUPPLIER_NAME,CONTACT_TYPE");
		page.setOrder("ASC,ASC");
		page.setParam(param);
		return (List<Contact>) contactDao.findPage(page, "t_da_contact_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<Contact> page = new Page<Contact>();
		page.setParam(param);
		return contactDao.count(page, "t_da_contact_Custom.countByCondition");
	}
	
	public Contact insert(Contact contact,String userName) {
		contact = validateContactName(contact);
		if (contact.getContactId() != null) {
			return contact;
		} else {
			contact.setContactId(sequenceDao.getContactNexId());
			contact.setCreatedBy(userName);
			contact.setCreatedDate(new Date());
			contact.setLastupdatedBy(userName);
			contact.setLastupdatedDate(new Date());
			contactDao.insert(contact);
			return contact;
		}
	}
	
	public Contact update(Contact contact,String userName) {
		contact = validateContactName(contact);
		if (contact.getContactId() == -1) {
			return contact;
		} else {
			contact.setLastupdatedBy(userName);
			contact.setLastupdatedDate(new Date());
			contactDao.updateByPrimaryKey(contact);
			return contact;
		}
	}
	
	public void delete(Integer id){
		contactDao.deleteByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	private Contact validateContactName(Contact contact) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("supplierId", contact.getSupplierId());
		paramMap.put("contactContent", contact.getContactContent());
		if (contact.getContactId() != null) {
			paramMap.put("contactId",contact.getContactId());
		}
		List<Map> list = contactDao.findByCondition(paramMap);
		if (list != null && list.size() > 0) {
			contact.setContactId(-1);
			return contact;
		} else {
			return contact;
		}
	}
}
