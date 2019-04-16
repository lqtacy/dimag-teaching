package com.dimag.scope;

public class Main {

	private static double topla(int[] numbers) {
		double total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total = total + numbers[i];
		}

		return total;
	}

	private double add(int[] numbers) {
		double total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total = total + numbers[i];
		}
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] * 2;
		}
		//System.out.println(i);
		//numbers = null;

		int k = 0;
		double sum = 0;
		while(k < numbers.length){
			double m = sum;
			sum = sum+numbers[k];
			k++;
		}
		System.out.println("average="+sum/(double)k);

		return total;
	}

	private static void printArray(int[] arr) {
		System.out.print("[");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		int numbers[] = {8, 7, 1, 2};
		printArray(numbers);
		Main m = new Main();
		double result = m.add(numbers);
		printArray(numbers);

		System.out.println(result);
	}
}
