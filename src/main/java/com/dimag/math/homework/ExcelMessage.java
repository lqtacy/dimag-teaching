package com.dimag.math.homework;

public class ExcelMessage implements Message {
	private Employee employee;

	public ExcelMessage(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toFancyString() {
		return null; //firstname,lastname,email
	}
}
