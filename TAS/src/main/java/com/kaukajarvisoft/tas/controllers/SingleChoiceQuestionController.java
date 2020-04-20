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

import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.services.SingleChoiceQuestionService;

@RestController
public class SingleChoiceQuestionController {

	@Autowired
	SingleChoiceQuestionService singleChoiceQuestionService;
	
	@GetMapping("/singlequestion/{id}")
	public ResponseEntity<SingleChoiceQuestion> getSingleChoiceQuestion(@PathVariable Long id){
		SingleChoiceQuestion question = singleChoiceQuestionService.getSingleChoiceQuestion(id); 
		if(question == null)
			return new ResponseEntity<SingleChoiceQuestion>(question, HttpStatus.NOT_FOUND);
		return new ResponseEntity<SingleChoiceQuestion>(question, HttpStatus.OK);
	}
	
	@GetMapping("/singlequestions/{local}")
	public ResponseEntity<List<SingleChoiceQuestion>> getSingleChoiceQuestions(@PathVariable String local){
		List<SingleChoiceQuestion> questions = singleChoiceQuestionService.getSingleChoiceQuestions(local); 
		if(questions == null)
			return new ResponseEntity<List<SingleChoiceQuestion>>(questions, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<SingleChoiceQuestion>>(questions, HttpStatus.OK);
	}
	
	@GetMapping("/singlequestions")
	public ResponseEntity<List<SingleChoiceQuestion>> getSingleChoiceQuestions(){
		List<SingleChoiceQuestion> questions = singleChoiceQuestionService.getSingleChoiceQuestions(); 
		if(questions == null)
			return new ResponseEntity<List<SingleChoiceQuestion>>(questions, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<SingleChoiceQuestion>>(questions, HttpStatus.OK);
	}
	
	@PostMapping("/singlequestion")
	  public ResponseEntity<SingleChoiceQuestion> postSingleChoiceQuestion(@RequestBody SingleChoiceQuestion question) {
	    try {
	      SingleChoiceQuestion _question = singleChoiceQuestionService.saveSingleChoiceQuestion(question);
	      return new ResponseEntity<SingleChoiceQuestion>(_question, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
}
