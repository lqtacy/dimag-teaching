package com.dimag.init;

/** Singleton Object **/
public class CacheFactory {
	private static  CacheFactory factory;

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
}
