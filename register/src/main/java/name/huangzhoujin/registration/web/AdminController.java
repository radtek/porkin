package name.huangzhoujin.registration.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		return "admin/index";

	}

}
