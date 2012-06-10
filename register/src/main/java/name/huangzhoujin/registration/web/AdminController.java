package name.huangzhoujin.registration.web;

import java.util.HashMap;

import name.huangzhoujin.registration.persistence.dto.CustomDto;
import name.huangzhoujin.registration.service.CustomService;
import name.huangzhoujin.registration.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private CustomService customService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		Page<CustomDto> page = new Page<CustomDto>();
		page.setPageNo(1);
		page.setPageSize(10);
		HashMap param = new HashMap();
		param.put("first",page.getFirst());
		param.put("pageSize", page.getPageSize());
		page.setResult(customService.listByCondition(param));
		page.setTotalCount(customService.countByCondition(param));
		
		//List<CustomDto> list = customService.listByCondition(pageNo,pageSize,param);
		model.addAttribute("page", page);
		return "admin/home";

	}

}
