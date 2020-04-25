package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	MultiChoiceQuestionService multiChoiceQuestionService;
	

	
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
