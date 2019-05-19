package com.dimag.index;

import java.util.*;

public class Searcher {
	private Indexer indexer;

	public Searcher(Indexer indexer) {
		this.indexer = indexer;
	}

	public List<DocumentFrequency> search(String query) {
		String q = query.toLowerCase();

		List<DocumentFrequency> documentFrequencyList = new ArrayList<>();
		Arrays.stream(q.split(" ")).forEach(w -> {
			List<DocumentFrequency> documents = indexer.getIndex().get(w);
			if (documents != null) {
				documentFrequencyList.addAll(documents);
			}
		});

		Map<String, DocumentFrequency> finalDocuments = new HashMap<>();

		documentFrequencyList.forEach(d -> {
			if (finalDocuments.containsKey(d.getId())) {
				DocumentFrequency documentFrequency = finalDocuments.get(d.getId());
				finalDocuments.put(d.getId(), new DocumentFrequency(d.getId(), documentFrequency.getFrequency() + d.getFrequency()));
			} else {
				finalDocuments.put(d.getId(), d);
			}

		});

		List<DocumentFrequency> results = new ArrayList<>(finalDocuments.values());
		results.sort((a, b) -> a.getFrequency() > b.getFrequency() ? -1 : 1);
		return results;
	}
}
