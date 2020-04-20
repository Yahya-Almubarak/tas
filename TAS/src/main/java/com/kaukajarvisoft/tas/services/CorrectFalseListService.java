package com.kaukajarvisoft.tas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.repositories.CorrectFalseListRepository;
import com.kaukajarvisoft.tas.tests.CorrectFalseList;

@Service
public class CorrectFalseListService {
	
	@Autowired
	CorrectFalseListRepository correctFalseListRepository;
	
	public CorrectFalseList saveCorrectFalseList(CorrectFalseList correctFalseList) {
		return correctFalseListRepository.save(correctFalseList);
	}

}
