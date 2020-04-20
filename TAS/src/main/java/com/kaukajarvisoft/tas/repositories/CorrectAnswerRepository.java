package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.questions.Question;

@RepositoryRestResource(collectionResourceRel = "correctanswers", path = "correctanswers")
public interface CorrectAnswerRepository extends PagingAndSortingRepository<CorrectAnswer, Long>{
	List<CorrectAnswer> findAll();
	CorrectAnswer findByQuestion(Question question);
}
