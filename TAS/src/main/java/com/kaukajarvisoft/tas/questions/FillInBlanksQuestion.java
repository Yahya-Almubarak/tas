package com.kaukajarvisoft.tas.questions;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FillInBlanksQuestion {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long  id;
	String name;
	String description;
	QuestionTypes type;
	Duration timeToPresent;
	Duration timeToAnswer; 
	@ElementCollection(targetClass=String.class)
	Map<Locale, String> body;
	/* Those comments are intended to be presented during test to test taker
	 * They are mapped according to the locale to allow localization */
	@ElementCollection(targetClass=String.class)
	Map<Locale, String> commentOnTime;
	@ElementCollection(targetClass=String.class)
	Map<Locale, String> commentOnQuestion;
	@ElementCollection(targetClass=String.class)
	Map<Locale, String> commentOnAnswering;
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
	
	//Map<Locale, Map<Long, List<String>>> body;
	//Map<Locale, Map<Long, List<String>>> suggestions;
	boolean suggestionForEachBlank;
	boolean suggestionsForEachSegment;
	boolean suggestionsForAll;
	public FillInBlanksQuestion() {
		super();
		type = QuestionTypes.FILL_IN_BLANKS;
	}
	

}
