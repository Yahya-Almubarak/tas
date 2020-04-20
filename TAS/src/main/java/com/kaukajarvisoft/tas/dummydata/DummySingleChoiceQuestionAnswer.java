package com.kaukajarvisoft.tas.dummydata;

import java.util.List;

import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;

import lombok.Data;

@Data
public class DummySingleChoiceQuestionAnswer {
	List<SingleChoiceQuestion> questions;
	List<CorrectSingleChoiceAnswer> answers;

}
