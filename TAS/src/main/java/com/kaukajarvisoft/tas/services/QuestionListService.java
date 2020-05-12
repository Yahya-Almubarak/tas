package com.kaukajarvisoft.tas.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questionlist.QuestionList;
import com.kaukajarvisoft.tas.questionlist.QuestionLists;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.repositories.QuestionListRepository;

@Service
@Transactional
public class QuestionListService {
	
	@Autowired
	QuestionListRepository questionListRepository;
	

	public QuestionList createList() {
		QuestionList questionList = new QuestionList();
		questionList.setName("Default Question List");
		questionList.setDescription("This questionlist is created by the system");
		questionListRepository.save(questionList);
		return questionList;
	}
	
	public QuestionList createList(QuestionList questionList) {
		questionListRepository.save(questionList);
		return questionList;
	}

	public QuestionList getQuestionList(Long id) {
		return questionListRepository.findById(id).orElse(null);
	}

	public QuestionLists getQuestionLists() {
		QuestionLists questionLists = new QuestionLists();
		List<QuestionList> listOfQuestionLists = questionListRepository.findAll();
		questionLists.setQuestionLists(listOfQuestionLists);
		return questionLists;
	}
	
	public QuestionLists getQuestionListsReturnDefault() {
		QuestionLists questionLists = new QuestionLists();
		List<QuestionList> listOfQuestionLists = questionListRepository.findAll(); 
		if(listOfQuestionLists == null || listOfQuestionLists.isEmpty()) {
			QuestionList defaultQuestionList = createList();
			listOfQuestionLists = new ArrayList<>();
			listOfQuestionLists.add(defaultQuestionList);
			}
		questionLists.setQuestionLists(listOfQuestionLists);
		return questionLists;
	}
	
	
	
	public void addQuestionToQuestionList(QuestionList questionList, Question question) {
		
		QuestionList _questionList = questionListRepository.findById(questionList.getId()).get();
		_questionList.getQuestions().add(question);
		questionListRepository.save(_questionList);
	}
}
