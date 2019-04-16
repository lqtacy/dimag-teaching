package com.dimag.meeting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tokenizer {
	private static Map<String, List<String>> PHRASES = new HashMap<>();

	static {
		PHRASES.put("1", Arrays.asList("1", "afterward", "whenever", "however", "until", "as soon as", "as long as", "while", "again", "also", "besides"));
		PHRASES.put("2", Arrays.asList("therefore", "thus", "consequently", "as a result", "for this reason", "so", "so that", "accordingly", "because"));
		PHRASES.put("3", Arrays.asList("in addition to", "so", "moreover"));
		PHRASES.put("4", Arrays.asList("in general", "for the most part", "as a general rule", "on the whole", "usually", "typically", "in summary"));
	}

	public static List<String> uniquePhrases(Map<String, List<String>> phrases) {
		//List<String> unitedList = new ArrayList<>(); 	//listA = [] bos liste

		/*phrases.forEach((key,value) -> { 				// her phrases elemani listB icin:
			value.forEach(str -> {						// her listB elemani p icin:
				if (!unitedList.contains(str)){			// eger p listA in icinde degilse:
					unitedList.add(str); 				//list A ya ekle.
				}
			});
		});*/


		return phrases.values().stream()
				.flatMap(x -> x.stream())
				.distinct()
				.collect(Collectors.toList());
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


//		Tokenizer tokenizer = new Tokenizer();
		List<String> gram1 = tokenize(text);

		//tokenize
		List<String> tokens = new ArrayList<>(gram1);

//		for (int i = 2; i < 5; i++) {
//			tokens.addAll(ngrams(gram1, i));    //create n-grams
//		}
		List<String> all = IntStream.range(2,5)
				.mapToObj(i->ngrams(gram1, i))
				.flatMap(x->x.stream())
				.collect(Collectors.toList());

		tokens.addAll(all);

		List<String> checkPhrases = uniquePhrases(PHRASES);                //1: single list of phrases

		Map<String, Integer> wordFrequencyMap = new HashMap<>();            //calculate frequencies
		for (int i = 0; i < checkPhrases.size(); i++) {
			Integer wordCount = 0;
			for (int j = 0; j < tokens.size(); j++) {
				if (checkPhrases.get(i).equals(tokens.get(j))) {
					wordCount++;
				}
			}
			wordFrequencyMap.put(checkPhrases.get(i), wordCount);
		}
		return wordFrequencyMap;
	}

	public static void main(String[] args) {
		String text = "Afterward, a yellow bird landed on the tall tree in addition to a lazy tortoise.  " +
				"However, he had a read beak. In addition to white the patches on the wings, he was completely yellow. " +
				"In summary, it was yellow bird. In summary, it did not sing.";

		System.out.println(new Tokenizer().tokenize(text));

		new Tokenizer().calculateFrequencies(text).forEach((key, value) -> System.out.println(key + "==>" + value));
	}
}
