package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.tests.TestResponse;

@Repository
public interface TestResponseRepository extends PagingAndSortingRepository<TestResponse, Long>{
	List<TestResponse> findAll();
}
