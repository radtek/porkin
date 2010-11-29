package net.cominfo.digiagent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cominfo.digiagent.exception.ResourceNotFoundException;
import net.cominfo.digiagent.persistence.domain.Comments;
import net.cominfo.digiagent.persistence.domain.Contact;
import net.cominfo.digiagent.persistence.domain.Supplier;
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;
import net.cominfo.digiagent.persistence.domain.UserRole;
import net.cominfo.digiagent.service.CommentsService;
import net.cominfo.digiagent.service.HistoryService;
import net.cominfo.digiagent.service.SupplierService;
import net.cominfo.digiagent.spring.FlashMap.Message;
import net.cominfo.digiagent.spring.FlashMap.MessageType;
import net.cominfo.digiagent.spring.security.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/supplier")
@SessionAttributes( { "userId", "userName" })
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private HistoryService historyService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) {
		return "supplier";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	Map query(@RequestParam Integer page, @RequestParam Integer rows,
			@RequestParam Map param) {
		Long total = supplierService.count(param);
		List<Supplier> supplierList = supplierService.query(page, rows, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", supplierList);
		return Collections.singletonList(map).get(0);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute SupplierWithBLOBs supplier,
			@ModelAttribute("userName") String userName,
			@RequestParam("file") MultipartFile image,
			@RequestParam("file1") MultipartFile image1,
			@RequestParam("file2") MultipartFile image2,
			HttpServletResponse response) throws IOException {
		SupplierWithBLOBs supplierUpdate = supplierService.getById(supplier
				.getSupplierId());
		if (supplier == null) {
			new ResourceNotFoundException(new Long(supplierUpdate
					.getSupplierId()));
		}
		supplier.setCreatedBy(supplierUpdate.getCreatedBy());
		supplier.setCreatedDate(supplierUpdate.getCreatedDate());
		supplier.setUserId(supplierUpdate.getUserId());
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize() / 1024 < 65) {
			supplier.setSupplierImage(image.getBytes());
		}
		// MYSQL BLOB类型最大65K--实名认证
		if (image1.getSize() > 0 && image1.getSize() / 1024 < 65) {
			supplier.setSupplierCertify(image1.getBytes());
		}
		// MYSQL BLOB类型最大65K--资质认证
		if (image2.getSize() > 0 && image2.getSize() / 1024 < 65) {
			supplier.setSupplierQualify(image2.getBytes());
		}
		try {
			PrintWriter pw = response.getWriter();
			if (image.getSize() / 1024 >= 65 || image1.getSize() / 1024 >= 65
					|| image2.getSize() / 1024 >= 65) {
				pw.write(Collections.singletonMap("supplierId", -2).toString()
						.replaceAll("=", ":"));
			} else {
				supplier = supplierService.update(supplier, userName);
				pw.write(Collections.singletonMap("supplierId",
						supplier.getSupplierId()).toString().replaceAll("=",
						":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody
	Supplier get(@RequestParam Integer id) {
		Supplier supplier = supplierService.getById(id);
		if (supplier == null) {
			new ResourceNotFoundException(new Long(id));
		}
		return supplier;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void create(@ModelAttribute("userName") String userName,
			@ModelAttribute SupplierWithBLOBs supplier,
			@RequestParam("file") MultipartFile image,
			@RequestParam("file1") MultipartFile image1,
			@RequestParam("file2") MultipartFile image2,
			@ModelAttribute User user, @ModelAttribute UserRole userRole,
			HttpServletResponse response) throws IOException {
		// MYSQL BLOB类型最大65K
		if (image.getSize() > 0 && image.getSize() / 1024 < 65) {
			supplier.setSupplierImage(image.getBytes());
		}
		// MYSQL BLOB类型最大65K--实名认证
		if (image1.getSize() > 0 && image1.getSize() / 1024 < 65) {
			supplier.setSupplierCertify(image1.getBytes());
		}
		// MYSQL BLOB类型最大65K--资质认证
		if (image2.getSize() > 0 && image2.getSize() / 1024 < 65) {
			supplier.setSupplierQualify(image2.getBytes());
		}
		try {
			PrintWriter pw = response.getWriter();
			if (image.getSize() / 1024 >= 65 || image1.getSize() / 1024 >= 65
					|| image2.getSize() / 1024 >= 65) {
				pw.write(Collections.singletonMap("supplierId", -2).toString()
						.replaceAll("=", ":"));
			} else {
				supplier = supplierService.insert(supplier, user, userRole,
						userName);
				pw.write(Collections.singletonMap("supplierId",
						supplier.getSupplierId()).toString().replaceAll("=",
						":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Supplier supplierNew = supplierService.insert(supplier);
		// return Collections.singletonMap("supplierId",
		// supplierNew.getSupplierId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	String delete(@RequestParam Integer id) {
		Supplier supplier = supplierService.getById(id);
		if (supplier == null) {
			new ResourceNotFoundException(new Long(id));
			return "fail";
		} else {
			return supplierService.delete(id);
		}
	}

	@RequestMapping(value = "/getCityList", method = RequestMethod.GET)
	public void getCityList(@RequestParam Integer id,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.write(supplierService.getCityList(id));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public String output(@RequestParam Integer id,
			HttpServletResponse response, HttpServletRequest request,
			Model model) {
		String noPicPath = request.getSession().getServletContext()
				.getRealPath("images/common/nopic.jpg");
		model.addAttribute("image", supplierService.getSupplierImage(id, 0,
				noPicPath));
		return "image";
	}

	/**
	 * 实名认证
	 * 
	 * @param id
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getImage1", method = RequestMethod.GET)
	public String output1(@RequestParam Integer id,
			HttpServletResponse response, HttpServletRequest request,
			Model model) {
		String noPicPath = request.getSession().getServletContext()
				.getRealPath("images/common/nopic.jpg");
		model.addAttribute("image", supplierService.getSupplierImage(id, 1,
				noPicPath));
		return "image";
	}

	/**
	 * 资质认证
	 * 
	 * @param id
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getImage2", method = RequestMethod.GET)
	public String output2(@RequestParam Integer id,
			HttpServletResponse response, HttpServletRequest request,
			Model model) {
		String noPicPath = request.getSession().getServletContext()
				.getRealPath("images/common/nopic.jpg");
		model.addAttribute("image", supplierService.getSupplierImage(id, 2,
				noPicPath));
		return "image";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String show(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response,
			Model model) throws UnsupportedEncodingException {
		String otherParam[] = {"categoryName", "productName", "brandName"};
		for (String key : otherParam) {
			String value = request.getParameter(key);
			if (value != null) {
				model.addAttribute(key, new String(value.getBytes("iso8859-1"),"utf-8"));
			}
		}
		SupplierWithBLOBs supplier = supplierService.getById(id);
		if (supplier != null) {

			String telephone = supplier.getSupplierTelephone();
			ArrayList<String> telephoneList = new ArrayList<String>();
			if (telephone != null) {
				telephoneList.add(telephone);
			}

			String mobile = supplier.getSupplierMobile();
			ArrayList<String> mobileList = new ArrayList<String>();
			if (mobile != null) {
				mobileList.add(mobile);
			}

			ArrayList<String> emailList = new ArrayList<String>();
			ArrayList<String> qqList = new ArrayList<String>();
			ArrayList<String> msnList = new ArrayList<String>();

			List<Contact> contactList = supplierService
					.getContactBySupplierId(id);
			Iterator<Contact> iterator = contactList.iterator();
			Contact contact = null;
			String contactContent = null;
			String contactType = null;
			while (iterator.hasNext()) {
				contact = iterator.next();
				contactContent = contact.getContactContent();
				contactType = contact.getContactType();
				if (contactType.equalsIgnoreCase("E")) {
					emailList.add(contactContent);
				} else if (contactType.equalsIgnoreCase("M")) {
					mobileList.add(contactContent);
				} else if (contactType.equalsIgnoreCase("T")) {
					telephoneList.add(contactContent);
				} else if (contactType.equalsIgnoreCase("Q")) {
					qqList.add(contactContent);
				} else if (contactType.equalsIgnoreCase("N")) {
					msnList.add(contactContent);
				}
			}

			String area = supplierService.getAreaInfoBySupplierId(id);
			Integer countComments = commentsService.countCommentsBySupplier(id);

			model.addAttribute("supplier", supplier);
			model.addAttribute("emailList", emailList);
			model.addAttribute("mobileList", mobileList);
			model.addAttribute("telephoneList", telephoneList);
			model.addAttribute("area", area);
			model.addAttribute("qqList", qqList);
			model.addAttribute("msnList", msnList);
			model.addAttribute("countComments", countComments);
			model.addAttribute("creditLevel", 3);

			supplierService.access(supplier);
			historyService.recordSupplierAccess(id);

			return "supplierDetail";
		} else {
			return "no_supplier";
		}

	}

	@RequestMapping(value = "/updatePicture", method = RequestMethod.POST)
	public void updatePicture(@ModelAttribute SupplierWithBLOBs supplier,
			@ModelAttribute("userName") String userName,
			@RequestParam("file1") MultipartFile image1,
			@RequestParam("file2") MultipartFile image2,
			HttpServletResponse response) throws IOException {
		supplier = supplierService.getById(supplier.getSupplierId());
		if (supplier == null) {
			new ResourceNotFoundException(new Long(supplier.getSupplierId()));
		}
		// MYSQL BLOB类型最大65K--实名认证
		if (image1.getSize() > 0 && image1.getSize() / 1024 < 65) {
			supplier.setSupplierCertify(image1.getBytes());
		}
		// MYSQL BLOB类型最大65K--资质认证
		if (image2.getSize() > 0 && image2.getSize() / 1024 < 65) {
			supplier.setSupplierQualify(image2.getBytes());
		}
		try {
			PrintWriter pw = response.getWriter();
			if (image1.getSize() / 1024 >= 65 || image2.getSize() / 1024 >= 65) {
				pw.write(Collections.singletonMap("supplierId", -2).toString()
						.replaceAll("=", ":"));
			} else {
				supplier = supplierService.update(supplier, userName);
				pw.write(Collections.singletonMap("supplierId",
						supplier.getSupplierId()).toString().replaceAll("=",
						":"));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/commentForm", method = RequestMethod.GET)
	public String commentForm(@RequestParam("id") String id, Model model) {
		model.addAttribute("id",id);
		return "commentForm";
	}

	@RequestMapping(value = "/comments", method = RequestMethod.POST)
	public String postComments(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("logined") String logined,
			@RequestParam("rank") Integer rank,
			@RequestParam("comments") String comments,
			@RequestParam("id") Integer id,
			HttpServletRequest request, HttpSession session, Model model) throws IOException {
		
		String result = "commentForm";
		User user = null;
		
		if(logined.equals("Y")){
			String userName = (String)session.getAttribute("userName");
			if(userName.equals(username)){
				user = securityService.getUserByName(userName);
			}
		}
		else{
			user = securityService.loginWithoutType(username, password);
		}
		
		if(user==null){
			model.addAttribute("id",id);
			model.addAttribute("nologin", new Message(MessageType.success,"supplier.comments.nologin"));
			result = "commentForm";
		}
		else{
			Integer userId = user.getUserId();
			String strRank = Integer.toHexString(rank).toUpperCase(); 
			commentsService.save(id, userId, strRank, comments, username);
			model.addAttribute("userId", userId);
			model.addAttribute("userName", username);
			model.addAttribute("supplierId", new Integer(0));
			model.addAttribute("id",id);
			result = "successForcomments";
		}
		
		return result;

	}
	
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public String image(@RequestParam("id") String id, @RequestParam("getMethod") String getMethod, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("getMethod", getMethod);
		return "supplierImage";
	}
	
	@RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
	public String showComments(@PathVariable Integer id, @RequestParam Integer page,@RequestParam Integer rows,
			Model model) throws UnsupportedEncodingException {
		Map param = new HashMap();
		param.put("supplierId", id);
		Long total = commentsService.count(id);
		List<Comments> commentsList = commentsService.query(page, rows, param);
		model.addAttribute("commentsList",commentsList);
		model.addAttribute("total", total);
		model.addAttribute("supplierId", id);
		model.addAttribute("pageSize", (int)Math.ceil(total/Double.valueOf(rows)));
		model.addAttribute("page",page);
		return "commentsDetail";

	}
	
	@RequestMapping(value = "/iframe", method = RequestMethod.GET)
	public String iframe() {
		return "iframe";
	}
			
}
