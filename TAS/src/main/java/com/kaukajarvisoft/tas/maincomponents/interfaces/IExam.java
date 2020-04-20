package com.kaukajarvisoft.tas.maincomponents.interfaces;

public interface IExam {
	boolean addQuestionList(IQuestionsList questionList);
	boolean removeQuestionList(IQuestionsList questionList);
	boolean addTest(ITest test);
	boolean removeTest(ITest test);
	boolean addExamManager(IUser user);
	boolean removeExamManager(IUser user);
}
