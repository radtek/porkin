
package net.cominfo.digiagent.utils.mail;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.*;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;


/**
 * 
 * @copyright: Copyright 2009
 * @company: Genpact
 * @author: 703006677 (Porkin)
 * @version: 1.0 Modification History 
 * Date Author Description
 * ----------------------- 
 * May 27, 2008 710000571 Initialization
 */

public class MailEngine {

	private static final Logger log = LoggerFactory.getLogger(MailEngine.class);

	private MailSender mailSender;
	private VelocityEngine velocityEngine;

	private String generateMailContent(String mailTemplate, Map modal) {
		try {
			return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
					mailTemplate, modal);
		} catch (VelocityException e) {
			log.error("Error while processing Vilocity template.", e);
		}

		return null;
	}

	/**
	 * 
	 * 
	 * @param msg
	 * @param mailTemplate
	 * @param modal
	 * @author: 710000571 (Relic)
	 * @version: 1.0
	 * 
	 *           Modification History: Date Author Description
	 *           ----------------------- May 27, 2008 710000571 Initialization
	 */
	public void send(SimpleMailMessage msg, String mailTemplate, Map modal) {
		String content = generateMailContent(mailTemplate, modal);

		MimeMessage mimeMsg = null;

		try {
			mimeMsg = ((JavaMailSender) mailSender).createMimeMessage();
			MimeMessageHelper mimeMsgHelper = new MimeMessageHelper(mimeMsg,
					true);

			mimeMsgHelper.setTo(msg.getTo());

			// mimeMsgHelper.setCc(msg.getCc());
			if (msg.getCc() != null)
				mimeMsgHelper.setCc(msg.getCc());

			if (null != msg.getSubject()) {
				mimeMsgHelper.setSubject(msg.getSubject());
			}

			mimeMsgHelper.setText(content, true);

			((JavaMailSender) mailSender).send(mimeMsg);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

	}

	@SuppressWarnings("unchecked")
	public void send(SimpleMailMessage msg, String mailTemplate, Map modal,
			InputStreamSource[] attachements, String[] fileNames) {
		String content = generateMailContent(mailTemplate, modal);
		MimeMessage mimeMsg = null;
		try {
			mimeMsg = ((JavaMailSenderImpl) mailSender).createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);

			helper.setTo(msg.getTo());

			if (msg.getCc() != null)
				helper.setCc(msg.getCc());

			if (msg.getSubject() != null) {
				helper.setSubject(msg.getSubject());
			}

			helper.setFrom(msg.getFrom());

			helper.setText(content, true);

			if (attachements != null) {
				for (int i = 0; i < attachements.length; i++) {
					helper.addAttachment(fileNames[i], attachements[i]);
				}
			}

			log.info("Send mail by information of " + modal.toString());
			((JavaMailSenderImpl) mailSender).send(mimeMsg);
		} catch (MessagingException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	public void send(SimpleMailMessage msg, String mailTemplate, Map modal,
			Map olddata, Map newdata, InputStreamSource[] attachements,
			String[] fileNames) {
		String content = generateMailContent(mailTemplate, modal);

		String content1 = generateMailContent(mailTemplate, olddata);
		String content2 = generateMailContent(mailTemplate, newdata);
		MimeMessage mimeMsg = null;
		try {
			mimeMsg = ((JavaMailSenderImpl) mailSender).createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);

			helper.setTo(msg.getTo());

			if (msg.getCc() != null)
				helper.setCc(msg.getCc());

			if (msg.getSubject() != null) {
				helper.setSubject(msg.getSubject());
			}

			helper.setFrom(msg.getFrom());

			helper.setText(content, true);
			helper.setText(content1, true);
			helper.setText(content2, true);
			if (attachements != null) {
				for (int i = 0; i < attachements.length; i++) {
					helper.addAttachment(fileNames[i], attachements[i]);
				}
			}

			log.info("Send mail by information of " + modal.toString());
			((JavaMailSenderImpl) mailSender).send(mimeMsg);
		} catch (MessagingException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * @return the mailSender
	 */
	public MailSender getMailSender() {
		return mailSender;
	}

	/**
	 * @param mailSender
	 *            the mailSender to set
	 */
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * @return the velocityEngine
	 */
	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	/**
	 * @param velocityEngine
	 *            the velocityEngine to set
	 */
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

}
