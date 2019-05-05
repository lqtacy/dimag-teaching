package com.dimag.parallel;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.stream.Collectors.toList;


class HttpFailedException extends Exception {

	public HttpFailedException() {
		super();
	}

	public HttpFailedException(String message) {
		super(message);
	}

	public HttpFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpFailedException(Throwable cause) {
		super(cause);
	}

	protected HttpFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

public class DataExtractor {
	public static List<String> urls = Arrays.asList(
			"https://www.tutorialspoint.com/java/java_loop_control.htm",
			"https://www.tutorialspoint.com/java/java_numbers.htm",
			"https://www.tutorialspoint.com/java/java_constructors.htm",
			"https://www.tutorialspoint.com/java/java_numbers.htm",
			"https://www.tutorialspoint.com/java/java_methods.htm"
	);


	private String fetchData(String path) {
		StringBuffer content = null;
		try {
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			System.out.println("Content: " + content);
		} catch (Throwable e) {
			//
		}
		return content.toString();

	}


	public static void main(String[] args) throws HttpFailedException, ExecutionException, InterruptedException {
		DataExtractor extractor = new DataExtractor();


		List<CompletableFuture<String>> result = DataExtractor.urls.stream()
				.map(url -> CompletableFuture.supplyAsync(() -> extractor.fetchData(url)))
				.collect(toList());


		result.stream().forEach(f->{
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});


	}
}
