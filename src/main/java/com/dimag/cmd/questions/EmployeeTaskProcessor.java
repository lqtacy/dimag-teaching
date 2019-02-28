package com.dimag.cmd.questions;

public class EmployeeTaskProcessor implements TaskProcessor, EmployeeProcessor {
	@Override
	public String getName() {
		return null;
	}

	@Override
	public void process() {

	}

	public static void main(String[] args) {
		EmployeeTaskProcessor processor = new EmployeeTaskProcessor();
		processor.process();
		System.out.println(processor.getName());

		TaskProcessor processor2 = new EmployeeTaskProcessor();
		processor2.process();

		EmployeeProcessor processor3 = new EmployeeTaskProcessor();
		System.out.println(processor3.getName());

	}
}
