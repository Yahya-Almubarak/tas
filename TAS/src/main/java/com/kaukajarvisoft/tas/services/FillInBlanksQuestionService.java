package com.kaukajarvisoft.tas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.repositories.FillInBlanksQuestionRepository;

@Service
public class FillInBlanksQuestionService {
	@Autowired
	FillInBlanksQuestionRepository repo;

}
