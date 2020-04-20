package com.kaukajarvisoft.tas.services;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.answers.SingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.repositories.CorrectSingleChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.SingleChoiceAnswerRepository;

@Service
public class CorrectSingleChoiceAnswerService {
	
	@Autowired
	CorrectSingleChoiceAnswerRepository correctSingleChoiceAnswerRepository;
	
	@Autowired
	CorrectAnswerService correctAnswerService;
	
	public CorrectSingleChoiceAnswer getCorrectSingleChoiceAnswer(Long id) {
		CorrectSingleChoiceAnswer correctSingleChoiceAnswer  = correctSingleChoiceAnswerRepository.findById(id).get();
		return correctSingleChoiceAnswer;
	}
	
	public List<CorrectSingleChoiceAnswer> getCorrectSingleChoiceAnswers() {
		return correctSingleChoiceAnswerRepository.findAll();
	}
	
	public CorrectSingleChoiceAnswer saveCorrectSingleChoiceAnswer(CorrectSingleChoiceAnswer correctSingleChoiceAnswer) {
		return correctSingleChoiceAnswerRepository.save(correctSingleChoiceAnswer);
	}
	
	public CorrectSingleChoiceAnswer getCorrectSingleChoiceAnswer(CorrectAnswer correctAnswer) {
		return correctSingleChoiceAnswerRepository.findByCorrectAnswer(correctAnswer);
	}
	
	public CorrectSingleChoiceAnswer getCorrectSingleChoiceAnswer(SingleChoiceQuestion singleChoiceQuestion) {
		Question question = singleChoiceQuestion.getQuestion();
		CorrectAnswer correctAnswer = correctAnswerService.getCorrectAnswer(question);
		return this.getCorrectSingleChoiceAnswer(correctAnswer);	
	}
	
	
	
}
