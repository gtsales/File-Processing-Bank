package luiz.sales.file.processing.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import luiz.sales.file.processing.dto.CustomerRequest;
import luiz.sales.file.processing.model.Customer;

public interface CustomerApi {
	
	@PostMapping("/register-customer/")
	void registerCustomer(@RequestBody CustomerRequest customerRequest);

	@GetMapping("/find-by-cpf/{cpf}")
	Optional<Customer> findCustomerByCpf(@PathVariable(name = "cpf") String cpf);
}
