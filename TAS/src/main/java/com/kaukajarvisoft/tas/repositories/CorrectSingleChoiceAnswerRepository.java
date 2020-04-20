package com.kaukajarvisoft.tas.repositories;

import java.util.List;
import java.util.Locale;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;


@RepositoryRestResource(collectionResourceRel = "correctsinglechoiceanswer", path = "correctsinglechoiceanswer")
public interface CorrectSingleChoiceAnswerRepository extends PagingAndSortingRepository<CorrectSingleChoiceAnswer, Long> {
       List<CorrectSingleChoiceAnswer> findAll();
       CorrectSingleChoiceAnswer findByCorrectAnswer(CorrectAnswer correctAnswer);
}
