package net.cominfo.digiagent.web;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Commodity;
import net.cominfo.digiagent.service.CommodityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(
			@RequestParam("file") MultipartFile image) throws IOException {
		Commodity commodity = new Commodity();
		commodity.setCommodityName(String.valueOf(new Date().getTime()));
		commodity.setCommodityDescription("testDesc");
		commodity.setActiveFlag("Y");
		commodity.setCommodityImage(image.getBytes());
		commodity.setStartDate(new Date());
		commodity.setEndDate(new Date());
		commodity = commodityService.insert(commodity);
		return Collections.singletonMap("commodityId", commodity.getCommodityId());
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
