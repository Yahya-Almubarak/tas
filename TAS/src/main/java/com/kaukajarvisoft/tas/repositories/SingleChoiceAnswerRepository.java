package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.SingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;

@Repository
public interface SingleChoiceAnswerRepository extends PagingAndSortingRepository<SingleChoiceAnswer, Long>{
	List<SingleChoiceAnswer> findAll();
	SingleChoiceAnswer findByAnswer(Answer answer);

}
