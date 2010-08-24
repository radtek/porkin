package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CommodityDao;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria;
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

	public int countCommodity() {
		return commodityDao.countByExample(new CommodityCriteria());
	}
	
	public Commodity getById(Integer id){
		return commodityDao.selectByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Commodity> query(int pageNo, int pageSize, Map<String, Object> param){
		Page<Commodity> page = new Page<Commodity>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setOrderBy("COMMODITY_NAME");
		page.setOrder("ASC");
		page.setParam(param);
		return (List<Commodity>) commodityDao.findPage(page, "t_da_commodity_Custom.pageByCondition").getResult();
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
			commodityDao.updateByPrimaryKeyWithBLOBs(commodity);
			return commodity;
		}
	}
	
	public String delete(Integer id){
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
		List<Commodity> list = commodityDao.selectByExampleWithoutBLOBs(example);
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
			return commodity.getCommodityImage();
		} else {
			return null;
		}
	}
	
}