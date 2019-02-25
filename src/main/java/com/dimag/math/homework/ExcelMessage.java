package com.dimag.math.homework;

public class ExcelMessage implements Message {
	private Employee employee;

	public ExcelMessage(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toFancyString() {
		return String.join(",", employee.getFirstName(), employee.getLastName(), employee.getEmail()); //firstname,lastname,email
	}


	public static void main(String[] args) {
		ExcelMessage message  = new ExcelMessage(new Employee("Hasari", "Tosun", "ht@gmail.com"));
		System.out.println(message.toFancyString());
	}

	public  String header(){
		return "#firstName,lastName,email";
	}
}
