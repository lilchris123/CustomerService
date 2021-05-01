package APIS.SimpleAPI.controller;

import APIS.SimpleAPI.model.Address;
import APIS.SimpleAPI.model.City;
import APIS.SimpleAPI.model.Country;
import APIS.SimpleAPI.model.Customer;
import APIS.SimpleAPI.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {

    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private List<Customer> customers;

    @BeforeEach
    void init(){
        this.customers= new ArrayList<>();
        customers.add(new Customer(1,"Chris","Mayol", "chris@gmail.com",
                new Address("1 arden","","Manhattan",
                        new City("New York",new Country("USA")),10040,2127777777),
                null));
    }

    @Test
    public void shouldFetchAllCustomers() throws Exception{
        given(customerService.getCustomers()).willReturn(customers);

        mockMvc.perform(get("/api/customer/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(customers.size())));
    }

    @Test
    void shouldFetchById() throws Exception{
        final int id=1;
        Customer customer= customers.get(0);
        given(customerService.getCustomer(id)).willReturn(customer);

        mockMvc.perform(get("/api/customer/{id}",id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(customer.getFirstName())))
                .andExpect((jsonPath("$.lastName",is(customer.getLastName()))));
    }

    @Test
    void shouldFindByFirstName() throws Exception{
        final String fname="Chris";
        Customer customer= customers.get(0);
        given(customerService.getCustomer(fname)).willReturn(customer);
        mockMvc.perform(get("/api/customer/name/{fname}",fname))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(customer.getFirstName())))
                .andExpect((jsonPath("$.lastName",is(customer.getLastName()))));
    }
    @Test
    @Disabled
    void shouldCreateCustomer() throws Exception{
        objectMapper =new ObjectMapper();
        Customer customer= customers.get(0);
        given(customerService.createCustomer(any(Customer.class))).willAnswer((invocation)-> invocation.getArgument(0));
        mockMvc.perform(post("/api/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(customer.getFirstName())))
                .andExpect((jsonPath("$.lastName",is(customer.getLastName()))));
    }
    @Test
    void shouldDeleteById() throws Exception{
        final int id =1;
        Customer customer= customers.get(0);
        given(customerService.getCustomer(id)).willReturn(customer);
        doNothing().when(customerService).deleteCustomer(customer.getId());
        System.out.println(customer.getId());

        this.mockMvc.perform(delete("/api/customer/{id}",customer.getId()))
                .andExpect(status().isOk());
    }

}
