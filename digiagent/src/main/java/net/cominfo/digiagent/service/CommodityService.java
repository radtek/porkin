package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CommodityDao;
import net.cominfo.digiagent.persistence.dao.CommodityImageDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria;
import net.cominfo.digiagent.persistence.domain.CommodityImage;
import net.cominfo.digiagent.persistence.domain.CommodityImageCriteria;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria.Criteria;
import net.cominfo.digiagent.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CommodityService {

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	private CommodityImageDao commodityImageDao;
	
	@Autowired
	private SequenceDao sequenceDao;

	public int countCommodity() {
		return commodityDao.countByExample(new CommodityCriteria());
	}
	
	public Commodity getById(Integer id){
		return commodityDao.selectByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Commodity> page = new Page<Commodity>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("COMMODITY_NAME");
		page.setOrder("ASC");
		page.setParam(param);
		return (List<Map>) commodityDao.findPage(page, "t_da_commodity_Custom.pageByCondition").getResult();
	}
	
	public Long count(Map<String, Object> param){
		Page<Commodity> page = new Page<Commodity>();
		page.setParam(param);
		return commodityDao.count(page, "t_da_commodity_Custom.countByCondition");
	}
	
	
	public Commodity insert(Commodity commodity) {
		commodity = validateCommodityName(commodity);
		if (commodity.getCommodityId() != null) {
			return commodity;
		} else {
			int commodityId = sequenceDao.getCommodityNexId();
			commodity.setCommodityId(commodityId);
			// FIXME GET CURRENT LOGIN USER ID
			commodity.setUserId(1);
			commodity.setCreatedBy("sj");
			commodity.setCreatedDate(new Date());
			commodity.setLastupdatedBy("sj");
			commodity.setLastupdatedDate(new Date());
			commodityDao.insert(commodity);
			return commodity;
		}
	}
	
	public Commodity update(Commodity commodity) {
		commodity = validateCommodityName(commodity);
		if (commodity.getCommodityId() == -1) {
			return commodity;
		} else {
			commodity.setLastupdatedBy("sj");
			commodity.setLastupdatedDate(new Date());
			commodityDao.updateByPrimaryKey(commodity);
			return commodity;
		}
	}
	
	public String delete(Integer id){
		CommodityImageCriteria criteria = new CommodityImageCriteria();
		criteria.createCriteria().andCommodityIdEqualTo(id);
		commodityImageDao.deleteByExample(criteria);
		commodityDao.deleteByPrimaryKey(id);
		return "success";
	}
	
	private Commodity validateCommodityName(Commodity commodity) {
		CommodityCriteria example = new CommodityCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andCommodityNameEqualTo(commodity.getCommodityName());
		if (commodity.getCommodityId() != null) {
			criteria.andCommodityIdNotEqualTo(commodity.getCommodityId());
		}
		List<Commodity> list = commodityDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			commodity.setCommodityId(-1);
			return commodity;
		} else {
			return commodity;
		}
	}
	
	public byte[] getCommodityImage(Integer commodityId) {
		Commodity commodity = commodityDao.selectByPrimaryKey(commodityId);
		if (commodity != null) {
//			return commodity.getCommodityImage();
			return null;
		} else {
			return null;
		}
	}
	
	public Commodity release(Commodity commodity, List<CommodityImage> commodityImageList) {
		commodity.setCommodityId(sequenceDao.getCommodityNexId());
		// FIXME GET CURRENT LOGIN USER ID
		commodity.setUserId(1);
		// FIXME DEFAULT ACTIVE_FLAG IS N
		commodity.setActiveFlag("Y");
		commodity.setCreatedBy("sj");
		commodity.setCreatedDate(new Date());
		commodity.setLastupdatedBy("sj");
		commodity.setLastupdatedDate(new Date());
		commodityDao.insert(commodity);
		for (CommodityImage commodityImage : commodityImageList) {
			commodityImage.setCommodityimageId(sequenceDao.getCommodityimageNexId());
			commodityImage.setCreatedBy("sj");
			commodityImage.setCreatedDate(new Date());
			commodityImage.setLastupdatedBy("sj");
			commodityImage.setLastupdatedDate(new Date());
			commodityImage.setActiveFlag("Y");
			commodityImage.setCommodityId(commodity.getCommodityId());
			commodityImageDao.insert(commodityImage);
		}
		return commodity;
	}
	
}
