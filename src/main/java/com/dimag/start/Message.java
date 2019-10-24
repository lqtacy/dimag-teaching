package com.dimag.start;

public class Message{
	private String from;
	private String to;
	private String message;

	public Message() {
	}

	public Message(String from, String to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return "Message{" +
				"from='" + from + '\'' +
				", to='" + to + '\'' +
				", message='" + message + '\'' +
				'}';
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
