package com.kaukajarvisoft.tas.dummydata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.AnswerList;
import com.kaukajarvisoft.tas.answers.CorrectAnswer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.CorrectSingleChoiceAnswer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.SingleChoiceAnswer;
import com.kaukajarvisoft.tas.assesment.AssessmentHandler;
import com.kaukajarvisoft.tas.controllers.AssessmentController;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionList;
import com.kaukajarvisoft.tas.questions.SingleChoiceQuestion;
import com.kaukajarvisoft.tas.repositories.CorrectMultiChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.CorrectSingleChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.MultiChoiceQuestionRepository;
import com.kaukajarvisoft.tas.repositories.QuestionListRepository;
import com.kaukajarvisoft.tas.repositories.QuestionRepository;
import com.kaukajarvisoft.tas.repositories.SingleChoiceQuestionRepository;
import com.kaukajarvisoft.tas.services.AnswerListService;
import com.kaukajarvisoft.tas.services.AnswerService;
import com.kaukajarvisoft.tas.services.CorrectAnswerService;
import com.kaukajarvisoft.tas.services.CorrectMultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.CorrectSingleChoiceAnswerService;
import com.kaukajarvisoft.tas.services.GradeService;
import com.kaukajarvisoft.tas.services.MultiChoiceQuestionService;
import com.kaukajarvisoft.tas.services.QuestionListService;
import com.kaukajarvisoft.tas.services.QuestionService;
import com.kaukajarvisoft.tas.services.SingleChoiceAnswerService;
import com.kaukajarvisoft.tas.services.SingleChoiceQuestionService;
import com.kaukajarvisoft.tas.services.TestResponseService;
import com.kaukajarvisoft.tas.services.TestService;
import com.kaukajarvisoft.tas.tests.Grade;
import com.kaukajarvisoft.tas.tests.GradeCriteria;
import com.kaukajarvisoft.tas.tests.Test;
import com.kaukajarvisoft.tas.tests.TestResponse;

public class DummyData {

	
	static public void populateData(SingleChoiceQuestionRepository singleChoiceQuestionRepository, 
			MultiChoiceQuestionRepository multiChoiceQuestionRepository,
			CorrectSingleChoiceAnswerRepository correctSingleChoiceAnswerRepository, 
			CorrectMultiChoiceAnswerRepository correctMultiChoiceAnswerRepository,
			QuestionListRepository questionListRepository, 
			QuestionRepository questionRepository,
			QuestionListService questionListService,
			QuestionService questionService,
			SingleChoiceQuestionService singleChoiceQuestionService,
			MultiChoiceQuestionService multiChoiceQuestionService,
			CorrectSingleChoiceAnswerService correctSingleChoiceAnswerService,
			CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService,
			SingleChoiceAnswerService singleChoiceAnswerService,
			CorrectAnswerService correctAnswerService,
			TestService testService,
			AnswerService answerService,
			TestResponseService testResponseService,
			AnswerListService answerListService,
			AssessmentHandler assessmentService,
			GradeService gradeService
			) {
	//	obtainDummySingleChoiceQuestions(singleChoiceQuestionRepository,correctSingleChoiceAnswerRepository, questionListRepository,questionRepository);
	//	obtainDummyMultiChoiceQuestions(multiChoiceQuestionRepository, correctMultiChoiceAnswerRepository, questionListRepository,questionRepository);
	//	obtainDummySingleChoiceQuestionsToSecondList(singleChoiceQuestionRepository, correctSingleChoiceAnswerRepository, questionListRepository, questionRepository);
		obtainDummyQuestionandAddItToListFromServices_I(
				singleChoiceQuestionService,
				multiChoiceQuestionService,
				correctSingleChoiceAnswerService, 
				correctMultiChoiceAnswerService,
				questionListService, 
				questionService,
				singleChoiceAnswerService,
				correctAnswerService,
				testService); 
	
	
	obtainDummyQuestionandAddItToListFromServices_II(
			singleChoiceQuestionService,
			multiChoiceQuestionService,
			correctSingleChoiceAnswerService, 
			correctMultiChoiceAnswerService,
			questionListService, 
			questionService,
			singleChoiceAnswerService,
			correctAnswerService,
			testService); 
	
	answerTest(singleChoiceQuestionService,
			multiChoiceQuestionService,
			correctSingleChoiceAnswerService, 
			correctMultiChoiceAnswerService, 
			questionListService, 
			questionService,
			singleChoiceAnswerService,
			correctAnswerService,
			testService,
			answerService,
			testResponseService,
			answerListService,
			assessmentService,
			gradeService);
}
	
	/*
	
	static public void obtainDummySingleChoiceQuestions(SingleChoiceQuestionRepository singleChoiceQuestionRepository,
			CorrectSingleChoiceAnswerRepository correctSingleChoiceAnswerRepository, 
			QuestionListRepository questionListRepository, 
			QuestionRepository questionRepository) {
	
		QuestionList questionList = new QuestionList();
		questionList.setQuestions(new ArrayList<>());
		questionListRepository.save(questionList);
		
		SingleChoiceQuestion singleChoiceQuestion;
		Question question;
		Map<Long, String> choices;
		CorrectSingleChoiceAnswer  answer;
		String body;
		
		// -------------------------------
				//________________________________ Question 2
				
				
				singleChoiceQuestion = new SingleChoiceQuestion();
				question = new Question();
				singleChoiceQuestion.setLocal(new Locale("fi"));
				singleChoiceQuestion.setName("Kysymys Yksi");
				singleChoiceQuestion.setDescription("Teko Kysymys");
				
				body = "Mitä on Suomen pääkaupunki?";
				singleChoiceQuestion.setBody(body);
				
				choices = new HashMap<>();
				choices.put(1L, "Helsinki");
				choices.put(2L, "Tokholma");
				choices.put(3L, "Turku");
				singleChoiceQuestion.setChoices(choices);
				
				questionRepository.save(question);
				singleChoiceQuestion.setQuestion(question);
				singleChoiceQuestionRepository.save(singleChoiceQuestion);
				
				questionList.getQuestions().add(question);
				questionListRepository.save(questionList);
				
			
				
				
				
				
				//-------------------------
				//__________________________ Answer 2
				 answer = new CorrectSingleChoiceAnswer();
				answer.setLocal(new Locale("fi"));
				answer.setName("Vastaus 2");
				answer.setDescription("Vastaus 1");
				answer.setQuestion(singleChoiceQuestion);
				answer.setChoice(1L);
				
				correctSingleChoiceAnswerRepository.save(answer);
				
		
		//__________________________
		//__________________________ Question 1
		
		// -----------------------------------
	
		singleChoiceQuestion = new SingleChoiceQuestion();
		question = new Question();
		choices = new HashMap<>();
		
		singleChoiceQuestion.setLocal(new Locale("en"));
		singleChoiceQuestion.setName("Question one");
		singleChoiceQuestion.setDescription("Dummy question");
		
		body = "What is the capital of Finland?";
		singleChoiceQuestion.setBody(body);
		
		
		choices.put(1L, "Helsinki");
		choices.put(2L, "Stockholm");
		choices.put(3L, "Turku");
		singleChoiceQuestion.setChoices(choices);
		
		questionRepository.save(question);
		singleChoiceQuestion.setQuestion(question);
		singleChoiceQuestionRepository.save(singleChoiceQuestion);
		
		questionList.getQuestions().add(question);
		questionListRepository.save(questionList);
		
		
		
		
		//___________________________________
		//___________________________________ Answer 1
		
		answer = new CorrectSingleChoiceAnswer();
		answer.setLocal(new Locale("en"));
		answer.setName("Answer 1");
		answer.setDescription("Answer for dummy question 1");
		answer.setQuestion(singleChoiceQuestion);
		answer.setChoice(1L);
		
		correctSingleChoiceAnswerRepository.save(answer);
		
		
		
		
		
	}
	
	// ..................................................
	
	
	static public void obtainDummyMultiChoiceQuestions(MultiChoiceQuestionRepository multiChoiceQuestionRepository, 
			CorrectMultiChoiceAnswerRepository correctMultiChoiceAnswerRepository,
			QuestionListRepository questionListRepository, 
			QuestionRepository questionRepository) {
		
		QuestionList questionList = questionListRepository.findAll().get(0);
		//questionListRepository.save(questionList);
		
		Question question = new Question();
		
		//______________________
		//______________________ question 1
	
		MultiChoiceQuestion multiChoiceQuestion = new MultiChoiceQuestion();
		
		// -----------------------------------
		Map<Long, String> choices = new HashMap<>();
		
		multiChoiceQuestion.setLocal(new Locale("en"));
		multiChoiceQuestion.setName("Multi Question");
		multiChoiceQuestion.setDescription("About continent question");
		
		String body = "Some of these are continents?";
		multiChoiceQuestion.setBody(body);
		
		
		choices.put(1L, "Africa");
		choices.put(2L, "Amerika");
		choices.put(3L, "Russia");
		multiChoiceQuestion.setChoices(choices);

		questionRepository.save(question);
		multiChoiceQuestion.setQuestion(question);
		multiChoiceQuestionRepository.save(multiChoiceQuestion);
		
		questionList.getQuestions().add(question);
		questionListRepository.save(questionList);
		
		//____________________
		//_______________________ answer 1
		CorrectMultiChoiceAnswer answer = new CorrectMultiChoiceAnswer();
		answer.setLocal(new Locale("en"));
		answer.setName("Answer 1");
		answer.setDescription("Answer for dummy question 1");
		answer.setQuestion(multiChoiceQuestion);
		answer.setChoices(Arrays.asList(new Long[]{1L, 2L}));
		correctMultiChoiceAnswerRepository.save(answer);
	
		
		// -------------------------------
		// _______________________ question 2
		multiChoiceQuestion = new MultiChoiceQuestion();
		question = new Question();
		multiChoiceQuestion.setLocal(new Locale("fi"));
		multiChoiceQuestion.setName("vaihtoehto Kysymys");
		multiChoiceQuestion.setDescription("Teko Kysymys maanosista");
		
		body = "Mitä niitä on maanosaia?";
		multiChoiceQuestion.setBody(body);
		
		choices = new HashMap<>();
		choices.put(1L, "Afrikka");
		choices.put(2L, "Amerikka");
		choices.put(3L, "Venäjä");
		multiChoiceQuestion.setChoices(choices);
		
		questionRepository.save(question);
		multiChoiceQuestion.setQuestion(question);
		multiChoiceQuestionRepository.save(multiChoiceQuestion);
		
		questionList.getQuestions().add(question);
		questionListRepository.save(questionList);
		
		//-------------------------
		//__________________ answer 2
			answer = new CorrectMultiChoiceAnswer();
			answer.setLocal(new Locale("fi"));
			answer.setName("Vastaus 2");
			answer.setDescription("Vastaus 2");
			answer.setQuestion(multiChoiceQuestion);
			answer.setChoices(Arrays.asList(new Long[]{1L, 2L}));
			
			correctMultiChoiceAnswerRepository.save(answer);
		
		
		//______________________
		//______________________ question 3	
			
		multiChoiceQuestion = new MultiChoiceQuestion();
		question = new Question();
		multiChoiceQuestion.setLocal(new Locale("ar"));
		multiChoiceQuestion.setName("سؤال متعدد");
		multiChoiceQuestion.setDescription("سؤال عن القارات");
		
		body = "ما هي القارات من الاختيارات";
		multiChoiceQuestion.setBody(body);
		
		choices = new HashMap<>();
		choices.put(1L, "افريقيا");
		choices.put(2L, "امريكا");
		choices.put(3L, "روسيا");
		multiChoiceQuestion.setChoices(choices);
		
		questionRepository.save(question);
		multiChoiceQuestion.setQuestion(question);
		multiChoiceQuestionRepository.save(multiChoiceQuestion);
		
		questionList.getQuestions().add(question);
		questionListRepository.save(questionList);
		
		//-------------------------
		//______________________ answer 3
		answer = new CorrectMultiChoiceAnswer();
		answer.setLocal(new Locale("ar"));
		answer.setName("Vastaus 3");
		answer.setDescription("Vastaus 3");
		answer.setQuestion(multiChoiceQuestion);
		answer.setChoices(Arrays.asList(new Long[]{1L, 2L}));
		correctMultiChoiceAnswerRepository.save(answer);
		//_______________________
		
	
	}

	
	static public void obtainDummySingleChoiceQuestionsToSecondList(SingleChoiceQuestionRepository singleChoiceQuestionRepository,
			CorrectSingleChoiceAnswerRepository correctSingleChoiceAnswerRepository, 
			QuestionListRepository questionListRepository, 
			QuestionRepository questionRepository) {
	
		QuestionList questionList = new QuestionList();
		questionList.setQuestions(new ArrayList<>());
		questionListRepository.save(questionList);
		
		Question question = new Question();
		//__________________________
		//__________________________ Question 1
		SingleChoiceQuestion singleChoiceQuestion = new SingleChoiceQuestion();
		
		// -----------------------------------
	
		Map<Long, String> choices = new HashMap<>();
		
		singleChoiceQuestion.setLocal(new Locale("en"));
		singleChoiceQuestion.setName("Question one");
		singleChoiceQuestion.setDescription("Dummy question");
		
		String body = "What is MayDay?";
		singleChoiceQuestion.setBody(body);
		
		
		choices.put(1L, "call for help");
		choices.put(2L, "first of may");
		choices.put(3L, "labour day");
		singleChoiceQuestion.setChoices(choices);
		
		questionRepository.save(question);
		singleChoiceQuestion.setQuestion(question);
		singleChoiceQuestionRepository.save(singleChoiceQuestion);
		
		questionList.getQuestions().add(question);
		questionListRepository.save(questionList);
		
		
		
		
		//___________________________________
		//___________________________________ Answer 1
		
		CorrectSingleChoiceAnswer  answer = new CorrectSingleChoiceAnswer();
		answer.setLocal(new Locale("en"));
		answer.setName("Answer 1");
		answer.setDescription("Answer for dummy question 1");
		answer.setQuestion(singleChoiceQuestion);
		answer.setChoice(1L);
		
		correctSingleChoiceAnswerRepository.save(answer);
		
		
		
		// -------------------------------
		//________________________________ Question 2
		
		
		singleChoiceQuestion = new SingleChoiceQuestion();
		question = new Question();
		singleChoiceQuestion.setLocal(new Locale("en"));
		singleChoiceQuestion.setName("question to be answered");
		singleChoiceQuestion.setDescription("Description is good");
		
		body = "How many days in the year?";
		singleChoiceQuestion.setBody(body);
		
		choices = new HashMap<>();
		choices.put(1L, "30");
		choices.put(2L, "365");
		choices.put(3L, "24");
		singleChoiceQuestion.setChoices(choices);
		
		questionRepository.save(question);
		singleChoiceQuestion.setQuestion(question);
		singleChoiceQuestionRepository.save(singleChoiceQuestion);
		
		questionList.getQuestions().add(question);
		questionListRepository.save(questionList);
		
	
		
		
		
		
		//-------------------------
		//__________________________ Answer 2
		 answer = new CorrectSingleChoiceAnswer();
		answer.setLocal(new Locale("en"));
		answer.setName("Answer");
		answer.setDescription("Answer Description");
		answer.setQuestion(singleChoiceQuestion);
		answer.setChoice(2L);
		
		correctSingleChoiceAnswerRepository.save(answer);
		
		
	} */

	
	static public void obtainDummyQuestionandAddItToListFromServices_I(SingleChoiceQuestionService singleChoiceQuestionService,
			MultiChoiceQuestionService multiChoiceQuestionService,
			CorrectSingleChoiceAnswerService correctSingleChoiceAnswerService, 
			CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService, 
			QuestionListService questionListService, 
			QuestionService questionService,
			SingleChoiceAnswerService singleChoiceAnswerService,
			CorrectAnswerService correctAnswerService,
			TestService testService) {
		
	
		QuestionList questionList = new QuestionList();
		questionList.setQuestions(new ArrayList<>());
		questionList = questionListService.createList(questionList);
		
		SingleChoiceQuestion singleChoiceQuestion;
		Question question;
		Question tempQuestion;
		Map<Long, String> choices;
		CorrectAnswer correctAnswer; 
		CorrectSingleChoiceAnswer  correctSingleChoiceAnswer;
		SingleChoiceAnswer singleChoiceAnswer;
		MultiChoiceQuestion multiChoiceQuestion;
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer;
		String body;
		
		// -------------------------------
				
		//__________________________
		//__________________________ Question 1
		
		// -----------------------------------
	
		singleChoiceQuestion = new SingleChoiceQuestion();
		choices = new HashMap<>();
		
		singleChoiceQuestion.setLocal(new Locale("en"));
		singleChoiceQuestion.setName("Question one");
		singleChoiceQuestion.setDescription("Dummy question");
		
		body = "What is the capital of Finland?";
		singleChoiceQuestion.setBody(body);
	
		choices.put(1L, "Helsinki");
		choices.put(2L, "Stockholm");
		choices.put(3L, "Turku");
		singleChoiceQuestion.setChoices(choices);
		
		
		// ----- 
		singleChoiceQuestion = singleChoiceQuestionService.saveSingleChoiceQuestion(singleChoiceQuestion);
		question = questionService.createQuestion(singleChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, question);
		
		
		
		
		
		//___________________________________
		//___________________________________ Correct Answer 1
		
		correctSingleChoiceAnswer = new CorrectSingleChoiceAnswer();
		correctSingleChoiceAnswer.setLocal(new Locale("en"));
		correctSingleChoiceAnswer.setName("Answer 1");
		correctSingleChoiceAnswer.setDescription("Answer for dummy question 1");
		correctSingleChoiceAnswer.setChoice(1L);
		correctAnswer = correctAnswerService.createCorrectAnswer(correctSingleChoiceAnswer);
		correctAnswer.setQuestion(question);
		correctAnswerService.saveCorrectAnswer(correctAnswer);
		
		
		//________________________________________________
		
		
		//________________________________ Question 2
		
		
		singleChoiceQuestion = new SingleChoiceQuestion();
		singleChoiceQuestion.setLocal(new Locale("fi"));
		singleChoiceQuestion.setName("Kysymys Yksi");
		singleChoiceQuestion.setDescription("Teko Kysymys");
		
		body = "Mitä on Suomen pääkaupunki?";
		singleChoiceQuestion.setBody(body);
		
		choices = new HashMap<>();
		choices.put(1L, "Helsinki");
		choices.put(2L, "Tokholma");
		choices.put(3L, "Turku");
		singleChoiceQuestion.setChoices(choices);
		
		
		singleChoiceQuestion = singleChoiceQuestionService.saveSingleChoiceQuestion(singleChoiceQuestion);
		question = questionService.createQuestion(singleChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, question);
		
	
		
		
		
		
		//-------------------------
		//__________________________ Correct Answer 2
		 correctSingleChoiceAnswer = new CorrectSingleChoiceAnswer();
		correctSingleChoiceAnswer.setLocal(new Locale("fi"));
		correctSingleChoiceAnswer.setName("Vastaus 2");
		correctSingleChoiceAnswer.setDescription("Vastaus 1");
		correctSingleChoiceAnswer.setChoice(1L);
		
		correctAnswer = correctAnswerService.createCorrectAnswer(correctSingleChoiceAnswer);
		correctAnswer.setQuestion(question);
		correctAnswerService.saveCorrectAnswer(correctAnswer);
		

		
		// ________________________________________
		//______________________ question 3
		
			multiChoiceQuestion = new MultiChoiceQuestion();
			
			// -----------------------------------
			choices = new HashMap<>();
			
			multiChoiceQuestion.setLocal(new Locale("en"));
			multiChoiceQuestion.setName("Multi Question");
			multiChoiceQuestion.setDescription("About continent question");
			
			body = "Some of these are continents?";
			multiChoiceQuestion.setBody(body);
			
			
			choices.put(1L, "Africa");
			choices.put(2L, "Amerika");
			choices.put(3L, "Russia");
			multiChoiceQuestion.setChoices(choices);

			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			question = questionService.createQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, question);
			
			//____________________
			//_______________________ Correct answer 3
			correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("en"));
			correctMultiChoiceAnswer.setName("Answer 1");
			correctMultiChoiceAnswer.setDescription("Answer for dummy question 1");
			correctMultiChoiceAnswer.setChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));
			

			correctAnswer = correctAnswerService.createCorrectAnswer(correctMultiChoiceAnswer);
			correctAnswer.setQuestion(question);
			correctAnswerService.saveCorrectAnswer(correctAnswer);
			
		
			
			
			// -------------------------------
			// _______________________ question 4
			multiChoiceQuestion = new MultiChoiceQuestion();
			question = new Question();
			multiChoiceQuestion.setLocal(new Locale("fi"));
			multiChoiceQuestion.setName("vaihtoehto Kysymys");
			multiChoiceQuestion.setDescription("Teko Kysymys maanosista");
			
			body = "Mitä niitä on maanosaia?";
			multiChoiceQuestion.setBody(body);
			
			choices = new HashMap<>();
			choices.put(1L, "Afrikka");
			choices.put(2L, "Amerikka");
			choices.put(3L, "Venäjä");
			multiChoiceQuestion.setChoices(choices);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			question = questionService.createQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, question);
			
			
			//-------------------------
			//__________________ Correct answer 4
				correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
				correctMultiChoiceAnswer.setLocal(new Locale("fi"));
				correctMultiChoiceAnswer.setName("Vastaus 2");
				correctMultiChoiceAnswer.setDescription("Vastaus 2");
				correctMultiChoiceAnswer .setChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));
				

				correctAnswer = correctAnswerService.createCorrectAnswer(correctMultiChoiceAnswer);
				correctAnswer.setQuestion(question);
				correctAnswerService.saveCorrectAnswer(correctAnswer);
				
			
			
			//______________________
			//______________________ question 5	
				
			multiChoiceQuestion = new MultiChoiceQuestion();
			question = new Question();
			multiChoiceQuestion.setLocal(new Locale("ar"));
			multiChoiceQuestion.setName("سؤال متعدد");
			multiChoiceQuestion.setDescription("سؤال عن القارات");
			
			body = "ما هي القارات من الاختيارات";
			multiChoiceQuestion.setBody(body);
			
			choices = new HashMap<>();
			choices.put(1L, "افريقيا");
			choices.put(2L, "امريكا");
			choices.put(3L, "روسيا");
			
			multiChoiceQuestion.setChoices(choices);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			question = questionService.createQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, question);
			
			//-------------------------
			//______________________ Correct answer 5
			correctMultiChoiceAnswer  = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("ar"));
			correctMultiChoiceAnswer.setName("Vastaus 3");
			correctMultiChoiceAnswer.setDescription("Vastaus 3");
			correctMultiChoiceAnswer.setChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));

			correctAnswer = correctAnswerService.createCorrectAnswer(correctMultiChoiceAnswer);
			correctAnswer.setQuestion(question);
			correctAnswerService.saveCorrectAnswer(correctAnswer);
			
			Test test = new Test();
			test = testService.createTest(test);
			testService.addQuestionList(test, questionList);
			GradeCriteria gradeCriteria = new GradeCriteria();
			gradeCriteria.setOnlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal(true);;
			gradeCriteria.setEveryCorrectSelectionGetsPlus(true);
			gradeCriteria.setPointsPerChoice(1L);
			test = testService.addGradeCriteria(test, gradeCriteria);
			
			
			
			
	}
	
	
	static public void obtainDummyQuestionandAddItToListFromServices_II(SingleChoiceQuestionService singleChoiceQuestionService,
			MultiChoiceQuestionService multiChoiceQuestionService,
			CorrectSingleChoiceAnswerService correctSingleChoiceAnswerService, 
			CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService, 
			QuestionListService questionListService, 
			QuestionService questionService,
			SingleChoiceAnswerService singleChoiceAnswerService,
			CorrectAnswerService correctAnswerService,
			TestService testService) {
		
	
		QuestionList questionList = new QuestionList();
		questionList.setQuestions(new ArrayList<>());
		questionList = questionListService.createList(questionList);
		
		SingleChoiceQuestion singleChoiceQuestion;
		Question question;
		Question tempQuestion;
		Map<Long, String> choices;
		CorrectAnswer correctAnswer; 
		CorrectSingleChoiceAnswer  correctSingleChoiceAnswer;
		SingleChoiceAnswer singleChoiceAnswer;
		MultiChoiceQuestion multiChoiceQuestion;
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer;
		String body;
		
		// -------------------------------
				
		//__________________________
		//__________________________ Question 6
		
		// -----------------------------------
	
		singleChoiceQuestion = new SingleChoiceQuestion();
		choices = new HashMap<>();
		
		singleChoiceQuestion.setLocal(new Locale("en"));
		singleChoiceQuestion.setName("Question one");
		singleChoiceQuestion.setDescription("Dummy question");
		
		body = "What is the capital of Italy?";
		singleChoiceQuestion.setBody(body);
	
		choices.put(1L, "Helsinki");
		choices.put(2L, "Paris");
		choices.put(3L, "Rome");
		singleChoiceQuestion.setChoices(choices);
		
		
		// ----- 
		singleChoiceQuestion = singleChoiceQuestionService.saveSingleChoiceQuestion(singleChoiceQuestion);
		question = questionService.createQuestion(singleChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, question);
		
		
		
		
		
		//___________________________________
		//___________________________________ Correct Answer 6
		
		correctSingleChoiceAnswer = new CorrectSingleChoiceAnswer();
		correctSingleChoiceAnswer.setLocal(new Locale("en"));
		correctSingleChoiceAnswer.setName("Answer 1");
		correctSingleChoiceAnswer.setDescription("Answer for dummy question 1");
		correctSingleChoiceAnswer.setChoice(3L);
		correctAnswer = correctAnswerService.createCorrectAnswer(correctSingleChoiceAnswer);
		correctAnswer.setQuestion(question);
		correctAnswerService.saveCorrectAnswer(correctAnswer);
		
		
		//________________________________________________
		
		
		//________________________________ Question 7
		
		
		singleChoiceQuestion = new SingleChoiceQuestion();
		singleChoiceQuestion.setLocal(new Locale("fi"));
		singleChoiceQuestion.setName("Kysymys Yksi");
		singleChoiceQuestion.setDescription("Teko Kysymys");
		
		body = "Mitä on Viron pääkaupunki?";
		singleChoiceQuestion.setBody(body);
		
		choices = new HashMap<>();
		choices.put(1L, "London");
		choices.put(2L, "Tallin");
		choices.put(3L, "Oslo");
		singleChoiceQuestion.setChoices(choices);
		
		
		singleChoiceQuestion = singleChoiceQuestionService.saveSingleChoiceQuestion(singleChoiceQuestion);
		question = questionService.createQuestion(singleChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, question);
		
	
		
		
		
		
		//-------------------------
		//__________________________Correct  Answer 7
		 correctSingleChoiceAnswer = new CorrectSingleChoiceAnswer();
		correctSingleChoiceAnswer.setLocal(new Locale("fi"));
		correctSingleChoiceAnswer.setName("Vastaus 2");
		correctSingleChoiceAnswer.setDescription("Vastaus 1");
		correctSingleChoiceAnswer.setChoice(1L);
		
		correctAnswer = correctAnswerService.createCorrectAnswer(correctSingleChoiceAnswer);
		correctAnswer.setQuestion(question);
		correctAnswerService.saveCorrectAnswer(correctAnswer);
		

		
		// ________________________________________
		//__________________________________________ question 8
		
			multiChoiceQuestion = new MultiChoiceQuestion();
			
			// -----------------------------------
			choices = new HashMap<>();
			
			multiChoiceQuestion.setLocal(new Locale("en"));
			multiChoiceQuestion.setName("Multi Question");
			multiChoiceQuestion.setDescription("About continent question");
			
			body = "Some of these are continents?";
			multiChoiceQuestion.setBody(body);
			
			
			choices.put(1L, "Africa");
			choices.put(2L, "Amerika");
			choices.put(3L, "Russia");
			multiChoiceQuestion.setChoices(choices);

			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			question = questionService.createQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, question);
			
			//____________________
			//_______________________ Correct answer 8
			correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("en"));
			correctMultiChoiceAnswer.setName("Answer 1");
			correctMultiChoiceAnswer.setDescription("Answer for dummy question 1");
			correctMultiChoiceAnswer.setChoices(Arrays.asList(new Long[]{1L, 2L}));
			

			correctAnswer = correctAnswerService.createCorrectAnswer(correctMultiChoiceAnswer);
			correctAnswer.setQuestion(question);
			correctAnswerService.saveCorrectAnswer(correctAnswer);
			
		
			
			
			// -------------------------------
			// _______________________ question 9
			multiChoiceQuestion = new MultiChoiceQuestion();
			question = new Question();
			multiChoiceQuestion.setLocal(new Locale("fi"));
			multiChoiceQuestion.setName("vaihtoehto Kysymys");
			multiChoiceQuestion.setDescription("Teko Kysymys maanosista");
			
			body = "Mitä niitä on maanosaia?";
			multiChoiceQuestion.setBody(body);
			
			choices = new HashMap<>();
			choices.put(1L, "Afrikka");
			choices.put(2L, "Amerikka");
			choices.put(3L, "Venäjä");
			multiChoiceQuestion.setChoices(choices);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			question = questionService.createQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, question);
			
			
			//-------------------------
			//__________________ _____________ correct answer 9
				correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
				correctMultiChoiceAnswer.setLocal(new Locale("fi"));
				correctMultiChoiceAnswer.setName("Vastaus 2");
				correctMultiChoiceAnswer.setDescription("Vastaus 2");
				correctMultiChoiceAnswer .setChoices(Arrays.asList(new Long[]{1L, 2L}));
				

				correctAnswer = correctAnswerService.createCorrectAnswer(correctMultiChoiceAnswer);
				correctAnswer.setQuestion(question);
				correctAnswerService.saveCorrectAnswer(correctAnswer);
				
			
			
			//______________________
			//______________________ question 10
				
			multiChoiceQuestion = new MultiChoiceQuestion();
			question = new Question();
			multiChoiceQuestion.setLocal(new Locale("ar"));
			multiChoiceQuestion.setName("سؤال متعدد");
			multiChoiceQuestion.setDescription("سؤال عن القارات");
			
			body = "ما هي القارات من الاختيارات";
			multiChoiceQuestion.setBody(body);
			
			choices = new HashMap<>();
			choices.put(1L, "افريقيا");
			choices.put(2L, "امريكا");
			choices.put(3L, "روسيا");
			multiChoiceQuestion.setChoices(choices);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			question = questionService.createQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, question);
			
			//-------------------------
			//______________________ correct answer 10
			correctMultiChoiceAnswer  = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("ar"));
			correctMultiChoiceAnswer.setName("Vastaus 3");
			correctMultiChoiceAnswer.setDescription("Vastaus 3");
			correctMultiChoiceAnswer.setChoices(Arrays.asList(new Long[]{1L, 2L}));

			correctAnswer = correctAnswerService.createCorrectAnswer(correctMultiChoiceAnswer);
			correctAnswer.setQuestion(question);
			correctAnswerService.saveCorrectAnswer(correctAnswer);
			
			Test test = testService.createTest(new Test());
			testService.addQuestionList(test, questionList);
			GradeCriteria gradeCriteria = new GradeCriteria();
			gradeCriteria.setOnlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal(true);
			gradeCriteria.setEveryCorrectSelectionGetsPlus(true);
			gradeCriteria.setPointsPerChoice(1L);
			testService.addGradeCriteria(test, gradeCriteria);		
	}
	
	public static void answerTest(SingleChoiceQuestionService singleChoiceQuestionService,
			MultiChoiceQuestionService multiChoiceQuestionService,
			CorrectSingleChoiceAnswerService correctSingleChoiceAnswerService, 
			CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService, 
			QuestionListService questionListService, 
			QuestionService questionService,
			SingleChoiceAnswerService singleChoiceAnswerService,
			CorrectAnswerService correctAnswerService,
			TestService testService,
			AnswerService answerService,
			TestResponseService testResponseService,
			AnswerListService answerListService,
			AssessmentHandler assessmentService,
			GradeService gradeService) {
		
		List<Test> tests; 
		AnswerList answerList = new AnswerList();
		List<Answer> answers = new ArrayList<>();
		Answer answer;
		QuestionList questionList = new QuestionList();	
		
		SingleChoiceQuestion singleChoiceQuestion;
		Question question;
		Question tempQuestion;
		Map<Long, String> choices;
		CorrectSingleChoiceAnswer  correctSingleChoiceAnswer;
		SingleChoiceAnswer singleChoiceAnswer;
		MultiChoiceAnswer multiChoiceAnswer;
		
		
			tests = testService.getTests();
			questionList = tests.get(0).getQuestionList();
			
			singleChoiceAnswer = new SingleChoiceAnswer();
			singleChoiceAnswer.setChoice(2L);
			
			
			answer = answerService.createAnswer(singleChoiceAnswer);
			answer.setQuestion(questionList.getQuestions().get(0));
			answer = answerService.saveAnswer(answer);
			answers.add(answer);
			
			singleChoiceAnswer = new SingleChoiceAnswer();
			singleChoiceAnswer.setChoice(1L);
			answer = answerService.createAnswer(singleChoiceAnswer);
			answer.setQuestion(questionList.getQuestions().get(1));
			answer = answerService.saveAnswer(answer);
			answers.add(answer);
			
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {1L, 0L, 0L}));
			answer = answerService.createAnswer(multiChoiceAnswer);
			answer.setQuestion(questionList.getQuestions().get(2));
			answer = answerService.saveAnswer(answer);
			answers.add(answer);
			
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {1L, 1L, 1L}));
			answer = answerService.createAnswer(multiChoiceAnswer);
			answer.setQuestion(questionList.getQuestions().get(3));
			answer = answerService.saveAnswer(answer);
			answers.add(answer);
			
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {0L, 1L, 1L}));
			answer = answerService.createAnswer(multiChoiceAnswer);
			answer.setQuestion(questionList.getQuestions().get(4));
			answer = answerService.saveAnswer(answer);
			answers.add(answer);
			
			answerList = answerListService.cteateList(answerList);
			answerList.setAnswers(answers);
			answerList = answerListService.cteateList(answerList);
			
			TestResponse testResponse = new TestResponse();
			testResponse = testResponseService.saveTestResponse(testResponse);
			testResponseService.addAnswerList(testResponse, answerList);
			testResponse.setTestId(tests.get(0).getId());
			testResponse = testResponseService.saveTestResponse(testResponse);
			
			Grade grade = assessmentService.grade(testResponse);
			gradeService.saveGrade(grade);
			
	}
	
	
}
