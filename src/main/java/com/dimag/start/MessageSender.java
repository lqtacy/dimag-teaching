package com.dimag.start;

public interface MessageSender {
	void send(Message message);

	default void log(Message message) {
		System.out.println(message);
	}

	static void displayMessage(Message message) {

	}

	String MESSAGE = "message";
}
