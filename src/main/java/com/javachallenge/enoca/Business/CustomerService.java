package com.javachallenge.enoca.Business;

import com.javachallenge.enoca.DataAccess.ICustomerDal;
import com.javachallenge.enoca.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final ICustomerDal customerDal;

    @Autowired
    public CustomerService(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    @Transactional
    public void addCustomer(Customer customer) {
        this.customerDal.createCustomer(customer);
    }
}
