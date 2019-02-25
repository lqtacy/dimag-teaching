package com.dimag.notification;

public class Main {
	public static void main(String[] args) {
		LogMessage message1 = new LogMessage("abc", "Test message");
		LogMessage message2 = new DbEvent("abc", "Test message", "URGENT");
		LogMessage message3 = new ConsoleEvent("abc", "Test message", "blue");


		System.out.println("--------------message1----------------");
		System.out.println(message1.getMessage());
		System.out.println(message1.getSource());
		System.out.println(message1.getBody());

		System.out.println("--------------message2----------------");
		System.out.println(message2.getMessage());
		System.out.println(message2.getSource());
		System.out.println(message2.getBody());
		System.out.println(((DbEvent) message2).getType());


		System.out.println("--------------message3----------------");
		System.out.println(message3.getMessage());
		System.out.println(message3.getSource());
		System.out.println(message3.getBody());
		System.out.println(((ConsoleEvent) message3).getColor());


		ConsoleEvent event1 = new ConsoleEvent("ABC", "This is a test", "blue");


		PrettyConsoleEvent event2 = new PrettyConsoleEvent("ABC", "This is a test", "blue");
		event1.logToConsole();
		event2.logToConsole();




		System.out.println("-----------Message1--------");
		System.out.println(message1);


	}
}
