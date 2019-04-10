package com.dimag.streams;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
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

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

public class Main {
	public static void main(String[] args) {
		List<Employee> employeeList = Arrays.asList(
				new Employee("Hasari", 50),
				new Employee("Abdurrahman", 28),
				new Employee("Mehmet", 38)
		);

		//employeeList.stream().forEach(System.out::print);

//		Consumer<Employee> function = e->System.out.println(e);
//		employeeList.stream().forEach(function);

		employeeList.stream().forEach(e -> System.out.println(e));

		System.out.println("----------------");
		employeeList.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);

		List<Employee> matureEmployees = employeeList.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());

		System.out.println("----------------");

		int total = employeeList.parallelStream().map(e->e.getAge()).reduce((x,y)->x+y).get();
		System.out.println("Total ="+total+ " average="+total/(float)employeeList.size());


		Map<String, Employee> employeeMap = new HashMap<>();
		employeeMap.put("eyub", new Employee("Eyub", 13));
		employeeMap.put("eyub", new Employee("Eyub2", 23));
		employeeMap.put("yakob", new Employee("Yakob", 10));

		Set<String> keys = employeeMap.keySet();

		List<Employee> youngEmployees = employeeMap.keySet().stream()
				.filter(key->employeeMap.get(key).getAge() < 20)
				.map(key-> employeeMap.get(key))
				.collect(Collectors.toList());

		youngEmployees.forEach(System.out::println);




	}
}
