package com.dimag.collections;

public class Hasta implements KnowsHowToPrint {
	private String name;
	private int age;
	private String gender;
	private String sikayeti;

	public Hasta(String name, int age, String gender, String sikayeti) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.sikayeti = sikayeti;
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

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSikayeti() {
		return sikayeti;
	}

	public void setSikayeti(String sikayeti) {
		this.sikayeti = sikayeti;
	}

	@Override
	public String toString() {
		return "Hasta{" +
				"name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", sikayeti='" + sikayeti + '\'' +
				'}';
	}

	@Override
	public void print() {
		System.out.println(this);
	}
}
