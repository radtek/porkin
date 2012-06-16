package name.huangzhoujin.registration.web;

import java.util.Date;
import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.domain.Education;
import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.persistence.domain.Location;
import name.huangzhoujin.registration.persistence.domain.Memo;
import name.huangzhoujin.registration.persistence.domain.Registration;
import name.huangzhoujin.registration.service.AreaService;
import name.huangzhoujin.registration.service.EducationService;
import name.huangzhoujin.registration.service.LevelService;
import name.huangzhoujin.registration.service.LocationService;
import name.huangzhoujin.registration.service.MemoService;
import name.huangzhoujin.registration.service.RegistrationService;
import name.huangzhoujin.registration.utils.FlashMap.Message;
import name.huangzhoujin.registration.utils.FlashMap.MessageType;
import name.huangzhoujin.registration.utils.IdCardValidator;
import name.huangzhoujin.registration.utils.SystemConstants;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/enroll")
public class MainController {

	@Autowired
	private AreaService areaService;

	@Autowired
	private EducationService educationService;

	@Autowired
	private LevelService levelService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private MemoService memoService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam String name,
			@RequestParam String gender, @RequestParam String education,
			@RequestParam Integer area, @RequestParam String old_level,
			@RequestParam String new_level, @RequestParam String id_card,
			@RequestParam String unemployee_no, @RequestParam String telephone,
			@RequestParam Integer location, //@RequestParam String start_date,
			Model model) {

		boolean hasError = false;
		if (name == null || name.trim().equals("")) {
			model.addAttribute("register", new Message(MessageType.error,
					"registration.register.error"));
			hasError = true;
		}

		if (id_card == null || id_card.trim().equals("")
				|| (!IdCardValidator.isValid(id_card))) {
			model.addAttribute("idcard", new Message(MessageType.error,
					"registration.idcard.error"));
			hasError = true;
		}

		if (telephone == null || telephone.trim().equals("")) {
			model.addAttribute("phone", new Message(MessageType.error,
					"registration.telphone.error"));
			hasError = true;
		}

//		if (start_date == null || start_date.trim().equals("")
//				|| (!DateUtil.isValidate(start_date))) {
//			model.addAttribute("start_course", new Message(MessageType.error,
//					"registration.start_date.error"));
//			hasError = true;
//		}

		if (hasError) {
			List<Area> areaList = areaService.getAll();
			model.addAttribute(SystemConstants.AreaCache, areaList);
			List<Education> eductionList = educationService.getAll();
			model.addAttribute(SystemConstants.EducationCache, eductionList);
			List<Level> levelList = levelService.getAll();
			model.addAttribute(SystemConstants.LevelCache, levelList);
			List<Location> locationList = locationService.getAll();
			model.addAttribute(SystemConstants.LocationCache, locationList);
			
			Memo memo = memoService.getById(1);
			if(memo!=null){
				model.addAttribute("memoDesc", memo.getMemoDescription());
			}

			return "enroll/welcome";

		} else {
			Registration record = new Registration();
			record.setRegister(StringUtils.substring(name.trim(), 0, 10));
			record.setGender(gender);
			record.setEducation(education);
			record.setAreaId(area);
			record.setOldLevel(old_level);
			record.setNewLevel(new_level);
			record.setIdCard(StringUtils.substring(id_card, 0, 18));
			record.setUnemployedNo(unemployee_no);
			record.setPhone(StringUtils.substring(telephone.trim(),0, 20));
			record.setLocationId(location);
			record.setRegistrationDate(new Date());
//			record.setStartDate(DateUtil.strToDate(StringUtils.substring(
//					start_date.trim(), 0, 10)));
			registrationService.create(record);
			model.addAttribute("name", name);
			Memo memo = memoService.getById(1);
			if(memo!=null){
				model.addAttribute("memoDesc", memo.getMemoDescription());
			}
			
			return "enroll/success";

		}

	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		
		Memo memo = memoService.getById(1);
		if(memo!=null){
			model.addAttribute("memoDesc", memo.getMemoDescription());
		}

		List<Area> areaList = areaService.getAll();
		model.addAttribute(SystemConstants.AreaCache, areaList);
		List<Education> eductionList = educationService.getAll();
		model.addAttribute(SystemConstants.EducationCache, eductionList);
		List<Level> levelList = levelService.getAll();
		model.addAttribute(SystemConstants.LevelCache, levelList);
		List<Location> locationList = locationService.getAll();
		model.addAttribute(SystemConstants.LocationCache, locationList);

		return "enroll/welcome";
	}

}
