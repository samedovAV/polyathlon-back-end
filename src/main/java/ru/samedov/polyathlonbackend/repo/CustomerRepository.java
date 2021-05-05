package ru.samedov.polyathlonbackend.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.samedov.polyathlonbackend.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
