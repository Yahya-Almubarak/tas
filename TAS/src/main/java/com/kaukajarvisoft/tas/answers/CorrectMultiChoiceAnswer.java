package com.kaukajarvisoft.tas.answers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.QuestionTypes;
import lombok.Data;

@Data
@Entity
public class CorrectMultiChoiceAnswer{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long  id;

	String name;
	Locale local;
	String description;
	QuestionTypes type;
	Long numberOfCorrectChoices;
	
	@ElementCollection(targetClass=Long.class, fetch=FetchType.EAGER)
	List<Long> choices;
	

	String commentOnAnswer;
	@ElementCollection(targetClass=String.class)
	Map<Long, String> commentOnChoices;
	
	
	
	@OneToOne
	CorrectAnswer correctAnswer;
	
	public CorrectMultiChoiceAnswer() {
		super();
		type = QuestionTypes.MULTI_CHOICE;
	}
	
	

}
