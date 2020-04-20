package com.kaukajarvisoft.tas.maincomponents.interfaces;

import java.util.List;
import java.util.Map;

import com.kaukajarvisoft.tas.answers.IAnswer;
import com.kaukajarvisoft.tas.questions.IQuestion;

public interface ITest {
	boolean addQuestion(IQuestion question);
	boolean removeQuestion(IQuestion question);
	boolean addTestAssembler(IUser user);
	boolean removeTestAssembler(IUser user);
	boolean addTestSupervisor(IUser user);
	boolean removeTestSupervisor(IUser user);
	boolean addTestEvaluator(IUser user);
	boolean removeTestEvaluator(IUser user);
	boolean addTestReviewer(IUser user);
	boolean removeTestReviewer(IUser user);
	boolean addTestTaker(IUser user);
	boolean removeTestTaker(IUser user);
	boolean supplyAnswers(IUser user, Map<IQuestion, IAnswer> answers);
	List<IQuestion> publishTest();
}
