package com.dimag.math.homework;

public class JsonMessage implements Message {
	private Employee employee;

	public JsonMessage(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toFancyString() {
		return "{\"firstName\":\"" + employee.getFirstName() + "\", \"lastName\":\"" + employee.getLastName() + "\", \"email\":\"" + employee.getEmail() + "\"}";
	}

	public static void main(String[] args) {
		JsonMessage jsonMessage = new JsonMessage(new Employee("Hasari", "Tosun", "ht@gmail.com"));
		System.out.println(jsonMessage.toFancyString());
	}
}
