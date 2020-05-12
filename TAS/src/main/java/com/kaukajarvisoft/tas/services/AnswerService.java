package com.kaukajarvisoft.tas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.repositories.AnswerRepository;
import com.kaukajarvisoft.tas.repositories.CorrectMultiChoiceAnswerRepository;

@Service
@Transactional
public class AnswerService {
	@Autowired
	AnswerRepository answerRepository;
		
	@Transactional
	public Answer getAnswer(Long id) {
		return answerRepository.findById(id).get();
	}
	@Transactional
	public List<Answer> getAnswers() {
		return answerRepository.findAll();
	}
	@Transactional
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	

}
