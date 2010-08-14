package net.cominfo.digiagent.web;

import net.cominfo.digiagent.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/admin")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getView(Model model) {
//		Brand brand = brandService.getById(id);
//		if (brand == null) {
//			throw new ResourceNotFoundException(new Long(id));
//		}
//		model.addAttribute(brand);
		return "admin";
	}
}
