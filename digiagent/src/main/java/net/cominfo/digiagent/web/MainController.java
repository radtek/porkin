package net.cominfo.digiagent.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/admin")
public class MainController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getView(Model model) {
		return "admin";
	}
}
