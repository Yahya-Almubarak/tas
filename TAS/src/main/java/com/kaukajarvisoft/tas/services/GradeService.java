package com.kaukajarvisoft.tas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.repositories.GradeRepository;
import com.kaukajarvisoft.tas.tests.Grade;

@Service
@Transactional
public class GradeService {
	
	@Autowired
	GradeRepository gradeRepository;
	
	@Transactional
	public Grade saveGrade(Grade grade) {
		return gradeRepository.save(grade);
	}
	
	@Transactional
	public List<Grade> getGrades() {
		return gradeRepository.findAll();
	}

}
