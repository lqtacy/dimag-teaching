package com.dimag.init;

public class Cache {
	private int size = 10;

	public Cache(int size) {
		this.size = size;
	}

	public Cache() {
		System.out.println("no param....");
	}

	public int getSize() {
		return size;
	}

	public Cache setSize(int size) {
		this.size = size;
		return this;
	}
}
