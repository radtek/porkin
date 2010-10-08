package net.cominfo.digiagent.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		return "person/menu";
	}
	
	@RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
	public String basicInfo(Model model) {
		return "person/basicInfo";
	}

	@RequestMapping(value = "/infoRelease", method = RequestMethod.GET)
	public String infoRelease(Model model) {
		return "person/infoRelease";
	}
	
	@RequestMapping(value = "/commodityList", method = RequestMethod.GET)
	public String commodityList(Model model) {
		return "person/commodityList";
	}
}
