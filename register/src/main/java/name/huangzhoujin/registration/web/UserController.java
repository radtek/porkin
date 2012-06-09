package name.huangzhoujin.registration.web;

import name.huangzhoujin.registration.persistence.domain.User;
import name.huangzhoujin.registration.service.UserService;
import name.huangzhoujin.registration.utils.FlashMap.Message;
import name.huangzhoujin.registration.utils.FlashMap.MessageType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username,
			@RequestParam String password, Model model) {
		User user = userService.login(username, password);
		if (user != null) {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUsername());
			model.addAttribute("roleId", user.getRoleFlag());
			return "admin/home";
		}
		else{
			model.addAttribute("userlogin", new Message(MessageType.error,
					"user.login.error"));
			return "user/login";
		}
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(@RequestParam String username,
			@RequestParam String password, Model model) {
		return "";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		return "user/login";

	}

}
