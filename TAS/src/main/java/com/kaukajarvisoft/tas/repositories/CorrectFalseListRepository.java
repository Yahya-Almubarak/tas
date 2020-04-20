package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.tests.CorrectFalseList;

@Repository
public interface CorrectFalseListRepository extends PagingAndSortingRepository<CorrectFalseList, Long> {
	List<CorrectFalseList> findAll();
}
