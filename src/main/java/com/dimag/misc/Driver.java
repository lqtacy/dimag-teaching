package com.dimag.misc;



public class Driver {


	public  double getAverage(int[] numbers) {
		return topla(numbers) / numbers.length;
	}

	public static double topla(int [] numbers){
		double total = 0;
		for (int n : numbers) {
			total += n;
			//total = total +n;
		}
		return total;
	}

	public static double ortalama(int[] sayilar) {
		return topla(sayilar) / sayilar.length;
	}

	public static void main(String[] args) {
		int[] numbers = {5, 6, 7, 6};
		double average = Driver.ortalama(numbers);
		System.out.println("Average=" + average);

		Driver d = new Driver();
		System.out.println("Average=" + d.getAverage(numbers));


	}
}
