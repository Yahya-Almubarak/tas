package com.kaukajarvisoft.tas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.repositories.MultiChoiceAnswerRepository;

@Service
@Transactional
public class MultiChoiceAnswerService {
	
	@Autowired
	MultiChoiceAnswerRepository multiChoiceAnswerRepository;
	
	@Transactional	
	public MultiChoiceAnswer getMultiChoiceAnswer(Long id) {
		MultiChoiceAnswer multiChoiceAnswer  = multiChoiceAnswerRepository.findById(id).get();
		return multiChoiceAnswer;
	}
	@Transactional
	public List<MultiChoiceAnswer> getMultiChoiceAnswers() {
		return multiChoiceAnswerRepository.findAll();
	}
	@Transactional
	public MultiChoiceAnswer saveMultiChoiceAnswer(MultiChoiceAnswer multiChoiceAnswer) {
		return multiChoiceAnswerRepository.save(multiChoiceAnswer);
	}
	

}
