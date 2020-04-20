package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.tests.Test;

@Repository
public interface TestRepository extends PagingAndSortingRepository<Test, Long> {
	List<Test> findAll();

}
