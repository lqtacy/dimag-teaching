package com.dimag.timer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

class TimeEvent {
	private String name;
	private long startTime;

	public TimeEvent(String name) {
		this.name = name;
		this.startTime = System.nanoTime();
	}

	public String getName() {
		return name;
	}

	public TimeEvent setName(String name) {
		this.name = name;
		return this;
	}

	public long getStartTime() {
		return startTime;
	}

	public TimeEvent setStartTime(long startTime) {
		this.startTime = startTime;
		return this;
	}
}


class TimerFunction {
	private Deque<TimeEvent> eventStack = new ArrayDeque<>();

	public void start(String name) {
		TimeEvent event = new TimeEvent(name);
		eventStack.push(event);
	}

	public void time() {
		TimeEvent e = eventStack.poll();
		System.out.println(e.getName() + " took " + ((System.nanoTime() - e.getStartTime())/1000000000.0)+" seconds");
	}

}

public class Timer {

	public static void f() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void g() {
		try {
			TimeUnit.MILLISECONDS.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TimerFunction t = new TimerFunction();
		t.start("All");

		t.start("F");
		f();
		t.time();

		t.start("G");
		g();
		t.time();
		t.time();

	}
}
