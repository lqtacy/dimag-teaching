package com.dimag.init;

import com.dimag.lib.Employee;

public class Main {

	public static void test() {
		//the scope of these object is the method body: hayati bu methoddur
		EmployeeCache employeeCache = new EmployeeCache();
		EmployeeCache employeeCache1 = new EmployeeCache(10);
		EmployeeCache employeeCache2 = new EmployeeCache(10, true);

	}

	public static void main(String[] args) {
		test(); //after returning from test, objects are in the heap. Garbage collector will clean it up

		System.out.println(EmployeeCache.LIMIT);

		EmployeeCache employeeCache = new EmployeeCache();
		EmployeeCache employeeCache1 = new EmployeeCache(10);
		EmployeeCache employeeCache2 = new EmployeeCache(10, true);

		employeeCache.addEmployee(new Employee("Hasari", 77));
		employeeCache.addEmployee(new Employee("Mehmet", 77));

		Employee employee = employeeCache.getEmployee();
		System.out.println(employee);

		CacheFactory factory = CacheFactory.newInstance(true).setX(89).setY(90);
		CacheFactory factory2 = CacheFactory.newInstance(true);
		CacheFactory factory3 = CacheFactory.newInstance(true);

		if (factory2.equals(factory)) {
			System.out.println("equals1");
		}

		if (factory2 == factory) {
			System.out.println("equals2");
		}


		System.out.println("factory:" + factory);
		System.out.println("factory:" + factory3);


	}
}
