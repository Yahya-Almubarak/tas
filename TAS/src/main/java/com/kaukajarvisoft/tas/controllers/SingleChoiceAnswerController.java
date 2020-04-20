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

import com.kaukajarvisoft.tas.answers.SingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.services.SingleChoiceAnswerService;

@RestController
public class SingleChoiceAnswerController {
	@Autowired
	SingleChoiceAnswerService singleChoiceAnswerService;
	
	@GetMapping("/singleanswer/{id}")
	public ResponseEntity<SingleChoiceAnswer> getSingleChoiceAnswer(@PathVariable Long id){
		SingleChoiceAnswer answer = singleChoiceAnswerService.getSingleChoiceAnswer(id); 
		if(answer == null)
			return new ResponseEntity<SingleChoiceAnswer>(answer, HttpStatus.NOT_FOUND);
		return new ResponseEntity<SingleChoiceAnswer>(answer, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/singleanswers")
	public ResponseEntity<List<SingleChoiceAnswer>> getSingleChoiceAnswers(){
		List<SingleChoiceAnswer> answers = singleChoiceAnswerService.getSingleChoiceAnswers(); 
		if(answers == null)
			return new ResponseEntity<List<SingleChoiceAnswer>>(answers, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<SingleChoiceAnswer>>(answers, HttpStatus.OK);
	}
	
	@PostMapping("/singleanswer")
	  public ResponseEntity<SingleChoiceAnswer> postSingleChoiceAnswer(@RequestBody SingleChoiceAnswer answer) {
	    try {
	      SingleChoiceAnswer _answer = singleChoiceAnswerService.saveSingleChoiceAnswer(answer);
	      return new ResponseEntity<SingleChoiceAnswer>(_answer, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }

}
