package com.kaukajarvisoft.tas.services;

import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questionlist.QuestionList;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.repositories.MultiChoiceQuestionRepository;

@Service
@Transactional
public class MultiChoiceQuestionService {
	@Autowired
	MultiChoiceQuestionRepository multiChoiceQuestionRepository;
	
	@Autowired
	QuestionListService questionListService;
	
	
	
	public MultiChoiceQuestion getMultiChoiceQuestion(Long id) {
		MultiChoiceQuestion question = multiChoiceQuestionRepository.findById(id).get();
		if(question == null) {
			return null;
		} else {
			return question;
		}
	}
	
	
	public List<MultiChoiceQuestion> getMultiChoiceQuestions() {
		List<MultiChoiceQuestion> list = (List<MultiChoiceQuestion>)multiChoiceQuestionRepository.findAll();
		return list;		
	}
	

	public MultiChoiceQuestion saveMultiChoiceQuestion(MultiChoiceQuestion question) {
		return multiChoiceQuestionRepository.save(question);
	}
	
	public MultiChoiceQuestion saveMultiChoiceQuestionAnddaddToList(MultiChoiceQuestion question, Long listId) {
		QuestionList questionList = questionListService.getQuestionList(listId);
		MultiChoiceQuestion multiChoiceQuestion = multiChoiceQuestionRepository.save(question);
		questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
		return multiChoiceQuestion;
	}

}
