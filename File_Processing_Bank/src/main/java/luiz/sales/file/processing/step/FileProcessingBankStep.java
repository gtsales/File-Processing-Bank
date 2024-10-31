package luiz.sales.file.processing.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import luiz.sales.file.processing.dto.CustomerRequest;
import luiz.sales.file.processing.reader.FileProcessingBankReader;
import luiz.sales.file.processing.writer.FileProcessingBankWriter;

@Configuration
public class FileProcessingBankStep {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	FileProcessingBankWriter fileProcessingBankWriter;
	
	@Autowired
	FileProcessingBankReader fileProcessingBankReader;
	
	@Bean
	public Step fileProcessingStep() {
		
		return stepBuilderFactory
				.get("fileProcessingStep")
				.<CustomerRequest, CustomerRequest>chunk(5)
				.reader(fileProcessingBankReader.fileProcessingReader())
				.writer(fileProcessingWriter())
				.build();
	}
	
	@Bean("fileProcessingWriter")
	public FileProcessingBankWriter fileProcessingWriter() {
		return new FileProcessingBankWriter();
	}
}
