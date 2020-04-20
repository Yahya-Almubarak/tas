package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.AnswerList;

@Repository
public interface AnswerListRepository extends PagingAndSortingRepository<AnswerList, Long>{
	List<AnswerList> findAll();
}
