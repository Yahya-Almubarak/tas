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

import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionList;
import com.kaukajarvisoft.tas.services.TestService;
import com.kaukajarvisoft.tas.tests.Test;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/test/{id}")
	public ResponseEntity<Test> getTest(@PathVariable Long id){
		try {
			Test test = testService.getTest(id); 
			if(test == null)
				return new ResponseEntity<Test>(test, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Test>(test, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	
	@GetMapping("/tests")
	public ResponseEntity<List<Test>> getTests(){
		List<Test> tests = testService.getTests(); 
		if(tests == null)
			return new ResponseEntity<List<Test>>(tests, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Test>>(tests, HttpStatus.OK);
	}
	
	
	@PostMapping("/test")
	public ResponseEntity<Test> postTest(@RequestBody Test test) {
	    try {
	      Test _test = testService.saveTest(test);
	      return new ResponseEntity<Test>(_test, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	}
	
	@PostMapping("/test/addquestionlist/{testId}")
	public ResponseEntity<Test> addQuestionList(@RequestBody QuestionList questionList, @PathVariable Long testId) {
	    try {
	      Test _test = testService.getTest(testId);
	      _test =  testService.addQuestionList(_test, questionList);
	      _test = testService.saveTest(_test);
	      return new ResponseEntity<Test>(_test, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	}

}
