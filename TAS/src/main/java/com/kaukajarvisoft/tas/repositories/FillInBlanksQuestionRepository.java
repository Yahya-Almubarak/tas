package com.kaukajarvisoft.tas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kaukajarvisoft.tas.questions.FillInBlanksQuestion;

@RepositoryRestResource(collectionResourceRel = "", path = "")
public interface FillInBlanksQuestionRepository extends PagingAndSortingRepository<FillInBlanksQuestion, Long> {

}
