package net.cominfo.digiagent.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.cominfo.digiagent.persistence.domain.Contact;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.CompanyService;
import net.cominfo.digiagent.service.ProductBrandService;
import net.cominfo.digiagent.service.SupplierProductService;
import net.cominfo.digiagent.service.SupplierService;
import net.cominfo.digiagent.spring.FlashMap.Message;
import net.cominfo.digiagent.spring.FlashMap.MessageType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/company")
@SessionAttributes( { "userId", "userName" })
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private SupplierProductService supplierProductService;

	@Autowired
	private ProductBrandService productBrandService;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		return "company/menu";
	}

	@RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
	public String basicInfo(@ModelAttribute("userId") Integer userId,
			Model model) {
		User user = companyService.getUserById(userId);
		model.addAttribute("user", user);
		return "company/basicInfo";
	}

	@RequestMapping(value = "/passwordForm", method = RequestMethod.GET)
	public String passwordForm(@ModelAttribute("userId") Integer userId,
			Model model) {
		return "company/password";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changepassword(@ModelAttribute("userId") Integer userId,
			@RequestParam String oldpassword,
			@RequestParam String newpassword1,
			@RequestParam String newpassword2, Model model) {
		boolean validateUser = companyService.validateUser(userId, oldpassword);
		String promptMsg = "";
		if (validateUser) {
			if (newpassword1.equals(newpassword2)) {
				companyService.changePassword(userId, newpassword1);
				promptMsg = "changePassword.success";
			} else {
				promptMsg = "changePassword.newpassword.error";
			}
		} else {
			promptMsg = "changePassword.oldpassword.error";
		}
		model.addAttribute("message", new Message(MessageType.success,
				promptMsg));
		return "company/password";
	}

	@RequestMapping(value = "/emailForm", method = RequestMethod.GET)
	public String emailForm(@ModelAttribute("userId") Integer userId,
			Model model) {
		User user = companyService.getUserById(userId);
		model.addAttribute("email", user.getUserEmail());
		return "company/email";
	}

	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
	public String changeEmail(@ModelAttribute("userId") Integer userId,
			@RequestParam String oldEmail, @RequestParam String newEmail,
			Model model) {

		String promptMsg = "";
		if (newEmail != null && !newEmail.trim().equals("")) {
			companyService.changeEmail(userId, newEmail);
			model.addAttribute("email", newEmail);
			promptMsg = "changeEmail.success";
		} else {
			model.addAttribute("email", oldEmail);
			promptMsg = "changeEmail.error";
		}
		model.addAttribute("message", new Message(MessageType.success,
				promptMsg));
		return "company/email";
	}

	@RequestMapping(value = "/introductionForm", method = RequestMethod.GET)
	public String introductionForm(@ModelAttribute("userId") Integer userId,
			Model model) {
		Supplier supplier = companyService.getCompanyByUserId(userId);
		model.addAttribute("supplier", supplier);
		return "company/introduction";
	}

	@RequestMapping(value = "/introduction", method = RequestMethod.POST)
	public String introduction(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName, Model model,
			HttpServletRequest request) {
		SupplierWithBLOBs supplier = companyService.getCompanyByUserId(userId);

		String supplierName = (String) request.getParameter("supplierName");
		supplier.setSupplierName(supplierName);

		String supplierContactname = (String) request
				.getParameter("supplierContactname");
		supplier.setSupplierContactname(supplierContactname);

		String supplierZip = (String) request.getParameter("supplierZip");
		supplier.setSupplierZip(supplierZip);

		String supplierAddress = (String) request
				.getParameter("supplierContactname");
		supplier.setSupplierAddress(supplierAddress);

		String supplierTelephone = (String) request
				.getParameter("supplierName");
		supplier.setSupplierTelephone(supplierTelephone);

		String supplierMobile = (String) request.getParameter("supplierMobile");
		supplier.setSupplierMobile(supplierMobile);

		String supplierFax = (String) request.getParameter("supplierFax");
		supplier.setSupplierFax(supplierFax);

		String supplierDescription = (String) request
				.getParameter("supplierDescription");
		supplier.setSupplierDescription(supplierDescription);

		supplier.setLastupdatedBy(userName);
		supplier.setLastupdatedDate(new Date());

		companyService.updateSupplier(supplier);

		model.addAttribute("message", new Message(MessageType.success,
				"supplier.update.success"));
		model.addAttribute("supplier", supplier);

		return "company/introduction";
	}

	@RequestMapping(value = "/contactForm", method = RequestMethod.GET)
	public String contactForm(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName, Model model) {
		SupplierWithBLOBs supplier = companyService.getCompanyByUserId(userId);
		if(supplier==null){
			supplier = companyService.createDefaulutSupplier(userId, userName);
		}
		int supplierId = supplier.getSupplierId();
		List<Contact> contactList = supplierService.getContactBySupplierId(supplierId);
		model.addAttribute("contactList", contactList);
		return "company/contact";
	}

	@RequestMapping(value = "/contactCreate", method = RequestMethod.GET)
	public String contactCreate(Model model) {
		return "company/contact";
	}

	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public String agent(@ModelAttribute("userId") Integer userId, @ModelAttribute("userName") String userName,
			@RequestParam Map<String, Object> param, Model model) {
		SupplierWithBLOBs supplier = companyService.getCompanyByUserId(userId);
		if(supplier==null){
			supplier = companyService.createDefaulutSupplier(userId, userName);
		}
		int supplierId = supplier.getSupplierId();
		param.put("supplierId", supplierId);
		int pageNo = (Integer)(param.get("pageNo") == null ? 1 : param.get("pageNo"));
		int pageSize = (Integer)(param.get("pageSize") == null ? 10 : param.get("pageSize"));
		List<ProductBrand> supplierProductList = supplierProductService.queryProduct(pageNo, pageSize, param);
		model.addAttribute("supplierProductList", supplierProductList);
		return "company/agent";
	}
	
	@RequestMapping(value = "/productBrandList", method = RequestMethod.GET)
	public String productBrandList(@ModelAttribute("userId") Integer userId, @ModelAttribute("userName") String userName,
			@RequestParam Map<String, Object> param, Model model) {
		SupplierWithBLOBs supplier = companyService.getCompanyByUserId(userId);
		if(supplier==null){
			supplier = companyService.createDefaulutSupplier(userId, userName);
		}
		int supplierId = supplier.getSupplierId();
		param.put("supplierId", supplierId);
		param.put("activeFlag", "Y");
//		String[] str = new String[]{"1", "2"};
//		param.put("productbrandIds",  Arrays.asList(str));
		int pageNo = (Integer)(param.get("pageNo") == null ? 1 : param.get("pageNo"));
		int pageSize = (Integer)(param.get("pageSize") == null ? 10 : param.get("pageSize"));
		List<ProductBrand> productBrandList = productBrandService.query(pageNo, pageSize, param);
		model.addAttribute("productBrandList", productBrandList);
		return "company/productBrandList";
	}

	@RequestMapping(value = "/qualify", method = RequestMethod.GET)
	public String qualify(Model model) {
		return "company/menu";
	}

	@RequestMapping(value = "/infoRelease", method = RequestMethod.GET)
	public String infoRelease(Model model) {
		return "company/infoRelease";
	}

	@RequestMapping(value = "/commodityList", method = RequestMethod.GET)
	public String commodityList(Model model) {
		return "company/commodityList";
	}

	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	public String promotion(Model model) {
		return "company/menu";
	}
}
