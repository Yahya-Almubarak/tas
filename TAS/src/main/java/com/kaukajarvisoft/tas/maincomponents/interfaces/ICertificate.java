package com.kaukajarvisoft.tas.maincomponents.interfaces;

public interface ICertificate {
	boolean addExam(IExam exam);
	boolean removeExam(IExam exam);
	boolean addExamManager(IUser user);
	boolean removeExamManager(IUser user);

}
