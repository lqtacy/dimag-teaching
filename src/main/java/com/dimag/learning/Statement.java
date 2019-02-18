package com.dimag.learning;

public class Statement {
	public static void main(String[] args) {
		int a = 2-4; /* 2-4 expression dir */
		boolean sonuc = a < 0; /** a < 0 expression */
		int b = 7; int c = 89; ///statements turkcedeki cumle gibi
		if (sonuc && b > 5){ //isNegative in scope u bu block tir. Disarida gorunurlugu yok
			boolean isNegative = sonuc;
			System.out.println(sonuc);
		}
		System.out.println(sonuc);


	}
}
