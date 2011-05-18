package net.cominfo.digiagent.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.cominfo.digiagent.persistence.domain.Role;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.CategoryService;
import net.cominfo.digiagent.service.ProductBrandService;
import net.cominfo.digiagent.service.ProductService;
import net.cominfo.digiagent.service.SortableService;
import net.cominfo.digiagent.service.SupplierProductService;
import net.cominfo.digiagent.service.SupplierService;
import net.cominfo.digiagent.service.UserService;
import net.cominfo.digiagent.spring.FlashMap.Message;
import net.cominfo.digiagent.spring.FlashMap.MessageType;
import net.cominfo.digiagent.spring.security.SecurityService;
import net.cominfo.digiagent.utils.ValidatorUtils;
import net.sf.json.JSONArray;

@Controller
@RequestMapping(value = "/")
public class GeneralController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductBrandService productBrandService;

	@Autowired
	private SortableService sortableService;

	@Autowired
	private SupplierProductService supplierProductService;

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String aboutUs(Model model) {
		return "about";
	}

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String head(Model model) {
		return "header";
	}

	@RequestMapping(value = "/agreement", method = RequestMethod.GET)
	public String agreement(Model model) {
		return "agreement";
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String register(HttpServletResponse response) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, HttpServletRequest request,
			HttpSession session) {

		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String captcha = request.getParameter("captcha");
		model.addAttribute("user_type", type);
		model.addAttribute("user_username", username);
		model.addAttribute("user_email", email);
		boolean existFlag = securityService.isExistByName(username);
		String forward = "register";
		boolean hasError = false;
		if (existFlag) {
			model.addAttribute("username", new Message(MessageType.success,
					"register.username.exist"));
			hasError = true;
		}
		if (!password1.equals(password2) || password1 == null
				|| password1.equals("")) {
			model.addAttribute("password", new Message(MessageType.success,
					"register.password.error"));
			hasError = true;
		}
		if (email == null || email.equals("")
				|| !ValidatorUtils.validateEmail(email)) {
			model.addAttribute("email", new Message(MessageType.success,
					"register.email.error"));
			hasError = true;
		}

		existFlag = securityService.isExistByName(username);
		if (existFlag) {
			model.addAttribute("email", new Message(MessageType.success,
					"register.email.exist"));
			hasError = true;
		}

		String original = (String) session.getAttribute("icaptcha");

		// 验证码不区分大小写
		if (!captcha.equalsIgnoreCase(original)) {
			model.addAttribute("captcha", new Message(MessageType.success,
					"register.captcha.error"));
			hasError = true;
		}
		//
		// if(!agree.equalsIgnoreCase("Y")){
		// model.addAttribute("agree", new
		// Message(MessageType.success,"register.agree.checked"));
		// hasError = true;
		// }

		if (hasError) {
			forward = "register";
		} else {
			Role role = securityService.getRoleByName(type);
			User user = new User();
			user.setUserName(username);
			user.setUserPassword(password1);
			user.setUserEmail(email);
			int roleId = role.getRoleId();
			boolean companyFlag = (roleId == 4) ? true : false;
			userService.register(user, role.getRoleId(), companyFlag, username);
			model.addAttribute("username", username);
			model.addAttribute("password", password1);
			forward = "register_success";
		}
		return forward;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/freeSearch", method = RequestMethod.POST)
	public String freeSearch(@RequestParam String searchkw,
			@RequestParam String productId, @RequestParam String brandId,
			Model model) {
		List<Supplier> supplierList = null;
		if (StringUtils.isNotEmpty(searchkw)) {
			supplierList = supplierService.getSupplierList(searchkw);
		} else if (StringUtils.isNotEmpty(productId)) {
			Map condition = new HashMap();
			condition.put("brandId", brandId);
			condition.put("productId", productId);
			supplierList = supplierProductService
					.getMainPageSupplierList(condition);
		}
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("searchkw", searchkw);
		model.addAttribute("type", "supplierList");
		return "welcome";
	}

	/**
	 * 帐号验证
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/validateUserName", method = RequestMethod.GET)
	public @ResponseBody
	Boolean validateUserName(@RequestParam String username) {
		return securityService.isExistByName(username);
	}

	/**
	 * 邮箱验证
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/validateEmail", method = RequestMethod.GET)
	public @ResponseBody
	Boolean validateEmail(@RequestParam String email) {
		return securityService.isExistByEmail(email);
	}

	/**
	 * 从商家详细返回
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request, Model model) {
		String otherParam[] = { "categoryId", "productId", "productBrandId" };
		for (String key : otherParam) {
			String value = request.getParameter(key);
			if (value != null) {
				model.addAttribute(key, value);
			}
		}
		return "redirect:/welcome";
	}

	/**
	 * Search Bar 读取各列表
	 * <p>
	 * Example : http://localhost:8080/digiagent/sortable/0/0
	 * </p>
	 * 
	 * @param type
	 *            0:category 1:product 2:brand
	 * @param parentId
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sortable/{type}/{parentId}", method = RequestMethod.GET)
	public String sortable(@PathVariable Integer type,
			@PathVariable Integer parentId, Model model) {
		List<Map> categoryList = null;
		List<Map> productList = null;
		List<Map> brandList = null;
		List<Map> supplierList = null;
		int categoryId = 0;
		int productId = 0;
		Map param = new HashMap();
		try {
			switch (type) {
			case 0:
				categoryList = categoryService.getCateogryList();
				break;
			case 1:
				categoryList = categoryService.getCateogryList();
				categoryId = parentId;
				param.put("categoryId", parentId);
				productList = productService.getProductList(param);
				break;
			case 2:
				categoryList = categoryService.getCateogryList();
				categoryId = productService.getById(parentId).getCategoryId();
				// get product list
				param.put("categoryId", categoryId);
				productList = productService.getProductList(param);
				// get brand list
				param.put("productId", parentId);
				brandList = productBrandService.getBrandList(param);
				break;
			case 3:
				categoryList = categoryService.getCateogryList();
				productId = productBrandService.getById(parentId)
						.getProductId();
				// get brand list
				param.put("productId", productId);
				brandList = productBrandService.getBrandList(param);
				categoryId = productService.getById(productId).getCategoryId();
				param.clear();
				// get product list
				param.put("categoryId", categoryId);
				productList = productService.getProductList(param);
				param.clear();
				// get supplier list
				param.put("productBrandId", parentId);
				model.addAttribute("productBrandId", parentId);
				supplierList = supplierProductService.getSupplierList(param);
				parentId = productBrandService.getById(parentId).getBrandId();
				break;
			default:
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("productId", productId);
		model.addAttribute("type", type);
		model.addAttribute("parentId", parentId);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("productList", productList);
		model.addAttribute("brandList", brandList);
		model.addAttribute("supplierList", supplierList);
		return "sortable";
	}

	/**
	 * 保存Search Bar 排序结果
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Model model) {
		String items = request.getParameter("items");
		int type = Integer.valueOf((String) request.getParameter("type"));
		int parentId = Integer.valueOf((String) request
				.getParameter("parentId"));
		JSONArray jsonArray = JSONArray.fromObject(items);
		Object[] itemIds = jsonArray.toArray();
		int[] sortItemIds = new int[itemIds.length];
		int i = 0;
		for (Object itemId : itemIds) {
			sortItemIds[i++] = Integer.valueOf((String) itemId);
		}
		switch (type) {
		case 0:
			sortableService.sortCategory(sortItemIds);
			break;
		case 1:
			sortableService.sortProduct(sortItemIds, parentId);
			break;
		case 2:
			sortableService.sortBrand(sortItemIds, parentId);
			break;
		case 3:
			int productBrandId = Integer.valueOf((String) request
					.getParameter("productBrandId"));
			sortableService.sortSupplier(sortItemIds, parentId);
			parentId = productBrandId;
			break;
		default:
			break;
		}
		return "redirect:/sortable/" + type + "/" + parentId;
	}

	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	public String sales(Model model) {
		return "promotion";
	}

	@RequestMapping(value = "/secondHand", method = RequestMethod.GET)
	public String secondHand(Model model) {
		return "secondHand";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("type", "navigationList");
		model.addAttribute("navigationList",
				sortableService.getNavigationPage());
		return "welcome";
	}

}
