package luiz.sales.file.processing.utils;

import org.springframework.stereotype.Service;

import luiz.sales.file.processing.dto.CustomerRequest;
import luiz.sales.file.processing.model.Customer;

@Service
public class ConvertDtoToModel {

	public Customer convertToCustomer(CustomerRequest customerRequest) {
		
		int score = customerRequest.getScore() != null ? convertStringToInt(customerRequest.getScore()) : 0;
		double amount = customerRequest.getAmount() != null ? convertStringToDouble(customerRequest.getAmount()) : 0.0;
		
		Customer customer = new Customer();
		
		customer.setName(customerRequest.getName());
		customer.setLastName(customerRequest.getLastName());
		customer.setScore(score);
		customer.setCpf(customerRequest.getCpf());
		customer.setAmount(amount);
		
		return customer;
	}
	
	private int convertStringToInt(String score) {
		
		int convertedScore = Integer.parseInt(score);
		
		return convertedScore;
	}
	
	private double convertStringToDouble(String score) {
		
		double convertedScore = Integer.parseInt(score);
		
		return convertedScore;
	}
}
