package com.dimag.questions;

import com.dimag.questions.common.Answer;
import com.dimag.questions.common.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionStorage {
	private List<Question> questions = new ArrayList<>();
	private List<Answer> answers = new ArrayList<>();

	public void save(Question question, Answer answer) {
		this.answers.add(answer);
		this.questions.add(question);
	}

	public List<Question> getQuestions() {
		return questions;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


}
