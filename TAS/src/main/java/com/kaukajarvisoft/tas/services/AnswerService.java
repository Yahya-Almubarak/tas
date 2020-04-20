package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.SingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.repositories.AnswerRepository;
import com.kaukajarvisoft.tas.repositories.CorrectMultiChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.CorrectSingleChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.MultiChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.SingleChoiceAnswerRepository;

@Service
public class AnswerService {
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	SingleChoiceAnswerService singleChoiceAnswerService;
	@Autowired
	MultiChoiceAnswerService multiChoiceAnswerService;
	@Autowired
	CorrectSingleChoiceAnswerRepository correctSingleChoiceAnswerService;
	@Autowired
	CorrectMultiChoiceAnswerRepository correctMultiChoiceAnswerService;
	
	
	public Answer createAnswer(SingleChoiceAnswer singleChoiceAnswer) {
		Answer answer = singleChoiceAnswer.getAnswer();
		if(answer == null || answer.getId() == null) {
			answer = new Answer();
			answer.setType(singleChoiceAnswer.getType());
			answer.setName(singleChoiceAnswer.getName());
			answer.setLocal(singleChoiceAnswer.getLocal());
			answerRepository.save(answer);
			singleChoiceAnswer.setAnswer(answer);
		} else {
			answer = answerRepository.findById(answer.getId()).get();
			answerRepository.save(answer);
			singleChoiceAnswer.setAnswer(answer);
		}
		singleChoiceAnswerService.saveSingleChoiceAnswer(singleChoiceAnswer);
		return answer;
	}
	
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
		
	public Answer createAnswer(CorrectSingleChoiceAnswer correctSingleChoiceAnswer) {
		Answer answer = new Answer();
		answerRepository.save(answer);
		
		correctSingleChoiceAnswerService.save(correctSingleChoiceAnswer);
		return answer;
	}
	
	public Answer createAnswer(CorrectMultiChoiceAnswer correctMultiChoiceAnswer) {
		Answer answer = new Answer();
		answerRepository.save(answer);
	
		correctMultiChoiceAnswerService.save(correctMultiChoiceAnswer);
		return answer;
	}

}
