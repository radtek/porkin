package net.cominfo.digiagent.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.service.CategoryService;
import net.cominfo.digiagent.service.ProductBrandService;
import net.cominfo.digiagent.service.ProductService;
import net.cominfo.digiagent.service.SupplierProductService;

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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCategoryList", method = RequestMethod.GET)
	public void getCategoryList(HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			StringBuffer buffer = new StringBuffer();
			for (Map map : categoryService.getCateogryList()) {
				buffer.append(map.get("categoryName"));
				buffer.append(",");
			}
			pw.write(buffer.toString().replaceAll(",$", ""));
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	public void getProductList(@RequestParam String categoryName, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			StringBuffer buffer = new StringBuffer();
			Map param = new HashMap();
			param.put("categoryName", java.net.URLDecoder.decode(categoryName,"UTF-8"));
			for (Map map : productService.getProductList(param)) {
				buffer.append(map.get("productName"));
				buffer.append(",");
			}
			pw.write(buffer.toString().replaceAll(",$", ""));
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getBrandList", method = RequestMethod.GET)
	public void getBrandList(@RequestParam String productName, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			StringBuffer buffer = new StringBuffer();
			Map param = new HashMap();
			param.put("productName", java.net.URLDecoder.decode(productName,"UTF-8"));
			for (Map map : productBrandService.getBrandList(param)) {
				buffer.append(map.get("brandName"));
				buffer.append(",");
			}
			pw.write(buffer.toString().replaceAll(",$", ""));
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getSupplierList", method = RequestMethod.GET)
	public void getSupplierList(@RequestParam String brandName, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			StringBuffer buffer = new StringBuffer();
			Map param = new HashMap();
			param.put("brandName", java.net.URLDecoder.decode(brandName,"UTF-8"));
			for (Map map : supplierProductService.getSupplierList(param)) {
				buffer.append(map.get("supplierName"));
				buffer.append(",");
			}
			pw.write(buffer.toString().replaceAll(",$", ""));
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
