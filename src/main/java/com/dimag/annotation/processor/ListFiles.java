package com.dimag.annotation.processor;

import com.dimag.annotation.Processor;
import com.dimag.annotation.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Task(name = "lf", description = "This process lists all the files in the directory...")
public class ListFiles extends Processor {

	@Override
	protected void before() {
		System.out.println("ListFiles:before");
	}


	@Override
	protected void start() {
		try {
			Files.list(Paths.get("./")).forEach(f -> System.out.println(f));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
