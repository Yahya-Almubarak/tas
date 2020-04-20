package com.kaukajarvisoft.tas.questions;

import java.time.Duration;
import java.util.Locale;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.users.TasUser;

import lombok.Data;
@Data
@Entity
public class MultiChoiceQuestion implements IQuestion {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long  id;
	QuestionTypes type;
	String name;
	String description;
	Locale local;
	
	Duration timeToPresent;
	Duration timeToAnswer; 
	
	/* Those comments are intended to be presented during test to test taker
	 * They are mapped according to the locale to allow localization */
	String commentOnTime;
	String commentOnQuestion;
	String commentOnAnswering;
	
	String body;
	
	@ElementCollection(targetClass=String.class, fetch=FetchType.EAGER)
	Map<Long, String> choices;
	
	Long numberOfCorrectChoices;
	
	@OneToOne
	Question question;
	
	@OneToOne
	TasUser author;
	
	public MultiChoiceQuestion() {
		super();
		type = QuestionTypes.MULTI_CHOICE;
	}
	

}
