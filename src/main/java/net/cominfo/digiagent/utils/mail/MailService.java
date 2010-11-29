package net.cominfo.digiagent.utils.mail;

import java.util.Map;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class MailService {

	@Autowired
	private SimpleMailMessage mailMessage;

	@Autowired
	private MailEngine mailEngine;

	/**
	 * 
	 * 
	 * @param to
	 * @param cc
	 * @param subject
	 * @param mailTemplate
	 * @param data
	 * @author: 710000571 (Relic)
	 * @version: 1.0
	 * 
	 *           Modification History: Date Author Description
	 *           ----------------------- May 27, 2008 710000571 Initialization
	 */
	public void doPost(String to, String cc, String subject,
			String mailTemplate, Map data) {

		mailMessage.setTo(to);
		if (cc != null)
			mailMessage.setCc(cc);
		mailMessage.setSubject(subject);
		mailEngine.send(mailMessage, mailTemplate, data);
	}

	public void doPost(String[] to, String[] cc, String subject,
			String mailTemplate, Map data) {

		mailMessage.setTo(to);
		if (cc != null)
			mailMessage.setCc(cc);
		mailMessage.setSubject(subject);

		mailEngine.send(mailMessage, mailTemplate, data);
	}

	public void doPost(String to, String cc, String htmlTemplate,
			String subject, Map data, InputStreamSource[] attachements,
			String[] attachementNames) {

		if (to != null)
			mailMessage.setTo(to);
		if (cc != null)
			mailMessage.setCc(cc);
		mailMessage.setSubject(subject);

		mailEngine.send(mailMessage, htmlTemplate, data, attachements,
				attachementNames);
	}

}
