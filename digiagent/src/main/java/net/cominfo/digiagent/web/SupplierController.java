package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "supplier";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = supplierService.count(param);
		List<Supplier> supplierList = supplierService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", supplierList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute Supplier supplier,
			HttpServletResponse response) {
		Supplier supplierUpdate = supplierService.getById(supplier.getSupplierId());
		if (supplier == null) {
			new ResourceNotFoundException(new Long(supplierUpdate.getSupplierId()));
		}
		supplierUpdate.setCityId(supplier.getCityId());
		supplierUpdate.setActiveFlag(supplier.getActiveFlag());
		supplierUpdate.setSupplierName(supplier.getSupplierName());
		supplierUpdate = supplierService.update(supplierUpdate);
		return Collections.singletonMap("supplierId", supplierUpdate.getSupplierId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Supplier get(@RequestParam Integer id) {
		Supplier supplier = supplierService.getById(id);
		if (supplier == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return supplier;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute Supplier supplier,
			HttpServletResponse response) {
		Supplier supplierNew = supplierService.insert(supplier);
		return Collections.singletonMap("supplierId", supplierNew.getSupplierId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		Supplier supplier = supplierService.getById(id);
		if (supplier == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return supplierService.delete(id);
		}
	}
	
	@RequestMapping(value = "/getCityList", method = RequestMethod.GET)
	public void getCityList(@RequestParam Integer id, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(supplierService.getCityList(id));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
