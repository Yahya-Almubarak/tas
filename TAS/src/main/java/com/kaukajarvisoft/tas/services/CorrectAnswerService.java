package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.repositories.CorrectAnswerRepository;

@Service
public class CorrectAnswerService {
	@Autowired
	CorrectAnswerRepository correctAnswerRepository;
	@Autowired
	CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService;
	

	
	public CorrectAnswer createCorrectAnswer(CorrectMultiChoiceAnswer correctMultiChoiceAnswer) {
		CorrectAnswer correctAnswer = correctMultiChoiceAnswer.getCorrectAnswer();
		if(correctAnswer == null || correctAnswer.getId() == null) {
			correctAnswer = new CorrectAnswer();
			correctAnswer.setType(correctMultiChoiceAnswer.getType());
			correctAnswer.setName(correctMultiChoiceAnswer.getName());
			correctAnswer.setLocal(correctMultiChoiceAnswer.getLocal());
			correctAnswerRepository.save(correctAnswer);
			correctMultiChoiceAnswer.setCorrectAnswer(correctAnswer);
		} else {
			correctAnswer = correctAnswerRepository.findById(correctAnswer.getId()).get();
			correctAnswerRepository.save(correctAnswer);
			correctMultiChoiceAnswer.setCorrectAnswer(correctAnswer);
		}
		correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
		return correctAnswer;
	}
	
	public CorrectAnswer getCorrectAnswer(Long id) {
		return correctAnswerRepository.findById(id).get();
	}
	
	public List<CorrectAnswer> getCorrectAnswers() {
		return correctAnswerRepository.findAll();
	}
	
	public CorrectAnswer saveCorrectAnswer(CorrectAnswer correctAnswer) {
		return correctAnswerRepository.save(correctAnswer);
	}
	
	public CorrectAnswer getCorrectAnswer(Question question) {
		return correctAnswerRepository.findByQuestion(question);
	}
	
	
}
