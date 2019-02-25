package com.dimag.notification;

import java.util.logging.Logger;

public class LogMessage implements Notification {
	protected Logger logger = Logger.getLogger(LogMessage.class.getName());

	//protected: children can see
	//no access modifier: package protected
	//public accessible to everybody
	//private: only this class can see
	private String source;


	private String message;

	public LogMessage(String source, String message) {
		this.source = source;
		this.message = message;
	}

	public String getSource() {
		return source;
	}

	public LogMessage setSource(String source) {
		this.source = source;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public LogMessage setMessage(String message) {
		logger.finest("Set message cagrildi....");
		this.message = message;
		return this;
	}


	@Override
	public String getBody() {
		return getSource() + ":" + getMessage();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LogMessage that = (LogMessage) o;

		return source != null ? source.equals(that.source) : that.source == null;
	}

	@Override
	public int hashCode() {
		return source != null ? source.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "LogMessage{" +
				"source='" + source + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
