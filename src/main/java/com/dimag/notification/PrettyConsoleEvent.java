package com.dimag.notification;

public class PrettyConsoleEvent extends ConsoleEvent {
	private String color; //shadows the color in the parent class

	public PrettyConsoleEvent(String source, String message, String color) {
		super(source, message, color);
		this.color = color;
	}

	@Override
	public void logToConsole() {
		System.out.println("----------------------------");
		System.out.println(getBody());
		System.out.println("----------------------------");
	}

}
