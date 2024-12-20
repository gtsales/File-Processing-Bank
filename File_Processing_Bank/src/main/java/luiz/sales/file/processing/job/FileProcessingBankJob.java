package luiz.sales.file.processing.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class FileProcessingBankJob {

	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Bean
	Job fileProcessingJob (Step fileProcessingStep) {
		
		return jobBuilderFactory
				.get("fileProcessingJob")
				.start(fileProcessingStep)
				.incrementer(new RunIdIncrementer())
				.build();
				
	}
}
