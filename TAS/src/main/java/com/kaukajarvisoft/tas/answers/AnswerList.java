package com.kaukajarvisoft.tas.answers;

import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class AnswerList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	String description;
	Locale local;
	
	@OneToMany(targetEntity=Answer.class, fetch=FetchType.LAZY)
	List<Answer> answers;
}
