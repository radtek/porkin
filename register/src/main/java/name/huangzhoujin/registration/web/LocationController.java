package name.huangzhoujin.registration.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import name.huangzhoujin.registration.persistence.domain.Location;
import name.huangzhoujin.registration.service.LocationService;
import name.huangzhoujin.registration.utils.FlashMap.Message;
import name.huangzhoujin.registration.utils.FlashMap.MessageType;
import name.huangzhoujin.registration.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/location")
@SessionAttributes({ "userId", "userName", "roleId" })
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String home(Model model) {
		Page<Location> page = new Page<Location>();
		page.setPageNo(1);
		page.setPageSize(10);
		List<Location> locationList = locationService.getByPage(
				page.getFirst(), page.getPageSize());
		page.setResult(locationList);
		page.setTotalCount(locationService.countAllLocation());
		model.addAttribute("page", page);
		return "location/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam Integer id) {
		Location location = locationService.getById(id);
		if (location == null) {
			return "fail";
		} else {
			locationService.delete(id);
			return "redirect:/location/list";
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam Integer id,
			@RequestParam String locationName, Model model) {
		Location location = new Location();
		location.setLocationId(id);
		location.setLocationName(locationName);
		locationService.save(location);
		return "redirect:/location/list";

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@RequestParam String locationName, Model model) {
		Location location = new Location();
		location.setLocationName(locationName);
		boolean result = locationService.create(location);
		if (result) {
			model.addAttribute("location", new Message(MessageType.info,
					"admin.sava.success"));
		} else {
			model.addAttribute("location", new Message(MessageType.info,
					"admin.save.failure"));
		}
		return "location/result";

	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String display(@RequestParam Integer pageNo,
			HttpServletRequest request, Model model) {
		Page<Location> page = new Page<Location>();
		page.setPageNo(pageNo);
		page.setPageSize(10);
		List<Location> locationList = locationService.getByPage(
				page.getFirst(), page.getPageSize());
		page.setResult(locationList);
		page.setTotalCount(locationService.countAllLocation());
		model.addAttribute("page", page);
		return "location/list";

	}

	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public String addForm(Model model) {
		return "location/add";
	}

}
