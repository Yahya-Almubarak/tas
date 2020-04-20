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

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.services.MultiChoiceQuestionService;

@RestController
public class MultiChoiceQuestionController {
	
	@Autowired
	MultiChoiceQuestionService multiChoiceQuestionService;
	
	@GetMapping("/multiquestion/{id}")
	public ResponseEntity<MultiChoiceQuestion> getMultiChoiceQuestion(@PathVariable Long id){
		MultiChoiceQuestion question = multiChoiceQuestionService.getMultiChoiceQuestion(id); 
		if(question == null)
			return new ResponseEntity<MultiChoiceQuestion>(question, HttpStatus.NOT_FOUND);
		return new ResponseEntity<MultiChoiceQuestion>(question, HttpStatus.OK);
	}
	
	@GetMapping("/multiquestions/{local}")
	public ResponseEntity<List<MultiChoiceQuestion>> getMultiChoiceQuestions(@PathVariable String local){
		List<MultiChoiceQuestion> questions = multiChoiceQuestionService.getMultiChoiceQuestions(local); 
		if(questions == null)
			return new ResponseEntity<List<MultiChoiceQuestion>>(questions, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<MultiChoiceQuestion>>(questions, HttpStatus.OK);
	}
	
	@GetMapping("/multiquestions")
	public ResponseEntity<List<MultiChoiceQuestion>> getMultiChoiceQuestions(){
		List<MultiChoiceQuestion> questions = multiChoiceQuestionService.getMultiChoiceQuestions(); 
		if(questions == null)
			return new ResponseEntity<List<MultiChoiceQuestion>>(questions, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<MultiChoiceQuestion>>(questions, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/multiquestion")
	  public ResponseEntity<MultiChoiceQuestion> postMultiChoiceQuestion(@RequestBody MultiChoiceQuestion question) {
	    try {
	      MultiChoiceQuestion _question = multiChoiceQuestionService.saveMultiChoiceQuestion(question);
	      return new ResponseEntity<MultiChoiceQuestion>(_question, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }

}
