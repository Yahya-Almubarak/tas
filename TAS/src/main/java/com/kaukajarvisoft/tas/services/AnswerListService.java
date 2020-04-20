package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.repositories.AnswerListRepository;
import com.kaukajarvisoft.tas.repositories.AnswerRepository;
import com.kaukajarvisoft.tas.repositories.QuestionListRepository;

@Service
public class AnswerListService {
	
	@Autowired
	AnswerListRepository answerListRepository;
	
	
	public AnswerList cteateList(AnswerList answerList) {
		return answerListRepository.save(answerList);
	}
	
	public AnswerList getAnswerList(Long id) {
		return answerListRepository.findById(id).orElse(null);
	}
	
	public List<AnswerList> getAnswerLists() {
		return answerListRepository.findAll();
	}
	
	public void addAnswerToAnswerList(AnswerList answerList, Answer answer) {
		AnswerList _answerList = answerListRepository.findById(answerList.getId()).get();
		_answerList.getAnswers().add(answer);
		answerListRepository.save(_answerList);
	}
}
