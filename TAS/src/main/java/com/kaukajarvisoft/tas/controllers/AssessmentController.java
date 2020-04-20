package com.kaukajarvisoft.tas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaukajarvisoft.tas.assesment.AssessmentHandler;
import com.kaukajarvisoft.tas.tests.Grade;
import com.kaukajarvisoft.tas.tests.TestResponse;

@RestController
public class AssessmentController {
	
	@Autowired
	AssessmentHandler assessmentService;
	
	@PostMapping("/assess") 
	ResponseEntity<Grade> getGrade(@RequestBody TestResponse testResponse) {
		try {
			Grade grade = assessmentService.grade(testResponse);
			return new ResponseEntity<Grade>(grade, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
			
	}
	
	

}
