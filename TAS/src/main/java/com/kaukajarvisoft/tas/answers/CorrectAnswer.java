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
public class CorrectAnswer {
	// different container class is used to correct answers so that the will have thier own table and not mixed with  students answers
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
