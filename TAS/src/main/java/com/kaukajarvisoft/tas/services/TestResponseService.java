package com.kaukajarvisoft.tas.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.questions.QuestionTypes;
import com.kaukajarvisoft.tas.repositories.AnswerRepository;
import com.kaukajarvisoft.tas.repositories.MultiChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.TestRepository;
import com.kaukajarvisoft.tas.repositories.TestResponseRepository;
import com.kaukajarvisoft.tas.tests.Test;
import com.kaukajarvisoft.tas.tests.TestResponse;
import com.kaukajarvisoft.tas.tests.TestResponses;

@Service
@Transactional
public class TestResponseService {
	
	@Autowired
	TestResponseRepository testResponseRepository;
	@Autowired
	MultiChoiceAnswerRepository multiChoiceAnswerRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	TestRepository testRepository;
	@Autowired
	TestService testService;
	
	public TestResponse takeATest(Long testId) {
		Test test = testService.getTest(testId);
		TestResponse testResponse = new TestResponse();
		List<Answer> answers = new ArrayList<>();
		
		test.getQuestionList().getQuestions().forEach(question -> {
			if(question.getType() == QuestionTypes.MULTI_SELECT_MULTI_CHOICE
					|| question.getType() == QuestionTypes.SINGLE_SELECT_MULTI_CHOICE) {
					MultiChoiceAnswer multiChoiceAnswer;
					multiChoiceAnswer = new MultiChoiceAnswer();
					multiChoiceAnswer.setQuestion(question);
					multiChoiceAnswer.setChoices(new ArrayList<>());
					multiChoiceAnswer = multiChoiceAnswerRepository.save(multiChoiceAnswer);
					answers.add(multiChoiceAnswer);
			}
		});
		testResponse.setAnswers(answers);
		return testResponseRepository.save(testResponse);
	}
	
	
	public TestResponse getTestResponse(Long id) {
		return testResponseRepository.findById(id).get();
	}
	
	@Transactional
	public TestResponses getTestResponses() {
		TestResponses testResponses = new TestResponses();
		List<TestResponse> listOfTestResponses = testResponseRepository.findAll();
		testResponses.setTestResponses(listOfTestResponses);
		return testResponses;
	}
	
	@Transactional
	public TestResponse saveTestResponse(TestResponse testResponse) {
		return testResponseRepository.save(testResponse);
	}
	

}
