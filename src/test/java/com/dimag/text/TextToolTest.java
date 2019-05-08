package com.dimag.text;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TextToolTest {

	@Test
	public void analyze() {
	}

	@Test
	public void analyzeWithList() {
		List<String> words = Arrays.asList("fox", "dog", "cat", "fox", "fox", "dog");
		Map<String, Integer> frequencies = TextTool.analyzeFile(words);
		assertNotNull(frequencies);
		assertEquals(3, frequencies.size());
		assertEquals(3, frequencies.get("fox").intValue());
		assertEquals(2, frequencies.get("dog").intValue());
	}

	@Test(expected = TextProcessorException.class)
	public void analyzeReadingFromFile() throws TextProcessorException {
		Map<String, Integer> frequencies = new TextTool().analyzeFile("./test_xxx.txt");
	}
}