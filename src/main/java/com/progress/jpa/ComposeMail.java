package com.progress.jpa;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Bean class to hold the e-mail details
 * 
 * @author kiranb
 * 
 */
public class ComposeMail {
	public static String COMPOSE_MAIL_DATA_KEY = "mailDataKey";
	private String from;
	private String to;
	private String subject;
	private String body;
	private String userName;
	private String mobileNo;

	public ComposeMail() {
	}

	// Minimal
	public ComposeMail(String userName, String toEmail, String mobileNo) {
		this.userName = userName;
		this.to = toEmail;
		this.mobileNo = mobileNo;
	}

	public ComposeMail(String from, String to, String subject, String body) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	// These parameters are based on MailGun resource parameters....
	public MultiValueMap<String, Object> getAsValueMap() {
		MultiValueMap<String, Object> vars = new LinkedMultiValueMap<String, Object>();
		vars.add("from", getFrom());
		vars.add("to", getTo());
		vars.add("subject", getSubject());
		vars.add("html", getBody());
		return vars;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
