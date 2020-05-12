package com.kaukajarvisoft.tas.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.repositories.CorrectFalseListRepository;
import com.kaukajarvisoft.tas.tests.CorrectFalseList;

@Service
@Transactional
public class CorrectFalseListService {
	
	@Autowired
	CorrectFalseListRepository correctFalseListRepository;
	
	@Transactional
	public CorrectFalseList saveCorrectFalseList(CorrectFalseList correctFalseList) {
		return correctFalseListRepository.save(correctFalseList);
	}

}
