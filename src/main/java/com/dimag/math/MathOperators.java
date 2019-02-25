package com.dimag.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Param {
	private int left;
	private int right;

	public Param(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public Param setLeft(int left) {
		this.left = left;
		return this;
	}

	public int getRight() {
		return right;
	}

	public Param setRight(int right) {
		this.right = right;
		return this;
	}
}

public class MathOperators {
	public static void main(String[] args) {

		String xxx = Operator.OP;
		//Operator op = new Operator(); //you cannot initialize interfaces
		Operator op = new SubstractionOperator();
		//op.display();
		SubstractionOperator opx = (SubstractionOperator) op;
		opx.display();


		List<Operator> operators = new ArrayList<>();
		operators.add(new AdditionOperator());
		operators.add(new AdditionOperator());
		operators.add(new MultiplicationOperator());
		operators.add(new SubstractionOperator());
		System.out.println(Operator.OP);


		//System.out.println(new SubstractionOperator().process(7, 1));

		List<Param> params = Arrays.asList(
				new Param(4, 5),
				new Param(4, 6),
				new Param(3, 4),
				new Param(15, 6)
		);

		System.out.println(calculate(operators, params));

	}


	public static double calculate(List<Operator> operators, List<Param> params) {
		double result = 0;
		for (int i = 0; i < operators.size(); i++) {
			Operator op = operators.get(i);
			Param param = params.get(i);

			System.out.println("Applyin operator:" + op.getName());

			result += op.process(param.getLeft(), param.getRight());

			if(op instanceof  MultiplicationOperator){
				MultiplicationOperator mo  = (MultiplicationOperator)op; /** casting */
				System.out.println("symbolic:"+mo.processSymbolic(param.getLeft(), param.getRight()));
			}

		}
		return result;
	}

}
