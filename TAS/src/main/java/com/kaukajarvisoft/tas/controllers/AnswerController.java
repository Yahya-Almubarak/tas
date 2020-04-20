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

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.services.AnswerService;
import com.kaukajarvisoft.tas.services.CorrectMultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.CorrectSingleChoiceAnswerService;

@RestController
public class AnswerController {

	@Autowired
	AnswerService  answerService;
	
	
	
	
	@GetMapping("/answer/{id}")
	public ResponseEntity<Answer> getAnswer(@PathVariable Long id){
		Answer answer = answerService.getAnswer(id); 
		if(answer == null)
			return new ResponseEntity<Answer>(answer, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}
	
	
	@GetMapping("/answers")
	public ResponseEntity<List<Answer>> getAnswers(){
		List<Answer> answers = answerService.getAnswers(); 
		if(answers == null)
			return new ResponseEntity<List<Answer>>(answers, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
	}
	
	@PostMapping("/answer")
	  public ResponseEntity<Answer> postAnswer(@RequestBody Answer answer) {
	    try {
	      Answer _answer = answerService.saveAnswer(answer);
	      return new ResponseEntity<>(_answer, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	


}
