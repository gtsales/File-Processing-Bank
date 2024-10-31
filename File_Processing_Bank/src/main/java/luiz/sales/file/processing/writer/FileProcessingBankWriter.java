package luiz.sales.file.processing.writer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import luiz.sales.file.processing.dto.CustomerRequest;
import luiz.sales.file.processing.model.Customer;
import luiz.sales.file.processing.service.RegisterCustomer;
import luiz.sales.file.processing.utils.ConvertDtoToModel;

@Configuration
public class FileProcessingBankWriter implements ItemWriter<CustomerRequest>{

	@Autowired
	ConvertDtoToModel convertDtoToModel;
	
	@Autowired
	RegisterCustomer registerCustomer;
	
	@Override
	public void write(List<? extends CustomerRequest> items) throws Exception {
		
		List<Customer> customerList = new ArrayList<>();
		Customer customer = null;
		
		for (CustomerRequest customerRequest : items) {
			
			customer = convertDtoToModel.convertToCustomer(customerRequest);
			
			customerList.add(customer);
		}
		
		registerCustomer.saveAllBulkOperation(customerList);
	}
}
