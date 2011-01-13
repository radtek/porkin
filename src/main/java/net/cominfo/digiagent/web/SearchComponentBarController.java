package net.cominfo.digiagent.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.service.CategoryService;
import net.cominfo.digiagent.service.ProductBrandService;
import net.cominfo.digiagent.service.ProductService;
import net.cominfo.digiagent.service.SupplierProductService;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/searchComponentBar")
public class SearchComponentBarController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductBrandService productBrandService;
	
	@Autowired
	private SupplierProductService supplierProductService;
	
	@RequestMapping(value = "/getCategoryList", method = RequestMethod.GET)
	public void getCategoryList(HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			String result = JSONArray.toJSONString(categoryService.getCateogryList());  
			pw.write(result);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	public void getProductList(@RequestParam String categoryId, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			Map param = new HashMap();
			param.put("categoryId", categoryId);
			String result = JSONArray.toJSONString(productService.getProductList(param));  
			pw.write(result);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getBrandList", method = RequestMethod.GET)
	public void getBrandList(@RequestParam String productId, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			Map param = new HashMap();
			param.put("productId", productId);
			String result = JSONArray.toJSONString(productBrandService.getBrandList(param));  
			pw.write(result);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getSupplierList", method = RequestMethod.GET)
	public void getSupplierList(@RequestParam String productBrandId, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			Map param = new HashMap();
			param.put("productBrandId", productBrandId);
			String result = JSONArray.toJSONString(supplierProductService.getSupplierList(param));  
			pw.write(result);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
