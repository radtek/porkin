package name.huangzhoujin.registration.web;

import java.util.Date;
import java.util.List;

import name.huangzhoujin.registration.persistence.domain.Area;
import name.huangzhoujin.registration.persistence.domain.Education;
import name.huangzhoujin.registration.persistence.domain.Level;
import name.huangzhoujin.registration.persistence.domain.Location;
import name.huangzhoujin.registration.persistence.domain.Registration;
import name.huangzhoujin.registration.service.AreaService;
import name.huangzhoujin.registration.service.EducationService;
import name.huangzhoujin.registration.service.LevelService;
import name.huangzhoujin.registration.service.LocationService;
import name.huangzhoujin.registration.service.RegistrationService;
import name.huangzhoujin.registration.utils.DateUtil;
import name.huangzhoujin.registration.utils.FlashMap.Message;
import name.huangzhoujin.registration.utils.FlashMap.MessageType;
import name.huangzhoujin.registration.utils.IdCardValidator;
import name.huangzhoujin.registration.utils.SystemConstants;

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

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam String name,
			@RequestParam String gender, @RequestParam String education,
			@RequestParam Integer area, @RequestParam String old_level,
			@RequestParam String new_level, @RequestParam String id_card,
			@RequestParam String unemployee_no, @RequestParam String telephone, @RequestParam Integer location,
			@RequestParam String start_date, Model model) {

		boolean hasError = false;

		if (IdCardValidator.isValid(id_card)) {
			Registration record = new Registration();
			record.setRegister(name);
			record.setGender(gender);
			record.setEducation(education);
			record.setAreaId(area);
			record.setOldLevel(old_level);
			record.setNewLevel(new_level);
			record.setIdCard(id_card);
			record.setUnemployedNo(unemployee_no);
			record.setPhone(telephone);
			record.setLocationId(location);
			record.setRegistrationDate(new Date());
			record.setStartDate(DateUtil.strToDate(start_date));
			registrationService.create(record);
			model.addAttribute("name", name);
			return "enroll/success";

		} else {
			model.addAttribute("idcard", new Message(MessageType.error,
					"registration.idcard.error"));
			hasError = true;
			model.addAttribute("hasError", hasError);

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

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {

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
