package com.kaukajarvisoft.tas.tests;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CorrectFalseList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@ElementCollection(targetClass=Long.class)
	List<Long> correctFalseList;

}
