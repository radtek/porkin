package net.cominfo.digiagent.utils.mail;

import javax.mail.Authenticator;

public class SmtpAuthenticator extends Authenticator {

	private String username;

	private String password;

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

	public SmtpAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
