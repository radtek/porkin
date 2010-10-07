package net.cominfo.digiagent.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	@RequestMapping(value = "/personInfo", method = RequestMethod.GET)
	public String personInfo(HttpServletResponse response) {
		return "person/personInfo";
	}
	

	@RequestMapping(value = "/infoRelease", method = RequestMethod.GET)
	public String infoRelease(HttpServletResponse response) {
		return "person/infoRelease";
	}
}
