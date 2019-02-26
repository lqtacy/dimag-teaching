package com.dimag.cmd.processor;

import com.dimag.cmd.Processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
