package com.dimag.init;

import com.dimag.lib.Employee;
import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCache extends Cache {
	public static final int LIMIT = 10;

	private static Map<String, String> mappings = new HashMap<>();

	private CircularFifoQueue<Employee> queue;

	//static block
	static {
		mappings.put("abc", "abc-value");
		mappings.put("xyz", "xyz-value");
	}


	private boolean isFIFO = false;


	public EmployeeCache() {
		this(10, true);
		System.out.println("no param child....");

	}

	public EmployeeCache(int size) {
		this(size, true);
		String abc = "abc";
	}

	public EmployeeCache(int size, boolean isFIFO) {
		super(size);
		this.isFIFO = isFIFO;
		queue = new CircularFifoQueue<>(this.getSize());
	}

	public void addEmployee(Employee employee) {
		queue.add(employee);
	}

	public Employee getEmployee() {
		return queue.poll();
	}

	public CircularFifoQueue<Employee> getQueue() {
		return queue;
	}


	public boolean isFIFO() {
		return isFIFO;
	}

	public EmployeeCache setFIFO(boolean FIFO) {
		isFIFO = FIFO;
		return this;
	}

}
