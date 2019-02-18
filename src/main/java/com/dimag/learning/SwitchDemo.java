package com.dimag.learning;


enum MONTH {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}

enum SEASON{
	WINTER, SPRING, SUMMER, FALL;
}

public class SwitchDemo {
	public static void main(String[] args) throws Exception{
		//System.out.println(getMonth(10));
		System.out.println(getSeason(MONTH.AUGUST));
		System.out.println(getSeason(MONTH.SEPTEMBER));
		System.out.println(MONTH.SEPTEMBER.ordinal());


	}


	public static String getMonth(int month) {
		String monthString;
		switch (month) {
			case 1:
				monthString = "January";
				break;
			case 2:
				monthString = "February";
				break;
			case 3:
				monthString = "March";
				break;
			case 4:
				monthString = "April";
				break;
			case 5:
				monthString = "May";
				break;
			case 6:
				monthString = "June";
				break;
			case 7:
				monthString = "July";
				break;
			case 8:
				monthString = "August";
				break;
			case 9:
				monthString = "September";
				break;
			case 10:
				monthString = "October";
				break;
			case 11:
				monthString = "November";
				break;
			case 12:
				monthString = "December";
				break;
			default:
				monthString = "Invalid month";
				break;
		}
		return monthString;
	}

	public static SEASON getSeason(MONTH month) throws Exception {
		SEASON monthString;
		switch (month) {
			case JANUARY:
			case FEBRUARY:
			case MARCH:
				monthString = SEASON.WINTER;
				break;
			case APRIL:
			case MAY:
			case JUNE:
				monthString = SEASON.SPRING;
				break;
			case JULY:
			case AUGUST:
			case SEPTEMBER:
				monthString = SEASON.SUMMER;
				break;
			case OCTOBER:
			case NOVEMBER:
			case DECEMBER:
				monthString = SEASON.FALL;
				break;
			default:
				throw new Exception("Wrong data");


		}
		return monthString;
	}
}
