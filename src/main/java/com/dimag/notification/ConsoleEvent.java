package com.dimag.notification;

public class ConsoleEvent extends LogMessage {
	private String color;

	public ConsoleEvent(String source, String message, String color) {
		super(source, message);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public ConsoleEvent setColor(String color) {
		this.color = color;
		return this;
	}

	//final yapinca kimse override yapamaz.
	public void logToConsole(){
		System.out.println(getSource()+this.getBody());
	}
}
