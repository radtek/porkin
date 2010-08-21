package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.service.ProductBrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/productBrand")
public class ProductBrandController {
	
	@Autowired
	private ProductBrandService productBrandService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "productBrand";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = productBrandService.count(param);
		List<ProductBrand> productBrandList = productBrandService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", productBrandList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute ProductBrand productBrand,
			HttpServletResponse response) {
		ProductBrand productBrandUpdate = productBrandService.getById(productBrand.getProductbrandId());
		if (productBrand == null) {
			new ResourceNotFoundException(new Long(productBrandUpdate.getProductbrandId()));
		}
		productBrandUpdate.setProductId(productBrand.getProductId());
		productBrandUpdate.setActiveFlag(productBrand.getActiveFlag());
		productBrandUpdate.setBrandId(productBrand.getBrandId());
		productBrandUpdate = productBrandService.update(productBrandUpdate);
		return Collections.singletonMap("productBrandId", productBrandUpdate.getProductbrandId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody ProductBrand get(@RequestParam Integer id) {
		ProductBrand productBrand = productBrandService.getById(id);
		if (productBrand == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return productBrand;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute ProductBrand productBrand,
			HttpServletResponse response) {
		ProductBrand productBrandNew = productBrandService.insert(productBrand);
		return Collections.singletonMap("productBrandId", productBrandNew.getProductbrandId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		ProductBrand productBrand = productBrandService.getById(id);
		if (productBrand == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return productBrandService.delete(id);
		}
	}
	
	@RequestMapping(value = "/getBrandList", method = RequestMethod.GET)
	public void getBrandList(@RequestParam Integer id, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(productBrandService.getBrandList(id));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	public void getProvinceList(@RequestParam Integer id, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(productBrandService.getProductList(id));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
