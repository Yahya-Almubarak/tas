package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.repositories.TestResponseRepository;
import com.kaukajarvisoft.tas.tests.TestResponse;

@Service
public class TestResponseService {
	
	@Autowired
	TestResponseRepository testResponseRepository;
	
	 @Autowired
	 AnswerListService answerListService;
	
	public TestResponse getTestResponse(Long id) {
		return testResponseRepository.findById(id).get();
	}
	
	public List<TestResponse> getTestResponses() {
		return testResponseRepository.findAll();
	}
	
	public TestResponse saveTestResponse(TestResponse testResponse) {
		return testResponseRepository.save(testResponse);
	}
	
	public TestResponse addAnswerList(TestResponse testResponse, AnswerList answerList) {
		
		AnswerList _answerList = answerListService.getAnswerList(answerList.getId());
		testResponse.setAnswerList(_answerList);
		return testResponseRepository.save(testResponse);
	}

}
