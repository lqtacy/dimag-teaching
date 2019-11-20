package com.dimag.collections;

import java.util.UUID;

public class Music {
	private UUID id;
	private String singer;
	private int length;
	private String title;
	private String genre;
	private String location;

	public Music(String singer, int length, String title, String genre, String location) {
		this.singer = singer;
		this.length = length;
		this.title = title;
		this.genre = genre;
		this.location = location;
		this.id = UUID.randomUUID();
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public UUID getId() {
		return id;
	}
}
