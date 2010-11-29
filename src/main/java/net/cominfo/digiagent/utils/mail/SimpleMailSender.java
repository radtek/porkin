package net.cominfo.digiagent.utils.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class SimpleMailSender {
	private String host = "smtp.163.com";
	private String from = "shangxunw@163.com";
	private String username = "shangxunw@163.com";
	private String password = "shangxunwang1";
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void sendMail(String user, String pwd, String to) {
		final String host = getHost();
		final String from = getFrom();
		final String username = getUsername();
		final String password = getPassword();

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		try {
			Session session = Session.getDefaultInstance(props,
					new Authenticator() {
						public PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("找回密码");
			message.setText("您好!\r\n\t用户"+user+"的密码为: "+pwd);
			// session.getTransport("smtp").send(message);
			Transport.send(message);
			System.out.println("Send mail over!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args){
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendMail("porkin", "1111", "porkin@126.com");
		
	}
	
}
