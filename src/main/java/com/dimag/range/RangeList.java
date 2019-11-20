package com.dimag.range;

class Range{
	private int start;
	private int end;

	public Range(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public Range setStart(int start) {
		this.start = start;
		return this;
	}

	public int getEnd() {
		return end;
	}

	public Range setEnd(int end) {
		this.end = end;
		return this;
	}
}

/**
 * This object should have a list of ranges: [{1,3}, {4, 7}, {2, 3}, {8, 10}, {11, 20}]

 [{1,3}, {2, 3}, {4, 7},  {8, 10}, {11, 20}]

 *[{1, 9}, {12, 15}]
 * [
 */
public class RangeList {

	//add a range to list
	public void add(int start, int end){

	}
	private void sortAndCollapse(){

	}
}


