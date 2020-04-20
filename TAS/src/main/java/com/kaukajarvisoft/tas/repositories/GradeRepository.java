package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.tests.Grade;

@Repository
public interface GradeRepository extends PagingAndSortingRepository<Grade, Long>{
	List<Grade> findAll();

}
