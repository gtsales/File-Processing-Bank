package luiz.sales.file.processing.reader;

import java.io.IOException;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import luiz.sales.file.processing.dto.CustomerRequest;

@Configuration
public class FileProcessingBankReader {

	@Value("${file.processing.bank-path}")
	private String filePath;
	
	@StepScope
	@Bean
	public FlatFileItemReader<CustomerRequest> fileProcessingReader (){
		
		Resource file = getFileResource(filePath);
		
		return new FlatFileItemReaderBuilder<CustomerRequest>()
				.name("fileProcessingReader")
				.resource(file)
				.linesToSkip(1)
				.delimited()
				.delimiter(",")
				.names("Name", "Last Name", "Score", "CPF", "Amount")
				.targetType(CustomerRequest.class)
				.build();
	}
	
    private FileSystemResource getFileResource(String path) {
    	
        try {
        	
            return new FileSystemResource(ResourceUtils.getFile(path));
        } catch (IOException e) {
        	
            throw new RuntimeException(e);
        }
    }
}
