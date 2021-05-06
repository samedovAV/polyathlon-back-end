package ru.samedov.polyathlonbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.samedov.polyathlonbackend.domain.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
