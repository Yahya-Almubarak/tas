package com.kaukajarvisoft.tas.questions;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.answers.Answer;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	QuestionTypes type;
	String name;
	String description;
	Locale local;
	
}
