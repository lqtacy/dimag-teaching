package com.dimag.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlFlow {
	public static void main(String[] args) {


		for (int i = 0; /**initialization only once */i < 5;/** condition */i++ /** increment */) {
			System.out.println(i);
		}

		int j = 0;
		for (; ; ) {
			System.out.println(j);
			j++;
			if (j > 4)
				break;
		}

		int k = 0;
		while (k < 5) {
			System.out.println(k);
			k++;
		}

		do {
			System.out.println(k);
			k++;
		} while (k < 4);


		String names[] = {"Haydar", "Osman", "Mehmet"};
		for (String name : names) {
			String isim = name + " Sr.";
			System.out.println(name);
		}

		for (int i = 0; i < names.length; i++) {
			names[i] = names[i] + " Sr.";
			System.out.println(names[i]);
		}

		for (String name : names) {
			System.out.println(name);
		}

		List<String> isimler = new ArrayList<>();
		isimler.add("Ali");
		isimler.add("Osman");
		isimler.add("Mehmet");

		for (String isim : isimler) {
			if (isim.equals("Osman")) {
				System.out.println("Osman bulundu...");
			}
			System.out.println(isim);
		}


		for (int m = 0; m < isimler.size(); m++) {
			String isim = isimler.get(m);
			System.out.println(isim + "==>" + isim.length());
			if (isim.equals("Osman")) {
				System.out.println("Osman bulundu...sira:" + m);
			}
			System.out.println(isim);
		}


		isimler.forEach(x -> System.out.println(x));


		Map<String, Integer> employees = new HashMap<>();
		employees.put("haydar", 40);
		employees.put("veli", 30);
		employees.put("Ali", 22);

		for (String /** isim*/key : employees.keySet()) {
			System.out.println(key);
		}
		for (int /** yas*/value : employees.values()) {
			System.out.println(value);
		}
		for (Map.Entry<String, Integer> keyValue : employees.entrySet()) {
			System.out.println(keyValue.getKey() + "==>" + keyValue.getValue());

		}

		employees.forEach((key, value) -> System.out.println(key + "==>" + value));


	}



}
