package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.repositories.AnswerRepository;
import com.kaukajarvisoft.tas.repositories.CorrectMultiChoiceAnswerRepository;

@Service
public class AnswerService {
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	MultiChoiceAnswerService multiChoiceAnswerService;
	@Autowired
	CorrectMultiChoiceAnswerRepository correctMultiChoiceAnswerService;
	
	
	public Answer createAnswer(MultiChoiceAnswer multiChoiceAnswer) {
		Answer answer = multiChoiceAnswer.getAnswer();
		if(answer == null || answer.getId() == null) {
			answer = new Answer();
			answer.setType(multiChoiceAnswer.getType());
			answer.setName(multiChoiceAnswer.getName());
			answer.setLocal(multiChoiceAnswer.getLocal());
			answerRepository.save(answer);
			multiChoiceAnswer.setAnswer(answer);
		} else {
			answer = answerRepository.findById(answer.getId()).get();
			answerRepository.save(answer);
			multiChoiceAnswer.setAnswer(answer);
		}
		multiChoiceAnswerService.saveMultiChoiceAnswer(multiChoiceAnswer);
		return answer;
	}
	
	public Answer getAnswer(Long id) {
		return answerRepository.findById(id).get();
	}
	
	public List<Answer> getAnswers() {
		return answerRepository.findAll();
	}
	
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public Answer createAnswer(CorrectMultiChoiceAnswer correctMultiChoiceAnswer) {
		Answer answer = new Answer();
		answerRepository.save(answer);
	
		correctMultiChoiceAnswerService.save(correctMultiChoiceAnswer);
		return answer;
	}

}
