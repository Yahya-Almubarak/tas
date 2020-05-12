package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.questions.Question;

@RepositoryRestResource(collectionResourceRel = "correctmultianswers", path = "correctmultianswers")
public interface CorrectMultiChoiceAnswerRepository extends PagingAndSortingRepository<CorrectMultiChoiceAnswer, Long> {
	List<CorrectMultiChoiceAnswer> findAll();
	CorrectMultiChoiceAnswer findByQuestion(Question question);
	CorrectMultiChoiceAnswer findByQuestion_Id(Long questionId);
	
	
}
