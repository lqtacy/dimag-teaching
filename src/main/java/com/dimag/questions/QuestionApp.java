package com.dimag.questions;

import com.dimag.questions.common.Answer;
import com.dimag.questions.common.Question;

public class QuestionApp {
	public static void main(String[] args) {

		//Admin sorulari kaydedecek
		QuestionStorage storage = new QuestionStorage();
		QuestionAdmin admin = new QuestionAdmin(storage);
		admin.save(new Question("Who landed on moon first?").addOptions("a) Hemo, b) Memo, c)Remo, d) Heso"), new Answer());
		admin.save(new Question("What is the color bird?"), new Answer());
		admin.save(new Question("what is the name of Kurdish astronaut?"), new Answer());


		//Student
		QuestionPresenter presenter = new QuestionPresenter(storage);
		for (int i = 0; i < 100; i++) {
			presenter.present();
		}

	}
}
