package net.cominfo.digiagent.web;

import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.CompanyService;
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
	public String introductionForm(@ModelAttribute("userId") Integer userId,Model model) {
		Supplier supplier = companyService.getCompanyByUserId(userId);
		model.addAttribute("supplier", supplier);
		return "company/introduction";
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
