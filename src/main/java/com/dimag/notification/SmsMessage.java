package com.dimag.notification;

//parent
public class SmsMessage implements Notification {
	private String subject;
	private String body;

	public SmsMessage(String subject, String body) {
		this.subject = subject;
		this.body = body;
	}

	@Override
	public String getBody() {
		return body;
	}

	public String getSubject() {
		return subject;
	}

	public SmsMessage setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public SmsMessage setBody(String body) {
		this.body = body;
		return this;
	}
}
