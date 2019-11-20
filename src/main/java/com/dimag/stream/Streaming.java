package com.dimag.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


interface Adder{
	float add(float b);
}
interface Displayable {
	void display();

	default void print() {
		System.out.println("Hello World");
	}

	static void yazdir() {
		System.out.println("Merhaba Dunya");
	}
}

class Student implements Displayable {
	private String name;
	private int age;

	public static String NAME = "name";

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public void display() {
		System.out.println("name:" + name + ", age:" + age);
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Student setAge(int age) {
		this.age = age;
		return this;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

class Ogrenci {
	private String name;
	private String month;

	public Ogrenci(String name, String month) {
		this.name = name;
		this.month = month;
	}

	public String getName() {
		return name;
	}

	public Ogrenci setName(String name) {
		this.name = name;
		return this;
	}

	public String getMonth() {
		return month;
	}

	public Ogrenci setMonth(String month) {
		this.month = month;
		return this;
	}
}

public class Streaming {
	public static void main(String[] args) {
		Displayable student = new Student("Mehmet", 30);
		student.display();

		Displayable.yazdir();
		Student murat = new Student("Murat", 40);
		Student veli = new Student("Ali", 40).setName("Veli");

		System.out.println(Student.NAME);

		List<Student> students = Arrays.asList(
				new Student("Mehmet", 30),
				new Student("Ahmet", 29));

		//students.forEach(s->s.display());
		students.stream().forEach(x -> x.display());

		Predicate<Student> filter = (s) -> s.getAge() < 30;
		Function<Student, Student> mappingFunction = s -> new Student(s.getName(), s.getAge() + 1);

		List<Student> students1 = students.parallelStream()
				.filter(filter)
				.map(mappingFunction)
				.collect(Collectors.toList());


		students1.forEach(System.out::println);


		List<Ogrenci> ogrenciler = Arrays.asList(
				new Ogrenci("Mehmet", "Agustos"),
				new Ogrenci("Ahmet", "Ocak"),
				new Ogrenci("Hemo", "Agustos")
		);

		Streaming streaming = new Streaming();
		streaming.calculateBirthdays(ogrenciler)
				.forEach((key, value) -> {
					System.out.println(key + ":" + value.size());
				});


		//Lambda
		Displayable f = () -> {
			System.out.println("hello there..");
		};

		streaming.process(f);

		Adder adder = (x)->x+1;
		Function<Float, Float> adder2 = (x)->x+1;

		System.out.println(adder.add(45.03f));
		System.out.println(adder2.apply(45.043f));


	}


	private void process(Displayable d) {
		d.display();
	}

	private Map<String, List<Ogrenci>> calculateBirthdays(List<Ogrenci> ogrenciler) {
		return ogrenciler.parallelStream()
				.collect(Collectors.groupingBy(Ogrenci::getMonth));


	}
}
