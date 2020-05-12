package com.kaukajarvisoft.tas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.kaukajarvisoft.tas.assesment.AssessmentHandler;
import com.kaukajarvisoft.tas.dummydata.DummyData;
import com.kaukajarvisoft.tas.services.CorrectMultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.GradeService;
import com.kaukajarvisoft.tas.services.MultiChoiceAnswerService;
import com.kaukajarvisoft.tas.services.MultiChoiceQuestionService;
import com.kaukajarvisoft.tas.services.QuestionListService;
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
				QuestionListService questionListService,
				MultiChoiceQuestionService multiChoiceQuestionService,
				MultiChoiceAnswerService multiChoiceAnswerService,
				CorrectMultiChoiceAnswerService correctMultiChoiceAnswerService,
				TestService testService,
				TestResponseService testResponseService,
				AssessmentHandler assessmentService,
				GradeService gradeService) {
			
			return (args) -> {
				DummyData.populateData(
						questionListService,
						multiChoiceQuestionService,
						multiChoiceAnswerService,
						correctMultiChoiceAnswerService,
						testService,
						testResponseService,
						assessmentService,
						gradeService);				
			};
	}

}
