package com.dimag.annotation.processor;

import com.dimag.annotation.Processor;
import com.dimag.annotation.Task;

@Task(name = "mf", description = "Bu dosyalari bir klasorden digerine tasir.")
public class MoveFiles extends Processor {

	String name ="Ali";

	public static String NAME = "namex";

	@Override
	protected void start() {
		System.out.println("MoveFiles:start" + name);
	}

	//Method overloading
	public void start(String name) {
		System.out.println(name);
	}

	public void start(int age, String name) {
		System.out.println(name);
	}

	public void start(int age) {
		System.out.println(age);
	}

	public void start(Processor p) {
		System.out.println(p.getClass().getName());
	}

	public void start(MoveFiles p) {
		System.out.println(p.getClass().getName());
	}


	@Override
	protected void after() {
		super.after();
		System.out.println("Dosyalari tasidik...");
	}


}
