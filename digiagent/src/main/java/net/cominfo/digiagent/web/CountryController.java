package net.cominfo.digiagent.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "country";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = countryService.count(param);
		List<Country> countryList = countryService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", countryList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute Country country,
			HttpServletResponse response) {
		Country countryUpdate = countryService.getById(country.getCountryId());
		if (country == null) {
			new ResourceNotFoundException(new Long(countryUpdate.getCountryId()));
		}
		countryUpdate.setActiveFlag(country.getActiveFlag());
		countryUpdate.setCountryAbbreviation(country.getCountryAbbreviation());
		countryUpdate.setCountryName(country.getCountryName());
		countryUpdate = countryService.update(countryUpdate);
		return Collections.singletonMap("countryId", countryUpdate.getCountryId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Country get(@RequestParam Integer id) {
		Country country = countryService.getById(id);
		if (country == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return country;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute Country country,
			HttpServletResponse response) {
		Country countryNew = countryService.insert(country);
		return Collections.singletonMap("countryId", countryNew.getCountryId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		Country country = countryService.getById(id);
		if (country == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return countryService.delete(id);
		}
	}
}
