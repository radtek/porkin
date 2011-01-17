package net.cominfo.digiagent.web;

import java.util.HashMap;
import java.util.Map;

import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.CompanyService;
import net.cominfo.digiagent.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/person")
@SessionAttributes( { "userId", "userName", "supplierId" })
public class PersonController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		return "person/menu";
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
		return "person/basicInfo";
	}
	
	@RequestMapping(value = "/passwordForm", method = RequestMethod.GET)
	public String passwordForm(@ModelAttribute("userId") Integer userId,
			Model model) {
		return "person/password";
	}

	@RequestMapping(value = "/infoRelease", method = RequestMethod.GET)
	public String infoRelease(Model model) {
		return "person/infoRelease";
	}
	
	@RequestMapping(value = "/commodityList", method = RequestMethod.GET)
	public String commodityList(Model model) {
		return "person/commodityList";
	}
}
