package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.persistence.domain.UserRole;
import net.cominfo.digiagent.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes( { "userId", "userName" })
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "user";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows,
			@RequestParam Map param) {
		Long total = userService.count(param);
		List<User> userList = userService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", userList);
		return Collections.singletonList(map).get(0);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(
			@ModelAttribute("userName") String userName,
			@ModelAttribute User user, @ModelAttribute UserRole userRole,
			HttpServletResponse response) {
		User userUpdate = userService.getById(user.getUserId());
		if (user == null) {
			new ResourceNotFoundException(new Long(userUpdate.getUserId()));
		}
		userUpdate.setUserEmail(user.getUserEmail());
		userUpdate.setActiveFlag(user.getActiveFlag());
		userUpdate.setUserName(user.getUserName());
		userUpdate.setUserPassword(user.getUserPassword());
		userUpdate = userService.update(userUpdate, userRole, userName);
		return Collections.singletonMap("userId", userUpdate.getUserId());
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody
	Map get(@RequestParam Integer id) {
		Map condition = new HashMap();
		condition.put("userId", id);
		Map user = userService.getUserInfo(condition);
		if (user == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return user;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(
			@ModelAttribute("userName") String userName,
			@ModelAttribute User user, @ModelAttribute UserRole userRole,
			HttpServletResponse response) {
		User userNew = userService.insert(user, userRole, userName);
		return Collections.singletonMap("userId", userNew.getUserId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	String delete(@RequestParam Integer id) {
		User user = userService.getById(id);
		if (user == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return userService.delete(id);
		}
	}

	@RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
	public void getRoleList(HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(userService.getRoleList());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
