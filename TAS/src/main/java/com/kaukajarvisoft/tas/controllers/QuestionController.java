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
import com.kaukajarvisoft.tas.services.MultiChoiceQuestionService;
import com.kaukajarvisoft.tas.services.QuestionService;


@RestController
public class QuestionController {
	
	@Autowired
	QuestionService QuestionService;
	
	@GetMapping("/question/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable Long id){
		try {
			Question question = QuestionService.getQuestion(id); 
			if(question == null)
				return new ResponseEntity<Question>(question, HttpStatus.NOT_FOUND);
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	
	@GetMapping("/questions")
	public ResponseEntity<List<Question>> getQuestions(){
		List<Question> questions = QuestionService.getQuestions(); 
		if(questions == null)
			return new ResponseEntity<List<Question>>(questions, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
	
	
	@PostMapping("/question")
	  public ResponseEntity<Question> postQuestion(@RequestBody Question question) {
	    try {
	      Question _question = QuestionService.saveQuestion(question);
	      return new ResponseEntity<Question>(_question, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
}
