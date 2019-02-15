package com.dimag.lib;


//Object-Oriented :
public class Employee {
	private String name = "Ahmet Mehmet"; //instance variable
	private int age = 90;
	private double salary = 1_000_000;
	private static final String ABC = "abc"; //class variable. Static variable


	public Employee() {

	}

	/**
	 * We create an employee instance here.
	 * @param name the name of employee
	 * @param age the age of employee
	 */
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public boolean yaslimi() {

		boolean yasli = (age > 0) ? true : false; //local variable. short-circuit if

		boolean gercektenmiYasli = false;
		if (age > 0) {
			gercektenmiYasli = true;
		} else {
			gercektenmiYasli = false;
		}

		return yasli;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public Employee setAge(int age) {
		this.age = age;
		return this;
	}

	public static String getABC(){
		return ABC;
	}
	public double getSalary() {
		return salary;
	}

	public Employee setSalary(double salary) {
		this.salary = salary;
		return this;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Employee employee = (Employee) o;

		return name != null ? name.equals(employee.name) : employee.name == null;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
