package com.kaukajarvisoft.tas.answers;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionTypes;

import lombok.Data;

@Data
@Entity
public class Answer {
	/* This class is intended to be stored in answer list. The real answers; SingleChoiceAnswer, multiChoiceAnswer,  etc
	 * point to it. The purpose is to allow AnswerList to store different type of answers. The OOP solution is normally 
	 * make this class as a super class for others but for complexity or lack of knowledge how to do it in
	 * JPA, this approach is followed.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	QuestionTypes type;
	String name;
	String description;
	Locale local;
	
	
	// Answer knows what question it belongs to, but the question has no reference to the Answer
	@ManyToOne
	Question question;

}
