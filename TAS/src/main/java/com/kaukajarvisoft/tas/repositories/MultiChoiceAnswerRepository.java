package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;

@Repository
public interface MultiChoiceAnswerRepository extends PagingAndSortingRepository<MultiChoiceAnswer, Long>{

	List<MultiChoiceAnswer> findAll();
	
	MultiChoiceAnswer findByAnswer(Answer answer);

}
