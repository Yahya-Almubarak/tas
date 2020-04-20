package com.kaukajarvisoft.tas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kaukajarvisoft.tas.users.UserGroup;

@Repository
public interface UserGroupRepository  extends PagingAndSortingRepository<UserGroup, Long>{

}
