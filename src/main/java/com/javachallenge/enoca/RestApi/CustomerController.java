package com.javachallenge.enoca.RestApi;

import com.javachallenge.enoca.Business.CustomerService;
import com.javachallenge.enoca.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/AddCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        this.customerService.addCustomer(customer);
    }
}
