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

import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.services.MultiChoiceAnswerService;

@RestController
public class MultiChoiceAnswerController {
	@Autowired
	MultiChoiceAnswerService multiChoiceAnswerService;
	
	@GetMapping("/multianswer/{id}")
	public ResponseEntity<MultiChoiceAnswer> getMultiChoiceAnswer(@PathVariable Long id){
		MultiChoiceAnswer answer = multiChoiceAnswerService.getMultiChoiceAnswer(id); 
		if(answer == null)
			return new ResponseEntity<MultiChoiceAnswer>(answer, HttpStatus.NOT_FOUND);
		return new ResponseEntity<MultiChoiceAnswer>(answer, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/multianswers")
	public ResponseEntity<List<MultiChoiceAnswer>> getMultiChoiceAnswers(){
		List<MultiChoiceAnswer> answers = multiChoiceAnswerService.getMultiChoiceAnswers(); 
		if(answers == null)
			return new ResponseEntity<List<MultiChoiceAnswer>>(answers, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<MultiChoiceAnswer>>(answers, HttpStatus.OK);
	}
	
	@PostMapping("/multianswer")
	  public ResponseEntity<MultiChoiceAnswer> postMultiChoiceAnswer(@RequestBody MultiChoiceAnswer answer) {
	    try {
	      MultiChoiceAnswer _answer = multiChoiceAnswerService.saveMultiChoiceAnswer(answer);
	      return new ResponseEntity<MultiChoiceAnswer>(_answer, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }

}
