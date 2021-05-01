package APIS.SimpleAPI.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import APIS.SimpleAPI.model.Customer;
import APIS.SimpleAPI.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getCustomers() {
        logger.info("Get endpoint hit");
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable() int id) {
        Customer cus = customerService.getCustomer(id);
        return cus;
    }

    @GetMapping("/name/{fname}")
    public Customer getCustomer(@PathVariable() String fname) {
        Customer cus = customerService.getCustomer(fname);
        return cus;
    }

    @PostMapping("/")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

}
