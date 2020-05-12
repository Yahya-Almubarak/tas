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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionTypes;

import lombok.Data;

@Data
@Entity
public class MultiChoiceAnswer  extends Answer{

	@ElementCollection(targetClass=Long.class, fetch=FetchType.LAZY)
	List<Long> choices;
	
	String commentOnAnswer;
	
	@ElementCollection(targetClass=String.class)
	List<String> commentOnChoices;
	
	@ManyToOne
	Question question;
	
		
}
