package com.dimag.oo;

class Employee {
	private String name;
	private int age;
	private static String EMP = "EMP";

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void changeName(){
		this.name = name+ " Haydaroglu";
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Employee setAge(int age) {
		this.age = age;
		return this;
	}

	public boolean isOld() {
		return age > 33 ? true : false;
	}
}

public class Main {
	public void test() {
		Employee emp = new Employee("John Doe", 33);
		if (emp.isOld()) {
			System.out.println("He is old");
		} else {
			System.out.println("He is young.");
		}
		Employee emp2  = new Employee("Abdurrahman", 28);
	}

	public static void test2(){

	}

	public static void main(String[] args) {
		Main m = new Main(); //instance
		m.test();

		Main.test2();

	}
}
