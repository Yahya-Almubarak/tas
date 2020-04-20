package com.kaukajarvisoft.tas.tests;

import java.util.Locale;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.questions.QuestionList;
import com.kaukajarvisoft.tas.users.TasUser;

import lombok.Data;


@Data
@Entity
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String name;
	String description;
	Locale local;
	
	@OneToOne
	TasUser author;
	
	@OneToOne
	QuestionList questionList;
	
	@Embedded
	GradeCriteria gradeCriteria;
}
