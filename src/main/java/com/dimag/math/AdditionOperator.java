package com.dimag.math;

public class AdditionOperator implements Operator {
	@Override
	public double process(int left, int right) {
		return add(left, right);
	}

	@Override
	public String getName() {
		return "ADD_" + Operator.getOperatorSuffix();
	}
}
