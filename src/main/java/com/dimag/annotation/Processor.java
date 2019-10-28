package com.dimag.annotation;

public abstract class Processor {

	protected String name = "Haydar";

	public static String NAME = "name";

	protected void before() {
	}


	protected void after() {
	}


	protected abstract void start();

	/**
	 * Life-cycle calisma dongusu
	 */
	public final void process() {
		before();
		start();
		after();

	}
}
