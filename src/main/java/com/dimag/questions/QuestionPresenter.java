package com.dimag.questions;

import com.dimag.questions.common.Question;

public class QuestionPresenter {
	private QuestionSelector selector;

	public QuestionPresenter(QuestionStorage storage) {
		this.selector = new QuestionSelector(storage);
	}

	public void present(){
		Question q = selector.select();
		System.out.println(q);
	}
}
