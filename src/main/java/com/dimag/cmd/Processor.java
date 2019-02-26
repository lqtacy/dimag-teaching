package com.dimag.cmd;

public abstract class Processor {

	protected void before() {
	}



	protected void after() {
	}



	protected abstract void start();

	public final void process() {
		before();
		start();
		after();
	}
}
