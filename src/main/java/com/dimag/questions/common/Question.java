package com.dimag.questions.common;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private String question;
	private List<String> options = new ArrayList<>();

	public Question(String question) {
		this.question = question;
	}

	public Question addOptions(String ... options){
		for(String option:options) {
			this.options.add(option);
		}
		return this;
	}

	@Override
	public String toString() {
		return "Question{" +
				"question='" + question + '\'' +
				", options=" + options +
				'}';
	}
}
