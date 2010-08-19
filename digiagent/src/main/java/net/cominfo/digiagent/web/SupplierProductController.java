package net.cominfo.digiagent.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.domain.SupplierProduct;
import net.cominfo.digiagent.service.SupplierProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		List<SupplierProduct> supplierProductList = supplierProductService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", supplierProductList);
		return Collections.singletonList(map).get(0);
	}
}
