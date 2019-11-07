package com.dimag.collections;

import java.util.Date;

public interface KnowsHowToPrint {
	void print();

	default void sendAlert(){
		//alarm gonder...
	}
	static void time(){
		System.out.println(new Date());
	}
}
