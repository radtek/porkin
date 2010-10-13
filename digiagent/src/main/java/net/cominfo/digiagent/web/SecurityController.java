package net.cominfo.digiagent.web;

import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cominfo.digiagent.captcha.impl.FactoryRandomImpl;
import net.cominfo.digiagent.captcha.render.Producer;
import net.cominfo.digiagent.persistence.domain.Role;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.UserRoleService;
import net.cominfo.digiagent.service.UserService;
import net.cominfo.digiagent.spring.FlashMap.Message;
import net.cominfo.digiagent.spring.FlashMap.MessageType;
import net.cominfo.digiagent.spring.security.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
@SessionAttributes({"userId","userName"})
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam String username,
			@RequestParam String password) {
		User user = securityService.login(username, password);
		if (user != null) {
			//session.setAttribute("username", user.getUserName());
			//session.setAttribute("userId", user.getUserId());
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());		
		}
		return "welcome";
	}
	
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(@ModelAttribute("userName") String userName) {
		List<String> roleIdList = userRoleService.getRoleIdListByUserName(userName);
		String roleId = null;
		
		String result = "welcome";
		if(roleIdList!=null && roleIdList.size()>0){
			roleId = roleIdList.get(0);
			if(roleId.equals("1") || roleId.equals("2") || roleId.equals("3")){
				result = "/admin";
			}
			else if (roleId.equals("4")){
				result = "company";
			}
			else if (roleId.equals("5")){
				result = "person";
			}
			else{
				result = "welcome";
			}
		}
		
		return result;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "welcome";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userName") String userName,Model model, HttpServletRequest request, HttpSession session) {
		
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String captcha = request.getParameter("captcha");
		
		boolean existFlag = securityService.isExistByName(username);
		String forward = "register";
		boolean hasError = false;
		if(existFlag){
			model.addAttribute("username", new Message(MessageType.success,"register.username.exist"));
			hasError = true;
		}
		if(!password1.equals(password2) || password1==null || password1.equals("")){
			model.addAttribute("password", new Message(MessageType.success,"register.password.error"));
			hasError = true;
		}
		if(email == null || email.equals("")){
			model.addAttribute("email", new Message(MessageType.success,"register.email.error"));
			hasError = true;
		}
		String original = (String)session.getAttribute("icaptcha");
		if(!captcha.equals(original)){
			model.addAttribute("captcha", new Message(MessageType.success,"register.captcha.error"));
			hasError = true;
		}
//		
//		if(!agree.equalsIgnoreCase("Y")){
//			model.addAttribute("agree", new Message(MessageType.success,"register.agree.checked"));
//			hasError = true;
//		}
		
		if(hasError){
			forward = "register";
		}
		else{
			Role role = securityService.getRoleByName(type);
			User user = new User();
			user.setUserName(username);
			user.setUserPassword(password1);
			user.setUserEmail(email);
			int roleId = role.getRoleId();
			boolean companyFlag = (roleId==4)?true:false;
			userService.register(user, role.getRoleId(),companyFlag,userName);
			forward = "welcome";
		}	
		return forward;
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String register(HttpServletResponse response) {
		return "register";
	}
	
	
	@RequestMapping(value = "/passwordForm", method = RequestMethod.GET)
	public String passwordForm(HttpServletResponse response) {
		return "password";
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public ModelAndView captcha(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) {

		Properties props = new Properties();
		String ext = "jpg";
		props.put("format", ext);
		props.put("font", "Helvetica");
		props.put("fontsize", "28");
		props.put("min-width", "180");
		props.put("padding-x", "20");
		props.put("padding-y", "20");

		try {
			OutputStream os = response.getOutputStream();
			FactoryRandomImpl inst = (FactoryRandomImpl) Producer
					.forName("net.cominfo.digiagent.captcha.impl.FactoryRandomImpl");
			inst.setSize(6);
			Producer.render(os, inst, props);
			session = request.getSession();
			session.setAttribute("icaptcha", inst.getLastWord());

		} catch (Exception e) {

		}

		return null;
	}
	
}
