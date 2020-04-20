package com.kaukajarvisoft.tas.tests;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.questions.QuestionTypes;
import com.kaukajarvisoft.tas.users.TasUser;

import lombok.Data;

@Data
@Entity
public class TestResponse {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String name;
	String description;
	Locale local;
	
	@OneToOne
	TasUser user;

	
	
	Long  testId;
	
	@OneToOne
	AnswerList answerList;

}
