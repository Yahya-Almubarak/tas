package com.kaukajarvisoft.tas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.repositories.CorrectMultiChoiceAnswerRepository;

@Service
@Transactional
public class CorrectMultiChoiceAnswerService {
	

	@Autowired
	CorrectMultiChoiceAnswerRepository correctMultiChoiceAnswerRepository;
	

		
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
	
	
	

	public CorrectMultiChoiceAnswer getCorrectMultiChoiceAnswer(Question question) {
		return correctMultiChoiceAnswerRepository.findByQuestion(question);
	}
	
	public CorrectMultiChoiceAnswer getCorrectMultiChoiceAnswerByQuestionId(Long questionId) {
		return correctMultiChoiceAnswerRepository.findByQuestion_Id(questionId);
	}

}
