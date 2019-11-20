package com.dimag.start;

public class Emailer extends AbstractMessageSender {
	String to;

	@Override
	public void send(Message message) {
		to = message.getTo();
		log(message);
		System.out.println("Emailing message:" + composeMessage(message));
	}

	@Override
	public String getDestination() {
		return "to:" + to;
	}
}
