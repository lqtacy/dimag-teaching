package com.dimag.start;

public class SmsSender extends AbstractMessageSender {
	private String from;

	@Override
	public void send(Message message) {
		from = message.getFrom();
		MessageSender.displayMessage(message);
		log(message);
		System.out.println("Sms message:" + composeMessage(message)
		);
	}

	@Override
	public String getDestination() {
		return "from:" + from;
	}
}
