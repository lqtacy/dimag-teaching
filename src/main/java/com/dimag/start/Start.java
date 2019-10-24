package com.dimag.start;


//encapsulation: ihata etmek

//private only class can use it
//protected only class and its child object
//none (hic birsey yoksa): package-protected : classes within the package.
//TODO:
// 1) interfaces
// 2) Data collection
// 3) more methods
// 4) inheritance
class Starter {
	//class variable
	public final static String NAME="BASLANGIC";
	//instance variables
	protected String startTime = null;
	private int duration;
	private float ratio;
	private double ratioInDouble;


	public Starter() {
	}

	public Starter(String startTime, int duration, float ratio, double ratioInDouble) {
		this.startTime = startTime;
		this.duration = duration;
		this.ratio = ratio;
		this.ratioInDouble = ratioInDouble;
	}

	public String getStartTime() {
		return startTime;
	}

	public Starter setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	public int getDuration() {
		return duration;
	}

	public Starter setDuration(int duration) {
		this.duration = duration;
		return this;
	}

	public float getRatio() {
		return ratio;
	}

	public Starter setRatio(float ratio) {
		this.ratio = ratio;
		return this;
	}

	public double getRatioInDouble() {
		return ratioInDouble;
	}

	public Starter setRatioInDouble(double ratioInDouble) {
		this.ratioInDouble = ratioInDouble;
		return this;
	}



}


public class Start {
	public Start() {
	}


	public static void main(String[] args) {
		System.out.println("Merhaba AI...");
		//create instance
		var s = new Starter("Haziaran 10", 1, 0.4f, 0.4);

		System.out.println("Start time:" + s.getStartTime() + " ratio:" + s.getRatio());

		var s2 = new Starter()
				.setStartTime("Haziran 22")
				.setDuration(3);

s2.startTime = "subat";
		System.out.println("Start time:" + s2.getStartTime() + " ratio:" + s.getRatio());


		s2.setStartTime("Agustos 11");

		System.out.println("Start time:" + s2.getStartTime() + " ratio:" + s.getRatio());

		System.out.println("S2 NAME="+Starter.NAME);
		System.out.println("S1 NAME="+Starter.NAME);





	}
}
