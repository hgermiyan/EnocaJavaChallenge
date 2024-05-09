package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Cart;
import com.javachallenge.enoca.Entities.Customer;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class HibernateCustomerDal implements ICustomerDal{
    private final EntityManager entityManager;

    @Autowired
    public HibernateCustomerDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public List<Customer> getAllCustomer() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer ", Customer.class).getResultList();
    }

    @Override
    public void createCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);

        session.merge(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);

        Customer customer1 = session.get(Customer.class, customer.getId());
        session.remove(customer1);
    }

    @Override
    public Customer getCustomer(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Customer.class, id);
    }

}
