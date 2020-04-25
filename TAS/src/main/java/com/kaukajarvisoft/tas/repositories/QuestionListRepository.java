package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.questionlist.QuestionList;


@Repository
public interface QuestionListRepository  extends PagingAndSortingRepository<QuestionList, Long>{
	List<QuestionList> findAll();

}
