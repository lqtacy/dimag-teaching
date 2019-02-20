package com.dimag.lib;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	private List<Employee> employeeList = new ArrayList<>();

	public Employees addEmployee(Employee employee) {
		this.employeeList.add(employee);
		return this;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public Employees setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
		return this;
	}

	public boolean hasEmployee(String name) {
		return hasEmployeeMethod1(name);

	}


	private boolean hasEmployeeMethod1(String name) {
		boolean found = false;
		for (Employee employee : employeeList) {
			if (employee.getName().equals(name)) {
				found = true;
				break;
			}
		}

		return found;
	}

	private boolean hasEmployeeMethod2(String name) {
		return employeeList.stream().anyMatch(e -> e.getName().equals(name));
	}

}
