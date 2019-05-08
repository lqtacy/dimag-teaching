package com.dimag.index;

import com.dimag.text.TextProcessorException;
import com.dimag.text.TextTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class DocumentFrequency {
	private String id;
	private int frequency;
}

class TokenDocument {
	private String token;
	private List<DocumentFrequency> documents;


}

/**
 * Singleton
 **/
public class Indexer {
	private static Indexer indexer = null;
	private HtmlRemover htmlRemover = new HtmlRemover();
	private TextTool textTool = new TextTool();

	//expensive
	private List<TokenDocument> index = new ArrayList<>();

	//natural: access to map is fast.
	private Map<String, List<DocumentFrequency>> index2 = new HashMap<>();

	/*
	token1: D1:4, D2:5
	token2: D1:1, D2:3, D3:1
	 */
	private Indexer() {

	}

	public static Indexer getIndexer() {
		if (indexer != null) {
			return indexer;
		} else {
			return new Indexer();
		}

	}

	public void index(String content) throws TextProcessorException {
		String text = htmlRemover.removeHtml(content);
		Map<String, Integer> frequencies = textTool.analyzeText(text);
		System.out.println();
		//indexing operation done here.
	}
}
