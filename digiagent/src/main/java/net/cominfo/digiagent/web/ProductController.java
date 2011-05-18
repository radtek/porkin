package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.service.ProductService;

@Controller
@RequestMapping(value = "/product")
@SessionAttributes({ "userId", "userName" })
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "product";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows,
			@RequestParam Map param) {
		Long total = productService.count(param);
		List<Product> productList = productService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", productList);
		return Collections.singletonList(map).get(0);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> update(
			@ModelAttribute("userName") String userName,
			@ModelAttribute Product product, HttpServletResponse response) {
		Product productUpdate = productService.getById(product.getProductId());
		if (product == null) {
			new ResourceNotFoundException(
					new Long(productUpdate.getProductId()));
		}
		productUpdate.setCategoryId(product.getCategoryId());
		productUpdate.setDisplayType(product.getDisplayType());
		productUpdate.setActiveFlag(product.getActiveFlag());
		productUpdate.setProductName(product.getProductName());
		productUpdate = productService.update(productUpdate, userName);
		return Collections.singletonMap("productId",
				productUpdate.getProductId());
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody
	Product get(@RequestParam Integer id) {
		Product product = productService.getById(id);
		if (product == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return product;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> create(
			@ModelAttribute("userName") String userName,
			@ModelAttribute Product product, HttpServletResponse response) {
		Product productNew = productService.insert(product, userName);
		return Collections.singletonMap("productId", productNew.getProductId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	String delete(@RequestParam Integer id) {
		Product product = productService.getById(id);
		if (product == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return productService.delete(id);
		}
	}

	@RequestMapping(value = "/getCategoryList", method = RequestMethod.GET)
	public void getCategoryList(HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(productService.getCategoryList());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
