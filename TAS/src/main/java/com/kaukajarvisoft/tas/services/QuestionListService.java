package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionList;
import com.kaukajarvisoft.tas.repositories.QuestionListRepository;

@Service
public class QuestionListService {
	
	@Autowired
	QuestionListRepository questionListRepository;
	
	
	public QuestionList createList(QuestionList questionList) {
		questionListRepository.save(questionList);
		return questionList;
	}
	
	public QuestionList getQuestionList(Long id) {
		return questionListRepository.findById(id).orElse(null);
	}
	
	public List<QuestionList> getQuestionLists() {
		return questionListRepository.findAll();
	}
	
	public void addQuestionToQuestionList(QuestionList questionList, Question question) {
		
		QuestionList _questionList = questionListRepository.findById(questionList.getId()).get();
		_questionList.getQuestions().add(question);
		questionListRepository.save(_questionList);
	}
}
