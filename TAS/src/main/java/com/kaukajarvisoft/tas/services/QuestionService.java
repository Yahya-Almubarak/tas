package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.repositories.QuestionRepository;

@Service
@Transactional
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	
	@Transactional
	public Question getQuestion(Long id) {
		return questionRepository.findById(id).get();
	}
	
	@Transactional
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}
	
	@Transactional
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}
}
