package com.dimag.index;


import com.dimag.text.TextProcessorException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;


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
			"https://www.tutorialspoint.com/java/java_methods.htm",
			"https://www.karar.com/guncel-haberler/bakan-cavusoglu-letonyaya-gidiyor-1210998"
	);


	private HttpClient httpClient;
	private Indexer indexer;
	private Searcher searcher;


	public DataExtractor() {
		httpClient = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();
		indexer = Indexer.getIndexer();
		searcher = new Searcher(indexer);
	}

	public Indexer getIndexer() {
		return indexer;
	}

	public DataExtractor setIndexer(Indexer indexer) {
		this.indexer = indexer;
		return this;
	}

	public Searcher getSearcher() {
		return searcher;
	}

	public DataExtractor setSearcher(Searcher searcher) {
		this.searcher = searcher;
		return this;
	}

	private void fetchData(String path) throws TextProcessorException {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(path))
				.GET()
				.build();
		/*
		httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenAccept(response -> {
					//indexing
					System.out.println("Response is:" + response);
					try {
						indexer.index(path, (response.body()));
					} catch (TextProcessorException e) {
						e.printStackTrace();
					}
				});
				*/

		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response is:" + response);
			indexer.index(path, (response.body()));
		} catch (Throwable e) {
			e.printStackTrace();
		}


	}


	public static void main(String[] args) throws Exception {
		DataExtractor extractor = new DataExtractor();


		DataExtractor.urls.stream().forEach(url -> {
			try {
				extractor.fetchData(url);
			} catch (TextProcessorException e) {
				e.printStackTrace();
			}
		});


		List<DocumentFrequency> documents = extractor.getSearcher().search("program");

		System.out.println("---------------program-----------------");
		documents.forEach(d->{
			System.out.println(d);

		});

		documents = extractor.getSearcher().search("program statement");

		System.out.println("---------------statement-----------------");
		documents.forEach(d->{
			System.out.println(d);

		});

		documents = extractor.getSearcher().search("is");

		System.out.println("---------------is-----------------");
		documents.forEach(d->{
			System.out.println(d);

		});

		documents = extractor.getSearcher().search("Mevlüt Çavuşoğlu");
		System.out.println("---------------Çavuşoğlu-----------------");
		documents.forEach(d->{
			System.out.println(d);

		});

		System.out.println("Done...");

	}
}
