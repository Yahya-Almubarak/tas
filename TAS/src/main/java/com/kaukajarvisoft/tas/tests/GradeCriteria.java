package com.kaukajarvisoft.tas.tests;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class GradeCriteria {
	// total points
	Boolean everyChoiceInMultiChoiceQuestionGetsPointInTotal;
	Boolean onlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal;
	Boolean everyWholeQuestionGetsOnePointInTotal;
	Boolean everyChoiceInSingleChoiceQuestionGetsPointInTotal;
	
	//acquired points
	Boolean everyFalseSelectionGetsMinus;
	Boolean everyCorrectSelectionGetsPlus;
	Boolean wholeCorrectAnswerGetsPlus;
	Boolean wholeFalseAnswerGetsMinus;
	
	Long pointsPerChoice;
	Long pointsPerWholeAnswer;
	
	public GradeCriteria() {
		
		everyChoiceInMultiChoiceQuestionGetsPointInTotal = false;
		onlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal = false;
		everyWholeQuestionGetsOnePointInTotal = false;
		everyChoiceInSingleChoiceQuestionGetsPointInTotal = false;
		
		
		everyFalseSelectionGetsMinus = false;
		everyCorrectSelectionGetsPlus = false;
		wholeCorrectAnswerGetsPlus = false;
		wholeFalseAnswerGetsMinus = false;
		
				
		pointsPerChoice = 0L;
		pointsPerWholeAnswer = 0L;
	}
}
