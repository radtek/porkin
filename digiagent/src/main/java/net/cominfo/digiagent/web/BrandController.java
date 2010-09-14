package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping(value="/brand")
@SessionAttributes("user")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(@ModelAttribute("user") Map user, Model model) {
		String userName = (String)user.get("userName");
		System.out.println(userName);
		return "brand";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = brandService.count(param);
		List<Brand> brandList = brandService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", brandList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute Brand brand,
			HttpServletResponse response) {
		Brand brandUpdate = brandService.getById(brand.getBrandId());
		if (brand == null) {
			new ResourceNotFoundException(new Long(brandUpdate.getBrandId()));
		}
		brandUpdate.setCountryId(brand.getCountryId());
		brandUpdate.setActiveFlag(brand.getActiveFlag());
		brandUpdate.setBrandName(brand.getBrandName());
		brandUpdate.setBrandEnglish(brand.getBrandEnglish());
		brandUpdate = brandService.update(brandUpdate);
		return Collections.singletonMap("brandId", brandUpdate.getBrandId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Brand get(@RequestParam Integer id) {
		Brand brand = brandService.getById(id);
		if (brand == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return brand;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute Brand brand,
			HttpServletResponse response) {
		Brand brandNew = brandService.insert(brand);
		return Collections.singletonMap("brandId", brandNew.getBrandId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		Brand brand = brandService.getById(id);
		if (brand == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return brandService.delete(id);
		}
	}
	
	@RequestMapping(value = "/getCountryList", method = RequestMethod.GET)
	public void getCountryList(HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(brandService.getCountryList());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
