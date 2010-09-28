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
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.persistence.domain.UserRole;
import net.cominfo.digiagent.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


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
	public void update(@ModelAttribute SupplierWithBLOBs supplier,
			@RequestParam("file") MultipartFile image,
			HttpServletResponse response) throws IOException {
		SupplierWithBLOBs supplierUpdate = supplierService.getById(supplier.getSupplierId());
		if (supplier == null) {
			new ResourceNotFoundException(new Long(supplierUpdate.getSupplierId()));
		}
		supplier.setCreatedBy(supplierUpdate.getCreatedBy());
		supplier.setCreatedDate(supplierUpdate.getCreatedDate());
		supplier.setUserId(supplierUpdate.getUserId());
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize()/1024 < 65) {
			supplier.setSupplierImage(image.getBytes());
		}
		try {
			PrintWriter pw = response.getWriter();
			if (image.getSize()/1024 >= 65) {
				pw.write(Collections.singletonMap("supplierId", -2).toString().replaceAll("=", ":"));
			} else {
				supplier = supplierService.update(supplier);
				pw.write(Collections.singletonMap("supplierId", supplier.getSupplierId()).toString().replaceAll("=", ":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void create(@ModelAttribute SupplierWithBLOBs supplier,
			@RequestParam("file") MultipartFile image,
			@ModelAttribute User user,
			@ModelAttribute UserRole userRole,
			HttpServletResponse response) throws IOException {
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize()/1024 < 65) {
			supplier.setSupplierImage(image.getBytes());
		}
		try {
			PrintWriter pw = response.getWriter();
			if (image.getSize()/1024 >= 65) {
				pw.write(Collections.singletonMap("supplierId", -2).toString().replaceAll("=", ":"));
			} else {
				supplier = supplierService.insert(supplier, user, userRole);
				pw.write(Collections.singletonMap("supplierId", supplier.getSupplierId()).toString().replaceAll("=", ":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Supplier supplierNew = supplierService.insert(supplier);
//		return Collections.singletonMap("supplierId", supplierNew.getSupplierId());
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
	
	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public String output(@RequestParam Integer id, HttpServletResponse response, Model model) {
		model.addAttribute("image", supplierService.getSupplierImage(id));
		return "image";
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String show(@PathVariable Integer id, HttpServletResponse response, Model model) {
		Supplier supplier = supplierService.getById(id);
		if(supplier!=null){
			model.addAttribute("supplier", supplierService.getById(id));
			return "supplierDetail";
		}
		else{
			return "no_supplier";
		}
		
	}
}
