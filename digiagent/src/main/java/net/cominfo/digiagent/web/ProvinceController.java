package net.cominfo.digiagent.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Province;
import net.cominfo.digiagent.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/province")
public class ProvinceController {

	@Autowired
	private ProvinceService provinceService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "province";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = provinceService.count(param);
		List<Province> provinceList = provinceService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", provinceList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute Province province,
			HttpServletResponse response) {
		Province provinceUpdate = provinceService.getById(province.getProvinceId());
		if (province == null) {
			new ResourceNotFoundException(new Long(provinceUpdate.getProvinceId()));
		}
		provinceUpdate.setActiveFlag(province.getActiveFlag());
		provinceUpdate.setProvinceAbbreviation(province.getProvinceAbbreviation());
		provinceUpdate.setProvinceName(province.getProvinceName());
		provinceUpdate = provinceService.update(provinceUpdate);
		return Collections.singletonMap("provinceId", provinceUpdate.getProvinceId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Province get(@RequestParam Integer id) {
		Province province = provinceService.getById(id);
		if (province == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return province;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute Province province,
			HttpServletResponse response) {
		Province provinceNew = provinceService.insert(province);
		return Collections.singletonMap("provinceId", provinceNew.getProvinceId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		Province province = provinceService.getById(id);
		if (province == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return provinceService.delete(id);
		}
	}
}
