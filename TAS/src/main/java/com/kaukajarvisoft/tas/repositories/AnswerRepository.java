package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.Answer;

@Repository
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long>{
	List<Answer> findAll();
}
