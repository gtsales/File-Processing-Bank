package luiz.sales.file.processing.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import luiz.sales.file.processing.dto.CustomerRequest;

@Configuration
public class FileProcessingBankWriter {

	@Bean
	public ItemWriter<CustomerRequest> FileProcessingWriter() {
		
		return items -> items.forEach(System.out::println);
	}
}
