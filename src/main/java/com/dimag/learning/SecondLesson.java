package com.dimag.learning;

import com.dimag.lib.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SecondLesson {

	//Comment.................
	/*

	sdfsdf

	sdfsdf




	 */

	public void displayEmployee(Employee employee /**parameter**/) {
		System.out.println("Employee name=" + employee.getName() + " age=" + employee.getAge() + " Yasli mi?" + employee.yaslimi());
	}


	/**
	 * it adds all numbers in an array and returns the sum
	 *
	 * @param a array of numbers to be summed
	 * @return sume of all numbers
	 */
	public static long sum(int a[]) {

		long total = 0;
		for (int i = 0; i < a.length; i++) {
//			total = total + a[i];
			total += a[i];
		}

		long total2 = 0;
		int count = 0;

		for (int value : a) {
			total2 = total2 + value;
			count--;
		}
		double average = (double)total2/count;



		return total;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

		String names []  = {"Hasari", "Abuzer", "Gafari", "Mahmut"};
		String names2[]; //declaration definition
		names2 = new String[4]; //initialization

		names2[0] = "Hasari";
		names2[3] = "Mahmut";

		String namesx[] = names;  //reference


		int a[] = new int[10];

		a[5] = 8;
		a[a.length - 1] = 90;


		CompletableFuture<String> completableFuture
				= CompletableFuture.supplyAsync(() -> "Hello")
				.thenCombine(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> s1 + s2);

		System.out.println("args = [" + completableFuture.get() + "]");


		FileWriter writer = new FileWriter("test.txt");
		writer.write("hello world...");
		writer.close();

		//Birinci isci
		// isci=instance of an object
		//Employee object
		Employee isci1 = new Employee();
		isci1.setName("John Doe");
		isci1.setAge(44);


		PrintWriter writer2 = new PrintWriter("test.txt");
		writer2.println("hellow world");
		writer2.println("My name is Abuzer...");



		//Ikinci isci
		Employee e1 = new Employee("Ahmet Mehmet", 44);
		Employee e2 = new Employee("Ahmet Mehmet", 44);

		if(e1.equals(e2)){
			System.out.println("They are equal");
		}else{
			System.out.println("not equal,..");
		}


		String n1 = "hasari";
		String n2 = "hasari";
		boolean isEqual = n1.equals(n2);

		System.out.println(Employee.getABC());

		System.out.println("Employee=" + isci1);
		System.out.println("Employee=" + e1);

		e1.setAge(100);
		System.out.println("Employee=" + e1);

		if (e1.yaslimi()) {
			System.out.println("Yasli");
		} else {
			System.out.println("Daha genc");
		}

		SecondLesson lesson = new SecondLesson();
		lesson.displayEmployee(e1);
	}
}
