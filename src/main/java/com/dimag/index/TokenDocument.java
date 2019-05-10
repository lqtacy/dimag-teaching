package com.dimag.index;

import java.util.List;

public class TokenDocument {
	private String token;


	private List<DocumentFrequency> documents;

	public TokenDocument(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public TokenDocument setToken(String token) {
		this.token = token;
		return this;
	}

	public List<DocumentFrequency> getDocuments() {
		return documents;
	}

	public TokenDocument setDocuments(List<DocumentFrequency> documents) {
		this.documents = documents;
		return this;
	}
	public TokenDocument addDocument(DocumentFrequency document){
		this.documents.add(document);
		return this;
	}
}
