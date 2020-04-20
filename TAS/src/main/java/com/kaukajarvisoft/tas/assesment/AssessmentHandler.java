package com.kaukajarvisoft.tas.assesment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.SingleChoiceAnswer;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionList;
import com.kaukajarvisoft.tas.questions.QuestionTypes;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.services.CorrectAnswerService;
import com.kaukajarvisoft.tas.services.CorrectFalseListService;
import com.kaukajarvisoft.tas.services.CorrectMultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.CorrectSingleChoiceAnswerService;
import com.kaukajarvisoft.tas.services.MultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.MultiChoiceQuestionService;
import com.kaukajarvisoft.tas.services.SingleChoiceAnswerService;
import com.kaukajarvisoft.tas.services.SingleChoiceQuestionService;
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
	CorrectSingleChoiceAnswerService correctSingleChoiceAnswerService;
	@Autowired
	CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService;
	@Autowired
	SingleChoiceQuestionService singleChoiceQuestionService;
	@Autowired
	MultiChoiceQuestionService multiChoiceQuestionService;
	@Autowired
	SingleChoiceAnswerService singleChoiceAnswerService;
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
		SingleChoiceQuestion singleChoiceQuestion;
		SingleChoiceAnswer singleChoiceAnswer;
		MultiChoiceQuestion multiChoiceQuestion;
		MultiChoiceAnswer multiChoiceAnswer;
		List<List<Long>> correctFalseMap = new ArrayList<>();
		List<Long> assessedChoices;
		for (int i = 0; i < questions.size(); i++) {
			question = questions.get(i);
			answer = answers.get(i);
			assessedChoices = new ArrayList<>();
			if(question.getType() == QuestionTypes.SINGLE_CHOICE) {
				singleChoiceQuestion = singleChoiceQuestionService.getSingleChoiceQuestion(question);
				singleChoiceAnswer = singleChoiceAnswerService.getSingleChoiceAnswer(answer);
				assessedChoices = assess(singleChoiceQuestion, singleChoiceAnswer);
			} else if(question.getType() == QuestionTypes.MULTI_CHOICE) {
				multiChoiceQuestion = multiChoiceQuestionService.getMultiChoiceQuestion(question);
				multiChoiceAnswer = multiChoiceAnswerService.getMultiChoiceAnswer(answer);
				assessedChoices = assess(multiChoiceQuestion, multiChoiceAnswer);
			}
			correctFalseMap.add(assessedChoices);
		}
		
		for (int i = 0; i < correctFalseMap.size(); i++) {
			assessedChoices = correctFalseMap.get(i);
			Long assessedChoice;
			Boolean oneChoiceIsWrong = false;
			for (int j = 0; j < assessedChoices.size(); j++) {
				assessedChoice = assessedChoices.get(j);
				switch(assessedChoice.intValue()){
				case(3):
					if(gradeCriteria.getEveryCorrectSelectionGetsPlus()) acquiredPoints++;
					break;
				case(2):
					break;
				case(1):
					oneChoiceIsWrong = true;
					if(gradeCriteria.getEveryFalseSelectionGetsMinus()) acquiredPoints--;
					break;
				case(0):
					oneChoiceIsWrong = true;
				if(gradeCriteria.getEveryFalseSelectionGetsMinus()) acquiredPoints--;
				break;
				}
			}
			if(oneChoiceIsWrong && gradeCriteria.getWholeFalseAnswerGetsMinus()) acquiredPoints--;
			if(!oneChoiceIsWrong && gradeCriteria.getWholeCorrectAnswerGetsPlus()) acquiredPoints++;
		}
		grade.setTestResponse(testResponse);
		grade.setTotalPoints(totalPoints);
		grade.setAcquiredPoints(acquiredPoints);
		// this call is to transfer List<List<Long> into List<CorrectFalseList>.
		List<CorrectFalseList> modifiedCorrectFalseMap = this.modifyCorrectFalseMap(correctFalseMap);
		grade.setCorrectFalseMap(modifiedCorrectFalseMap);
		return grade;
		
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
	


	
	public List<Long> assess(SingleChoiceQuestion singleChoiceQuestion, SingleChoiceAnswer singleChoiceAnswer) {
		Long choice = singleChoiceAnswer.getChoice();
		CorrectSingleChoiceAnswer correctSingleChoiceAnswer = correctSingleChoiceAnswerService.getCorrectSingleChoiceAnswer(singleChoiceQuestion);
		Long correctChoice = correctSingleChoiceAnswer.getChoice();
		Long numberOfChoices = 0L + singleChoiceQuestion.getChoices().size();
		List<Long> assessedChoices = new ArrayList<>();
		// value of 0 in assessedChoices means wrong answer, the correct choice is not selected
		// value of 1 in assessedChoices means wrong answer, the wrong choice is selected
		// value of 2 in assessedChoices means neutral answer, the wrong choice is not selected
		// value of 3 in assessedChoices means right answer, the correct choice is selected, it is the only right answer.
		for (int i = 0; i < numberOfChoices; i++) {
			if(i == choice.intValue()) {  // the choice is selected
				if(i == correctChoice.intValue()) {
					assessedChoices.add(3L); // the selected choice is correct
				} else {
					assessedChoices.add(1L); // the selected choice is not  correct
				}
			} else {                   // the choice is not selected
				if(i == correctChoice.intValue()) {
					assessedChoices.add(0L); // the not selected choice is correct
				} else {
					assessedChoices.add(2L); // the not selected choice is not  correct
				}
			}
		}
		return assessedChoices;
		
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
		SingleChoiceQuestion singleChoiceQuestion;
		CorrectAnswer correctAnswer;
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer;
		CorrectSingleChoiceAnswer correctSingleChoiceAnswer;
		if(gradeCriteria.getEveryWholeQuestionGetsOnePointInTotal()) {
			totalPoints = 0L + questions.size();
		}
		else {
			for (int i = 0; i < questions.size(); i++) {
				question = questions.get(i);
				correctAnswer = correctAnswerService.getCorrectAnswer(question);
				if(question.getType() == QuestionTypes.SINGLE_CHOICE) {
					if(gradeCriteria.getEveryChoiceInSingleChoiceQuestionGetsPointInTotal()) {
						singleChoiceQuestion = singleChoiceQuestionService.getSingleChoiceQuestion(question); 
						totalPoints += singleChoiceQuestion.getChoices().size();
						//System.out.println(" Qusetion no: " + i + " has " + singleChoiceQuestion.getChoices().size() +" scored choices");
					} else {
						totalPoints++;
						//System.out.println(" Qusetion no: " + i + " hass " + 1 +" scored choices");
					}
					
				} else if(question.getType() == QuestionTypes.MULTI_CHOICE) {					
					if(gradeCriteria.getEveryChoiceInMultiChoiceQuestionGetsPointInTotal()) {
						totalPoints += multiChoiceQuestionService.getMultiChoiceQuestion(question).getChoices().size();
						//System.out.println(" Qusetion no: " + i + " hasss " + multiChoiceQuestionService.getMultiChoiceQuestion(question).getChoices().size() +" scored choices");
					} else if(gradeCriteria.getOnlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal()) {
						correctMultiChoiceAnswer = correctMultiChoiceAnswerService.getCorrectMultiChoiceAnswer(correctAnswer);
						totalPoints += correctMultiChoiceAnswer.getChoices().stream().filter(n -> n.longValue() == 1L).count();
						//System.out.println(" Qusetion no: " + i + " hasssss " + correctMultiChoiceAnswer.getChoices().stream().filter(n -> n.longValue() == 1L).count() +" scored choices");
					}
					
				}
			}
		}
		
		return totalPoints;
	}
	
	
	
}
