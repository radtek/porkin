package net.cominfo.digiagent.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/search")
public class SearchController {

	@RequestMapping(method=RequestMethod.GET)
	public String getView(Model model) {
		Map user = new HashMap();
		user.put("userName", "songjie");
		model.addAttribute("user", user);
		return "admin";
	}
}
