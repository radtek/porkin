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
import net.cominfo.digiagent.service.CommodityService;

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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "commodity";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = commodityService.count(param);
		List<Commodity> brandList = commodityService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", brandList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Commodity get(@RequestParam Integer id) {
		Commodity commodity = commodityService.getById(id);
		if (commodity == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return commodity;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void create(@ModelAttribute Commodity commodity,
			@RequestParam("file") MultipartFile image, HttpServletResponse response) throws IOException {
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize()/1024 < 65) {
			commodity.setCommodityImage(image.getBytes());
		}
		try {
			PrintWriter pw = response.getWriter();
			if (image.getSize()/1024 >= 65) {
				pw.write(Collections.singletonMap("commodityId", -2).toString().replaceAll("=", ":"));
			} else {
				commodity = commodityService.insert(commodity);
				pw.write(Collections.singletonMap("commodityId", commodity.getCommodityId()).toString().replaceAll("=", ":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return Collections.singletonMap("commodityId", commodity.getCommodityId());
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Commodity commodity,
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
			commodityUpdate.setCommodityImage(image.getBytes());
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
//		return Collections.singletonMap("commodityId", commodityUpdate.getCommodityId());
	}

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public String output(@RequestParam Integer id, HttpServletResponse response, Model model) {
//		try {
//			ServletOutputStream sos = response.getOutputStream();
//			sos.write(commodityService.getCommodityImage(id));
//			sos.flush();  
//			sos.close();  
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		model.addAttribute("image", commodityService.getCommodityImage(id));
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
