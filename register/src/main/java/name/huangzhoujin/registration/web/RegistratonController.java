package name.huangzhoujin.registration.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.domain.Education;
import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.persistence.domain.Location;
import name.huangzhoujin.registration.persistence.dto.CustomDto;
import name.huangzhoujin.registration.service.AreaService;
import name.huangzhoujin.registration.service.CustomService;
import name.huangzhoujin.registration.service.EducationService;
import name.huangzhoujin.registration.service.LevelService;
import name.huangzhoujin.registration.service.LocationService;
import name.huangzhoujin.registration.utils.NumberUtil;
import name.huangzhoujin.registration.utils.Page;
import name.huangzhoujin.registration.utils.StringUtil;
import name.huangzhoujin.registration.utils.SystemConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/registration")
public class RegistratonController {

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
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		Page<CustomDto> page = new Page<CustomDto>();
		page.setPageNo(1);
		page.setPageSize(10);
		HashMap param = new HashMap();
		param.put("first", page.getFirst());
		param.put("pageSize", page.getPageSize());
		page.setResult(customService.listByCondition(param));
		page.setTotalCount(customService.countByCondition(param));

		model.addAttribute("page", page);

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String register = StringUtil.toNull(request.getParameter("register"));
		String id_card = StringUtil.toNull(request.getParameter("id_card"));
		String telephone = StringUtil.toNull(request.getParameter("telephone"));
		Integer area_id = NumberUtil.strToIngeger(StringUtil.toNull(request
				.getParameter("area_id")));
		String old_level = StringUtil.toNull(request.getParameter("old_level"));
		String new_level = StringUtil.toNull(request.getParameter("new_level"));
		String start_date = StringUtil.toNull(request
				.getParameter("start_date"));
		String end_date = StringUtil.toNull(request.getParameter("end_date"));
		String start_time = StringUtil.toNull(request
				.getParameter("start_time"));
		String end_time = StringUtil.toNull(request.getParameter("end_time"));
		Integer location_id = NumberUtil.strToIngeger(StringUtil.toNull(request
				.getParameter("location_id")));
		Integer pageNo = NumberUtil.strToIngeger(StringUtil.toNull(request
				.getParameter("pageNo")));

		Page<CustomDto> page = new Page<CustomDto>();
		HashMap param = new HashMap();
		param.put("register", register);
		param.put("id_card", id_card);
		param.put("telephone", telephone);
		param.put("area_id", area_id);
		param.put("old_level", old_level);
		param.put("new_level", new_level);
		param.put("start_date", start_date);
		param.put("end_date", end_date);
		param.put("start_time", start_time);
		param.put("end_time", end_time);
		param.put("location_id", location_id);

		if (pageNo == null) {
			pageNo = 1;
		}
		page.setPageNo(pageNo);
		page.setPageSize(10);
		param.put("first", page.getFirst());
		param.put("pageSize", page.getPageSize());

		page.setResult(customService.listByCondition(param));
		page.setTotalCount(customService.countByCondition(param));
		model.addAttribute("page", page);

		List<Area> areaList = areaService.getAll();
		model.addAttribute(SystemConstants.AreaCache, areaList);
		List<Education> eductionList = educationService.getAll();
		model.addAttribute(SystemConstants.EducationCache, eductionList);
		List<Level> levelList = levelService.getAll();
		model.addAttribute(SystemConstants.LevelCache, levelList);
		List<Location> locationList = locationService.getAll();
		model.addAttribute(SystemConstants.LocationCache, locationList);

		model.addAttribute("register", register);
		model.addAttribute("id_card", id_card);
		model.addAttribute("telephone", telephone);
		model.addAttribute("area_id", area_id);
		model.addAttribute("old_level", old_level);
		model.addAttribute("new_level", new_level);
		model.addAttribute("start_date", start_date);
		model.addAttribute("end_date", end_date);
		model.addAttribute("start_time", start_time);
		model.addAttribute("end_time", end_time);
		model.addAttribute("location_id", location_id);

		return "admin/home";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "admin/home";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model) {
		return "admin/home";
	}

}
