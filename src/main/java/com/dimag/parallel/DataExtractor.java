package com.dimag.parallel;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


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


	private HttpClient httpClient;

	public DataExtractor() {
		httpClient = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();
	}

	private void fetchData(String path) {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(path))
				.GET()
				.build();
		httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenAccept(response -> {

					//indexing
					System.out.println("Response is:" + response);


				});


	}


	public static void main(String[] args) throws HttpFailedException, ExecutionException, InterruptedException {
		DataExtractor extractor = new DataExtractor();


		DataExtractor.urls.stream().forEach(url -> extractor.fetchData(url));


	}
}
