package com.dimag.math.homework;

import java.util.ArrayList;
import java.util.List;

public class MessageSender {
	public void writeMessages(List<Message> messages) {
		//for each message in messages:
		//display message
		//System.out.println(messages.get(0).toFancyString());
	}

	public static void main(String[] args) {
		List<Message> messages = new ArrayList<>();

		//new ExcelMessage(new Employee("hasari", "tosun", "ht@gmail.com"))
		//add different messages;
		new MessageSender().writeMessages(messages);
	}


}
