package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Customer;
import com.javachallenge.enoca.Entities.OrderHistory;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateOrderHistoryDalDal implements IOrderHistoryDal {
    private final EntityManager entityManager;

    @Autowired
    public HibernateOrderHistoryDalDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<OrderHistory> getAllOrderHistory() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from OrderHistory", OrderHistory.class).getResultList();
    }

    @Override
    public void createOrderHistory(OrderHistory orderHistory) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(orderHistory);
    }

    @Override
    public void updateOrderHistory(OrderHistory orderHistory) {
        Session session = entityManager.unwrap(Session.class);

        session.merge(orderHistory);
    }

    @Override
    public void deleteOrderHistory(OrderHistory orderHistory) {
        Session session = entityManager.unwrap(Session.class);

        Customer orderHistory1 = session.get(Customer.class, orderHistory.getId());
        session.remove(orderHistory1);
    }

    @Override
    public OrderHistory getOrderHistory(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(OrderHistory.class, id);
    }
}
