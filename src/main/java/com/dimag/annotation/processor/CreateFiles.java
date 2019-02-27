package com.dimag.annotation.processor;

import com.dimag.annotation.Processor;
import com.dimag.annotation.Task;

@Task(name = "cf")
public class CreateFiles extends Processor {

	@Override
	protected void start() {
		System.out.println("CreateFiles:start");

	}
}
