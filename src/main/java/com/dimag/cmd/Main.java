package com.dimag.cmd;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {

	//Properties
	private Properties properties = new Properties();


	private Map<String, Processor> processorMap = new HashMap();

	public Main() throws Exception {
		properties.load(new FileReader("./src/main/resources/commands.properties"));
		for (Object key : properties.keySet()) {
			addProcessor((String) key, (String) properties.get(key));
		}

	}

	public void addProcessor(String name, String value) throws Exception {
		//Java Reflection
		Class clazz = Class.forName(value);
		Processor processor = (Processor) clazz.getDeclaredConstructor().newInstance();

		processorMap.put(name, processor);

	}

	public void startProcess(String command) throws Exception {
		Processor processor = processorMap.get(command);
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
