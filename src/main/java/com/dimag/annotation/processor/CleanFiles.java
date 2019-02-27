package com.dimag.annotation.processor;

import com.dimag.annotation.Processor;
import com.dimag.annotation.Task;

@Task(name = "cp")
public class CleanFiles extends Processor {

	@Override
	protected void start() {
		System.out.println("CleanFiles:start");

	}
}
