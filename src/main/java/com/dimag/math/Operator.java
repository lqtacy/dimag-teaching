package com.dimag.math;

public interface Operator {
	String OP = "OPERATOR"; //final static

	double process(int a, int b); //no {body}

	String getName();


	//JAVA 8 den sonra eklenenler.
	static String getOperatorSuffix() {
		return OP;
	}

	//Java8: instance method gibi. It has a body.
	default double add(int a, int b) {
		return a + b;
	}
}
