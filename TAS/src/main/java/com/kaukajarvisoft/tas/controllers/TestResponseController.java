package com.kaukajarvisoft.tas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.services.TestResponseService;
import com.kaukajarvisoft.tas.tests.TestResponse;
import com.kaukajarvisoft.tas.tests.TestResponses;

@RestController
public class TestResponseController {
	
	@Autowired
	TestResponseService testResponseService;
	
	@GetMapping("/testresponse/{id}")
	public ResponseEntity<TestResponse> getTestResponse(@PathVariable Long id){
		try {
			TestResponse testResponse = testResponseService.getTestResponse(id); 
			if(testResponse == null)
				return new ResponseEntity<TestResponse>(testResponse, HttpStatus.NOT_FOUND);
			return new ResponseEntity<TestResponse>(testResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	
	@GetMapping("/testresponses")
	public ResponseEntity<TestResponses> getTestResponses(){
		TestResponses testResponses = testResponseService.getTestResponses(); 
		if(testResponses == null)
			return new ResponseEntity<TestResponses>(testResponses, HttpStatus.NOT_FOUND);
		return new ResponseEntity<TestResponses>(testResponses, HttpStatus.OK);
	}
	
	@GetMapping("/taketest/{testId}")
	public ResponseEntity<TestResponse> takeATest(@PathVariable Long testId){
		try {
			TestResponse testResponse = testResponseService.takeATest(testId);
			if(testResponse == null)
				return new ResponseEntity<TestResponse>(testResponse, HttpStatus.NOT_FOUND);
			return new ResponseEntity<TestResponse>(testResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	
	@PostMapping("/testresponse")
	public ResponseEntity<TestResponse> postTestResponse(@RequestBody TestResponse testResponse) {
	    try {
	      TestResponse _testResponse = testResponseService.saveTestResponse(testResponse);
	      return new ResponseEntity<TestResponse>(_testResponse, HttpStatus.CREATED);
	    } catch (Exception e) {
	    	System.out.println("ERROR: " + e.getMessage());
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	}
	
	
}
