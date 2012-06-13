package name.huangzhoujin.registration.web;

import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.service.AreaService;
import name.huangzhoujin.registration.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/area")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String home(Model model){
		Page<Area> page = new Page<Area>();
		page.setPageNo(1);
		page.setPageSize(10);
		List<Area> areaList = areaService.getByPage(page.getFirst(), page.getPageSize());
		page.setResult(areaList);
		page.setTotalCount(areaService.countAllArea());
		model.addAttribute("page", page);
		return "area/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam Integer id) {
		Area area = areaService.getById(id);
		if (area == null) {
			return "fail";
		} else {
			areaService.delete(id);
			return "redirect:/area/list";
		}
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "admin/home";
	}
	
	
	

}
