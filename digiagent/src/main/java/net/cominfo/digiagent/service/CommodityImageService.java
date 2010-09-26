package net.cominfo.digiagent.service;

import java.util.Date;

import net.cominfo.digiagent.persistence.dao.CommodityImageDao;
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

	public int countCommodity() {
		return commodityImageDao.countByExample(new CommodityImageCriteria());
	}
	
	public CommodityImage getById(Integer id){
		return commodityImageDao.selectByPrimaryKey(id);
	}
	
	
	
	public CommodityImage insert(CommodityImage commodityImage) {
			commodityImage.setCreatedBy("sj");
			commodityImage.setCreatedDate(new Date());
			commodityImage.setLastupdatedBy("sj");
			commodityImage.setLastupdatedDate(new Date());
			commodityImageDao.insert(commodityImage);
			return commodityImage;
	}
	
	public CommodityImage update(CommodityImage commodityImage) {
		CommodityImageCriteria example = new CommodityImageCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCommodityIdEqualTo(commodityImage.getCommodityId());
		commodityImageDao.deleteByExample(example);
		return insert(commodityImage);
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
