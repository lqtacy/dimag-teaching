package com.dimag.index;

public class DocumentFrequency {
	private String id;
	private int frequency;

	public DocumentFrequency(String id, int frequency) {
		this.id = id;
		this.frequency = frequency;
	}

	public String getId() {
		return id;
	}

	public int getFrequency() {
		return frequency;
	}
}
