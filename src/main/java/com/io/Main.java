package com.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Path p = Paths.get("./test.txt");
		System.out.println(p.toUri().toString());

		try {
			List<String> lines = Files.readAllLines(p);
			lines.forEach(System.out::println);

			Files.write(Paths.get("./test3.txt"), lines);


			Files.copy(p, Paths.get("./test4.txt"));

			if (Files.exists(p)) {
				System.out.println("File found...");
			}

			if (Files.isDirectory(Paths.get("/Users/htosun"))) {
				System.out.println("File is directory...");
			} else {
				System.out.println("File is not directory...");

			}

			Files.list(Paths.get(".")).forEach(System.out::println);

			Files.lines(Paths.get("./settings.gradle")).forEach(System.out::println);





		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("hata olustu....");
		}
	}
}
