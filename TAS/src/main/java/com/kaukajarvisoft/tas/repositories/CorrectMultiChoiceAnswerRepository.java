package com.kaukajarvisoft.tas.repositories;

import java.util.List;
import java.util.Locale;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;

@RepositoryRestResource(collectionResourceRel = "correctmultianswers", path = "correctmultianswers")
public interface CorrectMultiChoiceAnswerRepository extends PagingAndSortingRepository<CorrectMultiChoiceAnswer, Long> {
	List<CorrectMultiChoiceAnswer> findAll();
	CorrectMultiChoiceAnswer findByCorrectAnswer(CorrectAnswer correctAnswer);
}
