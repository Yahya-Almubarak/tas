package com.kaukajarvisoft.tas.repositories;

import java.util.List;
import java.util.Locale;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;

@Repository
public interface CorrectMultiChoiceAnswerRepository extends PagingAndSortingRepository<CorrectMultiChoiceAnswer, Long> {
	List<CorrectMultiChoiceAnswer> findAll();
	CorrectMultiChoiceAnswer findByCorrectAnswer(CorrectAnswer correctAnswer);
}
