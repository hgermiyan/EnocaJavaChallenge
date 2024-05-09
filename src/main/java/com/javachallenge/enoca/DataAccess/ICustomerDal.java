package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Customer;

import java.util.List;

public interface ICustomerDal {
    List<Customer> getAllCustomer();
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer getCustomer(long id);
}
