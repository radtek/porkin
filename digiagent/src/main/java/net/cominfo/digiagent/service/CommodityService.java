package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.dao.CommodityDao;
import net.cominfo.digiagent.persistence.dao.CommodityImageDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria;
import net.cominfo.digiagent.persistence.domain.CommodityImage;
import net.cominfo.digiagent.persistence.domain.CommodityImageCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.CommodityCriteria.Criteria;
import net.cominfo.digiagent.utils.Page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class CommodityService {
	Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

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
	
	
	public Commodity insert(Commodity commodity, String userName, Integer userId) {
		commodity = validateCommodityName(commodity);
		if (commodity.getCommodityId() != null) {
			return commodity;
		} else {
			commodity.setCommodityId(sequenceDao.getCommodityNexId());
			commodity.setUserId(userId);
			commodity.setCreatedBy(userName);
			commodity.setCreatedDate(new Date());
			commodity.setLastupdatedBy(userName);
			commodity.setLastupdatedDate(new Date());
			commodityDao.insert(commodity);
			return commodity;
		}
	}
	
	public Commodity update(Commodity commodity, String userName) {
//		commodity = validateCommodityName(commodity);
//		if (commodity.getCommodityId() == -1) {
//			return commodity;
//		} else {
			commodity.setLastupdatedBy(userName);
			commodity.setLastupdatedDate(new Date());
			commodityDao.updateByPrimaryKey(commodity);
			return commodity;
//		}
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
	
	public Commodity release(Commodity commodity, List<CommodityImage> commodityImageList,String userName, Integer userId) {
		commodity.setCommodityId(sequenceDao.getCommodityNexId());
		commodity.setUserId(userId);
		commodity.setActiveFlag("Y");
		commodity.setCreatedBy(userName);
		commodity.setCreatedDate(new Date());
		commodity.setLastupdatedBy(userName);
		commodity.setLastupdatedDate(new Date());
		commodityDao.insert(commodity);
		for (CommodityImage commodityImage : commodityImageList) {
			commodityImage.setCommodityimageId(sequenceDao.getCommodityimageNexId());
			commodityImage.setCreatedBy(userName);
			commodityImage.setCreatedDate(new Date());
			commodityImage.setLastupdatedBy(userName);
			commodityImage.setLastupdatedDate(new Date());
			commodityImage.setActiveFlag("Y");
			commodityImage.setCommodityId(commodity.getCommodityId());
			commodityImageDao.insert(commodityImage);
		}
		return commodity;
	}
	
	/**
	 * Method Description
	 * 
	 * @param categoryName
	 * @param productName
	 * @param userName
	 * @return
	 */
	public int generateNewProductId(String categoryName, String productName, String userName) {
		// 类别新增
		Category category = new Category();
		category.setCategoryId(sequenceDao.getCategoryNexId());
		category.setActiveFlag("Y");
		category.setCategoryName(categoryName);
		category.setCreatedBy(userName);
		category.setCreatedDate(new Date());
		category.setLastupdatedBy(userName);
		category.setLastupdatedDate(new Date());
		categoryDao.insert(category);
		// 产品新增
		Product product = new Product();
		product.setProductId(sequenceDao.getProductNexId());
		product.setProductName(productName);
		product.setActiveFlag("Y");
		product.setCategoryId(category.getCategoryId());
		product.setCreatedBy(userName);
		product.setCreatedDate(new Date());
		product.setLastupdatedBy(userName);
		product.setLastupdatedDate(new Date());
		productDao.insert(product);
		return product.getProductId();
	}
	
	/**
	 * 商品信息过期没有自动删除
	 */
	@SuppressWarnings("unchecked")
	public boolean autoTimeDeleteCommodity() {
		List<Integer> commodityIdList = commodityDao.getSqlMapClientTemplate().queryForList("t_da_commodity_Custom.getExpiredCommodity");
		if (commodityIdList != null && commodityIdList.size() > 0) {
			log.info("过期商品条数：" + commodityIdList.size() + " 条");
			try {
				commodityDao.getSqlMapClientTemplate().delete("t_da_commodity_Custom.deleteExpiredCommodityImage", commodityIdList);
				int result = commodityDao.getSqlMapClientTemplate().delete("t_da_commodity_Custom.deleteExpiredCommodity", commodityIdList);
				if (commodityIdList.size() == result) {
					return true;
				}
				return false;
			} catch (Exception e) {
				log.error(e);
				return false;
			}
		}
		return true;
		
	}
	
}
