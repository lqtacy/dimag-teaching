package com.dimag.index;

import com.dimag.text.TextProcessorException;
import com.dimag.text.TextTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Singleton
 **/
public class Indexer {
	private static Indexer indexer = null;
	private HtmlRemover htmlRemover = new HtmlRemover();
	private TextTool textTool = new TextTool();


/*
	cat: [D1:4, D2:5]
	fox: [D1:1, D2:3, D3:1]
	 */
	private Map<String, List<DocumentFrequency>> index = new HashMap<>();


	private Indexer() {

	}

	public static Indexer getIndexer() {
		if (indexer != null) {
			return indexer;
		} else {
			return new Indexer();
		}

	}

	public void index(String path, String content) throws TextProcessorException {
		String text = htmlRemover.removeHtml(content);
		Map<String, Integer> frequencies = textTool.analyzeText(text);
		frequencies.keySet().stream().forEach(word->{
			if(index.containsKey(word)){
				List<DocumentFrequency> documentList = index.get(word);
				if(documentList== null || documentList.isEmpty()){
					documentList = new ArrayList<>();
				}
				documentList.add(new DocumentFrequency(path, frequencies.get(word)));
			}else{
				List<DocumentFrequency>  documentList = new ArrayList<>();
				documentList.add(new DocumentFrequency(path, frequencies.get(word)));
				index.put(word, documentList);
			}

		});
		System.out.println();
	}

	public Map<String, List<DocumentFrequency>> getIndex() {
		return index;
	}
}
