package com.kaukajarvisoft.tas.dummydata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.kaukajarvisoft.tas.answers.Answer;
import com.kaukajarvisoft.tas.answers.CorrectMultiChoiceAnswer;
import com.kaukajarvisoft.tas.answers.MultiChoiceAnswer;
import com.kaukajarvisoft.tas.assesment.AssessmentHandler;
import com.kaukajarvisoft.tas.questionlist.QuestionList;
import com.kaukajarvisoft.tas.questions.MultiChoiceQuestion;
import com.kaukajarvisoft.tas.questions.Question;
import com.kaukajarvisoft.tas.questions.QuestionTypes;
import com.kaukajarvisoft.tas.repositories.CorrectMultiChoiceAnswerRepository;
import com.kaukajarvisoft.tas.repositories.MultiChoiceQuestionRepository;
import com.kaukajarvisoft.tas.repositories.QuestionListRepository;
import com.kaukajarvisoft.tas.repositories.QuestionRepository;
import com.kaukajarvisoft.tas.services.CorrectMultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.GradeService;
import com.kaukajarvisoft.tas.services.MultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.MultiChoiceQuestionService;
import com.kaukajarvisoft.tas.services.QuestionListService;
import com.kaukajarvisoft.tas.services.QuestionService;
import com.kaukajarvisoft.tas.services.TestResponseService;
import com.kaukajarvisoft.tas.services.TestService;
import com.kaukajarvisoft.tas.tests.Grade;
import com.kaukajarvisoft.tas.tests.GradeCriteria;
import com.kaukajarvisoft.tas.tests.Test;
import com.kaukajarvisoft.tas.tests.TestResponse;
import com.kaukajarvisoft.tas.tests.Tests;

public class DummyData {

	
	static public void populateData(
			QuestionListService questionListService,
			MultiChoiceQuestionService multiChoiceQuestionService,
			MultiChoiceAnswerService multiChoiceAnswerService,
			CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService,
			TestService testService,
			TestResponseService testResponseService,
			AssessmentHandler assessmentService,
			GradeService gradeService
			) { 
	//	obtainDummySingleChoiceQuestions(singleChoiceQuestionRepository,correctSingleChoiceAnswerRepository, questionListRepository,questionRepository);
	//	obtainDummyMultiChoiceQuestions(multiChoiceQuestionRepository, correctMultiChoiceAnswerRepository, questionListRepository,questionRepository);
	//	obtainDummySingleChoiceQuestionsToSecondList(singleChoiceQuestionRepository, correctSingleChoiceAnswerRepository, questionListRepository, questionRepository);
		obtainDummyQuestionandAddItToListFromServices_I(
				multiChoiceQuestionService,
				correctMultiChoiceAnswerService,
				questionListService, 
				testService); 
	
	
	obtainDummyQuestionandAddItToListFromServices_II(
			multiChoiceQuestionService,
			correctMultiChoiceAnswerService,
			questionListService, 
			testService); 
	
	/* answerTest(multiChoiceQuestionService, 
			questionListService, 
			testService,
			testResponseService,
			multiChoiceAnswerService,
			assessmentService,
			gradeService); */
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
				singleChoiceQuestion.setOptions(choices);
				
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
		singleChoiceQuestion.setOptions(choices);
		
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
		multiChoiceQuestion.setOptions(choices);

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
		multiChoiceQuestion.setOptions(choices);
		
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
		multiChoiceQuestion.setOptions(choices);
		
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
		singleChoiceQuestion.setOptions(choices);
		
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
		singleChoiceQuestion.setOptions(choices);
		
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

	
	static public void obtainDummyQuestionandAddItToListFromServices_I(MultiChoiceQuestionService multiChoiceQuestionService,
			CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService, 
			QuestionListService questionListService, 
			TestService testService) {
		
	
		QuestionList questionList = new QuestionList();
		questionList.setName("First qestion list");
		questionList.setQuestions(new ArrayList<>());
		questionList = questionListService.createList(questionList);
		
		List<String> options;
		MultiChoiceQuestion multiChoiceQuestion = new MultiChoiceQuestion() ;
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
		
		String body;
		
		// -------------------------------
				
		//__________________________
		//__________________________ Question 1
		
		// -----------------------------------
	
		options = new ArrayList<>();
		
		multiChoiceQuestion.setLocal(new Locale("en"));
		multiChoiceQuestion.setName("Question one");
		multiChoiceQuestion.setDescription("Dummy question");
		multiChoiceQuestion.setType(QuestionTypes.SINGLE_SELECT_MULTI_CHOICE);
		
		body = "What is the capital of Finland?";
		multiChoiceQuestion.setBody(body);
	
		options.add("Helsinki");
		options.add("Stockholm");
		options.add("Turku");
		multiChoiceQuestion.setOptions(options);
		
		
		// ----- 
		multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
		
		
		
		
		
		//___________________________________
		//___________________________________ Correct Answer 1
		
		correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
		correctMultiChoiceAnswer.setLocal(new Locale("en"));
		correctMultiChoiceAnswer.setName("Answer 1");
		correctMultiChoiceAnswer.setDescription("Answer for dummy question 1");
		correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[] {1L, 0L, 0L}));
		
		
		correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
		correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
		
		
		//________________________________________________
		
		
		//________________________________ Question 2
		
		
		multiChoiceQuestion = new MultiChoiceQuestion();
		multiChoiceQuestion.setLocal(new Locale("fi"));
		multiChoiceQuestion.setName("Kysymys Yksi");
		multiChoiceQuestion.setDescription("Teko Kysymys");
		multiChoiceQuestion.setType(QuestionTypes.SINGLE_SELECT_MULTI_CHOICE);
		
		body = "Mitä on Suomen pääkaupunki?";
		multiChoiceQuestion.setBody(body);
		
		options = new ArrayList<>();
		options.add("Helsinki");
		options.add("Tokholma");
		options.add("Turku");
		multiChoiceQuestion.setOptions(options);
		
		
		multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
		
	
		
		
		
		
		//-------------------------
		//__________________________ Correct Answer 2
		 correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
		correctMultiChoiceAnswer.setLocal(new Locale("fi"));
		correctMultiChoiceAnswer.setName("Vastaus 2");
		correctMultiChoiceAnswer.setDescription("Vastaus 1");
		correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[] {1L, 0L, 0L}));
		
		correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
		correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
		

		
		// ________________________________________
		//______________________ question 3
		
			multiChoiceQuestion = new MultiChoiceQuestion();
			
			// -----------------------------------
			options = new ArrayList<>();
			multiChoiceQuestion.setLocal(new Locale("en"));
			multiChoiceQuestion.setName("Multi Question");
			multiChoiceQuestion.setDescription("About continent question");
			multiChoiceQuestion.setType(QuestionTypes.MULTI_SELECT_MULTI_CHOICE);
			
			body = "Some of these are continents?";
			multiChoiceQuestion.setBody(body);
			
			
			options.add("Africa");
			options.add("Amerika");
			options.add("Russia");
			multiChoiceQuestion.setOptions(options);

			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
			
			//____________________
			//_______________________ Correct answer 3
			correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("en"));
			correctMultiChoiceAnswer.setName("Answer 1");
			correctMultiChoiceAnswer.setDescription("Answer for dummy question 1");
			correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));
			

			correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
			correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
			
		
			
			
			// -------------------------------
			// _______________________ question 4
			multiChoiceQuestion = new MultiChoiceQuestion();
			multiChoiceQuestion.setLocal(new Locale("fi"));
			multiChoiceQuestion.setName("vaihtoehto Kysymys");
			multiChoiceQuestion.setDescription("Teko Kysymys maanosista");
			multiChoiceQuestion.setType(QuestionTypes.MULTI_SELECT_MULTI_CHOICE);
			
			body = "Mitä niitä on maanosaia?";
			multiChoiceQuestion.setBody(body);
			
			options = new ArrayList<>();
			options.add("Afrikka");
			options.add("Amerikka");
			options.add("Venäjä");
			multiChoiceQuestion.setOptions(options);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
			
			
			//-------------------------
			//__________________ Correct answer 4
				correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
				correctMultiChoiceAnswer.setLocal(new Locale("fi"));
				correctMultiChoiceAnswer.setName("Vastaus 2");
				correctMultiChoiceAnswer.setDescription("Vastaus 2");
				correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));
				

				correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
				correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
				
			
			/*
			//______________________
			//______________________ question 5	
				
			multiChoiceQuestion = new MultiChoiceQuestion();
			multiChoiceQuestion.setLocal(new Locale("ar"));
			multiChoiceQuestion.setName("سؤال متعدد");
			multiChoiceQuestion.setDescription("سؤال عن القارات");
			multiChoiceQuestion.setType(QuestionTypes.MULTI_SELECT_MULTI_CHOICE);
			
			body = "ما هي القارات من الاختيارات";
			multiChoiceQuestion.setBody(body);
			
			options = new ArrayList<>();
			options.add("افريقيا");
			options.add("امريكا");
			options.add("روسيا");
			
			multiChoiceQuestion.setOptions(options);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
			
			//-------------------------
			//______________________ Correct answer 5
			correctMultiChoiceAnswer  = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("ar"));
			correctMultiChoiceAnswer.setName("Vastaus 3");
			correctMultiChoiceAnswer.setDescription("Vastaus 3");
			correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));

			correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
			correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);*/
			
			Test test = new Test();
			test = testService.createTest(test);
			testService.addQuestionList(test, questionList);
			GradeCriteria gradeCriteria = new GradeCriteria();
			gradeCriteria.setOnlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal(true);;
			gradeCriteria.setEveryCorrectSelectionGetsPlus(true);
			gradeCriteria.setPointsPerChoice(1L);
			test = testService.addGradeCriteria(test, gradeCriteria);
			
			
		
			
	}
	
	
	static public void obtainDummyQuestionandAddItToListFromServices_II(MultiChoiceQuestionService multiChoiceQuestionService,
			CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService, 
			QuestionListService questionListService, 
			TestService testService) {
		
	
		QuestionList questionList = new QuestionList();
		questionList.setName("Second qestion list");
		questionList.setQuestions(new ArrayList<>());
		questionList = questionListService.createList(questionList);
		
		List<String> options;
		MultiChoiceQuestion multiChoiceQuestion;
		CorrectMultiChoiceAnswer correctMultiChoiceAnswer;
		String body;
		
		// -------------------------------
				
		//__________________________
		//__________________________ Question 6
		
		// -----------------------------------
	
		multiChoiceQuestion = new MultiChoiceQuestion();
		options = new ArrayList<>();
		
		multiChoiceQuestion.setLocal(new Locale("en"));
		multiChoiceQuestion.setName("Question one");
		multiChoiceQuestion.setDescription("Dummy question");
		multiChoiceQuestion.setType(QuestionTypes.SINGLE_SELECT_MULTI_CHOICE);
		
		body = "What is the capital of Italy?";
		multiChoiceQuestion.setBody(body);
	
		options.add("Helsinki");
		options.add("Paris");
		options.add("Rome");
		multiChoiceQuestion.setOptions(options);
		
		
		// ----- 
		multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
		
		
		
		
		//___________________________________
		//___________________________________ Correct Answer 6
		
		correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
		correctMultiChoiceAnswer.setLocal(new Locale("en"));
		correctMultiChoiceAnswer.setName("Answer 1");
		correctMultiChoiceAnswer.setDescription("Answer for dummy question 1");
		correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[] {0L, 0L, 1L}));
		
		
		correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
		correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
		
		
		//________________________________________________
		
		
		//________________________________ Question 7
		
		
		multiChoiceQuestion = new MultiChoiceQuestion();
		multiChoiceQuestion.setLocal(new Locale("fi"));
		multiChoiceQuestion.setName("Kysymys Yksi");
		multiChoiceQuestion.setDescription("Teko Kysymys");
		multiChoiceQuestion.setType(QuestionTypes.SINGLE_SELECT_MULTI_CHOICE);
		
		body = "Mitä on Viron pääkaupunki?";
		multiChoiceQuestion.setBody(body);
		
		options = new ArrayList<>();
		options.add("London");
		options.add("Tallin");
		options.add("Oslo");
		multiChoiceQuestion.setOptions(options);
		
		
		multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
		questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
		
	
		
		
		
		
		//-------------------------
		//__________________________Correct  Answer 7
		 correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
		correctMultiChoiceAnswer.setLocal(new Locale("fi"));
		correctMultiChoiceAnswer.setName("Vastaus 2");
		correctMultiChoiceAnswer.setDescription("Vastaus 1");
		correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[] {0L, 1L, 0L}));
		
		correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
		correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
		

		
		// ________________________________________
		//__________________________________________ question 8
		
			multiChoiceQuestion = new MultiChoiceQuestion();
			
			// -----------------------------------
			options = new ArrayList<>();
			
			multiChoiceQuestion.setLocal(new Locale("en"));
			multiChoiceQuestion.setName("Multi Question");
			multiChoiceQuestion.setDescription("About continent question");
			multiChoiceQuestion.setType(QuestionTypes.MULTI_SELECT_MULTI_CHOICE);
			
			body = "Some of these are continents?";
			multiChoiceQuestion.setBody(body);
			
			
			options.add("Africa");
			options.add("Amerika");
			options.add("Russia");
			multiChoiceQuestion.setOptions(options);

			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
			//____________________
			//_______________________ Correct answer 8
			correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("en"));
			correctMultiChoiceAnswer.setName("Answer 1");
			correctMultiChoiceAnswer.setDescription("Answer for dummy question 1");
			correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));
			

			correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
			correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
			
		
			
			
			// -------------------------------
			// _______________________ question 9
			multiChoiceQuestion = new MultiChoiceQuestion();
			multiChoiceQuestion.setLocal(new Locale("fi"));
			multiChoiceQuestion.setName("vaihtoehto Kysymys");
			multiChoiceQuestion.setDescription("Teko Kysymys maanosista");
			multiChoiceQuestion.setType(QuestionTypes.MULTI_SELECT_MULTI_CHOICE);
			
			body = "Mitä niitä on maanosaia?";
			multiChoiceQuestion.setBody(body);
			
			options = new ArrayList<>();
			options.add("Afrikka");
			options.add("Amerikka");
			options.add("Venäjä");
			multiChoiceQuestion.setOptions(options);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
			
			
			//-------------------------
			//__________________ _____________ correct answer 9
				correctMultiChoiceAnswer = new CorrectMultiChoiceAnswer();
				correctMultiChoiceAnswer.setLocal(new Locale("fi"));
				correctMultiChoiceAnswer.setName("Vastaus 2");
				correctMultiChoiceAnswer.setDescription("Vastaus 2");
				correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));
				

				correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
				correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
				
			
			
			//______________________
			//______________________ question 10
				
			multiChoiceQuestion = new MultiChoiceQuestion();
			multiChoiceQuestion.setLocal(new Locale("fi"));
			multiChoiceQuestion.setName("سؤال متعدد");
			multiChoiceQuestion.setDescription("سؤال عن القارات");
			multiChoiceQuestion.setType(QuestionTypes.MULTI_SELECT_MULTI_CHOICE);
			
			body = "ما هي القارات من الاختيارات";
			multiChoiceQuestion.setBody(body);
			
			options = new ArrayList<>();
			options.add("افريقيا");
			options.add("امريكا");
			options.add("روسيا");
			multiChoiceQuestion.setOptions(options);
			
			multiChoiceQuestion = multiChoiceQuestionService.saveMultiChoiceQuestion(multiChoiceQuestion);
			questionListService.addQuestionToQuestionList(questionList, multiChoiceQuestion);
			
			//-------------------------
			//______________________ correct answer 10
			correctMultiChoiceAnswer  = new CorrectMultiChoiceAnswer();
			correctMultiChoiceAnswer.setLocal(new Locale("fi"));
			correctMultiChoiceAnswer.setName("Vastaus 3");
			correctMultiChoiceAnswer.setDescription("Vastaus 3");
			correctMultiChoiceAnswer.setCorrectChoices(Arrays.asList(new Long[]{1L, 1L, 0L}));

			correctMultiChoiceAnswer.setQuestion(multiChoiceQuestion);
			correctMultiChoiceAnswerService.saveCorrectMultiChoiceAnswer(correctMultiChoiceAnswer);
			
			Test test = testService.createTest(new Test());
			testService.addQuestionList(test, questionList);
			GradeCriteria gradeCriteria = new GradeCriteria();
			gradeCriteria.setOnlyCorrectChoicesInMultiChoiceQuestionGetsPointInTotal(true);
			gradeCriteria.setEveryCorrectSelectionGetsPlus(true);
			gradeCriteria.setPointsPerChoice(1L);
			testService.addGradeCriteria(test, gradeCriteria);	
			
	}
	
	public static void answerTest(MultiChoiceQuestionService multiChoiceQuestionService,
			QuestionListService questionListService, 
			TestService testService,
			TestResponseService testResponseService,
			MultiChoiceAnswerService multiChoiceAnswerService,
			AssessmentHandler assessmentService,
			GradeService gradeService) {
		
		
		Tests tests; 
		List<Answer> answers = new ArrayList<>();
		QuestionList questionList = new QuestionList();	
		Question question;
	
		MultiChoiceAnswer multiChoiceAnswer;
		
		
			tests = testService.getTests();
			questionList = tests.getTests().get(0).getQuestionList();
			question = questionList.getQuestions().get(0);
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setQuestion(question);
			multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {1L, 0L, 1L}));
			multiChoiceAnswerService.saveMultiChoiceAnswer(multiChoiceAnswer);
			answers.add(multiChoiceAnswer);
			
			
			question = questionList.getQuestions().get(1);
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setQuestion(question);multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {1L, 0L, 1L}));
			multiChoiceAnswerService.saveMultiChoiceAnswer(multiChoiceAnswer);
			answers.add(multiChoiceAnswer);
			
			question = questionList.getQuestions().get(2);
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setQuestion(question);multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {1L, 0L, 0L}));
			multiChoiceAnswerService.saveMultiChoiceAnswer(multiChoiceAnswer);
			answers.add(multiChoiceAnswer);
			
			question = questionList.getQuestions().get(3);
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setQuestion(question);multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {1L, 1L, 1L}));
			multiChoiceAnswerService.saveMultiChoiceAnswer(multiChoiceAnswer);
			answers.add(multiChoiceAnswer);
			
			question = questionList.getQuestions().get(4);
			multiChoiceAnswer = new MultiChoiceAnswer();
			multiChoiceAnswer.setQuestion(question);multiChoiceAnswer.setChoices(Arrays.asList(new Long[] {0L, 1L, 1L}));
			multiChoiceAnswerService.saveMultiChoiceAnswer(multiChoiceAnswer);
			answers.add(multiChoiceAnswer);
			
			
			TestResponse testResponse = new TestResponse();
			testResponse.setAnswers(answers);
			testResponse = testResponseService.saveTestResponse(testResponse);
			testResponse.setTestId(tests.getTests().get(0).getId());
			testResponse = testResponseService.saveTestResponse(testResponse);
			
			//Grade grade = assessmentService.grade(testResponse);
			//gradeService.saveGrade(grade);
			
			
			
	}
	
	
}
