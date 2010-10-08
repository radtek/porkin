package net.cominfo.digiagent.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/company")
public class CompanyController {
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		return "company/menu";
	}
	
	@RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
	public String basicInfo(Model model) {
		return "company/basicInfo";
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String password(Model model) {
		return "company/menu";
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String email(Model model) {
		return "company/menu";
	}
	
	@RequestMapping(value = "/introduction", method = RequestMethod.GET)
	public String introduction(Model model) {
		return "company/menu";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		return "company/menu";
	}
	
	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public String agent(Model model) {
		return "company/menu";
	}
	
	@RequestMapping(value = "/qualify", method = RequestMethod.GET)
	public String qualify(Model model) {
		return "company/menu";
	}
	
	@RequestMapping(value = "/infoRelease", method = RequestMethod.GET)
	public String infoRelease(Model model) {
		return "company/infoRelease";
	}
	
	@RequestMapping(value = "/commodityList", method = RequestMethod.GET)
	public String commodityList(Model model) {
		return "company/commodityList";
	}
	
	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	public String promotion(Model model) {
		return "company/menu";
	}
}
