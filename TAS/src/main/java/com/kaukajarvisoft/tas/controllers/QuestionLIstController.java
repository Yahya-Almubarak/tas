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

import com.kaukajarvisoft.tas.questionlist.QuestionList;
import com.kaukajarvisoft.tas.questionlist.QuestionLists;
import com.kaukajarvisoft.tas.services.QuestionListService;

@RestController
public class QuestionLIstController {
	@Autowired
	QuestionListService questionListService;
	
	@GetMapping("/questionlist/{id}")
	public ResponseEntity<QuestionList> getQuestionList(@PathVariable Long id) {
		QuestionList questionList = questionListService.getQuestionList(id);
		if(questionList == null) 
			return new ResponseEntity<QuestionList>(questionList, HttpStatus.NOT_FOUND);
		return new ResponseEntity<QuestionList>(questionList, HttpStatus.OK);
	}
	
	@GetMapping("/questionlists")
	public ResponseEntity<QuestionLists> getQuestionList() {
		QuestionLists questionLists = questionListService.getQuestionLists();
		if(questionLists == null) 
			return new ResponseEntity<QuestionLists>(questionLists, HttpStatus.NOT_FOUND);
		return new ResponseEntity<QuestionLists>(questionLists, HttpStatus.OK);
	}
	
	@GetMapping("/questionlistsreturndefault")
	public ResponseEntity<QuestionLists> getQuestionListReturnDefault() {
		QuestionLists questionLists = questionListService.getQuestionListsReturnDefault();
		if(questionLists == null) 
			return new ResponseEntity<QuestionLists>(questionLists, HttpStatus.NOT_FOUND);
		return new ResponseEntity<QuestionLists>(questionLists, HttpStatus.OK);
	}
	
	@PostMapping("/createlist")
	public ResponseEntity<QuestionList> postQuestionList(@RequestBody QuestionList questionList) {
		try {
			QuestionList _questionList = questionListService.createList(questionList);
			return new ResponseEntity<QuestionList>(_questionList, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
	

