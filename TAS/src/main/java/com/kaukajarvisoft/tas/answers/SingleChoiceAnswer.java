package com.kaukajarvisoft.tas.answers;

import java.util.Locale;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.questions.QuestionTypes;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;

import lombok.Data;

@Data
@Entity
public class SingleChoiceAnswer {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long  id;
	
	String name;
	Locale local;
	String description;
	QuestionTypes type;
	Long choice;
	
	String commentOnAnswer;
	@ElementCollection(targetClass=String.class)
	Map<Long, String> commentOnChoices;
	
	@OneToOne
	Answer answer;
	
	public SingleChoiceAnswer() {
		super();
		type = QuestionTypes.SINGLE_CHOICE;
	}

}
