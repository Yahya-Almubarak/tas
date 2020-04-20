package com.kaukajarvisoft.tas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.kaukajarvisoft.tas.assesment.AssessmentHandler;
import com.kaukajarvisoft.tas.dummydata.DummyData;
import com.kaukajarvisoft.tas.questions.QuestionList;
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

@EnableAutoConfiguration
@ComponentScan ({"com.kaukajarvisoft.tas", "com.kaukajarvisoft.tas.services","com.kaukajarvisoft.tas.repositories"})
@SpringBootApplication
public class TasApplication {


	public static void main(String[] args) {
		SpringApplication.run(TasApplication.class, args);
	}
		@Bean
		public CommandLineRunner demo(
				SingleChoiceQuestionRepository singleChoiceQuestionRepository, 
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
				GradeService gradeService) {
			
			return (args) -> {
				DummyData.populateData(singleChoiceQuestionRepository, 
						multiChoiceQuestionRepository, 
						correctSingleChoiceAnswerRepository,  
						correctMultiChoiceAnswerRepository, 
						questionListRepository, 
						questionRepository,
						questionListService,
						questionService,
						singleChoiceQuestionService,
						multiChoiceQuestionService,
						correctSingleChoiceAnswerService,
						correctMultiChoiceAnswerService,
						singleChoiceAnswerService,
						correctAnswerService,
						testService,
						answerService, 
						testResponseService,
						answerListService,
						assessmentService,
						gradeService);
			//	correctSingleChoiceAnswerRepository.saveAll(DummyData.obtainDummySingleChoiceQuestions().getAnswers());
			//	singleChoiceQuestionRepository.saveAll(DummyData.obtainDummySingleChoiceQuestions().getQuestions());
			//	multiChoiceQuestionRepository.saveAll(DummyData.obtainDummyMultiChoiceQuestions().getQuestions());
			//	correctMultiChoiceAnswerRepository.saveAll(DummyData.obtainDummyMultiChoiceQuestions().getAnswers());
			
				
			};
		
	}

}
