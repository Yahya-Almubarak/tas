package com.kaukajarvisoft.tas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.policy.Policy;

@Repository
public interface PolicyRepository extends PagingAndSortingRepository<Policy, Long>{
	List<Policy> findAll();

}
