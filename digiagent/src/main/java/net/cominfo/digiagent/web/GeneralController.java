package net.cominfo.digiagent.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class GeneralController {
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String head(Model model) {
		return "header";
	}

}
