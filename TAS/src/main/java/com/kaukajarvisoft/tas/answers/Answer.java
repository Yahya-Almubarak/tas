package com.kaukajarvisoft.tas.answers;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionTypes;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	QuestionTypes type;
	String name;
	String description;
	Locale local;
	
	
	// Answer knows what question it belongs to, but the question has no reference to the Answer
		@OneToOne
		Question question;
}
