package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.repositories.MultiChoiceAnswerRepository;

@Service
public class MultiChoiceAnswerService {
	
	@Autowired
	MultiChoiceAnswerRepository multiChoiceAnswerRepository;
		
	public MultiChoiceAnswer getMultiChoiceAnswer(Long id) {
		MultiChoiceAnswer multiChoiceAnswer  = multiChoiceAnswerRepository.findById(id).get();
		return multiChoiceAnswer;
	}
	
	public List<MultiChoiceAnswer> getMultiChoiceAnswers() {
		return multiChoiceAnswerRepository.findAll();
	}
	
	public MultiChoiceAnswer saveMultiChoiceAnswer(MultiChoiceAnswer multiChoiceAnswer) {
		return multiChoiceAnswerRepository.save(multiChoiceAnswer);
	}
	
	public MultiChoiceAnswer getMultiChoiceAnswer(Answer answer) {
		return multiChoiceAnswerRepository.findByAnswer(answer);
	}

}
