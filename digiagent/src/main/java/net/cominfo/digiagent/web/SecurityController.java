package net.cominfo.digiagent.web;

import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cominfo.digiagent.captcha.impl.FactoryRandomImpl;
import net.cominfo.digiagent.captcha.render.Producer;
import net.cominfo.digiagent.persistence.domain.Role;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.UserService;
import net.cominfo.digiagent.spring.security.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam String username,
			@RequestParam String password, HttpSession session) {
		String userName = securityService.login(username, password);
		if (userName != null) {
			session.setAttribute("username", userName);
		}
		return "welcome";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("usrename");
		session.invalidate();
		return "welcome";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam String type,
			@RequestParam String username, @RequestParam String password,
			@RequestParam String email) {

		Role role = securityService.getRoleByName(type);

		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setUserEmail(email);
		userService.register(user, role.getRoleId());

		return "welcome";
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String register(HttpServletResponse response) {
		return "register";
	}

	@RequestMapping(value = "/passwordForm", method = RequestMethod.GET)
	public String password(HttpServletResponse response) {
		return "password";
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public ModelAndView captcha(HttpServletRequest request,
			HttpServletResponse response) {

		Properties props = new Properties();
		String ext = "jpg";
		props.put("format", ext);
		props.put("font", "Helvetica");
		props.put("fontsize", "28");
		props.put("min-width", "180");
		props.put("padding-x", "25");
		props.put("padding-y", "25");

		try {
			OutputStream os = response.getOutputStream();
			FactoryRandomImpl inst = (FactoryRandomImpl) Producer
					.forName("net.cominfo.digiagent.captcha.impl.FactoryRandomImpl");
			inst.setSize(6);
			Producer.render(os, inst, props);
			HttpSession session = request.getSession();
			session.setAttribute("icaptcha", inst.getHashCode(inst
					.getLastWord()));

		} catch (Exception e) {

		}

		return null;
	}
}
