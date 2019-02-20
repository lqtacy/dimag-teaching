package com.dimag.math;

public class SubstractionOperator implements Operator {
	public double process(int a, int b) {
		return a - b;
	}

	@Override
	public String getName() {
		return "SUB_" + Operator.getOperatorSuffix();
	}
}
