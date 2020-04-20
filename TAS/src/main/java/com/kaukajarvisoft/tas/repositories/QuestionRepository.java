package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.questions.Question;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long>{
	List<Question> findAll();

}
