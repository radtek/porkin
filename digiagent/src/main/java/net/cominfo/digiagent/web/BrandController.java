package net.cominfo.digiagent.web;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Brand;
import net.cominfo.digiagent.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Brand brand = brandService.getById(id);
		if (brand == null) {
			throw new ResourceNotFoundException(new Long(id));
		}
		model.addAttribute(brand);
		return "category/view";
	}
}
