package com.kaukajarvisoft.tas.services;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.repositories.MultiChoiceQuestionRepository;

@Service
public class MultiChoiceQuestionService {
	@Autowired
	MultiChoiceQuestionRepository multiChoiceQuestionRepository;
	
	public MultiChoiceQuestion getMultiChoiceQuestion(Long id) {
		MultiChoiceQuestion question = multiChoiceQuestionRepository.findById(id).get();
		if(question == null) {
			return null;
		} else {
			return question;
		}
	}
	
	public MultiChoiceQuestion getMultiChoiceQuestion(Question question) {
		MultiChoiceQuestion multiChoiceQuestion = multiChoiceQuestionRepository.findByQuestion(question);
		return multiChoiceQuestion;
	}
	
	public List<MultiChoiceQuestion> getMultiChoiceQuestions(String local) {
		List<MultiChoiceQuestion> list = (List<MultiChoiceQuestion>)multiChoiceQuestionRepository.findByLocal(new Locale(local));
		if(list == null || list.isEmpty()) {
			return null;
		} else {
			return list;
		}	
	}
	
	public List<MultiChoiceQuestion> getMultiChoiceQuestions() {
		List<MultiChoiceQuestion> list = (List<MultiChoiceQuestion>)multiChoiceQuestionRepository.findAll();
		return list;		
	}
	
	public MultiChoiceQuestion saveMultiChoiceQuestion(MultiChoiceQuestion question) {
		return multiChoiceQuestionRepository.save(question);
	}

}
