package APIS.SimpleAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import APIS.SimpleAPI.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Optional<Customer> findByFirstName(String first_name);

    public Optional<Customer> findByLastName(String last_name);

}
