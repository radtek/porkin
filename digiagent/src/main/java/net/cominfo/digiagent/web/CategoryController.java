package net.cominfo.digiagent.web;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		List<Category> categoryList = categoryService.getAll();
		model.addAttribute(categoryList);
		return "category";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		List<Category> categoryList = categoryService.getAll();
		model.addAttribute(categoryList);
		return "category";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("categoryForm") Category categoryForm,
			BindingResult result, SessionStatus status) {
		categoryForm.setCreatedBy("1");
		categoryForm.setCreatedDate(new Date());
		categoryForm.setLastupdatedBy("1");
		categoryForm.setLastupdatedDate(new Date());
		categoryService.insertCategory(categoryForm);
		return "category";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model) {
		List<Category> categoryList = categoryService.getAll();
		model.addAttribute(categoryList);
		return "category";
	}
}
