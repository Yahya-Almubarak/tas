package com.kaukajarvisoft.tas.questions;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Question {
	/* This class is intended to be stored in question list. The real questions; SingleChoiceQustion, multiChoiceQuestion,  etc
	 * point to it. The purpose is to allow QuestionList to store different type of questions. The OOP solution is normally 
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
}
