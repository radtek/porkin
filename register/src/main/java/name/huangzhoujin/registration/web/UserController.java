package name.huangzhoujin.registration.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.domain.Education;
import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.persistence.domain.Location;
import name.huangzhoujin.registration.persistence.domain.User;
import name.huangzhoujin.registration.persistence.dto.CustomDto;
import name.huangzhoujin.registration.service.AreaService;
import name.huangzhoujin.registration.service.CustomService;
import name.huangzhoujin.registration.service.EducationService;
import name.huangzhoujin.registration.service.LevelService;
import name.huangzhoujin.registration.service.LocationService;
import name.huangzhoujin.registration.service.UserService;
import name.huangzhoujin.registration.utils.FlashMap.Message;
import name.huangzhoujin.registration.utils.FlashMap.MessageType;
import name.huangzhoujin.registration.utils.Page;
import name.huangzhoujin.registration.utils.SystemConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({ "userId", "userName", "roleId" })
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomService customService;

	@Autowired
	private AreaService areaService;

	@Autowired
	private EducationService educationService;

	@Autowired
	private LevelService levelService;

	@Autowired
	private LocationService locationService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username,
			@RequestParam String password, Model model) {
		User user = userService.login(username, password);
		if (user != null) {

			Page<CustomDto> page = new Page<CustomDto>();
			page.setPageNo(1);
			page.setPageSize(10);
			HashMap param = new HashMap();
			param.put("first", page.getFirst());
			param.put("pageSize", page.getPageSize());
			page.setResult(customService.listByCondition(param));
			page.setTotalCount(customService.countByCondition(param));

			model.addAttribute("page", page);
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUsername());
			model.addAttribute("roleId", user.getRoleFlag());

			List<Area> areaList = areaService.getAll();
			model.addAttribute(SystemConstants.AreaCache, areaList);
			List<Education> eductionList = educationService.getAll();
			model.addAttribute(SystemConstants.EducationCache, eductionList);
			List<Level> levelList = levelService.getAll();
			model.addAttribute(SystemConstants.LevelCache, levelList);
			List<Location> locationList = locationService.getAll();
			model.addAttribute(SystemConstants.LocationCache, locationList);

			return "admin/home";
		} else {
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		Page<User> page = new Page<User>();
		page.setPageNo(1);
		page.setPageSize(10);
		List<User> areaList = userService.getByPage(page.getFirst(),
				page.getPageSize());
		page.setResult(areaList);
		page.setTotalCount(userService.countAlluser());
		model.addAttribute("page", page);
		return "user/list";
	}

	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public String addForm(Model model) {
		return "user/add";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String roleFlag = request.getParameter("roleFlag");
		String active = request.getParameter("active");
		
		String forward = "user/add";
		
		boolean existedUser = userService.existedUser(username);
		if(existedUser){
			model.addAttribute("useradd", new Message(MessageType.info,
					"user.existed.user"));
		}
		else{
			if(password.equals(password2)){
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setRoleFlag(roleFlag);
				user.setActive(active);
				if(userService.create(user)){
					forward ="redirect:/user/list";
				}
			}
			else{
				model.addAttribute("useradd", new Message(MessageType.info,
						"user.confict.password"));
			}
		}
		return forward;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam Integer id) {
		User user = userService.getById(id);
		if (user == null) {
			return "fail";
		} else {
			userService.delete(id);
			return "redirect:/user/list";
		}
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String roleFlag = request.getParameter("roleFlag");
		String active = request.getParameter("active");
		
		User user = new User();
		user.setUserId(Integer.parseInt(userId));
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setRoleFlag(roleFlag);
		user.setActive(active);
		userService.save(user);
		return "redirect:/location/list";
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String display(@RequestParam Integer pageNo,
			HttpServletRequest request, Model model) {
		Page<User> page = new Page<User>();
		page.setPageNo(pageNo);
		page.setPageSize(10);
		List<User> userList = userService.getByPage(
				page.getFirst(), page.getPageSize());
		page.setResult(userList);
		page.setTotalCount(userService.countAlluser());
		model.addAttribute("page", page);
		return "user/list";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/user/home";
	}

}
