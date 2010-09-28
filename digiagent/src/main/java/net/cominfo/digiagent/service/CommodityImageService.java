package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.CommodityImageDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.CommodityImage;
import net.cominfo.digiagent.persistence.domain.CommodityImageCriteria;
import net.cominfo.digiagent.persistence.domain.CommodityImageCriteria.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CommodityImageService {

	@Autowired
	private CommodityImageDao commodityImageDao;
	

	@Autowired
	private SequenceDao sequenceDao;


	public int countCommodity() {
		return commodityImageDao.countByExample(new CommodityImageCriteria());
	}
	
	public CommodityImage getById(Integer id){
		return commodityImageDao.selectByPrimaryKey(id);
	}
	
	public List<CommodityImage> getListByCommodityId(Integer commodityId){
		CommodityImageCriteria example = new CommodityImageCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCommodityIdEqualTo(commodityId);
		List<CommodityImage> imageList = commodityImageDao.selectByExampleWithoutBLOBs(example);
		return imageList;
	}
	
	
	
	public CommodityImage insert(CommodityImage commodityImage) {
		commodityImage.setCommodityimageId(sequenceDao.getCommodityimageNexId());
		commodityImage.setCreatedBy("sj");
		commodityImage.setCreatedDate(new Date());
		commodityImage.setLastupdatedBy("sj");
		commodityImage.setLastupdatedDate(new Date());
		commodityImageDao.insert(commodityImage);
		return commodityImage;
	}
	
	public int update(CommodityImage commodityImage) {
		return commodityImageDao.updateByPrimaryKeyWithBLOBs(commodityImage);
	}
	
	public String delete(Integer id){
		commodityImageDao.deleteByPrimaryKey(id);
		return "success";
	}
	
	
	public byte[] getCommodityImage(Integer commodityImageId) {
		CommodityImage commodityImage = commodityImageDao.selectByPrimaryKey(commodityImageId);
		if (commodityImage != null) {
			return commodityImage.getCommodityimageContent();
		} else {
			return null;
		}
	}
	
}
