package com.dimag.collections;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Hasta> hastalar = new ArrayList<>();
		Hasta h1 = new Hasta("Esref", 27, "M", "Bas agrisi");
		hastalar.add(h1);
		Hasta h2 = new Hasta("Ahmet", 70, "M", "Sigara iciyor");
		hastalar.add(h2);
		hastalar.add(new Hasta("Ramazan", 24, "M", "Sevte xwa hesiye..."));

		List<Hasta> altKattakiler = new ArrayList<>();
		hastalar.add(new Hasta("Yilmaz", 28, "M", "Uyku..."));
		hastalar.add(new Hasta("Mehmet", 22, "M", "Yasindan sikayetci"));
		hastalar.add(new Hasta("Sem", 25, "F", "Yasindan sikayetci"));

		hastalar.addAll(altKattakiler);

		System.out.println(hastalar.get(2));

		for (Hasta h : hastalar) {
			System.out.println(h.getName());
		}

		for (int i = 0; i < hastalar.size(); i++) {
			System.out.println(hastalar.get(i).getName());
		}

		hastalar.forEach(
				x -> {
					System.out.println(x);
				}
		);

		hastalar.forEach(System.out::println);

		List<String> isimler = Arrays.asList("Hasari", "Tosun", "Eyub");
		if (isimler.contains("Tosun")) {
			System.out.println("Bulundu...");
		}

		int i = isimler.indexOf("Tosun");

		Map<String, Hasta> hastaMap = new HashMap<>();

		hastaMap.put(h1.getName(), h1);
		hastaMap.put("Mustafa", new Hasta("Mustafa", 70, "M", "Bos geziyor"));
		hastaMap.put("Ali", new Hasta("Ali", 26, "M", "Gezmiyor"));
		hastaMap.put(h2.getName(), h2);

		System.out.println(hastaMap.get("Mustafa"));

		for (Map.Entry entry : hastaMap.entrySet()) {
			System.out.println(entry.getKey() + " =>" + entry.getValue());
		}

		Set<String> anahtarlar = hastaMap.keySet();
		for (String key : anahtarlar) {
			System.out.println(key + " =>" + hastaMap.get(key));
		}

		for (Hasta hasta : hastaMap.values()) {
			System.out.println(hasta);
		}

		hastaMap.forEach((key, value) -> {
					System.out.println(key + " =>" + value);
				}
		);


		List<String> hastaIsimleri = new ArrayList<>(anahtarlar);
		hastaIsimleri.sort((x, y) -> x.compareTo(y));

		System.out.println(hastaIsimleri);

		for (String isim : hastaIsimleri) {
			System.out.println(isim + " =>" + hastaMap.get(isim));
		}

		hastalar.sort((x, y) -> {
			if (x.getAge() < y.getAge()) {
				return -1;
			} else if (x == y) {
				return 0;
			} else {
				return 1;
			}
		});

		int a;
		Integer b;
		float c;
		Float d;
		double e;
		Double f;


		hastalar.sort((x, y) -> Integer.valueOf(x.getAge()).compareTo(Integer.valueOf(y.getAge())));

		hastalar.forEach(System.out::println);

		double ortalama = average(hastalar);
		System.out.println(ortalama);

		double average = hastalar.parallelStream()
				.filter(h -> h.getGender().equals("M"))
				.filter(h -> !h.getSikayeti().equals("Sigara iciyor"))
				.collect(Collectors.averagingDouble(x -> x.getAge()));
		System.out.println(average);

		List<Integer> yaslar = hastalar.parallelStream()
				.map(h -> h.getAge())
				.filter(x -> x < 70)
				.collect(Collectors.toList());

		yaslar.forEach(System.out::println);

		Optional<Integer> maxOptional = hastalar.parallelStream()
				.map(h -> h.getAge())
				.filter(x -> x < 70)
				.max(Integer::compareTo);


		System.out.println("Max age less 70:" + maxOptional.get());

		Hasta h4 = null;

		//int age = h4.getAge();


		Optional<Integer> yas = Optional.empty();

		yas = Optional.of(33);

		if (yas.isPresent()) {
			System.out.println(yas.get());
		}

		Optional<Integer> seventies = maxBiggerThanSeventy(hastalar);

		if (seventies.isPresent()) {
			System.out.println(seventies.get());

		} else {
			System.out.println("Bulunmadi....");
		}


		List<Integer> ages = new ArrayList<>();

		seventies.ifPresentOrElse(
				(x) -> {
					ages.add(x);
					System.out.println("Age==" + x);
				},
				() -> {
					throw new RuntimeException("Bulunamadi.... Something wrong....");
				}
		);


		List<KnowsHowToPrint> liste = new ArrayList<>();

		KnowsHowToPrint h = new Hasta("Murat", 44, "M", "Temizligi sevmiyor");
		liste.add(h);

		//h.print();

		h = new Employee("Kara murat", 55, "M");
		//h.print();
		liste.add(h);


		yaz(liste);

	}


	public static void yaz(List<KnowsHowToPrint> liste) {
		for (KnowsHowToPrint p : liste) {
			p.print();
		}
	}

	public static Optional<Integer> maxBiggerThanSeventy(List<Hasta> hastalar) {
		return hastalar.parallelStream()
				.map(h -> h.getAge())
				.filter(x -> x >= 70)
				.max(Integer::compareTo);

	}

	public static double average(List<Hasta> hastaList) {
		//int size = hastaList.size();
		int size = 0;
		int toplam = 0;
		for (Hasta h : hastaList) {
			//toplam = toplam +h.getAge();
			if (h.getGender().equals("M")) {
				toplam += h.getAge();
				size++;
			}

		}
		return toplam / (float) size;
	}
}
