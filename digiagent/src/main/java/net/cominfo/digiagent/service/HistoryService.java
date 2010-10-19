package net.cominfo.digiagent.service;

import java.util.Date;

import net.cominfo.digiagent.persistence.dao.HistoryDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class HistoryService {

	@Autowired
	private HistoryDao historyDao;

	@Autowired
	private SequenceDao sequenceDao;

	/**
	 * 类型为B:品牌,C:大类,P:产品,E:品牌产品,S:供应商)
	 * 
	 * @param type
	 * @param typeId
	 */
	public void insert(String type, int typeId, String fromIP) {
		History history = new History();
		history.setHistoryId(sequenceDao.getHistoryNexId());
		history.setHistoryAccessdate(new Date());
		history.setHistoryType(type);
		history.setHistoryTypeid(typeId);
		history.setHistoryFromip(fromIP);
		historyDao.insert(history);
	}

	public void insert(String type, int typeId) {
		insert(type, typeId, "255.255.255.255");
	}

	public void recordBrandAccess(int brandId, String fromIP) {
		insert("B", brandId, fromIP);
	}

	public void recordBrandAccess(int brandId) {
		insert("B", brandId);
	}

	public void recordCategoryAccess(int categoryId, String fromIP) {
		insert("C", categoryId, fromIP);
	}

	public void recordCategoryAccess(int categoryId) {
		insert("C", categoryId);
	}

	public void recordProductAccess(int productId, String fromIP) {
		insert("P", productId, fromIP);
	}

	public void recordProductAccess(int productId) {
		insert("P", productId);
	}

	public void recordProductBrandAccess(int productBrandId, String fromIP) {
		insert("E", productBrandId, fromIP);
	}

	public void recordProductBrandAccess(int productBrandId) {
		insert("E", productBrandId);
	}

	public void recordSupplierAccess(int supplierId, String fromIP) {
		insert("S", supplierId, fromIP);
	}

	public void recordSupplierAccess(int supplierId) {
		insert("S", supplierId);
	}

}
