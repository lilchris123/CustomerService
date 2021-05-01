package APIS.SimpleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APIS.SimpleAPI.model.Customer;
import APIS.SimpleAPI.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    public Customer getCustomer(String fname) {
        return customerRepository.findByFirstName(fname).get();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int id){
        customerRepository.deleteById(id);
    }

}
