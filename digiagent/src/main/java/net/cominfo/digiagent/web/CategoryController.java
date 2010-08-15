package net.cominfo.digiagent.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "category";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer skipResults, @RequestParam Integer maxResults) {
		List<Category> categoryList = categoryService.query(skipResults, maxResults);
		Map map = new HashMap();
		map.put("total", categoryService.countCategory());
		map.put("rows", categoryList);
		return Collections.singletonList(map).get(0);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(@ModelAttribute Category category,
			HttpServletResponse response) {
		Category categoryUpdate = categoryService.getById(category.getCategoryId());
		if (category == null) {
			new ResourceNotFoundException(new Long(categoryUpdate.getCategoryId()));
		}
		categoryUpdate.setActiveFlag(category.getActiveFlag());
		categoryUpdate.setCategoryName(category.getCategoryName());
		categoryUpdate = categoryService.update(categoryUpdate);
		return Collections.singletonMap("categoryId", categoryUpdate.getCategoryId());
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Category get(@RequestParam Integer id) {
		Category category = categoryService.getById(id);
		if (category == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return category;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(@ModelAttribute Category category,
			HttpServletResponse response) {
		Category categoryNew = categoryService.insert(category);
		return Collections.singletonMap("categoryId", categoryNew.getCategoryId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam Integer id) {
		Category category = categoryService.getById(id);
		if (category == null) {
			new ResourceNotFoundException(new Long(id));
		} else {
			categoryService.delete(id);
		}
		return "success";
	}
}