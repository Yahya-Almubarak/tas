package com.kaukajarvisoft.tas.dummydata;

import java.util.List;

import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;

import lombok.Data;

@Data
public class DummyMultiChoiceQuestionAnswer {
	List<MultiChoiceQuestion> questions;
	List<CorrectMultiChoiceAnswer> answers;

}
