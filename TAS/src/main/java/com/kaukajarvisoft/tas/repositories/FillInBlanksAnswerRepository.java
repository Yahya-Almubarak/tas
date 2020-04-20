package com.kaukajarvisoft.tas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.answers.FillInBlanksAnswer;

@Repository
public interface FillInBlanksAnswerRepository extends PagingAndSortingRepository<FillInBlanksAnswer, Long> {

}
