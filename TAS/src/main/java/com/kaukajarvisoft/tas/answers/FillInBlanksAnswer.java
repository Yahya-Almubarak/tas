package com.kaukajarvisoft.tas.answers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FillInBlanksAnswer {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long  id;
	
	/* Fill in blanks question is a sentence, paragraph or a group of sentences/paragraph.
	 * Sentence and paragraph mean the same thing which is a segment of text.
	 * 
	 * If there is only one sentence or paragraph then the Map<Long,List<String>> will contains only one value.
	 * If there is more than one sentence then the map will contain a list for each sentence/paragraph.
	 * one sentence or one paragraph is split to tokens, each token is an item in the list,
	 *  the blanks will be between tokens. If a blank is intended to be in the beginning then an 
	 *  empty string must be inserted in the beginning.
	 * If the blank is at the end then an empty string must be inserted at the end.
	 * example: ---- exam was ----- easy, but ---- I could not -----.
	 * then the list should contain: "", "exam was", "easy, but", "I could not" and "".
	 * 
	 * Suggestions can be presented with the questions, They can be presented together, 
	 * a word for each blank or a the end of sentence.
	 * Exam writer is responsible to arrange suggestions according to the corresponding blanks.
	 * 
	 */
	
	/* The answer is a Map of words where their keys represent the order in which the blank appears in the original question
	 * 
	 */
	
	//Map<Locale, Map<Long, String>> fillWords;
	//Map<Locale, String> commentOnAnswer;
	//Map<Locale, Map<Long, List<String>>> commentOnEachFillWord;
	/*public FillInBlanksAnswer() {
		super();
		type = QuestionTypes.FILL_IN_BLANKS;
	}*/

}
