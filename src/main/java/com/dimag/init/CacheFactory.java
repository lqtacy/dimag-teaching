package com.dimag.init;

/** Singleton Object pattern: desen/oruntu/nakis/ **/
public class CacheFactory {
	private static  CacheFactory factory;

	private int x;
	private int y;

	private CacheFactory() {
		this(false);
	}

	private CacheFactory(boolean isFifo) {

	}


	public static CacheFactory newInstance(boolean isFifo){
		if(factory == null){
			factory = new CacheFactory();
		}
		return factory;
	}

	public int getX() {
		return x;
	}

	public CacheFactory setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public CacheFactory setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public String toString() {
		return "CacheFactory{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
