package com.kaukajarvisoft.tas.services;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.repositories.CorrectMultiChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.CorrectSingleChoiceAnswerRepository;

@Service
public class CorrectMultiChoiceAnswerService {
	

	@Autowired
	CorrectMultiChoiceAnswerRepository correctMultiChoiceAnswerRepository;
	
	@Autowired
	CorrectAnswerService correctAnswerService;
	
	public CorrectMultiChoiceAnswer getCorrectMultiChoiceAnswer(Long id) {
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer  = correctMultiChoiceAnswerRepository.findById(id).get();
		return correctMultiChoiceAnswer;
	}
	
	public List<CorrectMultiChoiceAnswer> getCorrectMultiChoiceAnswers() {
		return correctMultiChoiceAnswerRepository.findAll();
	}
	
	public CorrectMultiChoiceAnswer saveCorrectMultiChoiceAnswer(CorrectMultiChoiceAnswer correctMultiChoiceAnswer) {
		return correctMultiChoiceAnswerRepository.save(correctMultiChoiceAnswer);
	}
	
	public CorrectMultiChoiceAnswer getCorrectMultiChoiceAnswer(CorrectAnswer correctAnswer) {
		return correctMultiChoiceAnswerRepository.findByCorrectAnswer(correctAnswer);
	}
	
	public CorrectMultiChoiceAnswer getCorrectMultiChoiceAnswer(MultiChoiceQuestion multiChoiceQuestion) {
		Question question = multiChoiceQuestion.getQuestion();
		CorrectAnswer correctAnswer = correctAnswerService.getCorrectAnswer(question);
		return this.getCorrectMultiChoiceAnswer(correctAnswer);	
	}

}
