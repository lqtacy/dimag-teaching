package com.dimag.notification;

//child
public class EmailMessage extends SmsMessage {

	private String email;

	public EmailMessage(String subject, String email, String body) {
		super(subject, body);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public EmailMessage setEmail(String email) {
		this.email = email;
		return this;
	}

}
