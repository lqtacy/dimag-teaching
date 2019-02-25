package com.dimag.notification;

//database event
public class DbEvent extends LogMessage {
	private String type = "AUDIT";

	public DbEvent(String source, String message, String type) {
		super(source, message);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public DbEvent setType(String type) {
		this.type = type;

		return this;
	}
}
