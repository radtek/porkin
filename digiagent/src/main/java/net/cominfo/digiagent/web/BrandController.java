package net.cominfo.digiagent.web;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	public BrandController() {
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Brand brand = brandService.getById(id);
		if (brand == null) {
			throw new ResourceNotFoundException(new Long(id));
		}
		model.addAttribute(brand);
		return "brand/view";
	}
	
	@RequestMapping(value="/first1",method=RequestMethod.GET)
	public @ResponseBody Map<String, ? extends Object> first1(HttpServletResponse response) {
		int id = 1;
		Brand brand = brandService.getById(id);
		if (brand == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return Collections.singletonMap("name", brand.getBrandName());
	}
	
	@RequestMapping(value="/first2",method=RequestMethod.GET)
	public @ResponseBody Brand firt2() {
		int id = 1;
		Brand brand = brandService.getById(id);
		if (brand == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return brand;
	}
	
}
