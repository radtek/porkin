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
@Transactional(rollbackFor = Exception.class)
public class CommodityImageService {

	@Autowired
	private CommodityImageDao commodityImageDao;

	@Autowired
	private SequenceDao sequenceDao;

	public int countCommodity() {
		return commodityImageDao.countByExample(new CommodityImageCriteria());
	}

	public CommodityImage getById(Integer id) {
		return commodityImageDao.selectByPrimaryKey(id);
	}

	public List<CommodityImage> getListByCommodityId(Integer commodityId) {
		CommodityImageCriteria example = new CommodityImageCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCommodityIdEqualTo(commodityId);
		List<CommodityImage> imageList = commodityImageDao
				.selectByExampleWithoutBLOBs(example);
		return imageList;
	}

	public CommodityImage insert(CommodityImage commodityImage, String userName) {
		commodityImage
				.setCommodityimageId(sequenceDao.getCommodityimageNexId());
		commodityImage.setCreatedBy(userName);
		commodityImage.setCreatedDate(new Date());
		commodityImage.setLastupdatedBy(userName);
		commodityImage.setLastupdatedDate(new Date());
		commodityImageDao.insert(commodityImage);
		return commodityImage;
	}

	public int update(CommodityImage commodityImage, String userName) {
		if (commodityImage.getCommodityimageId() == null) {
			return insert(commodityImage, userName).getCommodityimageId();
		}
		Object image = commodityImageDao.selectByPrimaryKey(commodityImage
				.getCommodityimageId());
		if (image == null) {
			return insert(commodityImage, userName).getCommodityimageId();
		}
		commodityImage.setLastupdatedBy(userName);
		commodityImage.setLastupdatedDate(new Date());
		return commodityImageDao.updateByPrimaryKeyWithBLOBs(commodityImage);
	}

	public String delete(Integer id) {
		commodityImageDao.deleteByPrimaryKey(id);
		return "success";
	}

	public byte[] getCommodityImage(Integer commodityImageId) {
		CommodityImage commodityImage = commodityImageDao
				.selectByPrimaryKey(commodityImageId);
		if (commodityImage != null) {
			return commodityImage.getCommodityimageContent();
		} else {
			return null;
		}
	}

}
