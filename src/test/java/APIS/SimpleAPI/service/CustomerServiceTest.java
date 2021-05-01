package APIS.SimpleAPI.service;

import APIS.SimpleAPI.model.*;
import APIS.SimpleAPI.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldReturnFindAll(){
        List<Customer> customers= new ArrayList<>();
        customers.add(new Customer(1,"Chris","Mayol", "chris@gmail.com",
                new Address("1 arden","","Manhattan",
                        new City("New York",new Country("USA")),10040,2127777777),
                null));

        given(customerRepository.findAll()).willReturn(customers);
        List<Customer> expected= customerService.getCustomers();
        assertEquals(expected, customers);
    }
}
