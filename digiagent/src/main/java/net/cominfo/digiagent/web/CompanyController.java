package net.cominfo.digiagent.web;

import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.CompanyService;

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

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		return "company/menu";
	}

	@RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
	public String basicInfo(@ModelAttribute("userId") Integer userId,
			Model model) {
		User user = companyService.getUserById(userId);
		model.addAttribute("user", user);
		user.getLastlogintime();
		user.getLogonsum();
		return "company/basicInfo";
	}

	@RequestMapping(value = "/passwordForm", method = RequestMethod.GET)
	public String passwordForm(@ModelAttribute("userId") Integer userId,
			Model model) {
		return "company/password";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changepassword(@ModelAttribute("userId") Integer userId,
			@RequestParam String oldpassword,
			@RequestParam String newpassword1,
			@RequestParam String newpassword2, Model model) {
		boolean validateUser = companyService.validateUser(userId, oldpassword);
		if(validateUser){
			if(newpassword1.equals(newpassword2)){
				
			}
			else{
				
			}
		}
		else{
			
		}
		
		return "company/password";
	}

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String email(Model model) {
		return "company/menu";
	}

	@RequestMapping(value = "/introduction", method = RequestMethod.GET)
	public String introduction(Model model) {
		return "company/menu";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		return "company/menu";
	}

	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public String agent(Model model) {
		return "company/menu";
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
