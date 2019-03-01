package com.dimag.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Hatali extends Exception {

	public Hatali() {
		super();
	}

	public Hatali(String message) {
		super(message);
	}

	public Hatali(String message, Throwable cause) {
		super(message, cause);
	}

	public Hatali(Throwable cause) {
		super(cause);
	}

	protected Hatali(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

class MyException extends Exception {

	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	protected MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

public class Main {

	public static void calculate1(int i) throws Hatali, FileNotFoundException {

		FileInputStream stream = new FileInputStream("./src/main/resources/test.txt");


		try {
			myMethod(i);
		} catch (MyException e) {
			System.out.println("Hata olustu. Bir sey bilmiyorum..." + e.getMessage());
			throw new Hatali("Yeni hata olustu....", e);
		} catch (Hatali e) {
			System.out.println("Hata olustu. Bir sey bilmiyorum..." + e.getMessage());
			throw new Hatali("Yeni hata olustu....", e);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				//baska yapacak birsey yok.
			}
			System.out.println("finallly....");
		}
		System.out.println("Done");
	}


	public static void calculate3(int i) throws Hatali, FileNotFoundException {

		FileInputStream stream = new FileInputStream("./src/main/resources/test.txt");


		try {
			myMethod(i);
		} catch (MyException | Hatali e) {
			System.out.println("Hata olustu. Bir sey bilmiyorum..." + e.getMessage());
			throw new Hatali("Yeni hata olustu....", e);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				//baska yapacak birsey yok.
			}
			System.out.println("finallly....");
		}
		System.out.println("Done");
	}

	//runtime exception
	//checked exception
	public static void calculate2(int i) throws Hatali {
		try {
			myMethod(i);
		} catch (MyException e) {
			//bunu bilerek yutuyoruz...
			e.printStackTrace();
		}
		System.out.println("Done...");
	}

	public static void myMethod(int i) throws MyException, Hatali {
		if (i < 0) {
			throw new MyException("Burda bir hata var...");
		}

		if (i > 1000) {
			throw new Hatali("Burda bir hata var...");
		}

	}

	public static void main(String[] args) throws Exception {
		calculate1(-1);
	}
}
