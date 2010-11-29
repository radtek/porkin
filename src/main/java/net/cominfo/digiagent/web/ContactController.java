package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Contact;
import net.cominfo.digiagent.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping(value="/contact")
@SessionAttributes({"userId","userName"})
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "contact";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@ModelAttribute("userName") String userName,@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Map param) {
		Long total = contactService.count(param);
		List<Contact> contactList = contactService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", contactList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute("userName") String userName,@ModelAttribute Contact contact,
			HttpServletResponse response) {
		Contact contactUpdate = contactService.getById(contact.getContactId());
		if (contact == null) {
			new ResourceNotFoundException(new Long(contactUpdate.getContactId()));
		}
		contactUpdate.setSupplierId(contact.getSupplierId());
		contactUpdate.setActiveFlag(contact.getActiveFlag());
		contactUpdate.setContactContent(contact.getContactContent());
		contactUpdate.setContactType(contact.getContactType());
		contactUpdate = contactService.update(contactUpdate,userName);
		return Collections.singletonMap("contactId", contactUpdate.getContactId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Contact get(@RequestParam Integer id) {
		Contact contact = contactService.getById(id);
		if (contact == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return contact;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute("userName") String userName,@ModelAttribute Contact contact,
			HttpServletResponse response) {
		Contact contactNew = contactService.insert(contact,userName);
		return Collections.singletonMap("contactId", contactNew.getContactId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		Contact contact = contactService.getById(id);
		if (contact == null) {
			new ResourceNotFoundException(new Long(id));
		} else {
			contactService.delete(id);
		}
		return "success";
	}
	
	@RequestMapping(value = "/getSupplierList", method = RequestMethod.GET)
	public void getSupplierList(@RequestParam Integer id, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(contactService.getSupplierList(id));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
