package name.huangzhoujin.registration.web;

import javax.servlet.http.HttpServletRequest;

import name.huangzhoujin.registration.persistence.domain.Memo;
import name.huangzhoujin.registration.service.MemoService;
import name.huangzhoujin.registration.utils.FlashMap.Message;
import name.huangzhoujin.registration.utils.FlashMap.MessageType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/memo")
@SessionAttributes({ "userId", "userName", "roleId" })
public class MemoController {

	@Autowired
	private MemoService memoService;

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String load(@ModelAttribute("userName") String userName,
			HttpServletRequest request, Model model) {
		Memo memo = memoService.getById(1);
		if (memo == null) {
			memo = new Memo();
			memo.setMemoId(1);
			memo.setMemoDescription("");
			memoService.create(memo);
		}
		model.addAttribute("memo", memo);
		return "memo/detail";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("userName") String userName,
			@RequestParam Integer memoId, @RequestParam String description,
			HttpServletRequest request, Model model) {
		Memo memo = new Memo();
		memo.setMemoId(memoId);
		memo.setMemoDescription(StringUtils.substring(description, 0, 200));
		boolean result = memoService.save(memo);
		if (result) {
			model.addAttribute("memoInfo", new Message(MessageType.info,
					"memo.sava.success"));
		} else {
			model.addAttribute("memoInfo", new Message(MessageType.info,
					"memo.sava.failure"));
		}

		model.addAttribute("memo", memo);
		return "memo/detail";
	}

}
