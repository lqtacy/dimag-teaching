package com.dimag.start;

public abstract class AbstractMessageSender implements MessageSender {
	public String composeMessage(Message message) {
		return "<html><body> destination[" + getDestination() + "] " + message.getMessage() + "</body></html>";
	}

	public abstract String getDestination();
}
