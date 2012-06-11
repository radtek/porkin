package name.huangzhoujin.registration.web;

import java.util.HashMap;
import java.util.List;

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
import name.huangzhoujin.registration.utils.Page;
import name.huangzhoujin.registration.utils.SystemConstants;
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
			param.put("first",page.getFirst());
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
