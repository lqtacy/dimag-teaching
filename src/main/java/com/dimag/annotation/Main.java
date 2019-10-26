package com.dimag.annotation;

import org.apache.log4j.Logger;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class.getName());

	private Map<String, Processor> processorMap = new HashMap();

	public Main() throws Exception {
		Reflections ref = new Reflections("com.dimag.annotation.processor");
		for (Class<?> cl : ref.getTypesAnnotatedWith(Task.class)) {
			Task annotation = cl.getAnnotation(Task.class);
			String description = annotation.description();
			System.out.println("Adding processor:" + annotation.name() + " ==>" + description);
			addProcessor(annotation.name(), cl);
		}

	}

	public void addProcessor(String name, Class clazz) throws Exception {
		Processor processor = (Processor) clazz.getDeclaredConstructor().newInstance();
		processorMap.put(name, processor);

	}

	public void startProcess(String command) throws Exception {
		Processor processor = processorMap.get(command);
		System.out.println("Running:" + command);
		if (processor == null) {
			throw new Exception("Processor not found:" + command);
		}
		processor.process();
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();

		for (String command : args) {
			main.startProcess(command);
		}
	}
}
