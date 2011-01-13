package net.cominfo.digiagent.service;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleService {
	Log log = LogFactory.getLog(this.getClass());

	SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);  
	
	@Autowired
	private CommodityService commodityService;
	
	/**
	 * 商品信息过期没有自动删除
	 */
	public void outPeriodDeleteCommodity() {
		log.info("☆☆☆☆☆商品信息过期自动删除开始☆☆☆☆☆");
		sdf.applyPattern("yyyy年MM月dd日 HH时mm分ss秒");  
		long startTime = System.currentTimeMillis();
		log.info("开始时间：" + sdf.format(startTime));  
		boolean result = commodityService.autoTimeDeleteCommodity();
		if (result) {
			log.info("操作成功！");
		} else {
			log.info("操作失败！");
		}
		long endTime = System.currentTimeMillis();
		log.info("结束时间：" + sdf.format(endTime));  
		log.info("耗时：" + (endTime - startTime)/1000 + " 秒");
		log.info("☆☆☆☆☆商品信息过期自动删除结束☆☆☆☆☆");
	}
}
