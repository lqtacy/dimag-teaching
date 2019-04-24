package com.dimag.text;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * This TextTool analyzes text and finds frequencies
 */
public class TextTool {
	private static final Logger log = Logger.getLogger(TextTool.class.getName());

	/**
	 * reads text from file and finds the frequencies of each word
	 *
	 * @param fileName File name
	 * @return frequencies
	 * @throws IOException if text file does not exists
	 */
	public static Map<String, Integer> analyze(String fileName) throws TextProcessorException {

		log.debug("Analyzing text file:" + fileName);
		Stream<String> lines = null;
		try {
			lines = Files.lines(Paths.get(fileName));
		} catch (IOException e) {
			log.error("Failed to read from file:" + fileName, e);

			throw new TextProcessorException("Cannot find the text file:" + fileName, e);
		}
		List<String> allWords = lines
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.map(word -> word.toLowerCase())
				.collect(toList());
		return getFrequencies(allWords);

	}

	/**
	 * for given list  of words, it finds their frequencies
	 *
	 * @param allWords list of words
	 * @return frequencies
	 */
	public static Map<String, Integer> getFrequencies(List<String> allWords) {
		log.debug("Calculating frequencies...");

		Map<String, Integer> frequencies = new HashMap<>();
		allWords.forEach(word -> {
			if (frequencies.containsKey(word)) {
				frequencies.put(word, frequencies.get(word) + 1);
			} else {
				frequencies.put(word, 1);
			}
		});
		return frequencies;
	}

	public static void writeToCsvFile(String outputFileName, Map<String, Integer> frequencies) throws TextProcessorException {
		log.debug("Writing frequencies to  text file:" + outputFileName);

		FileWriter file = null;
		try {
			file = new FileWriter(outputFileName);
			for (String word : frequencies.keySet()) {
				file.write(word + "," + frequencies.get(word) + "\n");
			}

		} catch (IOException e) {
			log.error("Failed to write to file:" + outputFileName, e);
			throw new TextProcessorException("Cannot write to outputfile:" + outputFileName, e);
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
				}
			}
		}

	}

}
