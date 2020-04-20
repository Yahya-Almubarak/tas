package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.repositories.GradeRepository;
import com.kaukajarvisoft.tas.tests.Grade;

@Service
public class GradeService {
	
	@Autowired
	GradeRepository gradeRepository;
	
	public Grade saveGrade(Grade grade) {
		return gradeRepository.save(grade);
	}
	
	public List<Grade> getGrades() {
		return gradeRepository.findAll();
	}

}
