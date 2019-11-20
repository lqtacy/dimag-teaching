package com.dimag.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employee implements KnowsHowToPrint {
	private String employeeName;
	private int age;
	private String gender;

	public Employee(String employeeName, int age, String gender) {
		this.employeeName = employeeName;
		this.age = age;
		this.gender = gender;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void print() {
		System.out.println("Employee name=" + employeeName);
	}

	public static List<Integer> oldFolks(List<Employee> employeeList) {
		Predicate<Employee> erkek = (x) -> x.getGender().equals("M");
		Predicate<Employee> yasli = (x) -> x.getAge() > 70;
		Function<Employee, Integer> age = (x) -> x.getAge();
		return employeeList.stream()
				.filter(erkek.and(yasli))
				.map(age)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		var employees = Arrays.asList(
				new Employee("A", 45, "M"),
				new Employee("B", 89, "M"),
				new Employee("C", 90, "M"),
				new Employee("D", 91, "F"),
				new Employee("E", 100, "F"),
				new Employee("F", 23, "F")
		);

		var sonuc = oldFolks(employees);
		sonuc.forEach(x -> System.out.println(x));


	}
}
