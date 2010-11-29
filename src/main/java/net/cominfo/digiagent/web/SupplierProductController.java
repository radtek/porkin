package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;
import net.cominfo.digiagent.persistence.domain.SupplierProductKey;
import net.cominfo.digiagent.service.SupplierProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/supplierProduct")
public class SupplierProductController {
	
	@Autowired
	private SupplierProductService supplierProductService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "supplierProduct";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = supplierProductService.count(param);
		List<SupplierProductKey> supplierProductList = supplierProductService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", supplierProductList);
		return Collections.singletonList(map).get(0);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/productSearch", method = RequestMethod.GET)
	public @ResponseBody
	Map queryProduct(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = supplierProductService.countProduct(param);
		List<ProductBrand> supplierProductList = supplierProductService.queryProduct(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", supplierProductList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/addSupplierProduct", method = RequestMethod.GET)
	public void addSupplierProduct(@RequestParam String productBrandIds, @RequestParam String supplierId, HttpServletResponse response) {
		String result = supplierProductService.addSupplierProduct(productBrandIds.split(","), supplierId);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/updateSupplierProduct", method = RequestMethod.POST)
	public void updateSupplierProduct(@ModelAttribute SupplierProduct supplierProduct, HttpServletResponse response) {
		String result = supplierProductService.updateSupplierProduct(supplierProduct);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/deleteSupplierProduct", method = RequestMethod.GET)
	public void deleteSupplierProduct(@RequestParam String productBrandIds, @RequestParam String supplierId, HttpServletResponse response) {
		String result = supplierProductService.deleteSupplierProduct(productBrandIds.split(","), supplierId);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
