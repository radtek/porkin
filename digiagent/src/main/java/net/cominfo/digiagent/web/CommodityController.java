package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.persistence.domain.CommodityImage;
import net.cominfo.digiagent.service.CommodityImageService;
import net.cominfo.digiagent.service.CommodityService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/commodity")
public class CommodityController{
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CommodityImageService commodityImageService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryCommodityList", method = RequestMethod.GET)
	public void queryCommodityList(@RequestParam Map param, HttpServletResponse response) {
		try {
			Long total = commodityService.count(param);
			PrintWriter pw = response.getWriter();
			Integer page = Integer.valueOf((String)param.get("page"));
			Integer rows = 10;
			String resultList = JSONArray.toJSONString(commodityService.query(page, rows, param));
			Map resultMap = new HashMap();
			resultMap.put("total", total);
			resultMap.put("resultList", resultList);
			String result = JSONObject.toJSONString(resultMap);
			pw.write(result);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "commodity";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = commodityService.count(param);
		List<Map> commodityList = commodityService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", commodityList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Map get(@RequestParam Integer id) {
		Map map = new HashMap();
		Commodity commodity = commodityService.getById(id);
		if (commodity == null) {
			new ResourceNotFoundException(new Long(id));
		}
		map.put("commodity", commodity);
		List<CommodityImage> imageList = commodityImageService.getListByCommodityId(id);
		if (imageList != null && imageList.size() > 0) {
			map.put("commodityImage", imageList.get(0));
		}
		return map;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void create(@ModelAttribute Commodity commodity,
			@RequestParam("file") MultipartFile image, HttpServletResponse response) throws IOException {
		CommodityImage commodityImage = new CommodityImage();
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize()/1024 < 65) {
			commodityImage.setCommodityimageContent(image.getBytes());
		}
		try {
			PrintWriter pw = response.getWriter();
			if (image.getSize()/1024 >= 65) {
				pw.write(Collections.singletonMap("commodityId", -2).toString().replaceAll("=", ":"));
			} else {
				commodity = commodityService.insert(commodity);
				commodityImage.setCommodityId(commodity.getCommodityId());
				commodityImageService.insert(commodityImage);
				pw.write(Collections.singletonMap("commodityId", commodity.getCommodityId()).toString().replaceAll("=", ":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Commodity commodity, @ModelAttribute CommodityImage commodityImage,
			@RequestParam("file") MultipartFile image, HttpServletResponse response)  throws IOException {
		Commodity commodityUpdate = commodityService.getById(commodity.getCommodityId());
		if (commodity == null) {
			new ResourceNotFoundException(new Long(commodityUpdate.getCommodityId()));
		}
		commodityUpdate.setActiveFlag(commodity.getActiveFlag());
		commodityUpdate.setStartDate(commodity.getStartDate());
		commodityUpdate.setEndDate(commodity.getEndDate());
		commodityUpdate.setCommodityName(commodity.getCommodityName());
		commodityUpdate.setCommodityDescription(commodity.getCommodityDescription());
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize()/1024 < 65) {
			commodityImage.setCommodityimageContent(image.getBytes());
			commodityImage.setCommodityId(commodity.getCommodityId());
			commodityImageService.update(commodityImage);
		}
		commodityUpdate = commodityService.update(commodityUpdate);
		try {
			PrintWriter pw = response.getWriter();
			if (image.getSize()/1024 >= 65) {
				pw.write(Collections.singletonMap("commodityId", -2).toString().replaceAll("=", ":"));
			} else {
				pw.write(Collections.singletonMap("commodityId", commodityUpdate.getCommodityId()).toString().replaceAll("=", ":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public String output(@RequestParam Integer id, HttpServletResponse response, Model model) {
		model.addAttribute("image", commodityImageService.getCommodityImage(id));
		return "image";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		Commodity commodity = commodityService.getById(id);
		if (commodity == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return commodityService.delete(id);
		}
	}
}
