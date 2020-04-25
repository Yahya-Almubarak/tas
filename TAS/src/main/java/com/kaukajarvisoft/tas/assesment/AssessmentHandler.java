package com.kaukajarvisoft.tas.assesment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.questionlist.QuestionList;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionTypes;
import com.kaukajarvisoft.tas.services.CorrectAnswerService;
import com.kaukajarvisoft.tas.services.CorrectFalseListService;
import com.kaukajarvisoft.tas.services.CorrectMultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.MultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.MultiChoiceQuestionService;
import com.kaukajarvisoft.tas.services.TestService;
import com.kaukajarvisoft.tas.tests.CorrectFalseList;
import com.kaukajarvisoft.tas.tests.Grade;
import com.kaukajarvisoft.tas.tests.GradeCriteria;
import com.kaukajarvisoft.tas.tests.Test;
import com.kaukajarvisoft.tas.tests.TestResponse;


@Service
public class AssessmentHandler {
	
	@Autowired
	CorrectAnswerService correctAnswerService;
	@Autowired
	CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService;
	@Autowired
	MultiChoiceQuestionService multiChoiceQuestionService;
	@Autowired
	MultiChoiceAnswerService multiChoiceAnswerService;
	@Autowired
	TestService testService;
	@Autowired
	CorrectFalseListService correctFalseListService;
	

	public Grade grade(TestResponse testResponse) {
		Grade grade = new Grade();
		Long testId = testResponse.getTestId();
		Test test = testService.getTest(testId);
		Long totalPoints = computeTotalPoints(test);
		Long acquiredPoints = 0L;
		GradeCriteria gradeCriteria = test.getGradeCriteria();
		QuestionList questionList = test.getQuestionList();
		List<Question> questions = questionList.getQuestions();
		AnswerList answerList = testResponse.getAnswerList();
		List<Answer> answers = answerList.getAnswers();
		Question question;
		Answer answer;
		MultiChoiceQuestion multiChoiceQuestion;
		MultiChoiceAnswer multiChoiceAnswer;
		List<List<Long>> correctFalseMap = new ArrayList<>();
		List<Long> assessedSelections;
		for (int i = 0; i < questions.size(); i++) {
			question = questions.get(i);
			answer = answers.get(i);
			assessedSelections = new ArrayList<>();
			
			multiChoiceQuestion = multiChoiceQuestionService.getMultiChoiceQuestion(question);
			multiChoiceAnswer = multiChoiceAnswerService.getMultiChoiceAnswer(answer);
			assessedSelections = assess(multiChoiceQuestion, multiChoiceAnswer);
			
			correctFalseMap.add(assessedSelections);
		}
		
		acquiredPoints = computeAcquiredPoints(correctFalseMap, gradeCriteria);
		grade.setTestResponse(testResponse);
		grade.setTotalPoints(totalPoints);
		grade.setAcquiredPoints(acquiredPoints);
		// this call is to transfer List<List<Long> into List<CorrectFalseList>.
		List<CorrectFalseList> modifiedCorrectFalseMap = this.modifyCorrectFalseMap(correctFalseMap);
		grade.setCorrectFalseMap(modifiedCorrectFalseMap);
		return grade;
		
	}

	public Long computeAcquiredPoints(List<List<Long>> correctFalseMap,
			 GradeCriteria gradeCriteria) {
		Long acquiredPoints = 0L;
		List<Long> assessedSelections;
		for (int i = 0; i < correctFalseMap.size(); i++) {
			assessedSelections = correctFalseMap.get(i);
			Long assessedChoice;
			Boolean oneChoiceIsWrong = false;
			for (int j = 0; j < assessedSelections.size(); j++) {
				assessedChoice = assessedSelections.get(j);
				switch(assessedChoice.intValue()){
				case(3):
					if(gradeCriteria.getEveryCorrectSelectionGetsPlus()) acquiredPoints++;
					break;
				case(2):
					break;
				case(1):
				case(0):
					oneChoiceIsWrong = true;
					if(gradeCriteria.getEveryFalseSelectionGetsMinus()) acquiredPoints--;
					break;
				}
			}
			if(oneChoiceIsWrong && gradeCriteria.getWholeFalseAnswerGetsMinus()) acquiredPoints--;
			if(!oneChoiceIsWrong && gradeCriteria.getWholeCorrectAnswerGetsPlus()) acquiredPoints++;
		}
		return acquiredPoints;
	}
	
	public List<CorrectFalseList> modifyCorrectFalseMap(List<List<Long>> correctFalseMap) {
		CorrectFalseList correctFalseList;
		List<CorrectFalseList> modifiedCorrectFalseMap = new ArrayList<>();
		for (int i = 0; i < correctFalseMap.size(); i++) {
			correctFalseList = new CorrectFalseList();
			List<Long> assessedChoices = correctFalseMap.get(i);
			correctFalseList.setCorrectFalseList(assessedChoices);
			correctFalseListService.saveCorrectFalseList(correctFalseList);
			modifiedCorrectFalseMap.add(correctFalseList);
		}
		return modifiedCorrectFalseMap;
	}
	

	public List<Long> assess(MultiChoiceQuestion multiChoiceQuestion, MultiChoiceAnswer multiChoiceAnswer) {
		List<Long> choices = multiChoiceAnswer.getChoices();
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer = correctMultiChoiceAnswerService.getCorrectMultiChoiceAnswer(multiChoiceQuestion);
		Long numberOfChoices = 0L + multiChoiceQuestion.getChoices().size();
		List<Long> correctChoices = correctMultiChoiceAnswer.getChoices();
		List<Long> assessedChoices = new ArrayList<>();
		// value of 0 in assessedChoices means wrong answer, the correct choice is not selected
		// value of 1 in assessedChoices means wrong answer, the wrong choice is selected
		// value of 2 in assessedChoices means neutral answer, the wrong choice is not selected
		// value of 3 in assessedChoices means right answer, the correct choice is selected, it is the only right answer.
		Long choice;
		Long correctChoice;
		for (int i = 0; i < numberOfChoices; i++) {
			choice = choices.get(i);
			correctChoice = correctChoices.get(i);
			if( choice == 1L) {  // the choice is selected
				if(correctChoice == 1L) {
					assessedChoices.add(3L); // the selected choice is correct
				} else {
					assessedChoices.add(1L); // the selected choice is not  correct
				}
			} else {                   // the choice is not selected
				if(correctChoice == 1L) {
					assessedChoices.add(0L); // the not selected choice is correct
				} else {
					assessedChoices.add(2L); // the not selected choice is not  correct
				}
			}
					
		}
		return assessedChoices;
	}
	
	public Long computeTotalPoints(Test test) {
		Long totalPoints = 0L;
		GradeCriteria gradeCriteria = test.getGradeCriteria();
		QuestionList questionsList = test.getQuestionList();
		List<Question> questions = questionsList.getQuestions();
		Question question;
		CorrectAnswer correctAnswer;
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer;
		if(gradeCriteria.getEveryWholeQuestionGetsOnePointInTotal()) {
			totalPoints = 0L + questions.size();
		}
		else {
			for (int i = 0; i < questions.size(); i++) {
				question = questions.get(i);
				correctAnswer = correctAnswerService.getCorrectAnswer(question);
				correctMultiChoiceAnswer = correctMultiChoiceAnswerService.getCorrectMultiChoiceAnswer(correctAnswer);
				if(question.getType() == QuestionTypes.SINGLE_SELECT_MULTI_CHOICE) {
					if(gradeCriteria.getEveryChoiceInSingleChoiceQuestionGetsPointInTotal()) {
						totalPoints += correctMultiChoiceAnswer.getChoices().size();
					} else {
						totalPoints++;
						//System.out.println(" Qusetion no: " + i + " hass " + 1 +" scored choices");
					}
					
				} else if(question.getType() == QuestionTypes.MULTI_SELECT_MULTI_CHOICE) {					
					if(gradeCriteria.getEveryChoiceInMultiChoiceQuestionGetsPointInTotal()) {
						totalPoints += correctMultiChoiceAnswer.getChoices().size();
						//System.out.println(" Qusetion no: " + i + " hasss " + multiChoiceQuestionService.getMultiChoiceQuestion(question).getChoices().size() +" scored choices");
					} else if(gradeCriteria.getOnlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal()) {
						totalPoints += correctMultiChoiceAnswer.getChoices().stream().filter(n -> n.longValue() == 1L).count();
						//System.out.println(" Qusetion no: " + i + " hasssss " + correctMultiChoiceAnswer.getChoices().stream().filter(n -> n.longValue() == 1L).count() +" scored choices");
					}
					
				}
			}
		}
		
		return totalPoints;
	}
	
	
	
}
