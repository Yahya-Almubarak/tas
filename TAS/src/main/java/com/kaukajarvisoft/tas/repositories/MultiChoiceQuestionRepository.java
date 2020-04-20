package com.kaukajarvisoft.tas.repositories;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.questions.*;

@Repository
public interface MultiChoiceQuestionRepository extends PagingAndSortingRepository<MultiChoiceQuestion, Long> {
	
	List<MultiChoiceQuestion> findByLocal(Locale local);

	MultiChoiceQuestion findByQuestion(Question question);

}
