package com.kaukajarvisoft.tas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.users.TasUser;

@Repository
public interface UserRepository extends PagingAndSortingRepository<TasUser, Long>{
	List<TasUser> findAll();
}
