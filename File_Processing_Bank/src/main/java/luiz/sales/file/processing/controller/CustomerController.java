package luiz.sales.file.processing.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import luiz.sales.file.processing.api.CustomerApi;
import luiz.sales.file.processing.dto.CustomerRequest;
import luiz.sales.file.processing.model.Customer;
import luiz.sales.file.processing.repository.CustomerRepository;
import luiz.sales.file.processing.service.RegisterCustomer;
import luiz.sales.file.processing.utils.ConvertDtoToModel;

@RestController
@RequestMapping("/customer/")
public class CustomerController implements CustomerApi{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ConvertDtoToModel convertDtoToModel;
	
	@Autowired
	RegisterCustomer registerCustomer;
	
	public Optional<Customer> findCustomerByCpf(@PathVariable(name = "cpf") String cpf) {
		
		return customerRepository.findById(cpf);
	}

	public void registerCustomer(@RequestBody CustomerRequest customerRequest) {
		
		registerCustomer.registerCustomer(customerRequest);
	}
}
