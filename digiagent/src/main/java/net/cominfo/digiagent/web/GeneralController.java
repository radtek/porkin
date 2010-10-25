package net.cominfo.digiagent.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cominfo.digiagent.persistence.domain.Role;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.UserService;
import net.cominfo.digiagent.spring.FlashMap.Message;
import net.cominfo.digiagent.spring.FlashMap.MessageType;
import net.cominfo.digiagent.spring.security.SecurityService;
import net.cominfo.digiagent.utils.ValidatorUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class GeneralController {
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;
	
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
	public String register(Model model, HttpServletRequest request, HttpSession session) {

		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String captcha = request.getParameter("captcha");

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
		if (email == null || email.equals("") || !ValidatorUtils.validateEmail(email) ) {
			model.addAttribute("email", new Message(MessageType.success,
					"register.email.error"));
			hasError = true;
		}
		String original = (String) session.getAttribute("icaptcha");
		
		//验证码不区分大小写
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

	


}
