package luiz.sales.file.processing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.BulkOperationException;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.stereotype.Service;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoNodeIsRecoveringException;
import com.mongodb.MongoSocketReadException;
import com.mongodb.MongoWriteException;

import lombok.extern.slf4j.Slf4j;
import luiz.sales.file.processing.dto.CustomerRequest;
import luiz.sales.file.processing.model.Customer;
import luiz.sales.file.processing.repository.CustomerRepository;
import luiz.sales.file.processing.utils.ConvertDtoToModel;

@Service
@Slf4j
public class RegisterCustomer {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ConvertDtoToModel convertDtoToModel;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void registerCustomer(CustomerRequest customerRequest) {
		
		Customer customer = new Customer();
		customer = convertDtoToModel.convertToCustomer(customerRequest);
		
		try {
			
			customerRepository.insert(customer);
		} catch (DuplicateKeyException | MongoWriteException e) {
			
			log.error("Duplicate key, customer {} will not be save", customer.getCpf());
		} catch (Exception e ) {
			
			log.error("There is a problem whe trying to register this [{}] customer !!!", customer.getCpf());
		}
	}
	
	public void saveAllBulkOperation(List<Customer> items) {
		
		BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkMode.UNORDERED, Customer.class);
		
		try {
			
			bulkOperations.insert(items);
			bulkOperations.execute();
		} catch (BulkOperationException e) {
			
			log.error("An error occurred while inserting customer. ERROR [{}]", e.getMessage());
		} catch (MongoSocketReadException | MongoNodeIsRecoveringException e) {
			
			log.error("An error occurred while inserting customer. ERROR [{}]", e.getMessage());
		}
	}
}
