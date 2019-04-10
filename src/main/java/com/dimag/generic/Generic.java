package com.dimag.generic;

import java.util.*;


class CacheStorage<T> {

	private List<T> data = new ArrayList<>();

	void add(T item) {
		data.add(item);
	}

	public List<T> getData() {
		return data;
	}

	public List<T> getLastTenItems() {
		return this.data.size() > 10 ? data.subList(data.size() - 10, data.size()) : data;
	}
}


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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Employee employee = (Employee) o;

		if (age != employee.age) return false;
		return name != null ? name.equals(employee.name) : employee.name == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + age;
		return result;
	}
}

public class Generic {

	public static void testMap() {
		Map<String, Employee> employeeMap = new HashMap<>();
		employeeMap.put("eyub", new Employee("Eyub", 13));
		employeeMap.put("eyub", new Employee("Eyub2", 23));
		employeeMap.put("yakob", new Employee("Yakob", 10));


		for (String key : employeeMap.keySet()) {
			System.out.println(key + "=" + employeeMap.get(key));
		}

		for (Employee employee : employeeMap.values()) {
			System.out.println(employee);
		}

		for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
			System.out.println("Key=" + entry.getKey() + " value=" + entry.getValue());
		}

		if (!employeeMap.containsKey("eyub")) {
			employeeMap.put("eyub", new Employee("Eyub2", 23));
		}

		employeeMap.putIfAbsent("eyub", new Employee("Eyub2", 23));

		employeeMap.forEach((key, value) -> {
			System.out.println("Key=" + key + " value=" + value);
		});

	}

	public static void testMap2() {
		Map<Employee, String> employeeMap = new HashMap<>();
		employeeMap.put(new Employee("Eyub", 13), "eyub");
		employeeMap.put(new Employee("Eyub", 13), "eyub");
		employeeMap.put(new Employee("Yakob", 10), "yakob");


		for (Employee key : employeeMap.keySet()) {
			System.out.println(key + "=" + employeeMap.get(key));
		}


	}


	public static void testSet() {
		Set<String> isimler = new HashSet<>();
		isimler.add("Hasari");
		isimler.add("Hasari"); //no duplicates...
		isimler.add("Eyub");

		System.out.println(isimler);
		for (String isim : isimler) {
			System.out.println(isim);
		}

		isimler.forEach(isim -> {
			System.out.println(isim);
		});

	}

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Kahta");
		names.add("Adiyaman");

		List<Integer> ages = new ArrayList<>();
		ages.add(20);
		ages.add(30);


		CacheStorage<String> storage = new CacheStorage<>();
		storage.add("Adiyaman");
		storage.add("45");

		CacheStorage<Integer> storage2 = new CacheStorage<>();
		storage2.add(23);
		storage2.add(22);

		System.out.println(storage2.getLastTenItems());

		testSet();
		testMap();
		testMap2();

	}
}
