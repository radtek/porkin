package net.cominfo.digiagent.web;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cominfo.digiagent.captcha.impl.FactoryRandomImpl;
import net.cominfo.digiagent.captcha.render.Producer;
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.service.CompanyService;
import net.cominfo.digiagent.service.UserRoleService;
import net.cominfo.digiagent.spring.FlashMap.Message;
import net.cominfo.digiagent.spring.FlashMap.MessageType;
import net.cominfo.digiagent.spring.security.SecurityService;
import net.cominfo.digiagent.utils.mail.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
@SessionAttributes( { "userId", "userName", "supplierId" })
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(Model model, @RequestParam String username,
			@RequestParam String password, @RequestParam String type, HttpServletResponse response) {
		User user = securityService.login(username, password, type);

		String message = null;
		if (user != null) {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());
			model.addAttribute("supplierId", new Integer(0));
			message = "success";
		}
		else{
			message = "fail";
		}
		return message;
		
	}
	
	@RequestMapping(value = "/autologin", method = RequestMethod.POST)
	public String autoLogin(Model model, @RequestParam String username,
			@RequestParam String password, HttpServletResponse response) {
		User user = securityService.login(username, password, null);
		if (user != null) {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());
			model.addAttribute("supplierId", new Integer(0));
		}
		return "welcome";
		
	}
	
	

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(@ModelAttribute("userId") Integer userId,
			@ModelAttribute("userName") String userName,
			@ModelAttribute("supplierId") Integer supplierId, Model model) {
		List<String> roleIdList = userRoleService
				.getRoleIdListByUserName(userName);
		String roleId = null;

		String result = "welcome";
		if (roleIdList != null && roleIdList.size() > 0) {
			roleId = roleIdList.get(0);
			if (roleId.equals("1") || roleId.equals("2") || roleId.equals("3")) {
				result = "/admin";
			} else if (roleId.equals("4")) {
				SupplierWithBLOBs supplier = companyService
						.getCompanyByUserId(userId);
				if (supplier == null) {
					supplier = companyService.createDefaulutSupplier(userId,
							userName);
				}
				model.addAttribute("supplierId", supplier.getSupplierId());
				result = "company";

			} else if (roleId.equals("5")) {
				result = "person";
			} else {
				result = "welcome";
			}
		}

		return result;
	}
	
	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET)
	public @ResponseBody String adminLogout(SessionStatus status) {
		status.setComplete();
		return "welcome";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "welcome";
	}


	@RequestMapping(value = "/passwordForm", method = RequestMethod.GET)
	public String passwordForm(HttpServletResponse response) {
		return "password";
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String assword(Model model, @RequestParam String username,
			@RequestParam String captcha,HttpSession session) {
		
		String forward = "password";
		boolean existFlag = securityService.isExistByName(username);
		User user = securityService.getUserByName(username);
		if(user!=null){
			String original = (String) session.getAttribute("icaptcha");
			if (!captcha.equalsIgnoreCase(original)) {
				model.addAttribute("captcha", new Message(MessageType.success,
						"password.captcha.error"));
			}
			else{
				// Send mail
				String to = user.getUserEmail();
				String cc = user.getUserEmail();
				String subject = "找回密码";
				String mailTemplate = "password.vm";
				Map data = new HashMap();
				mailService.doPost(to, cc, subject, mailTemplate, data);
				forward = "success";
			}
		}
		else{
			model.addAttribute("captcha", new Message(MessageType.success,
			"password.userName.notExist"));
		}
		return forward;
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public ModelAndView captcha(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

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
