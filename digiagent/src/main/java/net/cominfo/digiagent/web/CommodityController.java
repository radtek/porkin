package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/commodity")
@SessionAttributes( { "userId", "userName" })
public class CommodityController {
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CommodityImageService commodityImageService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryCommodityList", method = RequestMethod.GET)
	public void queryCommodityList(@RequestParam Map param,
			@RequestParam String productName, HttpServletResponse response) {
		try {
			if (productName != null && productName.length() > 0) {
				param.put("productName", java.net.URLDecoder.decode(
						productName, "UTF-8"));
			}
			Long total = commodityService.count(param);
			PrintWriter pw = response.getWriter();
			Integer page = Integer.valueOf((String) param.get("page"));
			Integer rows = 10;
			List<Map> commodityList = commodityService.query(page, rows, param);
			String resultList = JSONArray.toJSONString(commodityList);
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
	Map query(@RequestParam Integer page, @RequestParam Integer rows,
			@RequestParam Map param) {
		Long total = commodityService.count(param);
		List<Map> commodityList = commodityService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", commodityList);
		return Collections.singletonList(map).get(0);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody
	Map get(@RequestParam Integer id) {
		Map map = new HashMap();
		Commodity commodity = commodityService.getById(id);
		if (commodity == null) {
			new ResourceNotFoundException(new Long(id));
		}
		map.put("commodity", commodity);
		List<CommodityImage> imageList = commodityImageService
				.getListByCommodityId(id);
		if (imageList != null && imageList.size() > 0) {
			map.put("commodityImage", imageList.get(0));
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	String create(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName,
			@ModelAttribute Commodity commodity,
			@RequestParam("file") MultipartFile image) throws IOException {
		Map map = new HashMap();
		CommodityImage commodityImage = new CommodityImage();
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize() / 1024 < 65) {
			commodityImage.setCommodityimageContent(image.getBytes());
		}
		if (image.getSize() / 1024 >= 65) {
			map.put("commodityId", -2);
		} else {
			commodity = commodityService.insert(commodity, userName, userId);
			commodityImage.setCommodityId(commodity.getCommodityId());
			commodityImageService.insert(commodityImage, userName);
			map.put("commodityId", commodity.getCommodityId());
			map.put("commodityImage", commodityImage.getCommodityimageId());
		}
		return JSONObject.toJSONString(map);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	String update(@ModelAttribute("userName") String userName,
			@ModelAttribute Commodity commodity,
			@ModelAttribute CommodityImage commodityImage,
			@RequestParam("file") MultipartFile image) throws IOException {
		Map map = new HashMap();
		Commodity commodityUpdate = commodityService.getById(commodity
				.getCommodityId());
		if (commodity == null) {
			new ResourceNotFoundException(new Long(commodityUpdate
					.getCommodityId()));
		}
		commodityUpdate.setProductId(commodity.getProductId());
		commodityUpdate.setActiveFlag(commodity.getActiveFlag());
		commodityUpdate.setStartDate(commodity.getStartDate());
		commodityUpdate.setEndDate(commodity.getEndDate());
		commodityUpdate.setCommodityName(commodity.getCommodityName());
		commodityUpdate.setCommodityPrice(commodity.getCommodityPrice());
		commodityUpdate.setCommodityType(commodity.getCommodityType());
		commodityUpdate.setCommodityDescription(commodity
				.getCommodityDescription());
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize() / 1024 < 65) {
			commodityImage.setCommodityimageContent(image.getBytes());
			commodityImage.setCommodityId(commodity.getCommodityId());
			commodityImageService.update(commodityImage, userName);
		}
		commodityUpdate = commodityService.update(commodityUpdate, userName);
		if (image.getSize() / 1024 >= 65) {
			map.put("commodityId", -2);
		} else {
			map.put("commodityId", commodityUpdate.getCommodityId());
			map.put("commodityImage", commodityImage.getCommodityimageId());
		}
		return JSONObject.toJSONString(map);
	}

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public String output(@RequestParam Integer id,
			HttpServletResponse response, Model model) {
		model
				.addAttribute("image", commodityImageService
						.getCommodityImage(id));
		return "image";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	String delete(@RequestParam Integer id) {
		Commodity commodity = commodityService.getById(id);
		if (commodity == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return commodityService.delete(id);
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/release", method = RequestMethod.POST)
	public @ResponseBody
	String release(@ModelAttribute("userName") String userName,
			@ModelAttribute Commodity commodity,
			@RequestParam("file1") MultipartFile image1,
			@RequestParam("file2") MultipartFile image2,
			@RequestParam("file3") MultipartFile image3,
			@RequestParam("file4") MultipartFile image4,
			@RequestParam("file5") MultipartFile image5) throws IOException {
		List<MultipartFile> imageList = new ArrayList<MultipartFile>();
		List<CommodityImage> commodityImageList = new ArrayList<CommodityImage>();
		imageList.add(image1);
		imageList.add(image2);
		imageList.add(image3);
		imageList.add(image4);
		imageList.add(image5);
		Map map = new HashMap();
		for (MultipartFile image : imageList) {
			if (image == null || image.getSize() == 0)
				continue;
			if (image.getSize() / 1024 >= 65) {
				map.put("commodityId", -2);
			}
			CommodityImage commodityImage = new CommodityImage();
			// MYSQL BLOB类型最大65K
			if (image.getSize() > 0 && image.getSize() / 1024 < 65) {
				commodityImage.setCommodityimageContent(image.getBytes());
				commodityImageList.add(commodityImage);
			}
		}
		if (map.size() > 0) {
			return JSONObject.toJSONString(map);
		} else {
			commodity = commodityService.release(commodity, commodityImageList,
					userName);
			map.put("commodityId", commodity.getCommodityId());
		}
		return JSONObject.toJSONString(map);
	}
}
