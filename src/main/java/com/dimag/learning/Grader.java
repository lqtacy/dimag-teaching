package com.dimag.learning;

public class Grader {

	public static String grade(int score) throws Exception {

		if (score < 0 || score > 100) {
			throw new Exception("Grade cannot be negative");
		}

		String derece = "F";
		if (score > 91) {
			derece = "A";
		} else if (score > 82) {
			derece = "B";
		} else if (score > 70) {
			derece = "c";
		} else {
			derece = "F";
		}

		return derece;

	}

	public static void main(String[] args) {

		String not = null;
		try {
			not = grade(105);
		} catch (Exception e) {
			System.out.println("Hata olustu.....");
			e.printStackTrace();
		}
		System.out.println(not);

	}

}
