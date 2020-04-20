package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.SingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.repositories.QuestionRepository;
import com.kaukajarvisoft.tas.repositories.SingleChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.SingleChoiceQuestionRepository;

@Service
public class SingleChoiceAnswerService {
	
	@Autowired
	SingleChoiceAnswerRepository singleChoiceAnswerRepository;
	
	public SingleChoiceAnswer getSingleChoiceAnswer(Long id) {
		SingleChoiceAnswer singleChoiceAnswer  = singleChoiceAnswerRepository.findById(id).get();
		return singleChoiceAnswer;
	}
	
	public List<SingleChoiceAnswer> getSingleChoiceAnswers() {
		return singleChoiceAnswerRepository.findAll();
	}
	
	public SingleChoiceAnswer saveSingleChoiceAnswer(SingleChoiceAnswer singleChoiceAnswer) {
		return singleChoiceAnswerRepository.save(singleChoiceAnswer);
	}
	
	
	public SingleChoiceAnswer getSingleChoiceAnswer(Answer answer) {
		return singleChoiceAnswerRepository.findByAnswer(answer);
	}
}
