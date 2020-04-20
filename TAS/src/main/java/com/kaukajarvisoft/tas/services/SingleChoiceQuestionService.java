package com.kaukajarvisoft.tas.services;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.repositories.SingleChoiceQuestionRepository;


@Service
public class SingleChoiceQuestionService {
	@Autowired
	SingleChoiceQuestionRepository singleChoiceQuestionRepository;
	
	public SingleChoiceQuestion getSingleChoiceQuestion(Long id) {
		SingleChoiceQuestion question = singleChoiceQuestionRepository.findById(id).get();
		if(question== null) {
			return null;
		} else {
			return question;
		}	
	}
	
	public SingleChoiceQuestion getSingleChoiceQuestion(Question question) {
		SingleChoiceQuestion singleChoiceQuestion = singleChoiceQuestionRepository.findByQuestion(question);
		return singleChoiceQuestion;
	}
	
	public List<SingleChoiceQuestion> getSingleChoiceQuestions(String local) {
		List<SingleChoiceQuestion> list = (List<SingleChoiceQuestion>)singleChoiceQuestionRepository.findByLocal(new Locale(local));
		if(list == null || list.isEmpty()) {
			return null;
		} else {
			return list;
		}
			
	}
	
	public List<SingleChoiceQuestion> getSingleChoiceQuestions() {
		List<SingleChoiceQuestion> list = (List<SingleChoiceQuestion>)singleChoiceQuestionRepository.findAll();
		return list;
			
	}
	
	public SingleChoiceQuestion saveSingleChoiceQuestion(SingleChoiceQuestion question) {
		return singleChoiceQuestionRepository.save(question);
				
	}
}
