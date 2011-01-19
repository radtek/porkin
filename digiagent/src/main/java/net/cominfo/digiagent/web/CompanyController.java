package net.cominfo.digiagent.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.Contact;
import net.cominfo.digiagent.persistence.domain.Country;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.CategoryService;
import net.cominfo.digiagent.service.CompanyService;
import net.cominfo.digiagent.service.ContactService;
import net.cominfo.digiagent.service.CountryService;
import net.cominfo.digiagent.service.SupplierProductService;
import net.cominfo.digiagent.service.SupplierService;
import net.cominfo.digiagent.service.UserService;
import net.cominfo.digiagent.spring.FlashMap.Message;
import net.cominfo.digiagent.spring.FlashMap.MessageType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/company")
@SessionAttributes( { "userId", "userName", "supplierId" })
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private ContactService contactService;

	@Autowired
	private SupplierProductService supplierProductService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		return "company/menu";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
	public String basicInfo(@ModelAttribute("userId") Integer userId,
			Model model) {
		User user = companyService.getUserById(userId);
		model.addAttribute("user", user);
		Map condition = new HashMap();
		condition.put("userId", userId);
		model.addAttribute("userRole", userService.getUserInfo(condition));
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
		model.addAttribute("cityList", companyService.getAllCity());
		return "company/introduction";
	}

	@RequestMapping(value = "/introduction", method = RequestMethod.POST)
	public String introduction(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName, Model model,
			HttpServletRequest request) {
		SupplierWithBLOBs supplier = companyService.getCompanyByUserId(userId);

		String cityId = (String) (String) request.getParameter("cityId");
		supplier.setCityId(Integer.valueOf(cityId));

		String supplierName = (String) request.getParameter("supplierName");
		supplier.setSupplierName(supplierName);

		String supplierContactname = (String) request
				.getParameter("supplierContactname");
		supplier.setSupplierContactname(supplierContactname);

		String supplierZip = (String) request.getParameter("supplierZip");
		supplier.setSupplierZip(supplierZip);

		String supplierAddress = (String) request
				.getParameter("supplierAddress");
		supplier.setSupplierAddress(supplierAddress);

		String supplierTelephone = (String) request
				.getParameter("supplierTelephone");
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

	@RequestMapping(value = "/contact/list", method = RequestMethod.GET)
	public String contactList(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName,
			@ModelAttribute("supplierId") Integer supplierId, Model model) {
		List<Contact> contactList = supplierService
				.getContactBySupplierId(supplierId);
		model.addAttribute("contactList", contactList);
		return "company/contact";
	}

	@RequestMapping(value = "/contact/delete/{id}", method = RequestMethod.GET)
	public String contactDelete(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName,
			@PathVariable Integer id, Model model) {
		supplierService.deleteContactById(id);

		return "redirect:/company/contact/list";
	}

	@RequestMapping(value = "/contact/form", method = RequestMethod.GET)
	public String contactCreateFrom(Model model) {
		return "company/contact/create";
	}

	@RequestMapping(value = "/contact/create", method = RequestMethod.GET)
	public String contactCreate(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName,
			@ModelAttribute("supplierId") Integer supplierId,
			@RequestParam String contactType,
			@RequestParam String contactContent, Model model) {
		Contact contact = new Contact();
		contact.setSupplierId(supplierId);
		contact.setContactContent(contactContent);
		contact.setContactType(contactType);
		contact.setActiveFlag("Y");
		contactService.insert(contact, userName);
		return "redirect:/company/contact/list";
	}

	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public String agent(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName,
			@RequestParam Map<String, Object> param, Model model) {
		SupplierWithBLOBs supplier = companyService.getCompanyByUserId(userId);
		if (supplier == null) {
			supplier = companyService.createDefaulutSupplier(userId, userName);
		}
		int supplierId = supplier.getSupplierId();
		param.put("supplierId", supplierId);
		int pageNo = (Integer) (param.get("pageNo") == null ? 1 : param
				.get("pageNo"));
		int pageSize = (Integer) (param.get("pageSize") == null ? 10 : param
				.get("pageSize"));
		List<ProductBrand> supplierProductList = supplierProductService
				.queryProduct(pageNo, pageSize, param);
		model.addAttribute("supplierProductList", supplierProductList);
		return "company/agent";
	}

	@RequestMapping(value = "/agent/form", method = RequestMethod.GET)
	public String agentForm(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName, Model model) {
		List<Country> countryList = countryService.getAllCountry();
		List<Category> categoryList = categoryService.getAllCategory();
		model.addAttribute("countryList", countryList);
		model.addAttribute("categoryList", categoryList);
		return "company/agent/form";
	}
	
	@RequestMapping(value = "/agent/create", method = RequestMethod.GET)
	public String agentCreate(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName, 
			@ModelAttribute("supplierId") Integer supplierId,
			@RequestParam Integer brandId,
			@RequestParam Integer productId,
			Model model) {
		
		companyService.applySupplier(supplierId, brandId, productId, userName);
		return "redirect:/company/agent?page=1";
	}

	@RequestMapping(value = "/agent/delete/{id}", method = RequestMethod.GET)
	public String agentDelete(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName,
			@ModelAttribute("supplierId") Integer supplierId,
			@PathVariable Integer id, Model model) {
		supplierProductService.deleteSupplierProduct(id, supplierId);
		return "redirect:/company/agent?page=1";
	}
	

	@RequestMapping(value = "/picture", method = RequestMethod.GET)
	public String picture(Model model) {
		return "company/picture";
	}
	
	@RequestMapping(value = "/updatePicture", method = RequestMethod.POST)
	public String updatePicture(@ModelAttribute SupplierWithBLOBs supplier,
			@ModelAttribute("userName") String userName,
			@RequestParam("file1") MultipartFile image1,
			@RequestParam("file2") MultipartFile image2,
			HttpServletResponse response,Model model) throws IOException {
		supplier = supplierService.getById(supplier.getSupplierId());
		
		boolean updateFlag = true;
		// MYSQL BLOB类型最大65K--实名认证
		if (image1.getSize() > 0 && image1.getSize() / 1024 < 65) {
			supplier.setSupplierCertify(image1.getBytes());
		}
		else{
			if(image1!=null && image1.getSize() / 1024 >65){
				model.addAttribute("message", new Message(MessageType.success,
				"image1.size.overlarge"));
				updateFlag = false;
			}
		}
		
		// MYSQL BLOB类型最大65K--资质认证
		if (image2.getSize() > 0 && image2.getSize() / 1024 < 65) {
			supplier.setSupplierQualify(image2.getBytes());
		}
		else{
			if(image2!=null && image2.getSize() / 1024 > 65){
				model.addAttribute("message", new Message(MessageType.success,
				"image2.size.overlarge"));
				updateFlag = false;	
			}
		}

		if(updateFlag){
			supplier = supplierService.update(supplier, userName);
			model.addAttribute("message", new Message(MessageType.success,
			"image.update.success"));
		}
		return "company/picture";
	}

	@RequestMapping(value = "/qualify", method = RequestMethod.GET)
	public String qualify(@ModelAttribute("supplierId") Integer supplierId, Model model) {
		model.addAttribute("supplierId", supplierId);
		return "company/menu";
	}

	@RequestMapping(value = "/infoRelease", method = RequestMethod.GET)
	public String infoRelease(Model model) {
		return "company/infoRelease";
	}
	

	@RequestMapping(value = "/infoRelease2", method = RequestMethod.GET)
	public String infoRelease2(Model model) {
		return "company/infoRelease2";
	}

	@RequestMapping(value = "/commodityList", method = RequestMethod.GET)
	public String commodityList(Model model) {
		return "company/commodityList";
	}
	
	@RequestMapping(value = "/commodityList2", method = RequestMethod.GET)
	public String commodityList2(Model model) {
		return "company/commodityList2";
	}

	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	public String promotion(Model model) {
		return "company/menu";
	}
}
