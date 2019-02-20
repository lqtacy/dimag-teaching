package com.dimag.math;

public class MultiplicationOperator implements Operator {
	private boolean symbolic = false;

	@Override
	public double process(int a, int b) {
		return a * b;
	}

	public String processSymbolic(int a, int b) {
		return a + "*" + b;
	}

	@Override
	public String getName() {
		return "MULTIPLY_"+Operator.getOperatorSuffix();
	}

	public MultiplicationOperator setSymbolic(boolean symbolic) {
		this.symbolic = symbolic;
		return this;
	}

	public boolean isSymbolic() {
		return false;
	}
}
