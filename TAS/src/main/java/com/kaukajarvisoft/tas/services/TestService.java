package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questions.QuestionList;
import com.kaukajarvisoft.tas.repositories.TestRepository;
import com.kaukajarvisoft.tas.tests.GradeCriteria;
import com.kaukajarvisoft.tas.tests.Test;

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
	
	public List<Test> getTests() {
		return testRepository.findAll();
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
