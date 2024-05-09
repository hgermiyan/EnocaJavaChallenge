package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Customer;
import com.javachallenge.enoca.Entities.Orders;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class HibernateOrderDal implements IOrderDal {
    private final EntityManager entityManager;

    @Autowired
    public HibernateOrderDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Orders> getAllOrder() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Orders", Orders.class).getResultList();
    }

    @Override
    public void createOrder(Orders orders) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(orders);
    }

    @Override
    public void updateOrder(Orders orders) {
        Session session = entityManager.unwrap(Session.class);

        session.merge(orders);
    }

    @Override
    public void deleteOrder(Orders orders) {
        Session session = entityManager.unwrap(Session.class);

        Customer orders1 = session.get(Customer.class, orders.getId());
        session.remove(orders1);
    }

    @Override
    public Orders getOrder(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Orders.class, id);
    }

    @Override
    public List<Orders> getAllOrdersForCustomer(long customerId) {
        Session session = entityManager.unwrap(Session.class);

        String hql = "SELECT o FROM Orders o WHERE o.customer.id = :customerId";
        Query<Orders> query = session.createQuery(hql, Orders.class);
        query.setParameter("customerId", customerId);
        return query.list();
    }
}
