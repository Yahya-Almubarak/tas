package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questionlist.QuestionList;
import com.kaukajarvisoft.tas.repositories.TestRepository;
import com.kaukajarvisoft.tas.tests.GradeCriteria;
import com.kaukajarvisoft.tas.tests.Test;
import com.kaukajarvisoft.tas.tests.Tests;

@Service
public class TestService {
	@Autowired
	private TestRepository testRepository;
	@Autowired
	private QuestionListService questionListService;
	
	public Test createTest(Test test) {
		return testRepository.save(test);
	}
	
	public Test getTest(Long id) {
		return testRepository.findById(id).get();
	}
	
	public Tests   getTests() {
		Tests tests = new Tests();
		List<Test> listOfTests =  testRepository.findAll();
		tests.setTests(listOfTests);
		return tests;
	}
	
	public void removeTest(Test test) {
		Test _test = this.getTest(test.getId());
		testRepository.delete(_test);
	}
	
	public Test saveTest(Test test) {
		return testRepository.save(test);
	}
	
	public Test addQuestionList(Test test, QuestionList questionList) {
		Test _test = this.getTest(test.getId());
		QuestionList _questionList = questionListService.getQuestionList(questionList.getId());
		_test.setQuestionList(_questionList);
		return testRepository.save(_test);
	}
	
	public Test addGradeCriteria(Test test, GradeCriteria gradeCriteria) {
		Test _test = this.getTest(test.getId());
		_test.setGradeCriteria(gradeCriteria);
		return testRepository.save(_test);
	}
	

}
