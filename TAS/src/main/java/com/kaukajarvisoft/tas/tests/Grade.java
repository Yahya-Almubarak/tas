package com.kaukajarvisoft.tas.tests;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.users.TasUser;

import lombok.Data;

@Data
@Entity
public class Grade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@OneToOne
	TasUser tasUser;
	
	@OneToOne
	TestResponse testResponse;
	
	Long totalPoints;
	Long acquiredPoints;
	
	@ElementCollection(targetClass=CorrectFalseList.class)
	List<CorrectFalseList> correctFalseMap;
	

}
