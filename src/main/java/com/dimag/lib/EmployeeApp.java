package com.dimag.lib;

public class EmployeeApp {
	public static void main(String[] args) {
		Employees list = new Employees()
				.addEmployee(new Employee("Hasari", 2).setSalary(89))
				.addEmployee(new Employee("Mehmet", 4))
				.addEmployee(new Employee("Ahmet", 5));


		if (list.hasEmployee("ABC")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
}
