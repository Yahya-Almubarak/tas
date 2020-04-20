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
import com.kaukajarvisoft.tas.services.TestResponseService;
import com.kaukajarvisoft.tas.tests.TestResponse;

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
	public ResponseEntity<List<TestResponse>> getTestResponses(){
		List<TestResponse> testResponses = testResponseService.getTestResponses(); 
		if(testResponses == null)
			return new ResponseEntity<List<TestResponse>>(testResponses, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<TestResponse>>(testResponses, HttpStatus.OK);
	}
	
	
	@PostMapping("/testresponse")
	public ResponseEntity<TestResponse> postTestResponse(@RequestBody TestResponse testResponse) {
	    try {
	      TestResponse _testResponse = testResponseService.saveTestResponse(testResponse);
	      return new ResponseEntity<TestResponse>(_testResponse, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	}
	
	@PostMapping("/testresponse/addanswerlist/{testResponseId}")
	public ResponseEntity<TestResponse> addAnswerList(@RequestBody AnswerList answerList, @PathVariable Long testResponseId) {
	    try {
	      TestResponse _testResponse = testResponseService.getTestResponse(testResponseId);
	      _testResponse =  testResponseService.addAnswerList(_testResponse, answerList);
	      _testResponse = testResponseService.saveTestResponse(_testResponse);
	      return new ResponseEntity<TestResponse>(_testResponse, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	}
	
}
