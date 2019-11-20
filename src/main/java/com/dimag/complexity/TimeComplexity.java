package com.dimag.complexity;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TimeComplexity {
	public static <T> List<T> diff(List<T> list1, List<T> list2) {

		Map<T, Boolean> map2 = new HashMap<>();

		for (int i = 0; i < list2.size(); i++) {
			map2.put(list2.get(i), true);
		}
		List<T> result = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			if (!map2.containsKey(list1.get(i))) {
				result.add(list1.get(i));
			}
		}
		return result;
	}

	public static <T> List<T> diff2(List<T> list1, List<T> list2) {

		Map<T, Boolean> map2 = new HashMap<>();

		for (T a : list2) {
			map2.put(a, true);
		}
		List<T> result = new ArrayList<>();
		for (T a : list1) {
			if (!map2.containsKey(a)) {
				result.add(a);
			}
		}
		return result;
	}

	public static <T> List<T> diff3(List<T> list1, List<T> list2) {
		var map2 = list2.parallelStream().collect(Collectors.toMap(x -> x, x -> true));
		Predicate<T> f = x -> !map2.containsKey(x);
		return list1.parallelStream().filter(f).collect(toList());
	}

	public static void main(String[] args) {
		var list1 = Arrays.asList("Hasari", "Tosun", "Eyub", "Yakob");
		List<String> list2 = Arrays.asList("Hasari", "Eyub", "Yakob");
		List<String> difference = diff3(list1, list2);

		difference.forEach(x -> System.out.println(x));


		var list3 = Arrays.asList(2, 5, 10, 12, 6);
		var list4 = Arrays.asList(2, 12, 5);
		List<Integer> difference2 = diff3(list3, list4);

		difference2.forEach(x -> System.out.println(x));


	}
}
