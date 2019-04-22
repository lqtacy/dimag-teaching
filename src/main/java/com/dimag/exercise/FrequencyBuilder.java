package com.dimag.exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FrequencyBuilder {
	//read the file

	//for each word, check if exists in frequency dictionary
	//increment the count
	//else
	//add new entry

	//write the frencies to a CSV file
	//yellow,5
	//fox,1


	public static Map<String, Integer> getFrequencies(List<String> allWords) {
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

	public static void oldWayTest() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("./test.txt"));
		List<String> allWords = new ArrayList<>();
		for (String line : lines) {
			String[] words = line.split(" ");
			for (String word : words) {
				String w = word.toLowerCase();
				allWords.add(w);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		Stream<String> lines = Files.lines(Paths.get("./test_freq.txt"));
		List<String> allWords = lines
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.map(word -> word.toLowerCase())
				.collect(toList());

		Map<String, Integer> freq = getFrequencies(allWords);

		FileWriter file = new FileWriter("./frequencies.csv");

		for (String word : freq.keySet()) {
			System.out.println(word + "->" + freq.get(word));
			file.write(word + "," + freq.get(word) + "\n");

		}
		file.close();


	}

}
