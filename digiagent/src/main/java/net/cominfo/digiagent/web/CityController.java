package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.City;
import net.cominfo.digiagent.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/city")
public class CityController {
	
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "city";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = cityService.count(param);
		List<City> cityList = cityService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", cityList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute City city,
			HttpServletResponse response) {
		City cityUpdate = cityService.getById(city.getCityId());
		if (city == null) {
			new ResourceNotFoundException(new Long(cityUpdate.getCityId()));
		}
		cityUpdate.setProvinceId(city.getProvinceId());
		cityUpdate.setActiveFlag(city.getActiveFlag());
		cityUpdate.setCityName(city.getCityName());
		cityUpdate.setCityAbbreviation(city.getCityAbbreviation());
		cityUpdate = cityService.update(cityUpdate);
		return Collections.singletonMap("cityId", cityUpdate.getCityId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody City get(@RequestParam Integer id) {
		City city = cityService.getById(id);
		if (city == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return city;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute City city,
			HttpServletResponse response) {
		City cityNew = cityService.insert(city);
		return Collections.singletonMap("cityId", cityNew.getCityId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		City city = cityService.getById(id);
		if (city == null) {
			new ResourceNotFoundException(new Long(id));
		} else {
			cityService.delete(id);
		}
		return "success";
	}
	
	@RequestMapping(value = "/getProvinceList", method = RequestMethod.GET)
	public void getProvinceList(HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(cityService.getProvinceList());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
