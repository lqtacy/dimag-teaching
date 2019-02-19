package com.dimag.lib;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	private List<Employee> employeeList = new ArrayList<>();

	public void addEmployee(Employee employee) {
		this.employeeList.add(employee);
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public Employees setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
		return this;
	}

	public boolean hasEmployee(String name){

		//eger employee bulunuyorsa, true, yoksa false return etsin.
		return false;
	}
}
