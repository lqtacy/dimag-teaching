package com.dimag.questions;

import com.dimag.questions.common.Answer;
import com.dimag.questions.common.Question;

public class QuestionAdmin {
	private QuestionStorage storage;

	public QuestionAdmin(QuestionStorage storage) {
		this.storage = storage;
	}

	public void save(Question question, Answer answer) {
		storage.save(question, answer);
	}
}
