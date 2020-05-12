package com.kaukajarvisoft.tas.questionlist;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.kaukajarvisoft.tas.questions.Question;

import lombok.Data;

@Data
@Entity
public class QuestionList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	String description;
	Locale local;
	
	LocalDateTime creationTime;
	LocalDateTime lastModificationTime;
	
	
	@OneToMany(fetch=FetchType.EAGER)
	List<Question> questions;
}
