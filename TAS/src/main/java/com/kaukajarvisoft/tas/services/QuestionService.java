package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.repositories.MultiChoiceQuestionRepository;
import com.kaukajarvisoft.tas.repositories.QuestionRepository;
import com.kaukajarvisoft.tas.repositories.SingleChoiceQuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	SingleChoiceQuestionService singleChoiceQuestionService;
	@Autowired
	MultiChoiceQuestionService multiChoiceQuestionService;
	

	public Question createQuestion(SingleChoiceQuestion singleChoiceQuestion) {
		Question question = singleChoiceQuestion.getQuestion();
		if(question == null || question.getId() == null) {
			question = new Question();
			question.setType(singleChoiceQuestion.getType());
			question.setName(singleChoiceQuestion.getName());
			question.setLocal(singleChoiceQuestion.getLocal());
			questionRepository.save(question);
			singleChoiceQuestion.setQuestion(question);
		} else {
			question = questionRepository.findById(question.getId()).get();
			questionRepository.save(question);
			singleChoiceQuestion.setQuestion(question);
		}
		singleChoiceQuestionService.saveSingleChoiceQuestion(singleChoiceQuestion);
		return question;
	}
	
	public Question createQuestion(MultiChoiceQuestion multiChoiceQuestion) {
		Question question = multiChoiceQuestion.getQuestion();
		if(question == null || question.getId() == null) {
			question = new Question();
			question.setType(multiChoiceQuestion.getType());
			question.setName(multiChoiceQuestion.getName());
			question.setLocal(multiChoiceQuestion.getLocal());
			questionRepository.save(question);
			multiChoiceQuestion.setQuestion(question);
		} else {
			question = questionRepository.findById(question.getId()).get();
			questionRepository.save(question);
			multiChoiceQuestion.setQuestion(question);
		}
		multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
		return question;
	}
	
	public Question getQuestion(Long id) {
		return questionRepository.findById(id).get();
	}
	
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}
	
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}
}
