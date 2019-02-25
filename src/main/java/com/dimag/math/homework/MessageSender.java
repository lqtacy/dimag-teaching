package com.dimag.math.homework;

import java.util.ArrayList;
import java.util.List;

public class MessageSender {
	public void writeMessages(List<Message> messages) {
		for (Message message : messages) {
			if(message instanceof ExcelMessage){
				System.out.println(((ExcelMessage)message).header());
			}
			System.out.println(message.toFancyString());
		}
	}

	public static void main(String[] args) {
		List<Message> messages = new ArrayList<>();

		//definition type is Message and initialized with runtime type JsonMessage
		Message message = new JsonMessage(new Employee("Hasari", "Tosun", "ht@gmail.com"));
		//new instance of JsonMessage
		messages.add(message);
		//polymorphism: runtime, we are changing the type.....
		message = new ExcelMessage(new Employee("Hasari", "Tosun", "ht@gmail.com"));
		messages.add(message);
		messages.add(new JsonMessage(new Employee("Ahmet", "Mehmet", "ahmetmehmet@gmail.com")));

		new MessageSender().writeMessages(messages);
	}


}
