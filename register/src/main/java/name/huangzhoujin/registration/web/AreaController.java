package name.huangzhoujin.registration.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.service.AreaService;
import name.huangzhoujin.registration.utils.FlashMap.Message;
import name.huangzhoujin.registration.utils.FlashMap.MessageType;
import name.huangzhoujin.registration.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/area")
@SessionAttributes({ "userId", "userName", "roleId" })
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String home(@ModelAttribute("userName") String userName, Model model) {
		Page<Area> page = new Page<Area>();
		page.setPageNo(1);
		page.setPageSize(10);
		List<Area> areaList = areaService.getByPage(page.getFirst(),
				page.getPageSize());
		page.setResult(areaList);
		page.setTotalCount(areaService.countAllArea());
		model.addAttribute("page", page);
		return "area/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("userName") String userName,
			@RequestParam Integer id) {
		Area area = areaService.getById(id);
		if (area == null) {
			return "fail";
		} else {
			areaService.delete(id);
			return "redirect:/area/list";
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("userName") String userName,
			@RequestParam Integer id, @RequestParam String areaName, Model model) {
		Area area = new Area();
		area.setAreaId(id);
		area.setAreaName(areaName);
		areaService.save(area);
		return "redirect:/area/list";

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("userName") String userName,
			@RequestParam String areaName, Model model) {
		Area area = new Area();
		area.setAreaName(areaName);
		boolean result = areaService.create(area);
		if (result) {
			model.addAttribute("area", new Message(MessageType.info,
					"admin.sava.success"));
		} else {
			model.addAttribute("area", new Message(MessageType.info,
					"admin.save.failure"));
		}
		return "area/result";

	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String display(@ModelAttribute("userName") String userName,
			@RequestParam Integer pageNo, HttpServletRequest request,
			Model model) {
		Page<Area> page = new Page<Area>();
		page.setPageNo(pageNo);
		page.setPageSize(10);
		List<Area> areaList = areaService.getByPage(page.getFirst(),
				page.getPageSize());
		page.setResult(areaList);
		page.setTotalCount(areaService.countAllArea());
		model.addAttribute("page", page);
		return "area/list";

	}

	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public String addForm(@ModelAttribute("userName") String userName,
			Model model) {
		return "area/add";
	}

}
