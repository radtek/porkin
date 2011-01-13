package net.cominfo.digiagent.web;

import java.util.HashMap;
import java.util.Map;

import net.cominfo.digiagent.service.SortableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping(value="/admin")
@SessionAttributes({"userId","userName"})
public class MainController {
	
	@Autowired
	private SortableService sortableService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET)
	public String getView(@ModelAttribute("userName") String userName,Model model) {
		Map user = new HashMap();
		user.put("userName", userName);
		model.addAttribute("user", user);
		return "admin";
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(@ModelAttribute("userName") String userName,Model model) {
		sortableService.reset();
		return null;
	}
}
