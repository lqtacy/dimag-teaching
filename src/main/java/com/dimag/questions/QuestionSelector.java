package com.dimag.questions;

import com.dimag.questions.common.Question;

import java.util.List;
import java.util.Random;

public class QuestionSelector {
	private QuestionStorage storage;

	public QuestionSelector(QuestionStorage storage) {
		this.storage = storage;
	}

	public Question select() {
		List<Question> questions = storage.getQuestions();
		Random r = new Random();
		int index = r.nextInt(questions.size());
		return questions.get(index);
	}
}
