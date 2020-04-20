package com.kaukajarvisoft.tas.repositories;

import java.util.List;
import java.util.Locale;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;


@Repository
public interface SingleChoiceQuestionRepository extends PagingAndSortingRepository<SingleChoiceQuestion, Long> {
	List<SingleChoiceQuestion> findByLocal(Locale local);
	SingleChoiceQuestion findByQuestion(Question question); 
}
