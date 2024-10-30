package luiz.sales.file.processing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import luiz.sales.file.processing.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
