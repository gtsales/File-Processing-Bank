package luiz.sales.file.processing.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import luiz.sales.file.processing.dto.CustomerRequest;

@Configuration
public class FileProcessingBankStep {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step fileProcessingStep(ItemReader<CustomerRequest> fileReader, ItemWriter<CustomerRequest> fileWriter) {
		
		return stepBuilderFactory
				.get("fileProcessingStep")
				.<CustomerRequest, CustomerRequest>chunk(5)
				.reader(fileReader)
				.writer(fileWriter)
				.build();
	}
}
