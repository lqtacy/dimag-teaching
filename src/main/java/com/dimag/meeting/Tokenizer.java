package com.dimag.meeting;

import java.util.*;
import java.util.stream.Collectors;

public class Tokenizer {
	private static Map<String, List<String>> PHRASES = new HashMap<>();

	static {
		PHRASES.put("1", Arrays.asList("1", "afterward", "whenever", "however", "until", "as soon as", "as long as", "while", "again", "also", "besides"));
		PHRASES.put("2", Arrays.asList("therefore", "thus", "consequently", "as a result", "for this reason", "so", "so that", "accordingly", "because"));
		PHRASES.put("3", Arrays.asList("in addition to", "so", "moreover"));
		PHRASES.put("4", Arrays.asList("in general", "for the most part", "as a general rule", "on the whole", "usually", "typically", "in summary"));
	}

	public static List<String> uniquePhrases(Map<String, List<String>> phrases) {
		//listA = [] bos liste
		//her phrases elemani listB icin:
		//   her listB elemani p icin:
		//       eger p listA in icinde degilse:
					//list A ya ekle.
		return null;
	}

	public List<String> ngrams(List<String> oneGrams, int n) {
		List<String> ngrams = new ArrayList<>();
		for (int i = 0; i < oneGrams.size() - n + 1; i++)
			ngrams.add(oneGrams.subList(i, i + n).stream().collect(Collectors.joining(" ")));
		return ngrams;
	}

	private List<String> tokenize(String text) {
		text = text.replace(".", "");
		text = text.replace(",", "");
		text = text.replace("?", "");
		return Arrays.stream(text.split(" "))
				.map(w -> w.trim())
				.filter(w -> w.length() > 0)
				.map(w -> w.toLowerCase())
				.collect(Collectors.toList());
	}

	public Map<String, Integer> calculateFrequencies(String text) {
		//1: single list of phrases
		//tokenize
		//create n-grams
		//calculate frequencies
		return null;
	}

	public static void main(String[] args) {
		String text = "Afterward, a yellow bird landed on the tall tree in addition to a lazy tortoise.  " +
				"However, he had a read beak. In addition to white the patches on the wings, he was completely yellow. " +
				"In summary, it was yellow bird. In summary, it did not sing.";


		Tokenizer tokenizer = new Tokenizer();

		List<String> tokens = tokenizer.tokenize(text);
		System.out.println(tokens);

		List<String> ngrams = tokenizer.ngrams(tokens, 3);
		System.out.println(ngrams);

	}
}
